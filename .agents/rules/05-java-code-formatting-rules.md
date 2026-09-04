---
trigger: glob
globs: "**/*.java"
---

# 05 — Java Code Formatting Rules

Applies to: All Java source files within the microservices project. The goal is to enforce clean, consistent, and highly readable code across all layers.

---

## 1. Import Organization

Organize import statements into 4 distinct groups, separated by a single blank line:

```java
// Group 1: Third-party libraries (lombok, mapstruct, swagger, etc.)
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Group 2: Framework dependencies (spring, jakarta, hibernate)
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

// Group 3: Internal project packages
import vn.conghung.common.api.ApiResult;
import vn.conghung.service.ProductService;

// Group 4: Java Standard Library
import java.math.BigDecimal;
import java.time.LocalDateTime;
```

**Rules:**
- DO NOT use wildcard imports (`import java.util.*`).
- Keep exactly one blank line between groups.
- Sort imports alphabetically within each group.

---

## 2. Blank Lines in Method Bodies (Controller & Service)

Insert intentional blank lines to separate logical execution blocks for readability:

```java
// ✅ DO — Clean, readable, and easy to scan
public ResponseEntity<ApiResult<Long>> create(@Valid @RequestBody ProductCreationRequest req) {

    log.info("[PRODUCT-CONTROLLER] Create product - name: {}", req.getName());

    Long productId = productService.createProduct(req);

    log.info("[PRODUCT-CONTROLLER] Create product success - productId: {}", productId);

    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResult.ok(productId));
}

// ❌ DON'T — Cluttered, hard to read
public ResponseEntity<ApiResult<Long>> create(@Valid @RequestBody ProductCreationRequest req) {
    log.info("[PRODUCT-CONTROLLER] Create product - name: {}", req.getName());
    Long productId = productService.createProduct(req);
    log.info("[PRODUCT-CONTROLLER] Create product success - productId: {}", productId);
    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResult.ok(productId));
}
```

**Pattern within method bodies:**
1. Leave a blank line after the opening brace `{` of the method.
2. Leave a blank line between `log.info` → business logic → `log.info` → `return`.
3. Separate distinct logical steps commented with `// N. ...` by a blank line.

---

## 3. Utility Classes (Constants, Helpers)

Ensure all utility classes cannot be instantiated or inherited:

```java
// ✅ DO — final class + exception thrown in private constructor
public final class ApiConstants {

    private ApiConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final String BASE_API = "/api";
}
```

**Rules:**
- Declare the class as `final` to prevent inheritance.
- Define a `private` constructor that throws `UnsupportedOperationException`.
- Apply the same pattern to static inner/nested utility classes.

---

## 4. Enums — Getter Methods

Write enum getters as block statements (no inline getters):

```java
// ✅ DO
public String code() {
    return code;
}

// ❌ DON'T — Inline getter
public String code() { return code; }
```

---

## 5. Enum Layout and Spacing

```java
public enum ProductResponseCode {

    PRODUCT_NOT_FOUND("4101", "Product not found"),   // ← 1 blank line after {
    PRODUCT_PRICE_INVALID("4103", "...");

    private final String code;                         // ← 1 blank line after values
    private final String defaultMessage;

    ProductResponseCode(String code, String defaultMessage) {  // ← 1 blank line after fields
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public String code() {
        return code;
    }

    public String defaultMessage() {                   // ← 1 blank line between getters
        return defaultMessage;
    }
}
```

---

## 6. Logging — Use Lombok @Slf4j

```java
// ✅ DO — Annotate classes with @Slf4j
@Slf4j(topic = "PRODUCT-CONTROLLER")
public class ProductController {
    // Variable 'log' is automatically generated
}

// ❌ DON'T — Manual logger instantiation
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
}
```

**Rules:**
- Always use Lombok's `@Slf4j(topic = "SERVICE-NAME")` instead of manual instantiation.
- Set the topic to SCREAMING_SNAKE_CASE matching the prefix in log statements.
- Rationale: @Slf4j follows DIP (Dependency Inversion Principle) — code against the SLF4J abstraction, not the Log4j2 implementation. This allows swapping logging backends (Logback ↔ Log4j2) via pom.xml only, without touching code. Also avoids Log4j2-specific CVE exposure (e.g. Log4Shell).

---

## 7. DTO Classes — Lombok Annotation Stack

> **Single source of truth** for DTO/Entity Lombok stacks across all rules (referenced by `01-backend-java-spring-rules.md` §4).

| DTO Type | Required Annotations | Notes |
|---|---|---|
| Request | `@Getter @Builder @NoArgsConstructor @AllArgsConstructor` | `@NoArgsConstructor` is required for Jackson deserialization |
| Response | `@Getter @Builder @NoArgsConstructor @AllArgsConstructor` | `@NoArgsConstructor` is required for client-side Jackson deserialization |
| Entity (JPA) | `@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor` | Full stack for JPA & MapStruct compatibility |
| Document (ES) | `@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor` | Full stack for ES & MapStruct compatibility |
| Lifecycle Entity/Document | `@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)` | Use factories/domain methods when public mutation would violate invariants |

**Annotation Ordering (Consistent):**
```java
@Getter
@Setter      // if mutability is required
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity / @Document / ... // Framework-specific annotations at the bottom
```

The lifecycle row overrides the generic Entity/Document stack. Do not add public setters, builders, or
all-args constructors solely for persistence when the framework can hydrate fields through a protected
no-args constructor; cover that assumption with a persistence-mapping round-trip test.

---

## 8. Entity Fields — Spacing

Leave a single blank line between field declarations for readability of annotations and types:

```java
// ✅ DO
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "name", nullable = false)
private String name;

// ❌ DON'T — Cluttered declarations
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "name", nullable = false)
private String name;
```

---

## 9. Fluent API Builders — Indentation

Format fluent builder patterns (OpenAPI, JOOQ, etc.) by placing each call on a new line:

```java
// ✅ DO
return new OpenAPI()
        .servers(List.of(new Server().url(server)))
        .components(new Components()
                .addSecuritySchemes(
                        securitySchemeName,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                )
        )
        .info(new Info()
                .title(title)
                .description(description));
```

---

## 10. Controller Methods — Multi-line @RequestParams

For controller methods with multiple parameters or verbose validation constraints:

```java
// ✅ DO — Each param on a new line, closing parenthesis on its own line
public ResponseEntity<...> search(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String sort,
        @RequestParam(defaultValue = "0") @Min(0) int page,
        @RequestParam(defaultValue = "20") @Min(1) @Max(100) int size
) {
```

---

## 11. MapStruct — Alignment of @Mapping

```java
// ✅ DO — Keep mappings block-aligned with a blank line before the method
@Mapping(target = "id", ignore = true)
@Mapping(target = "createdAt", ignore = true)
@Mapping(target = "updatedAt", ignore = true)
@Mapping(target = "userId", ignore = true)
void updateProductFromRequest(ProductUpdateRequest request, @MappingTarget Product product);
```

- DO NOT use tabs to align `target =` and `ignore =` values, as IDE code auto-formatting will break it.

---

## 12. File Termination

- DO NOT leave trailing blank lines at the end of the file.
- Terminate all files with exactly one newline character after the closing brace `}`.

---

## 13. Section Separators — Class Body Partitioning

When a class contains distinct groups of methods (e.g., public APIs vs. private helper methods), partition them clearly using standard comment headers:

```java
// ✅ DO — Clean partitioning in Service Implementation
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    // ... fields

    // ─── Public API (implements ProductService) ──────────────────────

    @Override
    public Long createProduct(ProductCreationRequest req) { ... }

    @Override
    public void updateProduct(ProductUpdateRequest req) { ... }

    // ==================== Private Helper Methods ====================

    /**
     * Syncs a product to Elasticsearch AFTER transaction commits.
     */
    private void syncToElasticsearch(Product product, String operation) { ... }

    private Product getProductById(Long id) { ... }
}
```

**Rules:**
- Place separators with one blank line before the first method of the section.
- **Private Helpers separator format:** `// ==================== Private Helper Methods ====================`
- **Public API separator format:** `// ─── Public API ───────────────────────────────────────────────`
- DO NOT use separators if a class only contains a single method category (e.g., clean endpoints in Controllers).
- In Test classes, group tests by target method using: `// ==================== methodName ====================`

**When to use separators:**

| Scenario | Separator Required |
|---|---|
| Service Impls containing private helper methods | ✅ Yes |
| Controllers containing only public mapping endpoints | ❌ No |
| Test classes grouping test cases by target method | ✅ Yes |
| Enums (values, fields, constructors, getters) | ❌ No (use blank lines instead) |

---

## Pre-Commit Checklist

Before committing any Java source file, verify that it meets the following criteria:

- [ ] Import statements are properly grouped and separated (third-party / framework / internal / java).
- [ ] Utility classes are marked `final` and throw an exception in a `private` constructor.
- [ ] Enum getter methods are written as blocks, not inlined.
- [ ] Loggers use Lombok's `@Slf4j(topic = "...")`.
- [ ] DTO classes have both `@NoArgsConstructor` and `@AllArgsConstructor` defined.
- [ ] Method bodies utilize logical blank lines between statement blocks (log → logic → return).
- [ ] Entity class fields are separated by a blank line.
- [ ] Service Implementations use the `// ==================== Private Helper Methods ====================` separator.
- [ ] The file has no trailing blank lines and ends with a single newline.
