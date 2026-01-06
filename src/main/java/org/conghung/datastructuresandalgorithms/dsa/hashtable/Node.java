package org.conghung.datastructuresandalgorithms.dsa.hashtable;

public class Node<K, V> {

    private final int hash;
    private K key;
    private V value;

    public Node( K key, V value) {
        this.hash = key.hashCode();
        // Lưu mã băm của khóa để sử dụng sau này
        // Store the hash code of the key for later use
        this.key = key;
        // Khởi tạo khóa
        // Initialize key
        this.value = value;
        // Khởi tạo giá trị
        // Initialize value
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Kiểm tra tham chiếu cùng trỏ đến 1 đối tượng
        // Check if references point to the same object
        if (obj == null || getClass() != obj.getClass()) return false;
        // Kiểm tra null hoặc khác lớp
        // Check for null or different class

        Node<?, ?> other = (Node<?, ?>) obj;
        if (hash != other.hash) return false;
        // So sánh mã băm trước cho nhanh
        // Compare hash code first for speed

        return key.equals(other.key);
        // So sánh nội dung khóa
        // Compare key content
    }

    public K getKey() {
        return key;
        // Lấy khóa
        // Get key
    }

    public V getValue() {
        return value;
        // Lấy giá trị
        // Get value
    }

    public void setValue(V value) {
        this.value = value;
        // Cập nhật giá trị
        // Update value
    }

    public int getHash() {
        return hash;
        // Lấy mã băm đã lưu
        // Get stored hash code
    }

    public void setKey(K key) {
        this.key = key;
        // Cập nhật khóa (lưu ý: không nên đổi khóa trong bảng băm)
        // Set key (note: should not change key in hash table)
    }

    @Override
    public String toString() {
        return "key=" + key + ", value=" + value;
        // Trả về chuỗi đại diện cho node
        // Return string representation of node
    }
}

