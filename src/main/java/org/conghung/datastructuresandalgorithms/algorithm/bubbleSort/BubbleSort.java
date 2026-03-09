package org.conghung.datastructuresandalgorithms.algorithm.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
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
