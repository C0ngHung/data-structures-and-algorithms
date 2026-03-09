# Tech Context

## Technology Stack

| Layer      | Technology               | Version                    |
| ---------- | ------------------------ | -------------------------- |
| Language   | Java                     | 17                         |
| Framework  | Spring Boot              | 4.0.0                      |
| Build Tool | Maven                    | via Maven Wrapper (`mvnw`) |
| Testing    | Spring Boot Starter Test | (bundled)                  |

## Project Coordinates

- **Group ID**: `org.conghung`
- **Artifact ID**: `data-structures-and-algorithms`
- **Version**: `0.0.1-SNAPSHOT`
- **Base Package**: `org.conghung.datastructuresandalgorithms`

## Dependencies

Minimal — only Spring Boot starters:

1. `spring-boot-starter` — Core Spring Boot
2. `spring-boot-starter-test` — Testing (scope: test)

## Development Setup

```bash
# Build
./mvnw clean compile

# Run
./mvnw spring-boot:run

# Test
./mvnw test
```

## Technical Constraints

- Java 17 features only (no preview features)
- No external DSA libraries — all implementations are hand-written
- Maven project structure (not Gradle)
- Windows development environment
