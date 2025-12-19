package org.conghung.datastructuresandalgorithms.dsa.stack;

public class StackPart1 {
    // Định nghĩa - Definition:
    // Stack là một cấu trúc dữ liệu dành để lưu trữ dữ liệu
    // và đặc điểm của stack là nó có thứ tự stack có nghĩa là chồng lớp
    // tuân theo nguyên tắc LIFO - Last In First Out
    // Phần tử được thêm vào cuối cùng sẽ được lấy ra đầu tiên
    // Khi nào nên dùng - when to use:
    // - Thường được sử dụng trong các trường hợp như: undo/redo trong các trình soạn thảo văn bản,
    // duyệt cây (tree traversal), gọi hàm đệ quy, xử lý biểu thức toán học, v.v.
    // Đặc điểm - Characteristics:
    // - Chỉ cho phép thêm và xóa phần tử từ một đầu gọi là "đỉnh" (top) của stack.
    // - Các thao tác chính: push (thêm phần tử), pop (lấy phần tử), peek (xem phần tử trên đỉnh mà không xóa).
    // Thành phần của Stack - Ingredients of Stack:
    // 1. Đỉnh - Top
    // 2. Dưới cùng - Bottom
    // Push và Pop:
    // - Push: Thêm một phần tử vào đỉnh của stack. Khi mà push vào 1 stack mà stack đó đầy thì sẽ xảy ra hiện tượng gọi là stack overflowException
    // - Pop: Loại bỏ và trả về phần tử ở đỉnh của stack. Khi mà pop 1 stack mà stack đó rỗng thì sẽ xảy ra hiện tượng gọi là stack underflowException
    // - Các loại Stack - Types of Stack:
    // Stack Abstract Data Type (ADT) có thể được triển khai bằng nhiều cách khác nhau, phổ biến nhất là:
    // Các implementation phổ biến trong stack:
    // Push, Pop, Top/Peek, size, isStackEmpty, isFullStack
    // Một số ứng dụng:
    // 1. Simple balance sens (Có nghĩa là kiểm tra dấu ngoặc trong biểu thức toán học có đúng hay không) - ứng dụng nổi tiếng nhất cuủa stack
    // 2. history trong trình duyệt web (back/forward) - sử dụng 2 stack để lưu trữ lịch sử
    // 3. Undo/Redo trong các trình soạn thảo văn bản - sử dụng 2 stack để lưu trữ lịch sử
    // 4. Gọi hàm đệ quy (Function Call Stack) - mỗi lần gọi hàm sẽ được lưu trữ trong stack
    // 5. Traversing trees and graphs (Duyệt cây và đồ thị) - sử dụng stack để duyệt theo chiều sâu (DFS)
    // 6. Expression evaluation and syntax parsing (Đánh giá biểu thức và phân tích cú pháp) - sử dụng stack để đánh giá biểu thức hậu tố (postfix) và tiền tố (prefix)
    // Các implementation phổ biến trong stack:
    // 1. Stack dựa trên mảng (Array-based Stack)
    // 2. Stack dựa trên liên kết (Linked List-based Stack)
    public static void main(String[] args) {
        System.out.println("Stack - Nguyên tắc LIFO (Last In First Out)");
    }
}
