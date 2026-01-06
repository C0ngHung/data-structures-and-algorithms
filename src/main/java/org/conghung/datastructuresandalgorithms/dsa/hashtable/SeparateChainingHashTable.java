package org.conghung.datastructuresandalgorithms.dsa.hashtable;

import org.conghung.datastructuresandalgorithms.dsa.linkedlist.Course8LinkedListPart3Code;
import org.conghung.datastructuresandalgorithms.dsa.linkedlist.DoublyLinkedList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SeparateChainingHashTable<K, V> implements HashTableADT<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private final double loadFactor;

    private int size = 0, capacity, threshold;

    private DoublyLinkedList<Node<K, V>>[] table;

    public SeparateChainingHashTable() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
        // Gọi constructor có tham số với các giá trị mặc định
        // Call the parameterized constructor with default values
    }

    public SeparateChainingHashTable(int capacity) {
        this(DEFAULT_LOAD_FACTOR, capacity);
        // Gọi constructor chính với load factor mặc định và capacity được truyền vào
        // Call the main constructor with default load factor and provided capacity
    }

    public SeparateChainingHashTable(double loadFactor, int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be a positive integer");
        // Kiểm tra capacity phải là số dương
        // Check if capacity is a positive integer

        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
            throw new IllegalArgumentException("loadFactor must be a positive number");
        // Kiểm tra loadFactor phải là số dương hợp lệ (đã sửa thông báo lỗi từ 'integer' thành 'number')
        // Check if loadFactor is a valid positive number (fixed error message from 'integer' to 'number')

        this.loadFactor = loadFactor;
        // Gán loadFactor được truyền vào cho biến instance
        // Assign the provided loadFactor to the instance variable

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        // Đảm bảo capacity ít nhất bằng mức mặc định
        // Ensure capacity is at least the default value

        this.threshold = (int) (this.capacity * this.loadFactor);
        // Tính toán ngưỡng (threshold) để biết khi nào cần thay đổi kích thước bảng
        // Calculate the threshold to know when to resize the table

        table = new DoublyLinkedList[this.capacity];
        // Khởi tạo mảng các danh sách liên kết (buckets)
        // Initialize the array of linked lists (buckets)
    }

    @Override
    public int size() {
        return size;
        // Trả về số lượng phần tử hiện tại trong bảng băm
        // Return the current number of elements in the hash table
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
        // Kiểm tra xem bảng băm có rỗng không
        // Check if the hash table is empty
    }

    @Override
    public int hashCodeToIndex(int hashedKey) {
        return (hashedKey & 0x7FFFFFFF) % capacity;
        // Chuyển đổi mã băm thành chỉ số index hợp lệ trong mảng
        // Convert hash code to a valid index in the array
        // Phép AND 0x7FFFFFFF để loại bỏ dấu âm (đảm bảo số dương)
        // Bitwise AND 0x7FFFFFFF removes the sign bit (ensures positive number)
        // Mod (%) capacity để tính vị trí nằm trong khoảng [0, capacity - 1]
        // Mod (%) capacity calculates position within range [0, capacity - 1]
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        // Xóa sạch tham chiếu đến các danh sách liên kết trong mảng
        // Clear references to linked lists in the array
        size = 0;
        // Đặt lại kích thước về 0
        // Reset size to 0
    }

    @Override
    public boolean has(K key) {
        int index = hashCodeToIndex(key.hashCode());
        // Tìm vị trí bucket (index) dựa trên mã băm của khóa
        // Find bucket position (index) based on key's hash code

        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        // Lấy danh sách liên kết tại vị trí index đó
        // Get the linked list at that index

        if (linkedList == null || linkedList.isEmpty()) return false;
        // Nếu không có danh sách hoặc danh sách rỗng, trả về false
        // If no list or list is empty, return false

        Iterator<Node<K, V>> iterator = linkedList.iterator();
        // Lấy iterator để duyệt qua các phần tử trong danh sách
        // Get iterator to traverse elements in the list

        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            // Lấy nốt tiếp theo
            // Get next node
            if (node.getKey().equals(key)) return true;
            // Nếu tìm thấy khóa trùng khớp, trả về true
            // If matching key found, return true
        }
        return false;
        // Không tìm thấy sau khi duyệt hết, trả về false
        // Not found after traversing all, return false
    }

    @Override
    public V insert(K key, V value) {
        int index = hashCodeToIndex(key.hashCode());
        // Tính toán index cho khóa mới
        // Calculate index for the new key

        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        // Lấy bucket (danh sách) tại index
        // Get bucket (list) at index

        if (linkedList == null) table[index] = linkedList = new Course8LinkedListPart3Code<>();
        // Nếu bucket chưa tồn tại, khởi tạo danh sách mới
        // If bucket doesn't exist, initialize a new list

        Node<K, V> existedNode = null;
        // Khởi tạo biến để lưu node nếu tìm thấy (sửa lỗi: cần khởi tạo null)
        // Initialize variable to store node if found (fix: need to initialize to null)

        Iterator<Node<K, V>> iterator = linkedList.iterator();
        // Duyệt qua danh sách để kiểm tra khóa đã tồn tại chưa
        // Traverse list to check if key already exists

        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) {
                existedNode = node;
                // Lưu lại node tìm thấy
                // Save found node
                break; 
                // Dừng vòng lặp ngay khi tìm thấy (sửa lỗi: tối ưu hiệu năng)
                // Stop loop immediately when found (fix: optimize performance)
            }
        }

        if (existedNode == null) {
            // Nếu khóa chưa tồn tại
            // If key does not exist
            linkedList.add(new Node<>(key, value));
            // Thêm node mới vào danh sách
            // Add new node to the list
            if (++size > threshold) resizeTable();
            // Tăng kích thước và kiểm tra nếu vượt quá ngưỡng thì thay đổi kích thước bảng
            // Increment size and check if threshold exceeded, then resize table
            return null;
            // Trả về null vì đây là phần tử mới
            // Return null as this is a new element
        } else {
            // Nếu khóa đã tồn tại
            // If key already exists
            V oldValue = existedNode.getValue();
            // Lưu lại giá trị cũ
            // Save old value
            existedNode.setValue(value);
            // Cập nhật giá trị mới
            // Update new value
            return oldValue;
            // Trả về giá trị cũ
            // Return old value
        }
    }

    private void resizeTable() {
        capacity *= 2;
        // Tăng gấp đôi kích thước bảng
        // Double the table capacity

        threshold = (int) (this.capacity * loadFactor);
        // Tính lại ngưỡng threshold mới
        // Recalculate new threshold

        DoublyLinkedList<Node<K, V>>[] newTable = new DoublyLinkedList[capacity];
        // Tạo bảng mới với kích thước đã tăng
        // Create new table with increased capacity

        for (int i = 0; i < table.length; i++) {
        // Duyệt qua tất cả các bucket trong bảng cũ
        // Iterate through all buckets in the old table
            if (table[i] == null) continue;
            // Bỏ qua nếu bucket trống
            // Skip if bucket is empty

            Iterator<Node<K, V>> iterator = table[i].iterator();
            // Duyệt qua từng phần tử trong bucket
            // Iterate through each element in the bucket

            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                int index = hashCodeToIndex(node.getKey().hashCode());
                // Tính toán lại index mới cho phần tử (sửa lỗi: dùng key hashcode cho an toàn)
                // Recalculate new index for the element (fix: use key hashcode for safety)

                DoublyLinkedList<Node<K, V>> linkedList = newTable[index];
                if (linkedList == null) newTable[index] = linkedList = new Course8LinkedListPart3Code<>();
                // Tạo bucket mới trong bảng mới nếu chưa có
                // Create new bucket in new table if not exists

                linkedList.add(node);
                // Thêm phần tử vào bảng mới
                // Add element to new table
            }

            table[i].clear();
            // Xóa dữ liệu bucket cũ để giải phóng bộ nhớ
            // Clear old bucket data to free memory
            table[i] = null;
            // Gán null cho bucket cũ
            // Set old bucket to null
        }

        table = newTable;
        // Cập nhật tham chiếu bảng chính sang bảng mới
        // Update main table reference to new table
    }

    @Override
    public V get(K key) {
        int index = hashCodeToIndex(key.hashCode());
        // Lấy index
        // Get index
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        // Lấy bucket
        // Get bucket
        if (linkedList == null || linkedList.isEmpty()) return null;
        // Không tìm thấy bucket, trả về null
        // Bucket not found, return null

        Iterator<Node<K, V>> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) return node.getValue();
            // Tìm thấy khóa, trả về giá trị
            // Found key, return value
        }

        return null;
        // Không tìm thấy sau khi duyệt, trả về null
        // Not found after traversal, return null
    }

    @Override
    public V remove(K key) {
        int index = hashCodeToIndex(key.hashCode());
        // Lấy index
        // Get index

        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        // Lấy bucket
        // Get bucket

        if (linkedList == null || linkedList.isEmpty()) return null;
        // Bucket trống, không có gì để xóa
        // Bucket empty, nothing to remove

        Iterator<Node<K, V>> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) {
                linkedList.remove(node);
                // Xóa node khỏi danh sách liên kết
                // Remove node from linked list
                --size;
                // Giảm số lượng phần tử của bảng
                // Decrease table size
                return node.getValue();
                // Trả về giá trị của node bị xóa
                // Return value of removed node
            }
        }
        return null;
        // Không tìm thấy khóa để xóa
        // Key not found to remove
    }

    @Override
    public Iterator<K> iterator() {

        final int elementCount = size();
        // Lưu lại số lượng phần tử tại thời điểm bắt đầu duyệt để kiểm tra đồng bộ
        // Capture element count at start of iteration for concurrency check

        return new Iterator<K>() {

            int index = 0;
            // Index hiện tại của bảng (bucket) đang duyệt
            // Current index of table (bucket) being traversed

            Iterator<Node<K, V>> bucketIterator = table[index] == null ? null : table[0].iterator();
            // Iterator cho bucket hiện tại
            // Iterator for current bucket

            @Override
            public boolean hasNext() {
                if (elementCount != size()) throw new ConcurrentModificationException("HashTable modified during iteration");
                // Ném lỗi nếu dữ liệu bị thay đổi trong quá trình duyệt
                // Throw error if data modified during iteration

                if (bucketIterator == null || !bucketIterator.hasNext()) {
                    // Nếu bucket hiện tại đã duyệt hết hoặc null
                    // If current bucket exhausted or null
                    while (++index < capacity) {
                        // Di chuyển sang bucket tiếp theo
                        // Move to next bucket
                        if (table[index] != null && !table[index].isEmpty()) {
                            // Sửa lỗi: dùng && thay vì || để đảm bảo bucket tồn tại VÀ có dữ liệu
                            // Fix: use && instead of || to ensure bucket exists AND has data
                            bucketIterator = table[index].iterator();
                            // Cập nhật iterator cho bucket mới tìm thấy
                            // Update iterator for the found bucket
                            break;
                            // Dừng tìm kiếm bucket
                            // Stop searching for bucket
                        }
                    }
                }

                return index < capacity;
                // Trả về true nếu vẫn còn trong phạm vi bảng (tức là còn phần tử)
                // Return true if still within table bounds (meaning elements remain)
            }

            @Override
            public K next() {
                return bucketIterator.next().getKey();
                // Trả về key của phần tử tiếp theo
                // Return key of next element
            }
        };
    }
}

