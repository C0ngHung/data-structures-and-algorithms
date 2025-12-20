package org.conghung.datastructuresandalgorithms.dsa.stack;

public class StackPart1 {
    // Định nghĩa - Definition:
    // Definition:
    // Stack là một cấu trúc dữ liệu dành để lưu trữ dữ liệu
    // A stack is a data structure for storing data.
    // và đặc điểm của stack là nó có thứ tự stack có nghĩa là chồng lớp
    // It is ordered like stacked layers.
    // tuân theo nguyên tắc LIFO - Last In First Out
    // It follows the LIFO (Last In First Out) principle.
    // Phần tử được thêm vào cuối cùng sẽ được lấy ra đầu tiên
    // The last element pushed is the first one popped.
    // Khi nào nên dùng - when to use:
    // When to use:
    // - Thường được sử dụng trong các trường hợp như: undo/redo trong các trình soạn thảo văn bản,
    // - Commonly used for cases like undo/redo in editors,
    // duyệt cây (tree traversal), gọi hàm đệ quy, xử lý biểu thức toán học, v.v.
    // tree traversal, recursive calls, expression processing, etc.
    // Đặc điểm - Characteristics:
    // Characteristics:
    // - Chỉ cho phép thêm và xóa phần tử từ một đầu gọi là "đỉnh" (top) của stack.
    // - Only allows push and pop at one end called the top.
    // - Các thao tác chính: push (thêm phần tử), pop (lấy phần tử), peek (xem phần tử trên đỉnh mà không xóa).
    // - Main operations: push, pop, peek (view top without removing).
    // Thành phần của Stack - Ingredients of Stack:
    // Components of a Stack:
    // 1. Đỉnh - Top
    // 1. Top
    // 2. Dưới cùng - Bottom
    // 2. Bottom
    // Push và Pop:
    // Push and Pop:
    // - Push: Thêm một phần tử vào đỉnh của stack. Khi push vào stack đầy sẽ xảy ra stack overflow (tràn stack)
    // - Push: Add an element to the top. Pushing onto a full stack causes stack overflow
    // - Pop: Loại bỏ và trả về phần tử ở đỉnh của stack. Khi pop stack rỗng sẽ throw EmptyStackException
    // - Pop: Remove and return the top element. Popping an empty stack throws EmptyStackException
    // Stack Abstract Data Type (ADT) có thể được triển khai bằng nhiều cách khác nhau, phổ biến nhất là:
    // Stack ADT can be implemented in various ways, most commonly:
    // 1. Stack dựa trên mảng (Array-based Stack)
    // 1. Array-based Stack
    // 2. Stack dựa trên liên kết (Linked List-based Stack)
    // 2. Linked List-based Stack
    // 
    // Stack ADT bao gồm các phương thức: Push, Pop, Top/Peek, size, isStackEmpty, isFullStack
    // Stack ADT includes methods: Push, Pop, Top/Peek, size, isStackEmpty, isFullStack
    // 
    // Một số ứng dụng:
    // Some applications:
    // 1. Balanced parentheses (Kiểm tra dấu ngoặc trong biểu thức toán học có đúng hay không) - ứng dụng nổi tiếng nhất của stack
    // 1. Balanced parentheses (checking parentheses correctness in mathematical expressions) – classic stack application
    // 2. history trong trình duyệt web (back/forward) - sử dụng 2 stack để lưu trữ lịch sử
    // 2. Browser history (back/forward) – uses two stacks.
    // 3. Undo/Redo trong các trình soạn thảo văn bản - sử dụng 2 stack để lưu trữ lịch sử
    // 3. Undo/Redo in text editors – uses two stacks.
    // 4. Gọi hàm đệ quy (Function Call Stack) - mỗi lần gọi hàm sẽ được lưu trữ trong stack
    // 4. Recursive function calls (Call Stack) – each call stored in the stack.
    // 5. Traversing trees and graphs (Duyệt cây và đồ thị) - sử dụng stack để duyệt theo chiều sâu (DFS)
    // 5. Traversing trees and graphs – use stack for depth-first search (DFS).
    // 6. Expression evaluation and syntax parsing (Đánh giá biểu thức và phân tích cú pháp) - sử dụng stack để đánh giá biểu thức hậu tố (postfix) và tiền tố (prefix)
    // 6. Expression evaluation and parsing – use stack for postfix/prefix evaluation.

    // Khi nào nên dùng stack:
    // When to use a stack:
    // - Khi làm việc với hệ thống hoặc stack thêm bớt liên tục thì sử dụng stack dựa trên linked list sẽ hiệu quả hơn
    // - For systems with frequent push/pop, a linked-list-based stack can be more efficient.
    // - Khi biết trước kích thước tối đa của stack và cần truy cập nhanh thì sử dụng stack dựa trên mảng sẽ hiệu quả hơn
    // - When maximum size is known and fast access is needed, an array-based stack is better.
    public static void main(String[] args) {
        System.out.println("Stack - Nguyên tắc LIFO (Last In First Out)");
    }
}
