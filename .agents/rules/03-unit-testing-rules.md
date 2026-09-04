---
trigger: glob
globs: "**/src/test/**/*.java,**/*Test.java"
---

# 03 — Unit Testing Rules

Applies to: JUnit 5, Mockito, AssertJ for Java backend projects.

---

## 1. Technology Stack

- **JUnit 5** (`@Test`, `@ExtendWith(MockitoExtension.class)`)
- **Mockito** for mocking dependencies
- **AssertJ** for fluent assertions — prefer over JUnit `assertEquals`
- Do NOT use `@SpringBootTest` for unit tests — it loads the full application context and is slow. Use `@SpringBootTest` only for integration tests.

---

## 2. Test Class Structure

- Mirror production package structure: `src/test/java/.../service/impl/UserServiceImplTest.java`
- Use `@ExtendWith(MockitoExtension.class)` — NOT `@SpringBootTest`
- `@Mock` for dependencies, `@InjectMocks` for the class under test
- Group tests by method with section comments:

```java
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    // ==================== createUser ====================

    @Test
    void createUser_WhenValidRequest_ShouldReturnUserId() { ... }

    @Test
    void createUser_WhenEmailExists_ShouldThrowConflict() { ... }

    // ==================== updateUser ====================

    @Test
    void updateUser_WhenUserNotFound_ShouldThrow404() { ... }
}
```

---

## 3. AAA Pattern (Arrange-Act-Assert)

Every test method MUST follow AAA:

```java
@Test
void createUser_WhenEmailExists_ShouldThrowException() {
    // Arrange — set up test data and stubs
    UserCreationRequest req = UserCreationRequest.builder()
            .email("test@example.com")
            .build();
    when(userRepository.findByEmail(req.getEmail())).thenReturn(Optional.of(new User()));

    // Act & Assert — execute and verify
    assertThatThrownBy(() -> userService.createUser(req))
            .isInstanceOf(AccountBusinessException.class)
            .hasFieldOrPropertyWithValue("status", HttpStatus.CONFLICT);

    verify(userRepository, never()).save(any());
}
```

---

## 4. Test Naming Convention

Format: `methodName_WhenCondition_ShouldExpectedResult`

| Good | Bad |
|---|---|
| `createUser_WhenEmailExists_ShouldThrowException` | `testCreateUser` |
| `changePassword_WhenOldPasswordWrong_ShouldThrow` | `test1` |
| `searchUsers_WithKeyword_ShouldCallSearchByKeyword` | `testSearch` |
| `deactivateUser_WhenAlreadyInactive_ShouldThrowConflict` | `deactivateTest` |

---

## 5. ArgumentCaptor — Avoid Unchecked Assignment

**Never** use inline `ArgumentCaptor.forClass()` with generic types — it causes "Unchecked assignment" compiler warnings:

```java
// ❌ BAD — unchecked assignment warning
ArgumentCaptor<List<Address>> captor = ArgumentCaptor.forClass(List.class);

// ✅ GOOD — class-level @Captor, fully type-safe
@Captor
private ArgumentCaptor<List<Address>> addressListCaptor;
```

Rules:
- Declare all `ArgumentCaptor` as class fields with `@Captor` annotation.
- Never use `ArgumentCaptor.forClass()` inline for generic types.
- `@Captor` is initialized automatically by `MockitoExtension`.

---

## 6. Mockito Matchers — No Useless `eq()`

SonarQube rule: Remove useless `eq(...)` invocations; pass values directly.

```java
// ❌ BAD — unnecessary eq() wrapping literal values
verify(repository).findByEmail(eq("test@example.com"));

// ✅ GOOD — pass literal values directly
verify(repository).findByEmail("test@example.com");

// ✅ OK — eq() is required only when mixing with other matchers
verify(service).execute(eq("value"), any());
```

**Prefer state verification** (assert on captured data) over interaction verification (verify with matchers) when testing data correctness:

```java
// ✅ BETTER — capture and assert state
verify(repository).saveAll(addressListCaptor.capture());
List<Address> saved = addressListCaptor.getValue();
assertThat(saved).hasSize(2);
assertThat(saved.get(0).getCity()).isEqualTo("Hanoi");
```

---

## 7. Test Behavior, Not Implementation

```java
// ✅ Tests what the user cares about — data state after operation
assertThat(user.getStatus()).isEqualTo(UserStatus.INACTIVE);
assertThat(result.getEmail()).isEqualTo("new@email.com");

// ❌ Tests internal wiring — fragile, breaks on refactor
verify(user).setStatus(UserStatus.INACTIVE);
verify(user).setEmail("new@email.com");
```

Rules:
- Assert on **returned data** or **captured arguments**, not on setter calls.
- `verify()` is for confirming **interactions** (was this method called?), not for asserting **data state**.
- Use `verify(repository, never()).save(any())` to confirm side effects did NOT happen.

---

## 8. Mock `doAnswer` for MapStruct — Reflect Production Behavior

When mocking MapStruct in-place update methods, the `doAnswer` must match production mapper behavior exactly:

```java
// If production mapper ignores addressType (it's the upsert lookup key),
// doAnswer must NOT set addressType either
doAnswer(invocation -> {
    AddressRequest r = invocation.getArgument(0);
    Address e = invocation.getArgument(1);
    // Only set fields that the real mapper would set
    e.setCity(r.getCity());
    e.setDistrict(r.getDistrict());
    // Do NOT set e.setAddressType() — mapper ignores this field
    return null;
}).when(addressMapper).updateEntityFromRequest(any(), any());
```

Rules:
- Study the production mapper's `@Mapping(ignore = true)` rules before writing `doAnswer`.
- If the mock sets a field that the real mapper ignores, the test will pass but production will fail.
- If the mock omits a field that the real mapper sets, the test will fail with a false negative.

---

## 9. Coverage Targets

| Metric | Target |
|---|---|
| Service layer (business logic) | ≥ 80% line coverage |
| Controller layer | Covered by integration tests, not unit tests |
| Repository layer | Covered by integration tests, not unit tests |
| Mapper layer | Auto-generated by MapStruct — no unit test needed |
| Exception handler | Covered by integration tests |

Unit tests focus on **service layer** — that's where business logic lives.

---

## 10. Test Data Best Practices

- Use `@Builder` on Request DTOs to create readable test data (see `01-backend-java-spring-rules.md` §4).
- Use constants for repeated values:

```java
private static final String TEST_EMAIL = "test@example.com";
private static final Long TEST_USER_ID = 1L;
```

- Use `when().thenReturn()` for simple stubs. Use `doAnswer()` only for in-place mutation (MapStruct update mappers).
- Do NOT create shared test fixtures (`@BeforeEach` setup) unless genuinely reused by > 50% of tests in the class. Prefer per-test arrangement for clarity.
