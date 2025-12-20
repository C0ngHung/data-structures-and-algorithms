package org.conghung.datastructuresandalgorithms.dsa.queue;

public class QueueImplementation {
    // 1. Simple Circular Array Based
    // Cơ chê hoạt hoạt động - Mechanism:
    // - Chúng ta có 1 array sau đó chúng ta enqueue vào thì chúng ta bắt đầu dịch
    // index rear từ 0 đến n-1 (n là kích thước của array)
    // - Khi mà rear đạt đến n-1 thì ta sẽ quay lại vị trí 0 nếu như vị trí đó trống
    // - Tương tự với front, khi mà ta dequeue thì ta sẽ dịch front từ 0 đến n-1
    // - Khi mà front đạt đến n-1 thì ta sẽ quay lại vị trí 0 nếu như vị trí đó có phần tử
    // Ưu điểm - Advantages:
    // - Tiết kiệm bộ nhớ hơn so với simple array based queue vì không bị lãng phí không gian khi có nhiều phần tử được dequeue
    // Nhược điểm - Disadvantages:
    // - Phức tạp hơn trong việc quản lý các con trỏ front và rear
    // - Cần phải xử lý trường hợp tràn (overflow) và dưới (underflow) một cách cẩn thận
    // Các phương thức chính - Key Methods:
    // - enqueue(item): Thêm một phần tử vào cuối hàng đợi
    // - dequeue(): Loại bỏ và trả về phần tử ở đầu hàng đợi
    // - front(): Trả về phần tử ở đầu hàng đợi mà không loại bỏ nó
    // - size(): Trả về số lượng phần tử hiện có trong hàng đợi
    // - isEmptyQueue(): Kiểm tra xem hàng đợi có rỗng hay không
    // - Hầu hết các độ phức tạp thời gian của các phương thức này là O(1) giống như stack
    // - Nhưng nếu chúng ta enqueue và dequeue liên tục thì sử dụng linked list based queue sẽ hiệu quả hơn
    // - vì nó không liên quan đến size
    // - Nhưng tốc độ của linked list based queue sẽ chậm hơn so với array based queue vì liên quan đến việc cấp phát bộ nhớ động
    // 2. Dynamic Circular Array Based
    // 3. Linked List Based
    // Hầu hết các implementation của queue giống như bên stack

    public static void main(String[] args) {
        System.out.println("Queue - Nguyên tắc FIFO (First In First Out)");
        System.out.println("Bảng so sánh các implementation phổ biến của Queue:");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-20s | %-20s |\n", "Implementation", "Ưu điểm", "Nhược điểm");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-20s | %-20s |\n",
                "Simple Circular Array Based",
                "Tiết kiệm bộ nhớ hơn so với simple array based queue",
                "Phức tạp hơn trong việc quản lý các con trỏ front và rear");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-20s | %-20s |\n",
                "Dynamic Circular Array Based",
                "Kích thước linh hoạt, không bị giới hạn bởi kích thước ban đầu",
                "Phức tạp hơn trong việc quản lý bộ nhớ và có thể chậm hơn do việc cấp phát lại bộ nhớ");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-20s | %-20s |\n",
                "Linked List Based",
                "Kích thước linh hoạt, dễ dàng thêm và xóa phần tử",
                "Sử dụng nhiều bộ nhớ hơn do lưu trữ các con trỏ và có thể chậm hơn do việc cấp phát bộ nhớ động");
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
