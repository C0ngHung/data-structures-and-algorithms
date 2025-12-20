package org.conghung.datastructuresandalgorithms.dsa.queue;

public class QueueImplementation {
    // 1. Simple Circular Array Based
    // 1. Simple Circular Array Based
    // Cơ chế hoạt động - Mechanism:
    // Mechanism:
    // - Chúng ta có 1 array sau đó chúng ta enqueue vào thì chúng ta bắt đầu dịch
    // - We have an array; when we enqueue, we move the rear index.
    // index rear từ 0 đến n-1 (n là kích thước của array)
    // Rear index moves from 0 to n-1 (n is the array size).
    // - Khi mà rear đạt đến n-1, nó sẽ quay lại vị trí 0 (circular wrap) nếu queue chưa đầy
    // - When rear reaches n-1, it wraps to 0 (circular wrap) if the queue is not full
    // - Tương tự với front, khi mà ta dequeue thì ta sẽ dịch front từ 0 đến n-1
    // - Similarly for front: when dequeuing, front moves from 0 to n-1.
    // - Khi mà front đạt đến n-1, nó sẽ quay lại vị trí 0 (circular wrap) nếu queue không rỗng
    // - When front reaches n-1, it wraps to 0 (circular wrap) if the queue is not empty
    // Ưu điểm - Advantages:
    // Advantages:
    // - Tiết kiệm bộ nhớ hơn so với simple array based queue vì không bị lãng phí không gian khi có nhiều phần tử được dequeue
    // - Saves more memory than simple array-based queues because space isn’t wasted after many dequeues.
    // Nhược điểm - Disadvantages:
    // Disadvantages:
    // - Phức tạp hơn trong việc quản lý các con trỏ front và rear
    // - More complex to manage front and rear pointers.
    // - Cần phải xử lý trường hợp tràn (overflow) và dưới (underflow) một cách cẩn thận
    // - Must handle overflow and underflow carefully.
    // Các phương thức chính - Key Methods:
    // Key Methods:
    // - enqueue(item): Thêm một phần tử vào cuối hàng đợi
    // - enqueue(item): Add an element to the end of the queue.
    // - dequeue(): Loại bỏ và trả về phần tử ở đầu hàng đợi
    // - dequeue(): Remove and return the front element.
    // - front(): Trả về phần tử ở đầu hàng đợi mà không loại bỏ nó
    // - front(): Return the front element without removing it.
    // - size(): Trả về số lượng phần tử hiện có trong hàng đợi
    // - size(): Return the current number of elements.
    // - isEmptyQueue(): Kiểm tra xem hàng đợi có rỗng hay không
    // - isEmptyQueue(): Check whether the queue is empty.
    // - Hầu hết các độ phức tạp thời gian của các phương thức này là O(1) giống như stack
    // - Most of these operations are O(1), similar to a stack.
    // - Nhưng nếu chúng ta enqueue và dequeue liên tục thì sử dụng linked list based queue sẽ hiệu quả hơn
    // - But with very frequent enqueue/dequeue, a linked-list-based queue can be more efficient.
    // - vì nó không bị giới hạn bởi kích thước cố định và không cần resize array
    // - because it's not limited by fixed size and doesn't require array resizing
    // - Nhưng tốc độ của linked list based queue sẽ chậm hơn so với array based queue vì liên quan đến việc cấp phát bộ nhớ động
    // - However, linked-list-based queues can be slower than array-based ones due to dynamic memory allocation.
    // 2. Dynamic Circular Array Based
    // 2. Dynamic Circular Array Based
    // 3. Linked List Based
    // 3. Linked List Based
    // Hầu hết các implementation của queue giống như bên stack
    // Most queue implementations resemble those of stacks.

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
