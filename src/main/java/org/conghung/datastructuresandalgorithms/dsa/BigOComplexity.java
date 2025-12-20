package org.conghung.datastructuresandalgorithms.dsa;

/**
 * Big O Complexity - Giải thích chi tiết về Big O Notation cho người mới học DSA
 * Big O Complexity - Detailed explanation of Big O Notation for DSA beginners
 * 
 * Big O Notation là gì?
 * What is Big O Notation?
 * - Big O giúp chúng ta đánh giá hiệu suất (performance) của một thuật toán
 * - Big O helps us evaluate the performance of an algorithm
 * - Mô tả cách thời gian chạy hoặc không gian bộ nhớ tăng lên khi input size tăng
 * - Describes how runtime or memory space increases as input size grows
 * - Big O chỉ ra trường hợp tệ nhất (worst case) của thuật toán
 * - Big O indicates the worst case scenario of an algorithm
 * - Bỏ qua các hằng số (constants) và các thành phần bậc thấp (lower order terms)
 * - Ignores constants and lower order terms
 * 
 * Tại sao cần Big O?
 * Why do we need Big O?
 * - So sánh hiệu suất giữa các thuật toán khác nhau
 * - Compare performance between different algorithms
 * - Dự đoán hiệu suất khi input lớn
 * - Predict performance with large inputs
 * - Chọn thuật toán phù hợp cho từng bài toán
 * - Choose the appropriate algorithm for each problem
 * 
 * Các độ phức tạp phổ biến (từ nhanh đến chậm):
 * Common complexities (from fastest to slowest):
 * O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)
 */
public class BigOComplexity {
    
    public static void main(String[] args) {
        System.out.println("=== BIG O COMPLEXITY EXAMPLES ===\n");
        
        // Ex1: O(1) - Constant Time
        demonstrateO1();
        
        // Ex2: O(n) - Linear Time
        demonstrateOn();
        
        // Ex3: O(n^2) - Quadratic Time
        demonstrateOn2();
        
        // Ex4: O(log n) - Logarithmic Time
        demonstrateOLogN();
        
        // Ex5: O(n log n) - Linearithmic Time
        demonstrateONLogN();
        
        // Ex6: O(n^3) - Cubic Time
        demonstrateOn3();
    }
    
    /**
     * Ex1: O(1) - Constant Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Thời gian chạy KHÔNG phụ thuộc vào kích thước input
     * - Runtime does NOT depend on input size
     * - Dù input có 10 phần tử hay 10 triệu phần tử, thời gian chạy vẫn như nhau
     * - Whether input has 10 elements or 10 million, runtime remains the same
     * - Đây là độ phức tạp tốt nhất có thể
     * - This is the best possible complexity
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - Truy cập phần tử trong array bằng index: arr[5]
     * - Accessing array element by index: arr[5]
     * - Thêm/xóa phần tử ở cuối array (nếu biết vị trí)
     * - Adding/removing element at end of array (if position is known)
     * - Thao tác với HashMap (trung bình)
     * - Operations with HashMap (average case)
     * 
     * Tại sao vòng lặp while(i < 100) vẫn là O(1)?
     * Why is while(i < 100) still O(1)?
     * - Vì số lần lặp là CỐ ĐỊNH (100 lần), không phụ thuộc vào input size
     * - Because the number of iterations is FIXED (100 times), independent of input size
     * - Khi n tiến tới vô cùng, 100 vẫn là constant → O(1)
     * - When n approaches infinity, 100 remains constant → O(1)
     */
    private static void demonstrateO1() {
        System.out.println("--- Ex1: O(1) - Constant Time ---");
        
        // Thao tác đơn giản - O(1)
        int a = 1;
        int b = 2;
        int sum = a + b; // O(1) - chỉ 1 phép tính
        
        // Vòng lặp với số lần cố định - vẫn là O(1)
        int i = 0;
        while (i < 100) {
            i += 1;
        }
        // Tại sao vẫn là O(1)?
        // - Số lần lặp = 100 (constant, không đổi)
        // - Không phụ thuộc vào input size
        // - f(n) = 100 → O(f(n)) = O(1)
        
        // Truy cập phần tử trong array - O(1)
        int[] arr = new int[1000];
        int firstElement = arr[0]; // O(1) - truy cập trực tiếp bằng index
        
        System.out.println("O(1): Thời gian chạy không đổi, dù input lớn hay nhỏ\n");
    }
    
    /**
     * Ex2: O(n) - Linear Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Thời gian chạy TỶ LỆ THUẬN với kích thước input
     * - Runtime is PROPORTIONAL to input size
     * - Input tăng 2 lần → thời gian chạy tăng 2 lần
     * - Input doubles → runtime doubles
     * - Input tăng 10 lần → thời gian chạy tăng 10 lần
     * - Input increases 10x → runtime increases 10x
     * 
     * Công thức: f(n) = n → O(f(n)) = O(n)
     * Formula: f(n) = n → O(f(n)) = O(n)
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - Duyệt qua tất cả phần tử trong array/list
     * - Iterating through all elements in array/list
     * - Tìm kiếm tuyến tính (linear search) trong array chưa sắp xếp
     * - Linear search in unsorted array
     * - In tất cả phần tử trong collection
     * - Printing all elements in collection
     * 
     * Ví dụ số liệu:
     * Example data:
     * - n = 100 → cần 100 lần lặp
     * - n = 100 → needs 100 iterations
     * - n = 1000 → cần 1000 lần lặp
     * - n = 1000 → needs 1000 iterations
     * - n = 10000 → cần 10000 lần lặp
     * - n = 10000 → needs 10000 iterations
     */
    private static void demonstrateOn() {
        System.out.println("--- Ex2: O(n) - Linear Time ---");
        
        // Giả sử arr.length = n (có thể thay đổi)
        int[] arr = new int[100]; // Ví dụ với n=100
        
        // Duyệt qua tất cả phần tử - O(n)
        for (int j = 0; j < arr.length; j++) {
            arr[j] = j; // Mỗi phần tử được xử lý 1 lần
        }
        // Phân tích:
        // - Vòng lặp chạy n lần (n = arr.length)
        // - Mỗi lần lặp: 1 phép gán → tổng cộng n phép gán
        // - f(n) = n → O(f(n)) = O(n)
        
        // Tìm kiếm tuyến tính - O(n)
        int target = 50;
        int index = linearSearch(arr, target);
        System.out.println("Linear search: Tìm " + target + " tại index " + index);
        System.out.println("O(n): Thời gian chạy tỷ lệ thuận với n\n");
    }
    
    /**
     * Tìm kiếm tuyến tính - O(n)
     * Linear Search - O(n)
     * Duyệt qua từng phần tử từ đầu đến cuối cho đến khi tìm thấy
     * Iterate through each element from start to end until found
     */
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Tìm thấy → trả về index
            }
        }
        return -1; // Không tìm thấy
    }
    
    /**
     * Ex3: O(n^2) - Quadratic Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Thời gian chạy TỶ LỆ THUẬN với BÌNH PHƯƠNG của input size
     * - Runtime is PROPORTIONAL to the SQUARE of input size
     * - Input tăng 2 lần → thời gian chạy tăng 4 lần (2^2)
     * - Input doubles → runtime increases 4x (2^2)
     * - Input tăng 10 lần → thời gian chạy tăng 100 lần (10^2)
     * - Input increases 10x → runtime increases 100x (10^2)
     * 
     * Công thức: f(n) = n^2 → O(f(n)) = O(n^2)
     * Formula: f(n) = n^2 → O(f(n)) = O(n^2)
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - 2 vòng lặp lồng nhau duyệt qua tất cả phần tử
     * - 2 nested loops iterating through all elements
     * - Bubble Sort, Selection Sort, Insertion Sort
     * - Bubble Sort, Selection Sort, Insertion Sort
     * - Kiểm tra tất cả cặp phần tử trong array
     * - Checking all pairs of elements in array
     * 
     * Ví dụ số liệu:
     * Example data:
     * - n = 10 → cần 100 lần lặp (10^2)
     * - n = 10 → needs 100 iterations (10^2)
     * - n = 100 → cần 10,000 lần lặp (100^2)
     * - n = 100 → needs 10,000 iterations (100^2)
     * - n = 1000 → cần 1,000,000 lần lặp (1000^2)
     * - n = 1000 → needs 1,000,000 iterations (1000^2)
     */
    private static void demonstrateOn2() {
        System.out.println("--- Ex3: O(n^2) - Quadratic Time ---");
        
        int[] arr = new int[100]; // n = 100
        
        // 2 vòng lặp lồng nhau - O(n^2)
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr.length; l++) {
                arr[k] += arr[l]; // Mỗi cặp (k, l) được xử lý
            }
        }
        // Phân tích:
        // - Vòng lặp ngoài: k từ 0 đến n-1 (n lần)
        // - Vòng lặp trong: l từ 0 đến n-1 (n lần)
        // - Tổng số lần thực hiện: n × n = n^2
        // - f(n) = n^2 → O(f(n)) = O(n^2)
        
        // Trường hợp tối ưu hơn nhưng vẫn O(n^2)
        System.out.println("Trường hợp tối ưu: l bắt đầu từ k");
        int count = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int l = k; l < arr.length; l++) { // l bắt đầu từ k thay vì 0
                count++; // Đếm số lần thực hiện
            }
        }
        // Phân tích chi tiết:
        // - Vòng lặp ngoài: k từ 0 đến n-1 (n lần)
        // - Vòng lặp trong: l từ k đến n-1
        //   * k=0: l chạy từ 0 đến n-1 → n lần
        //   * k=1: l chạy từ 1 đến n-1 → (n-1) lần
        //   * k=2: l chạy từ 2 đến n-1 → (n-2) lần
        //   * ...
        //   * k=n-1: l chạy từ n-1 đến n-1 → 1 lần
        // - Tổng: n + (n-1) + (n-2) + ... + 2 + 1
        // - Công thức tổng dãy số: n(n+1)/2
        // - f(n) = n(n+1)/2 = (n^2 + n)/2
        // - O(f(n)) = O(n^2) vì:
        //   + Bỏ qua constant (chia 2)
        //   + Bỏ qua lower order term (n) vì khi n lớn, n^2 chiếm ưu thế
        System.out.println("Số lần thực hiện với n=100: " + count);
        System.out.println("Công thức: n(n+1)/2 = " + (100 * 101 / 2));
        System.out.println("O(n^2): Thời gian chạy tỷ lệ thuận với n^2\n");
    }
    
    /**
     * Ex4: O(log n) - Logarithmic Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Thời gian chạy TỶ LỆ THUẬN với LOGARITHM của input size
     * - Runtime is PROPORTIONAL to LOGARITHM of input size
     * - Mỗi bước, input giảm đi một nửa
     * - Each step, input is halved
     * - Rất hiệu quả với input lớn
     * - Very efficient with large inputs
     * 
     * Công thức: f(n) = log₂(n) → O(f(n)) = O(log n)
     * Formula: f(n) = log₂(n) → O(f(n)) = O(log n)
     * 
     * Lưu ý quan trọng:
     * Important notes:
     * - Trong lập trình, log thường là log cơ số 2 (log₂)
     * - In programming, log usually means base 2 logarithm (log₂)
     * - Khi viết O(log n), mặc định là log₂(n)
     * - When writing O(log n), it defaults to log₂(n)
     * - Không có log cơ số 10 trong phân tích thuật toán
     * - Base 10 logarithm is not used in algorithm analysis
     * 
     * Ví dụ số liệu log₂(n):
     * Example data for log₂(n):
     * - n = 2 → log₂(2) = 1
     * - n = 4 → log₂(4) = 2
     * - n = 8 → log₂(8) = 3
     * - n = 16 → log₂(16) = 4
     * - n = 1024 → log₂(1024) = 10
     * - n = 1,000,000 → log₂(1,000,000) ≈ 20
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - Binary Search (tìm kiếm nhị phân) trong array đã sắp xếp
     * - Binary Search in sorted array
     * - Tìm kiếm trong Binary Search Tree (cân bằng)
     * - Search in balanced Binary Search Tree
     * - Bất kỳ thuật toán nào "chia đôi" input mỗi lần
     * - Any algorithm that "divides in half" the input each time
     */
    private static void demonstrateOLogN() {
        System.out.println("--- Ex4: O(log n) - Logarithmic Time ---");
        
        // Tìm kiếm tuyến tính trong array chưa sắp xếp - O(n)
        int[] unsortedArr = {5, 2, 8, 1, 9, 3};
        int target1 = 8;
        System.out.println("Linear search (O(n)): Tìm trong array chưa sắp xếp");
        System.out.println("  - Phải duyệt qua tất cả phần tử trong trường hợp tệ nhất");
        System.out.println("  - Với n=6, cần tối đa 6 lần so sánh");
        
        // Tìm kiếm nhị phân trong array ĐÃ SẮP XẾP - O(log n)
        int[] sortedArr = {1, 2, 3, 5, 8, 9}; // Array đã được sắp xếp
        int target2 = 8;
        System.out.println("\nBinary search (O(log n)): Tìm trong array ĐÃ SẮP XẾP");
        System.out.println("  - Chia đôi array mỗi lần, loại bỏ một nửa phần tử");
        System.out.println("  - Với n=6, chỉ cần tối đa log₂(6) ≈ 3 lần so sánh");
        
        int index = binarySearch(sortedArr, target2);
        System.out.println("  - Tìm thấy " + target2 + " tại index " + index);
        
        // Giải thích chi tiết Binary Search:
        System.out.println("\nCách hoạt động của Binary Search:");
        System.out.println("  Bước 1: So sánh phần tử giữa với target");
        System.out.println("  Bước 2: Nếu bằng → tìm thấy");
        System.out.println("  Bước 3: Nếu nhỏ hơn → tìm ở nửa bên phải");
        System.out.println("  Bước 4: Nếu lớn hơn → tìm ở nửa bên trái");
        System.out.println("  Bước 5: Lặp lại cho đến khi tìm thấy hoặc hết phần tử");
        System.out.println("  → Mỗi lần chia đôi → giảm đi một nửa phần tử");
        System.out.println("  → Số lần chia đôi = log₂(n)");
        
        System.out.println("\nSo sánh Linear vs Binary Search:");
        System.out.println("  n = 1000:");
        System.out.println("    - Linear: tối đa 1000 lần so sánh");
        System.out.println("    - Binary: tối đa log₂(1000) ≈ 10 lần so sánh");
        System.out.println("  n = 1,000,000:");
        System.out.println("    - Linear: tối đa 1,000,000 lần so sánh");
        System.out.println("    - Binary: tối đa log₂(1,000,000) ≈ 20 lần so sánh");
        
        System.out.println("\nQuy tắc nhớ:");
        System.out.println("  - Bất kỳ thuật toán nào 'chia 2, chia 2, chia 2' → O(log n)");
        System.out.println("  - Trong lập trình, log = log cơ số 2 (log₂)");
        System.out.println("O(log n): Rất hiệu quả với input lớn\n");
    }
    
    /**
     * Binary Search - O(log n)
     * Tìm kiếm trong array ĐÃ SẮP XẾP bằng cách chia đôi mỗi lần
     * Search in SORTED array by dividing in half each time
     * 
     * @param arr Array đã được sắp xếp tăng dần
     * @param arr Sorted array in ascending order
     * @param target Giá trị cần tìm
     * @param target Value to search for
     * @return Index của target nếu tìm thấy, -1 nếu không tìm thấy
     * @return Index of target if found, -1 if not found
     */
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1; // Quan trọng: end = length - 1, không phải length
        
        while (start <= end) {
            int mid = (start + end) / 2; // Lấy phần tử giữa
            
            if (arr[mid] == target) {
                return mid; // Tìm thấy!
            } else if (arr[mid] < target) {
                // Phần tử giữa nhỏ hơn target → tìm ở nửa bên phải
                start = mid + 1;
            } else {
                // Phần tử giữa lớn hơn target → tìm ở nửa bên trái
                end = mid - 1;
            }
        }
        
        return -1; // Không tìm thấy
    }
    
    /**
     * Ex5: O(n log n) - Linearithmic Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Kết hợp giữa O(n) và O(log n)
     * - Combination of O(n) and O(log n)
     * - Thường xuất hiện trong các thuật toán sắp xếp hiệu quả
     * - Commonly appears in efficient sorting algorithms
     * - Tốt hơn O(n^2) nhưng chậm hơn O(n)
     * - Better than O(n^2) but slower than O(n)
     * 
     * Công thức: f(n) = n × log₂(n) → O(f(n)) = O(n log n)
     * Formula: f(n) = n × log₂(n) → O(f(n)) = O(n log n)
     * 
     * Ví dụ số liệu:
     * Example data:
     * - n = 100 → n log n = 100 × log₂(100) ≈ 100 × 6.64 ≈ 664
     * - n = 1000 → n log n = 1000 × log₂(1000) ≈ 1000 × 9.97 ≈ 9,970
     * - n = 10,000 → n log n ≈ 132,877
     * 
     * So sánh với O(n^2):
     * Comparison with O(n^2):
     * - n = 100 → n^2 = 10,000 (gấp 15 lần n log n)
     * - n = 100 → n^2 = 10,000 (15x n log n)
     * - n = 1000 → n^2 = 1,000,000 (gấp 100 lần n log n)
     * - n = 1000 → n^2 = 1,000,000 (100x n log n)
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - Merge Sort, Quick Sort, Heap Sort
     * - Merge Sort, Quick Sort, Heap Sort
     * - Các thuật toán sắp xếp hiệu quả nhất (comparison-based)
     * - Most efficient sorting algorithms (comparison-based)
     */
    private static void demonstrateONLogN() {
        System.out.println("--- Ex5: O(n log n) - Linearithmic Time ---");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array ban đầu: " + java.util.Arrays.toString(arr));
        
        // Merge Sort - O(n log n)
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sau khi sắp xếp (Merge Sort): " + java.util.Arrays.toString(arr));
        
        System.out.println("\nGiải thích Merge Sort:");
        System.out.println("  - Chia array thành 2 nửa: O(log n) lần chia");
        System.out.println("  - Mỗi lần chia, merge lại: O(n) thao tác");
        System.out.println("  - Tổng: O(n) × O(log n) = O(n log n)");
        
        System.out.println("\nSo sánh các thuật toán sắp xếp:");
        System.out.println("  - Bubble Sort: O(n^2) - Chậm");
        System.out.println("  - Selection Sort: O(n^2) - Chậm");
        System.out.println("  - Insertion Sort: O(n^2) - Chậm");
        System.out.println("  - Merge Sort: O(n log n) - Nhanh");
        System.out.println("  - Quick Sort: O(n log n) trung bình - Nhanh");
        System.out.println("  - Heap Sort: O(n log n) - Nhanh");
        
        System.out.println("\nVí dụ số liệu với n = 1000:");
        System.out.println("  - O(n^2): 1,000,000 thao tác");
        System.out.println("  - O(n log n): ~9,970 thao tác");
        System.out.println("  - O(n log n) nhanh hơn ~100 lần!");
        
        System.out.println("O(n log n): Cân bằng tốt giữa hiệu suất và độ phức tạp\n");
    }
    
    /**
     * Merge Sort - O(n log n)
     * Thuật toán sắp xếp chia để trị (divide and conquer)
     * Divide and conquer sorting algorithm
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Chia đôi array - O(log n) lần
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge lại - O(n) mỗi lần
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merge hai mảng con đã sắp xếp
     * Merge two sorted subarrays
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Ex6: O(n^3) - Cubic Time Complexity
     * 
     * Giải thích:
     * Explanation:
     * - Thời gian chạy TỶ LỆ THUẬN với LẬP PHƯƠNG của input size
     * - Runtime is PROPORTIONAL to the CUBE of input size
     * - Input tăng 2 lần → thời gian chạy tăng 8 lần (2^3)
     * - Input doubles → runtime increases 8x (2^3)
     * - Input tăng 10 lần → thời gian chạy tăng 1000 lần (10^3)
     * - Input increases 10x → runtime increases 1000x (10^3)
     * - Rất chậm, nên tránh khi có thể
     * - Very slow, should be avoided when possible
     * 
     * Công thức: f(n) = n^3 → O(f(n)) = O(n^3)
     * Formula: f(n) = n^3 → O(f(n)) = O(n^3)
     * 
     * Ví dụ số liệu:
     * Example data:
     * - n = 10 → cần 1,000 lần lặp (10^3)
     * - n = 10 → needs 1,000 iterations (10^3)
     * - n = 100 → cần 1,000,000 lần lặp (100^3)
     * - n = 100 → needs 1,000,000 iterations (100^3)
     * - n = 1000 → cần 1,000,000,000 lần lặp (1000^3)
     * - n = 1000 → needs 1,000,000,000 iterations (1000^3)
     * 
     * Ví dụ thực tế:
     * Real-world examples:
     * - 3 vòng lặp lồng nhau
     * - 3 nested loops
     * - Thuật toán tìm tất cả bộ ba (triplets) trong array
     * - Algorithm to find all triplets in array
     * - Một số thuật toán ma trận (matrix multiplication naive)
     * - Some matrix algorithms (naive matrix multiplication)
     * 
     * Lưu ý quan trọng:
     * Important notes:
     * - Khi có nhiều vòng lặp lồng nhau, cộng các vòng lặp song song
     * - When having nested loops, multiply complexities; for parallel loops, add them
     * - Bỏ qua constants và lower order terms khi tính Big O
     * - Ignore constants and lower order terms when calculating Big O
     */
    private static void demonstrateOn3() {
        System.out.println("--- Ex6: O(n^3) - Cubic Time ---");
        
        // Giả sử n là input size (có thể thay đổi)
        int n = 10; // Ví dụ với n=10 để dễ hiểu
        
        System.out.println("Ví dụ: Vòng lặp ngoài O(n) với 2 vòng lặp bên trong");
        System.out.println("  - Vòng lặp 1: O(40) = O(1) - constant");
        System.out.println("  - Vòng lặp 2: O(n^2) - nhưng j tăng 2 mỗi lần");
        
        int totalIterations = 0;
        
        // Vòng lặp ngoài: i từ 0 đến n-1 (n lần)
        for (int i = 0; i < n; i++) {
            // Vòng lặp 1: j từ 0 đến 39 (40 lần - CONSTANT)
            // Độ phức tạp: O(40) = O(1) vì 40 là constant
            for (int j = 0; j < 40; j++) {
                totalIterations++;
                // Thao tác nào đó
            }
            
            // Vòng lặp 2: j từ 0 đến n*n-1, nhưng j tăng 2 mỗi lần
            // j = 0, 2, 4, 6, ..., n*n-2 hoặc n*n-1
            // Số lần lặp = (n*n) / 2 = n^2 / 2
            // Độ phức tạp: O(n^2 / 2) = O(n^2) (bỏ qua constant 1/2)
            for (int j = 0; j < n * n; j = j + 2) {
                totalIterations++;
                // Thao tác nào đó
            }
        }
        
        System.out.println("\nPhân tích chi tiết:");
        System.out.println("  Vòng lặp ngoài: i từ 0 đến n-1");
        System.out.println("    → Chạy n lần");
        System.out.println("\n  Mỗi lần lặp của i, thực hiện:");
        System.out.println("    1. Vòng lặp j từ 0 đến 39:");
        System.out.println("       → Chạy 40 lần (CONSTANT)");
        System.out.println("       → Độ phức tạp: O(40) = O(1)");
        System.out.println("\n    2. Vòng lặp j từ 0 đến n*n-1, j tăng 2:");
        System.out.println("       → j = 0, 2, 4, 6, ..., (n*n-2) hoặc (n*n-1)");
        System.out.println("       → Số lần lặp = (n*n) / 2 = n^2 / 2");
        System.out.println("       → Độ phức tạp: O(n^2 / 2) = O(n^2)");
        System.out.println("       → (Bỏ qua constant 1/2)");
        
        System.out.println("\n  Tổng số lần thực hiện cho mỗi i:");
        System.out.println("    = 40 + (n^2 / 2)");
        System.out.println("    = 40 + n^2/2");
        
        System.out.println("\n  Tổng số lần thực hiện cho tất cả i:");
        System.out.println("    f(n) = n × (40 + n^2/2)");
        System.out.println("    f(n) = 40n + n^3/2");
        System.out.println("    f(n) = n^3/2 + 40n");
        
        System.out.println("\n  Tính Big O:");
        System.out.println("    - Bỏ qua constant: n^3/2 → n^3");
        System.out.println("    - Bỏ qua lower order term: 40n (vì khi n lớn, n^3 chiếm ưu thế)");
        System.out.println("    → O(f(n)) = O(n^3)");
        
        System.out.println("\n  Ví dụ số liệu với n = 10:");
        int expected = 10 * (40 + (10 * 10 / 2));
        System.out.println("    - Công thức: n × (40 + n^2/2) = " + expected);
        System.out.println("    - Số lần thực hiện thực tế: " + totalIterations);
        System.out.println("    - n^3 = " + (n * n * n) + " (bỏ qua constant và lower order)");
        
        System.out.println("\n  So sánh với các độ phức tạp khác (n=100):");
        System.out.println("    - O(n): 100");
        System.out.println("    - O(n^2): 10,000");
        System.out.println("    - O(n^3): 1,000,000");
        System.out.println("    → O(n^3) chậm hơn O(n^2) rất nhiều!");
        
        System.out.println("\nQuy tắc nhớ:");
        System.out.println("  - Khi có nhiều vòng lặp lồng nhau: nhân các độ phức tạp");
        System.out.println("  - Khi có nhiều vòng lặp song song: cộng các độ phức tạp");
        System.out.println("  - Luôn bỏ qua constants và lower order terms");
        System.out.println("  - Chỉ giữ lại term có bậc cao nhất");
        System.out.println("O(n^3): Rất chậm, nên tránh khi có thể\n");
    }
}
