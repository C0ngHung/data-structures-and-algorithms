package org.conghung.datastructuresandalgorithms.algorithm.quickSort;

import java.util.Arrays;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            // Partition: đưa pivot về đúng vị trí, trả về index của pivot
            int pivotIndex = partition(arr, low, high);

            // Đệ quy sort 2 nửa: bên trái pivot và bên phải pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // Chọn phần tử cuối làm pivot
        T pivot = arr[high];

        // i theo dõi ranh giới giữa vùng <= pivot và vùng > pivot
        int i = low - 1;

        // Duyệt từ low đến high-1, so sánh từng phần tử với pivot
        for (int j = low; j < high; j++) {
            // Nếu phần tử hiện tại <= pivot → đưa nó vào vùng bên trái
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        // Đặt pivot vào đúng vị trí (giữa vùng <= và vùng >)
        swap(arr, i + 1, high);
        return i + 1;
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
