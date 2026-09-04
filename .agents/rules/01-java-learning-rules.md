---
trigger: glob
glob: "*.java"
---

# 01 — Java Learning Rules (DSA Project)

> Applies to all .java files. NOT a production project — no DB, no API layer, no multi-service patterns.

---

## Layer Discipline

- Package dataStructure/ = data structure implementations (ADT interfaces + concrete classes)
- Package lgorithm/ = algorithm implementations (sorting, searching, graph)
- Each class has exactly one responsibility
- No cross-package dependencies unless explicitly needed (e.g., algorithm using a data structure)

---

## Naming in Algorithms

Use descriptive names — this is learning code, so clarity trumps brevity:

`java
// Good
int leftPointer = 0;
int rightPointer = arr.length - 1;
TreeNode currentNode = root;
int pivotIndex = partition(arr, low, high);

// Bad
int l = 0;
int r = arr.length - 1;
TreeNode n = root;
int pi = partition(arr, low, high);
`

Loop counters i, j, k are acceptable for simple indexed loops only.

---

## Big O Documentation (Mandatory)

Every public method implementing an algorithm or data structure operation MUST document complexity:

`java
/**
 * Inserts a value into the binary search tree.
 *
 * @param value the value to insert
 * Time Complexity:  O(log n) average, O(n) worst case (skewed tree)
 * Space Complexity: O(log n) average (call stack depth)
 */
public void insert(int value) { ... }
`

---

## Testing Rules

- main() method is acceptable for quick exploration but is NOT a substitute for tests
- Every public implementation class MUST have a corresponding JUnit 5 test class
- Test class naming: BinarySearchTreeTest, BubbleSortTest
- Use @Test and AssertJ ssertThat() for assertions
- Do NOT test by reading System.out output — test return values and state directly

---

## What Does NOT Apply Here

The following production rules do NOT apply to this project:

- @Transactional — no database
- DTO pattern / DTO contracts — no API layer
- Multi-module Maven patterns — single module
- RestTemplate / FeignClient — no HTTP calls
- BigDecimal for money — no financial domain
- Message queue ACK rules — no messaging
