package org.conghung.datastructuresandalgorithms.dsa.hashtable;

import java.util.Random;

public class Test {
    static final int NUMBER_OF_KEYS = 1000000;
    // Số lượng khóa cần test
    // Number of keys to test
    static final int MOD = 10000000;
    // Giới hạn giá trị khóa
    // Limit of key values
    static int[] keys = new int[NUMBER_OF_KEYS];
    static int[] values = new int[NUMBER_OF_KEYS];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < keys.length; i++) {
            keys[i] = random.nextInt(MOD);
            values[i] = random.nextInt(MOD);
        }
        // Tạo dữ liệu ngẫu nhiên
        // Generate random data
        testSeparateChaining();
    }

    private static void testSeparateChaining() {

        HashTableADT<Integer, Integer> hashTable = new SeparateChainingHashTable<>();
        // Khởi tạo HashTable
        // Initialize HashTable

        long start = System.nanoTime();
        // Bắt đầu đo thời gian
        // Start measuring time

        for (int i =  0; i < NUMBER_OF_KEYS ; i++) {
            hashTable.insert(keys[i], values[i]);
            // Thêm phần tử
            // Insert element
            int value = hashTable.get(keys[i]);
            // Lấy lại phần tử vừa thêm để kiểm tra
            // Retrieve the inserted element to veriy
            if (value != values[i]) System.out.println("Error: value mismatch for key " + keys[i]);
            // Báo lỗi nếu giá trị không khớp
            // Report error if values mismatch
        }
        long end = System.nanoTime();
        // Kết thúc đo thời gian
        // End measuring time
        System.out.println("Separate Chaining Hash Table: " + (end - start) / 1e6 + " ms");
        // In ra thời gian thực thi (chia cho 1e6 để ra mili giây)
        // Print execution time (divide by 1e6 to get milliseconds)
    }
}
