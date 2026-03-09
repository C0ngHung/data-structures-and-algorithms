package org.conghung.datastructuresandalgorithms.algorithm.mergeSort;

import java.util.Arrays;

/**
 * Merge Sort — Divide and Conquer (Chia để trị)
 *
 * Ý tưởng:
 *   1. CẮT ĐÔI mảng cho đến khi mỗi mảnh chỉ còn 1 phần tử (1 phần tử = đã sorted)
 *   2. GHÉP (merge) 2 mảnh đã sorted thành 1 mảng sorted — giống xếp 2 bộ bài đã xếp thành 1 bộ
 *
 * Ví dụ tổng quát:
 *   [5, 3, 8, 1] → chia → [5, 3] [8, 1] → chia → [5] [3] [8] [1]
 *                 → merge → [3, 5] [1, 8] → merge → [1, 3, 5, 8] ✅
 *
 * Complexity: O(n log n) mọi trường hợp | Space: O(n) cho mảng tạm
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        // Mảng null hoặc chỉ có 0-1 phần tử → đã sorted, không cần làm gì
        if (arr == null || arr.length <= 1) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Bước CHIA: cắt đôi mảng rồi đệ quy cho đến khi chỉ còn 1 phần tử.
     *
     * Ví dụ: mergeSort([5, 3, 8, 1], 0, 3)
     *   mid = 1
     *   → mergeSort([5, 3, 8, 1], 0, 1)  ← sort nửa trái [5, 3]
     *   → mergeSort([5, 3, 8, 1], 2, 3)  ← sort nửa phải [8, 1]
     *   → merge(arr, 0, 1, 3)            ← ghép 2 nửa đã sorted
     */
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        // Base case: left >= right nghĩa là mảng chỉ còn 0 hoặc 1 phần tử → đã sorted
        if (left < right) {
            // Tính điểm giữa — dùng left + (right - left) / 2 thay vì (left + right) / 2
            // để tránh integer overflow khi left + right > Integer.MAX_VALUE
            int mid = left + (right - left) / 2;

            // Đệ quy sort nửa trái [left..mid]
            mergeSort(arr, left, mid);

            // Đệ quy sort nửa phải [mid+1..right]
            mergeSort(arr, mid + 1, right);

            // SAU KHI 2 nửa đã sorted → ghép chúng lại thành 1 mảng sorted
            merge(arr, left, mid, right);
        }
    }

    /**
     * Bước GHÉP (cốt lõi của Merge Sort):
     * Merge 2 nửa đã sorted: arr[left..mid] và arr[mid+1..right] → 1 mảng sorted.
     *
     * Kỹ thuật: Two-Pointer — 2 con trỏ i, j duyệt 2 mảng tạm,
     * so sánh từng cặp, lấy cái nhỏ hơn đặt vào mảng gốc.
     *
     * Ví dụ: merge leftArr=[3,5] + rightArr=[1,8]:
     *   Bước 1: 3 vs 1 → lấy 1   → [1, _, _, _]
     *   Bước 2: 3 vs 8 → lấy 3   → [1, 3, _, _]
     *   Bước 3: 5 vs 8 → lấy 5   → [1, 3, 5, _]
     *   Bước 4: left hết → lấy 8 → [1, 3, 5, 8] ✅
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {

        // --- Bước 1: Tạo 2 mảng tạm copy 2 nửa ra ngoài ---
        // Vì ta sẽ ghi đè lên arr[left..right], nên cần lưu dữ liệu gốc
        int n1 = mid - left + 1;    // Số phần tử nửa trái
        int n2 = right - mid;       // Số phần tử nửa phải

        // Java không cho tạo generic array trực tiếp (new T[n]),
        // nên dùng (T[]) new Comparable[n] rồi @SuppressWarnings ở trên
        T[] leftArr = (T[]) new Comparable[n1];
        T[] rightArr = (T[]) new Comparable[n2];

        // Copy nửa trái: arr[left..mid] → leftArr
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        // Copy nửa phải: arr[mid+1..right] → rightArr
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // --- Bước 2: Two-Pointer merge ---
        // i = con trỏ duyệt leftArr
        // j = con trỏ duyệt rightArr
        // k = vị trí ghi tiếp theo trong arr gốc
        int i = 0, j = 0;
        int k = left;

        // So sánh từng cặp leftArr[i] vs rightArr[j],
        // lấy cái nhỏ hơn đặt vào arr[k]
        while (i < n1 && j < n2) {
            // <= (không phải <) → nếu bằng nhau, lấy LEFT trước
            // → ĐẢM BẢO STABLE (phần tử bằng nhau giữ thứ tự ban đầu)
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // --- Bước 3: Copy phần còn lại ---
        // Khi 1 mảng hết, mảng kia còn dư → copy thẳng vào (đã sorted sẵn)

        // Nếu leftArr còn dư
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Nếu rightArr còn dư
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
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
