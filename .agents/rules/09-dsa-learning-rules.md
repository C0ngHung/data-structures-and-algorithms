---
trigger: glob
glob: "*.java"
---

# 09 — DSA Learning Rules

> Project-specific rules for the Data Structures and Algorithms learning project.

---

## Algorithm Implementation Order

When implementing any algorithm or data structure:

1. Write a comment explaining the idea (what problem it solves, how it works conceptually)
2. Write pseudocode for non-trivial algorithms before coding
3. Implement the code
4. Write JUnit 5 tests covering: happy path, edge cases (empty, single element, duplicates), boundary conditions
5. Document Big O (time + space) on the method

---

## Comment Standards for Algorithms

`java
/**
 * Bubble Sort — repeatedly swaps adjacent elements if they are in the wrong order.
 * Uses early termination: if no swap occurs in a pass, the array is already sorted.
 *
 * Time Complexity:  O(n^2) worst/average, O(n) best (already sorted)
 * Space Complexity: O(1) — in-place sorting
 */
public <T extends Comparable<T>> void sort(T[] arr) { ... }
`

---

## Commit Scopes for This Project

| Scope | When to Use |
|---|---|
| lgorithm | Adding/modifying files in lgorithm/ package |
| data-structure | Adding/modifying files in dataStructure/ package |
| 	est | Adding/modifying test files |
| memory-bank | Updating memory-bank documentation |
| config | pom.xml, .agents/, .gitignore, build config |
| docs | README, learning notes, diagrams |

---

## Commit Convention Examples

`
feat[DSA-001]:[algorithm]:add bubble sort with early termination optimization
feat[DSA-002]:[data-structure]:add binary search tree with insert and search
test[DSA-003]:[data-structure]:add JUnit 5 tests for hash table separate chaining
docs[DSA-004]:[memory-bank]:update progress to reflect merge sort completion
refactor[DSA-005]:[algorithm]:extract partition logic into separate method in quick sort
`

---

## main() Demo Policy

main() methods are acceptable for initial exploration and visual debugging.
However, they are NOT a replacement for JUnit tests. Every completed implementation
must have a *Test.java file with formal assertions.
