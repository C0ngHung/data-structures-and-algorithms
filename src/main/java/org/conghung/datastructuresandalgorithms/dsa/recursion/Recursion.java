package org.conghung.datastructuresandalgorithms.dsa.recursion;

public class Recursion {
    // Đệ quy - Recursion:
    // Định nghĩa - Definition:
    // Đệ quy là một kỹ thuật lập trình trong đó một hàm gọi chính nó để giải quyết một vấn đề.
    // Và mỗi lần 1 hàm đệ quy nó gọi lại chính nó thì nó được gọi là một bậc đệ quy hoặc 1 bước đệ quy - recursive level
    // Và quan trọng nhất đối với đệ quy là các bạn phải terminate (kết thúc) thoát ra khỏi đệ quy
    // Nếu không có điều kiện thoát thì hàm đệ quy sẽ throw ra lỗi StackOverflowError
    // function đệ quy mỗi lần gọi chính nó nó sẽ đẩy 1 cái copy của hàm đó vào trong ngăn xếp gọi là call stack
    // và nó cứ đẩy liên tục sau mỗi bậc đệ quy và sẽ dẫn đến stack overflow vì function của bạn bị tràn ngăn xếp
    // Khi nào nên dùng - When to use:
    // Khi bạn gặp các bài toán mà nó có tính chất lặp đi lặp lại giống nhau và có thể chia nhỏ vấn đề ra để giải quyết
    // Ví dụ: Tính giai thừa, tính dãy Fibonacci, tìm kiếm

    // Fibonacci
    // fib = 1 1 2 3 5 8 13 21 34 55 89 144 ...

    // fib(2) = fib(1) + fib(0)

    // fib(n) = fib(n-1) + fib(n-2)

    // chia dãy Fibonacci thành các phần nhỏ hơn để tính toán 1 dãy n < 2: 1 n >= 2 fib(n) = fib(n-1) + fib(n-2)

    // n = 4 fib(4) = fib(3) + fib(2) = fib(2) + fib(1) + fib(1) + fib(0) = fib(2) + 3 = fib(1) + fib(0) + 3 = 5

    // Lợi ích - Benefits:
    // Code ngắn gọn, dễ đọc, dễ hiểu
    // Dễ dàng giải quyết các bài toán phức tạp

    // Nhược điểm - Drawbacks:
    // Hiệu suất kém hơn so với các giải pháp lặp (iterative)
    // Sử dụng nhiều bộ nhớ do ngăn xếp gọi (call stack)

    // So sánh giữa Recursion và Iteration(lặp)(loop):
    // Recursion:
    // - Termination: Base case is reached - Điều kiện dừng được đạt tới
    // - Memory Usage: Each recursive step require more memory - Mỗi bước đệ quy yêu cầu thêm bộ nhớ
    // - Infinite: StackOverflowException
    // Iteration:
    // - Termination: Loop condition is false - Điều kiện vòng lặp sai
    // - Memory Usage: Each loop doesn't require more memory - Mỗi vòng lặp không yêu cầu thêm bộ nhớ
    // - Infinite: Just runs - Chỉ chạy mãi

    public static int fibonacci(int n) {
        if (n < 2) {
            return 1; // Đây là điều kiện dừng (base case)
        }
        // Tất cả đệ quy đều có 2 trường hợp:
        // 1. Base case (trường hợp dừng)
        // 2. Recursive case (trường hợp đệ quy)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int giaiThua(int n) {
        if (n == 0) {
            return 1; // Điều kiện dừng
        }
        return n * giaiThua(n - 1); // Trường hợp đệ quy
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10)); // Output: 89
        System.out.println(fibonacci(6)); // Output: 13

        System.out.println(giaiThua(4)); // Output: 120
    }
}
