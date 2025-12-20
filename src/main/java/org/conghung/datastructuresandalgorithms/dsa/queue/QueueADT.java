package org.conghung.datastructuresandalgorithms.dsa.queue;

public interface QueueADT<T> extends Iterable<T> {
    void enqueue(T element); // Thêm phần tử vào cuối hàng đợi

    T dequeue(); // Lấy phần tử ra từ đầu hàng đợi

    T peek(); // Xem phần tử ở đầu hàng đợi mà không xóa

    int size(); // Trả về số lượng phần tử trong hàng đợi

    boolean isEmptyQueue(); // Kiểm tra xem hàng đợi có rỗng không
}
