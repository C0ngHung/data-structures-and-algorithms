package org.conghung.datastructuresandalgorithms.dsa.recursion;

public class Recursion {
    // Đệ quy - Recursion:
    // Recursion:
    // Định nghĩa - Definition:
    // Definition:
    // Đệ quy là một kỹ thuật lập trình trong đó một hàm gọi chính nó để giải quyết một vấn đề.
    // Recursion is a programming technique where a function calls itself to solve a problem.
    // Và mỗi lần 1 hàm đệ quy nó gọi lại chính nó thì nó được gọi là một bậc đệ quy hoặc 1 bước đệ quy - recursive level
    // Each time a recursive function calls itself is considered a recursive level or step.
    // Và quan trọng nhất đối với đệ quy là các bạn phải terminate (kết thúc) thoát ra khỏi đệ quy
    // The most important part of recursion is having a termination condition to exit.
    // Nếu không có điều kiện thoát thì hàm đệ quy sẽ throw ra lỗi StackOverflowError
    // Without a base case, the recursive function will throw a StackOverflowError.
    // function đệ quy mỗi lần gọi chính nó sẽ đẩy một stack frame (chứa parameters, local variables, return address) vào call stack
    // Each recursive call pushes a stack frame (containing parameters, local variables, return address) onto the call stack.
    // và nó cứ đẩy liên tục sau mỗi bậc đệ quy và sẽ dẫn đến stack overflow vì function của bạn bị tràn ngăn xếp
    // Continuous pushing at each recursive level can lead to stack overflow.
    // Khi nào nên dùng - When to use:
    // When to use:
    // Khi bạn gặp các bài toán mà nó có tính chất lặp đi lặp lại giống nhau và có thể chia nhỏ vấn đề ra để giải quyết
    // When problems are repetitive in nature and can be broken into smaller subproblems.
    // Ví dụ: Tính giai thừa, tính dãy Fibonacci, tìm kiếm
    // Examples: Factorial, Fibonacci sequence, searching.

    // Fibonacci
    // fib = 1 1 2 3 5 8 13 21 34 55 89 144 ...
    // (fib(0) = 1, fib(1) = 1, fib(2) = 2, fib(3) = 3, ...)
    // fib(2) = fib(1) + fib(0) = 1 + 1 = 2
    // fib(n) = fib(n-1) + fib(n-2)
    // chia dãy Fibonacci thành các phần nhỏ hơn để tính toán: n < 2: return 1; n >= 2: fib(n) = fib(n-1) + fib(n-2)
    // break the Fibonacci sequence into smaller parts: for n < 2: return 1; for n >= 2: fib(n) = fib(n-1) + fib(n-2)
    // n = 4: fib(4) = fib(3) + fib(2) = (fib(2) + fib(1)) + (fib(1) + fib(0)) = ((fib(1) + fib(0)) + 1) + (1 + 1) = (1 + 1 + 1) + 2 = 5
    // n = 4: fib(4) = fib(3) + fib(2) = 3 + 2 = 5 (with fib(0) = 1, fib(1) = 1, fib(2) = 2, fib(3) = 3)

    // Lợi ích - Benefits:
    // Benefits:
    // Code ngắn gọn, dễ đọc, dễ hiểu
    // Concise, readable, and easy to understand code.
    // Dễ dàng giải quyết các bài toán phức tạp
    // Simplifies solving complex problems.

    // Nhược điểm - Drawbacks:
    // Drawbacks:
    // Hiệu suất kém hơn so với các giải pháp lặp (iterative)
    // Lower performance than iterative solutions.
    // Sử dụng nhiều bộ nhớ do ngăn xếp gọi (call stack)
    // Consumes more memory due to the call stack.

    // So sánh giữa Recursion và Iteration (lặp/loop):
    // Comparison between Recursion and Iteration (loop):
    // Recursion:
    // - Termination: Base case is reached - Điều kiện dừng được đạt tới
    // - Termination: Base case is reached.
    // - Memory Usage: Each recursive step requires more memory - Mỗi bước đệ quy yêu cầu thêm bộ nhớ
    // - Memory Usage: Each recursive step requires more memory.
    // - Infinite: StackOverflowError
    // - Infinite: StackOverflowError.
    // Iteration:
    // - Termination: Loop condition becomes false - Điều kiện vòng lặp trở thành false
    // - Termination: Loop condition becomes false.
    // - Memory Usage: Each loop does not require additional memory - Mỗi vòng lặp không yêu cầu thêm bộ nhớ
    // - Memory Usage: Each loop does not require additional memory.
    // - Infinite: It just keeps running - Chỉ chạy mãi
    // - Infinite: It just keeps running.

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
