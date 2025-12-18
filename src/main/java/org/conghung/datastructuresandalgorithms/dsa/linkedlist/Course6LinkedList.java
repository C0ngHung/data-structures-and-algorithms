package org.conghung.datastructuresandalgorithms.dsa.linkedlist;

public class Course6LinkedList {
  // Định nghĩa - Definition:
  // Linked List là một cấu trúc dữ liệu liên kết giữa các node với nhau.
  // Trong mỗi node luôn có dữ liệu và địa chỉ mà nó trỏ tới
  // 1 LinkedList có nhiều node nhưng node cuối cùng luôn trỏ tới 1 cái null - cái đuôi linkedlist địa chỉ nó trỏ tới null
  // Khi nào nên dùng - when to use:
  // - Thường được sử dụng để tạo ra loại cấu trúc dữ liệu mà ở trong đó yêu cầu độ 
  // insert và delete rất là nhiều ví dụ: 1 list, 1 stack, 1 queue: Bản chất là thêm vào và bớt đi liên tục sử dụng linkedList rất tốt
  // Được lưu trữ như thế nào ? - How it is stored:
  // Đặc điểm - Characteristics: LinkedList các node của nó không nhất thiết phải nằm liên tục nhau
  // Có nghĩa là các node của nó có thể nằm ở bất kỳ đâu ở trong dữ liệu của chúng ta
  // Nó khác với array: ví dụ như 1 array thì khi new 1 array thì nó sẽ chiếm 1 khoảng không gian trong bộ nhớ
  // còn các node của LinkedList thì nằm ở nhiều chỗ khác nhau và nằm rải rác ở khắp mọi nơi 
  // Trong mỗi node của LinkedList thì có 2 thông tin:
  // 1. Dữ liệu - Data
  // 2. Địa chỉ của node tiếp theo - Address of the next node
  // Địa chỉ của node tiếp theo là địa chỉ của node đó trỏ tới nên nó không nằm trên 1 thanh ghi --> Thoải mái thêm/xóa/sửa
  // Thành phần của linkedList: - Ingredients of LinkedList:
  // 1. Đầu - Head
  // 2. Đuôi - Tail
  // 3. Thân - Node (Có data và pointer trách nhiệm trỏ tới next node)
  // Các loại linkedList: - Types of LinkedList:có nhiều loại linkedList nhưng chủ yếu sử dụng 2 loại:
  // 1. Singly Linked List: 1 node chỉ trỏ tới 1 node tiếp theo
  // 2. Doubly Linked List: 1 node trỏ tới 1 node tiếp theo và 1 node trỏ tới 1 node trước đó
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
