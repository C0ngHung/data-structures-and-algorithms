# System Patterns

## Project Architecture

```
src/main/java/org/conghung/datastructuresandalgorithms/
├── DataStructuresAndAlgorithmsApplication.java   # Spring Boot entry point
├── dsa/                                           # Data Structures package
│   ├── BigOComplexity.java                        # Big O theory + examples
│   ├── array/                                     # Array implementations
│   ├── linkedlist/                                # Singly & Doubly Linked List
│   ├── stack/                                     # Array-based & LinkedList-based Stack
│   ├── queue/                                     # Array-based & LinkedList-based Queue
│   ├── hashtable/                                 # Hash Table with Separate Chaining
│   ├── tree/                                      # Binary Tree & BST
│   └── recursion/                                 # Recursion patterns
└── algorithm/                                     # Sorting Algorithms package
    ├── bubbleSort/                                # (planned)
    ├── mergeSort/                                 # (planned)
    └── quickSort/                                 # (planned)
```

## Design Patterns in Use

### 1. ADT Interface Pattern

Each data structure defines an **Abstract Data Type (ADT)** interface, then provides concrete implementations:

- `StackADT` → `ArrayBasedStack`, `LinkedListBasedStack`
- `QueueADT` → `CircularArrayBasedQueue`, `LinkedListBasedQueue`
- `TreeADT` → `BinaryTree`, `BinarySearchTree`
- `HashTableADT` → `SeparateChainingHashTable`

### 2. Definition + Implementation Pattern

- `Definition.java` — Contains theory, explanations, and conceptual overview as comments
- `*ADT.java` — Interface defining operations
- Implementation classes — Concrete code
- `*Test.java` — Verification with `main()` method demos

### 3. Node Pattern

Shared `Node` class per data structure package (e.g., `linkedlist.Node`, `tree.Node`, `hashtable.Node`).

### 4. Bilingual Documentation

All Javadoc and inline comments follow:

```
// Vietnamese explanation
// English explanation
```

## Key Technical Decisions

- **No external libraries** for DSA implementations — everything is built from scratch
- **`main()` method testing** over JUnit for most files (learning-oriented, runnable demos)
- **Package-per-topic** organization for clean separation
