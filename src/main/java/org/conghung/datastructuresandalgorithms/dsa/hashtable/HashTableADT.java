package org.conghung.datastructuresandalgorithms.dsa.hashtable;

public interface HashTableADT<K, V> extends Iterable<K> {

    int size();
    // Trả về số lượng phần tử
    // Return number of elements

    boolean isEmpty();
    // Kiểm tra rỗng
    // Check if empty

    // hash code
    int hashCodeToIndex(int hashedKey);
    // Chuyển mã băm thành chỉ số
    // Convert hash code to index

    void clear();
    // Xóa tất cả phần tử
    // Clear all elements

    boolean has(K key);
    // Kiểm tra khóa có tồn tại không
    // Check if key exists

    V insert(K key, V value);
    // Thêm hoặc cập nhật cặp key-value
    // Insert or update key-value pair

    V get(K key);
    // Lấy giá trị theo khóa
    // Get value by key

    V remove(K key);
    // Xóa phần tử theo khóa
    // Remove element by key

}
