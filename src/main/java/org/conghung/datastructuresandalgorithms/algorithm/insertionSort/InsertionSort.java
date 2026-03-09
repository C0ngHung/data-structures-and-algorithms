package org.conghung.datastructuresandalgorithms.algorithm.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // Duyệt từ phần tử thứ 2 (index 1), phần tử đầu tiên coi như đã sorted
        for (int i = 1; i < n; i++) {
            // Lưu phần tử hiện tại vào key — tránh bị ghi đè khi shift
            T key = arr[i];
            int j = i - 1;

            // Dịch (shift) các phần tử lớn hơn key sang phải 1 vị trí
            // Dừng khi gặp phần tử <= key hoặc đã duyệt hết phần sorted
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Chèn key vào chỗ trống vừa tạo ra (vị trí j+1)
            arr[j + 1] = key;
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After:  " + Arrays.toString(numbers));

        String[] words = {"banana", "apple", "cherry", "date"};

        System.out.println("\nBefore: " + Arrays.toString(words));
        sort(words);
        System.out.println("After:  " + Arrays.toString(words));
    }
}
