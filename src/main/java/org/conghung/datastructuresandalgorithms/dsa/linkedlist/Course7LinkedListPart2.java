package org.conghung.datastructuresandalgorithms.dsa.linkedlist;

public class Course7LinkedListPart2 {
  // Lưu ý: Trong LinkedList chúng ta không có index mà chỉ có pointer (con trỏ)
  // Insert (Singly Linked List):
  // Insert (Doubly Linked List):
  // Remove (Singly Linked List):
  // Remove (Doubly Linked List):
  // Big O Complexity:
  // Insert (Singly Linked List): O(1)
  // Insert (Doubly Linked List): O(1)
  // Remove (Singly Linked List): O(1)
  // Remove (Doubly Linked List): O(1)
  // Search (Singly Linked List): O(n)
  // Search (Doubly Linked List): O(n)
  // Update (Singly Linked List): O(n)
  // Update (Doubly Linked List): O(n)
  public static void main(String[] args) {
    System.out.println("BẢNG SO SÁNH:");
    System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┐");
    System.out.println("│ Operation            │ Singly Linked List   │ Doubly Linked List   │");
    System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┤");
    System.out.println("│ Insert (Head)        │ O(1)                 │ O(1)                 │");
    System.out.println("│ Insert (Tail)        │ O(1)                 │ O(1)                 │");
    System.out.println("│ Insert (Middle)      │ O(n)                 │ O(n)                 │");
    System.out.println("│ Remove (Head)        │ O(1)                 │ O(1)                 │");
    System.out.println("│ Remove (Tail)        │ O(n)                 │ O(1)                 │");
    System.out.println("│ Remove (Middle)      │ O(n)                 │ O(n)                 │");
    System.out.println("│ Search (Value)       │ O(n)                 │ O(n)                 │");
    System.out.println("│ Update (Value)       │ O(n)                 │ O(n)                 │");
    System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┘");
  }
}
