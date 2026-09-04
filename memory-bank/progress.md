# Progress

## What Works (Completed)

- [x] **Big O Complexity** — Full theory + 6 examples (O(1), O(n), O(n²), O(log n), O(n log n), O(n³))
- [x] **Array** — Lesson + Dynamic Array implementation
- [x] **Linked List** — Singly (3 parts) + Doubly Linked List + Node
- [x] **Stack** — ADT interface + Array-based + LinkedList-based + Tests
- [x] **Queue** — ADT interface + Circular Array-based + LinkedList-based + Definition + Tests
- [x] **Hash Table** — ADT interface + Separate Chaining + Definition + Node + Tests
- [x] **Tree** — ADT interface + Binary Tree + BST + Definition + Node + Traverse Types + Tests
- [x] **Recursion** — Recursion patterns
- [x] **Bubble Sort** — Generic sort + early termination optimization
- [x] **Insertion Sort** — Generic sort with shift-based insertion
- [x] **Quick Sort** — Lomuto partition, đệ quy Divide & Conquer

## What's Left to Build

- [x] **Merge Sort** — Generic sort + Divide & Conquer merge
- [x] **Visual Diagrams** — Added architecture/flow diagrams for List, Map, and Queue
- [x] **Portable Agent Kit** — Integrated AG Kit (`.agents/`), customized learning rules, guard hooks, and toolchains
- [ ] **JUnit Tests** — Only 1 test file exists; need comprehensive unit tests
- [ ] **Advanced Data Structures** — Heap, Graph, Trie (not yet planned)

## Current Status

**~90% complete** — All fundamental data structures + 4 sorting algorithms done (Bubble, Insertion, Quick, Merge). Testing remains.

## Known Issues

- Quick Sort doc section 1 pivot description was inconsistent (fixed)
- Most "tests" are `main()` demos rather than formal JUnit tests
- `BigOComplexity.java` includes a `mergeSort` implementation that could be extracted to the `algorithm/mergeSort/` package
