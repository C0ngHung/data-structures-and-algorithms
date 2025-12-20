package org.conghung.datastructuresandalgorithms.dsa.linkedlist;

public class Course6LinkedList {
  // Định nghĩa - Definition:
  // Definition:
  // Linked List là một cấu trúc dữ liệu liên kết giữa các node với nhau.
  // A Linked List is a data structure where nodes are linked together.
  // Trong mỗi node luôn có dữ liệu và địa chỉ mà nó trỏ tới
  // Each node contains data and the address it points to.
  // 1 LinkedList có nhiều node nhưng node cuối cùng luôn trỏ tới null
  // (Tail là pointer trỏ tới node cuối cùng, node cuối cùng có next = null)
  // A LinkedList has many nodes but the last node always points to null
  // (Tail is a pointer to the last node, and the last node's next = null)
  // Khi nào nên dùng - when to use:
  // When to use:
  // - Thường được sử dụng để tạo ra loại cấu trúc dữ liệu mà ở trong đó yêu cầu độ 
  // - Often used to build structures that require frequent operations.
  // insert và delete rất là nhiều ví dụ: 1 list, 1 stack, 1 queue: Bản chất là thêm vào và bớt đi liên tục sử dụng linkedList rất tốt
  // Frequent inserts and deletes, e.g., lists, stacks, queues—continuous add/remove suits LinkedList well.
  // Được lưu trữ như thế nào ? - How it is stored:
  // How it is stored:
  // Đặc điểm - Characteristics: LinkedList các node của nó không nhất thiết phải nằm liên tục nhau
  // Characteristics: LinkedList nodes are not required to be contiguous.
  // Có nghĩa là các node của nó có thể nằm ở bất kỳ đâu ở trong dữ liệu của chúng ta
  // Nodes can reside anywhere in memory.
  // Nó khác với array: ví dụ như 1 array thì khi new 1 array thì nó sẽ chiếm 1 khoảng không gian trong bộ nhớ
  // Different from arrays: creating an array allocates a contiguous memory block.
  // còn các node của LinkedList thì nằm ở nhiều chỗ khác nhau và nằm rải rác ở khắp mọi nơi 
  // LinkedList nodes are scattered across different memory locations.
  // Trong mỗi node của LinkedList có:
  // Each LinkedList node contains:
  // - Dữ liệu (Data)
  // - Data
  // - Pointer(s) đến node khác:
  // - Pointer(s) to other nodes:
  //   + Singly Linked List: chỉ có next pointer (trỏ tới node tiếp theo)
  //   + Singly Linked List: only has next pointer (points to next node)
  //   + Doubly Linked List: có cả next pointer (trỏ tới node tiếp theo) và prev pointer (trỏ tới node trước đó)
  //   + Doubly Linked List: has both next pointer (points to next node) and prev pointer (points to previous node)
  // Địa chỉ của node tiếp theo là địa chỉ của node đó trỏ tới nên nó không nằm trên 1 thanh ghi --> Thoải mái thêm/xóa/sửa
  // The next node address is a pointer target, not stored contiguously → flexible add/delete/update.
  // Thành phần của linkedList:
  // Components of a LinkedList:
  // 1. Đầu - Head (pointer trỏ tới node đầu tiên)
  // 1. Head (pointer to the first node)
  // 2. Đuôi - Tail (pointer trỏ tới node cuối cùng, có thể có hoặc không tùy implementation)
  // 2. Tail (pointer to the last node, may or may not be present depending on implementation)
  // 3. Node (Có data và pointer(s) trỏ tới node khác)
  // 3. Node (contains data and pointer(s) to other nodes)
  // Các loại linkedList: - Types of LinkedList:có nhiều loại linkedList nhưng chủ yếu sử dụng 2 loại:
  // Types of LinkedList: many variants exist but mainly two are used:
  // 1. Singly Linked List: 1 node chỉ trỏ tới 1 node tiếp theo
  // 1. Singly Linked List: each node points to one next node.
  // 2. Doubly Linked List: 1 node trỏ tới 1 node tiếp theo và 1 node trỏ tới 1 node trước đó
  // 2. Doubly Linked List: each node points to the next and the previous node.
  public static void main(String[] args) {
        System.out.println("BẢNG SO SÁNH:");
        System.out.println("┌─────────────────────┬──────────────────┬──────────────────┐");
        System.out.println("│ Lợi / Hại           │ Singly           │ Doubly           │");
        System.out.println("├─────────────────────┼──────────────────┼──────────────────┤");
        System.out.println("│ Bộ nhớ              │ Ít bộ nhớ        │ 2x bộ nhớ         │");
        System.out.println("│ Code                │ Code dễ hơn      │    dễ truy vấn ngược hơn│");
        System.out.println("│                     │ Khó truy vấn ngược O(n)             │");
        System.out.println("└─────────────────────┴──────────────────┴──────────────────┘");
  }

}
