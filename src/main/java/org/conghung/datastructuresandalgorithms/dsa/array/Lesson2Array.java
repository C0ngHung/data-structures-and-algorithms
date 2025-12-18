package org.conghung.datastructuresandalgorithms.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lesson 2: Array - Cấu trúc dữ liệu cơ bản nhất
 * 
 * Array (Mảng) là gì?
 * - Array là một cấu trúc dữ liệu lưu trữ một tập hợp các phần tử cùng kiểu dữ liệu
 * - Các phần tử được lưu trữ LIÊN TIẾP nhau trong bộ nhớ
 * - Mỗi phần tử được truy cập thông qua INDEX (chỉ số)
 * - Index luôn bắt đầu từ 0 (zero-based indexing)
 * - An array stores a collection of elements of the same type
 * - Elements are stored CONTIGUOUSLY in memory
 * - Each element is accessed via an INDEX (zero-based)
 * 
 * Đặc điểm quan trọng: - Characteristics:
 * - Array lưu địa chỉ bắt đầu của vùng nhớ
 * - Khi truy cập arr[i], máy tính tính: địa chỉ_bắt_đầu + (i × kích_thước_phần_tử)
 * - Đây là lý do tại sao truy cập array rất nhanh: O(1)
 * - The array stores the starting address of its memory block
 * - Accessing arr[i] = base_address + (i × element_size)
 * - Direct address calculation → O(1) access
 * 
 * Trong Java có 2 loại Array:
 * 1. Static Array (Array tĩnh): Kích thước cố định, không thể thay đổi
 * 2. Dynamic Array (ArrayList): Kích thước có thể thay đổi
 * 1. Static Array: fixed size, cannot change after creation
 * 2. Dynamic Array (ArrayList): resizable
 */
public class Lesson2Array {
    
    public static void main(String[] args) {
        System.out.println("=== LESSON 2: ARRAY ===\n");
        
        // Demo Static Array
        demonstrateStaticArray();
        
        // Demo Dynamic Array (ArrayList)
        demonstrateDynamicArray();
        
        // So sánh Static vs Dynamic Array
        compareStaticAndDynamic();
    }
    
    /**
     * ============================================
     * PHẦN 1: STATIC ARRAY (ARRAY TĨNH)
     * ============================================
     * 
     * Đặc điểm:
     * - Kích thước CỐ ĐỊNH, không thể thay đổi sau khi khởi tạo
     * - Phải khai báo kích thước khi tạo array
     * - Java cấp phát một vùng nhớ LIÊN TIẾP có kích thước cố định
     * - Phần tử đầu tiên (index 0) là địa chỉ bắt đầu của array
     * - Nếu truy cập index ngoài phạm vi → ArrayIndexOutOfBoundsException
    * Characteristics:
     * - FIXED size, cannot change after creation
     * - Must provide length at creation time
     * - Java allocates one CONTIGUOUS memory block
     * - First element (index 0) is at the starting address
     * - Accessing out-of-range index → ArrayIndexOutOfBoundsException
     * 
     * Cách hoạt động trong bộ nhớ:
     * - Khi khai báo: int[] arr = new int[5]
     * - Java tìm một vùng nhớ liên tiếp đủ 5 × 4 bytes (int = 4 bytes)
     * - Lưu địa chỉ bắt đầu vào biến arr
     * - arr[0] = địa chỉ bắt đầu
     * - arr[1] = địa chỉ bắt đầu + 4 bytes
     * - arr[2] = địa chỉ bắt đầu + 8 bytes
    * Memory layout:
     * - Example: int[] arr = new int[5]
     * - Needs 5 × 4 bytes (int = 4 bytes) in one contiguous block
     * - arr[0] = base address
     * - arr[1] = base address + 4 bytes
     * - arr[2] = base address + 8 bytes
     * 
     * Big O Complexity:
     * - Access (Truy cập): O(1) - Truy cập trực tiếp bằng index
     * - Search (Tìm kiếm): O(n) - Phải duyệt qua tất cả phần tử
     * - Insert: N/A - Không thể thêm phần tử mới (kích thước cố định)
     * - Update: O(1) - Cập nhật phần tử tại index
     * - Delete: N/A - Không thể xóa phần tử (chỉ có thể set = null hoặc giá trị mặc định)
    * Big O:
     * - Access: O(1)
     * - Search: O(n)
     * - Insert: N/A (size is fixed)
     * - Update: O(1)
     * - Delete: N/A (can only overwrite with default/null)
     * Ưu điểm - Pros:
     * - Truy cập nhanh: O(1) - Fast access O(1)
     * - Tiết kiệm bộ nhớ (không có overhead) - Low memory overhead
     * - Đơn giản, dễ sử dụng - simple and easy to use
     * 
     * Nhược điểm - Cons:
     * - Kích thước cố định, không linh hoạt - Fixed size, not flexible
     * - Không thể thêm/xóa phần tử - Cannot add/remove elements
     * - Phải biết kích thước trước - Must know size before creation
     * 
     * When to use Static Array?
     * - Khi biết chính xác số lượng phần tử - When you know the exact number of elements
     * - Khi cần hiệu suất cao (truy cập nhanh) - When you need high performance (fast access)
     * - Làm buffer, lookup table, return type - For buffer, lookup table, return type
     */
    private static void demonstrateStaticArray() {
        System.out.println("--- PHẦN 1: STATIC ARRAY (ARRAY TĨNH) ---\n");
        
        // Cách 1: Khai báo và khởi tạo với kích thước
        System.out.println("1. Khai báo Static Array:");
        int[] staticArray1 = new int[5]; // Tạo array có 5 phần tử, giá trị mặc định = 0
        System.out.println("   int[] arr = new int[5];");
        System.out.println("   → Tạo array có 5 phần tử, tất cả = 0");
        System.out.println("   → Array: " + Arrays.toString(staticArray1));
        
        // Cách 2: Khai báo và khởi tạo với giá trị
        int[] staticArray2 = {10, 20, 30, 40, 50};
        System.out.println("\n   int[] arr = {10, 20, 30, 40, 50};");
        System.out.println("   → Tạo array và gán giá trị ngay");
        System.out.println("   → Array: " + Arrays.toString(staticArray2));
        
        // Truy cập phần tử - O(1)
        System.out.println("\n2. Truy cập phần tử (Access) - O(1):");
        System.out.println("   arr[0] = " + staticArray2[0] + " (phần tử đầu tiên)");
        System.out.println("   arr[2] = " + staticArray2[2] + " (phần tử thứ 3)");
        System.out.println("   arr[4] = " + staticArray2[4] + " (phần tử cuối cùng)");
        System.out.println("   → Truy cập bằng index, rất nhanh: O(1)");
        System.out.println("   → Công thức: địa_chỉ = địa_chỉ_bắt_đầu + (index × kích_thước_phần_tử)");
        
        // Cập nhật phần tử - O(1)
        System.out.println("\n3. Cập nhật phần tử (Update) - O(1):");
        staticArray2[1] = 25;
        System.out.println("   arr[1] = 25;");
        System.out.println("   → Array sau khi cập nhật: " + Arrays.toString(staticArray2));
        System.out.println("   → Cập nhật rất nhanh: O(1)");
        
        // Tìm kiếm phần tử - O(n)
        System.out.println("\n4. Tìm kiếm phần tử (Search) - O(n):");
        int target = 30;
        int index = linearSearch(staticArray2, target);
        System.out.println("   Tìm số " + target + " trong array");
        if (index != -1) {
            System.out.println("   → Tìm thấy tại index " + index);
        } else {
            System.out.println("   → Không tìm thấy");
        }
        System.out.println("   → Phải duyệt qua tất cả phần tử: O(n)");
        
        // Lưu ý về index
        System.out.println("\n5. Lưu ý quan trọng về Index:");
        System.out.println("   - Index bắt đầu từ 0, không phải 1");
        System.out.println("   - Index cuối cùng = length - 1");
        System.out.println("   - arr.length = 5 → index hợp lệ: 0, 1, 2, 3, 4");
        System.out.println("   - Truy cập arr[5] → ArrayIndexOutOfBoundsException");
        
        // Không thể thêm/xóa phần tử
        System.out.println("\n6. Hạn chế của Static Array:");
        System.out.println("   - KHÔNG THỂ thêm phần tử mới (kích thước cố định)");
        System.out.println("   - KHÔNG THỂ xóa phần tử (chỉ có thể set = 0 hoặc null)");
        System.out.println("   - Nếu cần thêm/xóa → phải tạo array mới");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    /**
     * Tìm kiếm tuyến tính trong Static Array - O(n)
     */
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * ============================================
     * PHẦN 2: DYNAMIC ARRAY (ARRAYLIST)
     * ============================================
     * 
     * Đặc điểm: - Characteristics:
     * - Kích thước CÓ THỂ THAY ĐỔI sau khi khởi tạo - Resizable after creation
     * - Tự động mở rộng khi thêm phần tử - Automatically grow when adding elements
     * - Tự động thu nhỏ khi xóa phần tử (tùy implementation) - Automatically shrink when deleting elements (depends on implementation)
     * - Trong Java: ArrayList là implementation của Dynamic Array - In Java: ArrayList is an implementation of Dynamic Array
     * 
     * Cách hoạt động: - How it works:
     * - Ban đầu: ArrayList có capacity (dung lượng) mặc định (thường là 10) - Initially: ArrayList has a default capacity (usually 10)
     * - Khi thêm phần tử: - When adding elements:
     *   + Nếu còn chỗ → thêm trực tiếp: O(1) - If there is space: add directly: O(1)
     *   + Nếu hết chỗ → tạo array mới gấp đôi, copy toàn bộ → O(n) - If full: create new array double size, copy all: O(n)
     * - Khi xóa phần tử: phải dịch chuyển các phần tử còn lại → O(n) - When deleting elements: must shift remaining elements: O(n)
     * 
     * Big O Complexity:
     * - Access (Truy cập): O(1) - Giống Static Array - Same as Static Array
     * - Search (Tìm kiếm): O(n) - Phải duyệt qua tất cả phần tử - Must traverse all elements
     * - Insert (Chèn vào giữa): O(n) - Phải dịch chuyển các phần tử - Must shift elements
     * - Append (Thêm vào cuối): O(1) amortized - Thường O(1), đôi khi O(n) khi resize - Usually O(1), sometimes O(n) when resize
     * - Delete (Xóa): O(n) - Phải dịch chuyển các phần tử - Must shift elements
     * 
     * Ưu điểm - Pros:
     * - Linh hoạt: có thể thêm/xóa phần tử - Flexible: can add/remove elements
     * - Không cần biết kích thước trước - No need to know size before creation
     * - Truy cập nhanh: O(1) - Fast access: O(1)
     * 
     * Nhược điểm - Cons:
     * - Chèn/xóa chậm hơn: O(n) - Slower insert/delete: O(n)
     * - Tốn bộ nhớ hơn (có overhead) - More memory overhead (has overhead)
     * - Khi resize có thể tốn thời gian - When resize can take time
     * 
     * Khi nào dùng Dynamic Array? - When to use Dynamic Array?
     * - Khi không biết trước số lượng phần tử - When you don't know the exact number of elements
     * - Khi cần thêm/xóa phần tử thường xuyên - When you need to add/remove elements frequently
     * - Khi cần truy cập nhanh bằng index - When you need fast access by index
     */
    private static void demonstrateDynamicArray() {
        System.out.println("--- PHẦN 2: DYNAMIC ARRAY (ARRAYLIST) ---\n");
        
        // Khởi tạo ArrayList
        System.out.println("1. Khởi tạo ArrayList:");
        ArrayList<Integer> dynamicArray = new ArrayList<>();
        System.out.println("   ArrayList<Integer> list = new ArrayList<>();");
        System.out.println("   → Tạo ArrayList rỗng, capacity mặc định = 10");
        System.out.println("   → Size hiện tại: " + dynamicArray.size());
        
        // Thêm phần tử vào cuối - O(1) amortized
        System.out.println("\n2. Thêm phần tử vào cuối (Append) - O(1) amortized:");
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);
        System.out.println("   list.add(10);");
        System.out.println("   list.add(20);");
        System.out.println("   list.add(30);");
        System.out.println("   → List: " + dynamicArray);
        System.out.println("   → Thêm vào cuối rất nhanh: O(1)");
        System.out.println("   → Nếu hết chỗ, resize mất O(n) nhưng hiếm khi xảy ra");
        
        // Truy cập phần tử - O(1)
        System.out.println("\n3. Truy cập phần tử (Access) - O(1):");
        System.out.println("   list.get(0) = " + dynamicArray.get(0));
        System.out.println("   list.get(1) = " + dynamicArray.get(1));
        System.out.println("   → Truy cập bằng index, rất nhanh: O(1)");
        System.out.println("   → Giống Static Array");
        
        // Chèn phần tử vào giữa - O(n)
        System.out.println("\n4. Chèn phần tử vào giữa (Insert) - O(n):");
        dynamicArray.add(1, 15); // Chèn 15 vào vị trí index 1
        System.out.println("   list.add(1, 15); // Chèn vào index 1");
        System.out.println("   → List sau khi chèn: " + dynamicArray);
        System.out.println("   → Phải dịch chuyển các phần tử sau vị trí chèn");
        System.out.println("   → Độ phức tạp: O(n)");
        
        // Cập nhật phần tử - O(1)
        System.out.println("\n5. Cập nhật phần tử (Update) - O(1):");
        dynamicArray.set(2, 25);
        System.out.println("   list.set(2, 25);");
        System.out.println("   → List sau khi cập nhật: " + dynamicArray);
        System.out.println("   → Cập nhật rất nhanh: O(1)");
        
        // Tìm kiếm phần tử - O(n)
        System.out.println("\n6. Tìm kiếm phần tử (Search) - O(n):");
        int target = 20;
        int index = dynamicArray.indexOf(target);
        System.out.println("   list.indexOf(20) = " + index);
        System.out.println("   → Phải duyệt qua tất cả phần tử: O(n)");
        
        // Xóa phần tử - O(n)
        System.out.println("\n7. Xóa phần tử (Delete) - O(n):");
        System.out.println("   List trước khi xóa: " + dynamicArray);
        dynamicArray.remove(1); // Xóa phần tử tại index 1
        System.out.println("   list.remove(1); // Xóa phần tử tại index 1");
        System.out.println("   → List sau khi xóa: " + dynamicArray);
        System.out.println("   → Phải dịch chuyển các phần tử sau vị trí xóa");
        System.out.println("   → Độ phức tạp: O(n)");
        
        // Xóa theo giá trị - O(n)
        System.out.println("\n8. Xóa theo giá trị - O(n):");
        boolean removed = dynamicArray.remove(Integer.valueOf(25));
        System.out.println("   list.remove(Integer.valueOf(25));");
        System.out.println("   → Đã xóa: " + removed);
        System.out.println("   → List sau khi xóa: " + dynamicArray);
        System.out.println("   → Phải tìm phần tử trước (O(n)), rồi xóa (O(n))");
        System.out.println("   → Tổng: O(n)");
        
        // Resize tự động
        System.out.println("\n9. Resize tự động:");
        System.out.println("   - Ban đầu: capacity = 10");
        System.out.println("   - Khi thêm phần tử thứ 11:");
        System.out.println("     + Tạo array mới có capacity = 20 (gấp đôi)");
        System.out.println("     + Copy toàn bộ 10 phần tử sang array mới");
        System.out.println("     + Mất O(n) thời gian");
        System.out.println("     + Nhưng hiếm khi xảy ra → O(1) amortized");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    /**
     * So sánh Static Array vs Dynamic Array
     */
    private static void compareStaticAndDynamic() {
        System.out.println("--- SO SÁNH STATIC ARRAY vs DYNAMIC ARRAY ---\n");
        
        System.out.println("BẢNG SO SÁNH:");
        System.out.println("┌─────────────────────┬──────────────────┬──────────────────┐");
        System.out.println("│ THAO TÁC             │ STATIC ARRAY     │ DYNAMIC ARRAY    │");
        System.out.println("├─────────────────────┼──────────────────┼──────────────────┤");
        System.out.println("│ Access (Truy cập)    │ O(1)             │ O(1)             │");
        System.out.println("│ Search (Tìm kiếm)    │ O(n)             │ O(n)             │");
        System.out.println("│ Insert (Chèn)        │ N/A (không thể)  │ O(n)             │");
        System.out.println("│ Append (Thêm cuối)   │ N/A (không thể)  │ O(1) amortized   │");
        System.out.println("│ Update (Cập nhật)   │ O(1)             │ O(1)             │");
        System.out.println("│ Delete (Xóa)          │ N/A (không thể)  │ O(n)             │");
        System.out.println("│ Kích thước           │ Cố định          │ Thay đổi được    │");
        System.out.println("│ Bộ nhớ               │ Ít hơn           │ Nhiều hơn        │");
        System.out.println("│ Hiệu suất            │ Cao hơn          │ Thấp hơn một chút│");
        System.out.println("│ Linh hoạt            │ Thấp             │ Cao              │");
        System.out.println("└─────────────────────┴──────────────────┴──────────────────┘");
        
        System.out.println("\nKHI NÀO DÙNG STATIC ARRAY?");
        System.out.println("  ✓ Biết chính xác số lượng phần tử");
        System.out.println("  ✓ Cần hiệu suất cao (truy cập nhanh)");
        System.out.println("  ✓ Không cần thêm/xóa phần tử");
        System.out.println("  ✓ Làm buffer, lookup table, return type");
        
        System.out.println("\nKHI NÀO DÙNG DYNAMIC ARRAY?");
        System.out.println("  ✓ Không biết trước số lượng phần tử");
        System.out.println("  ✓ Cần thêm/xóa phần tử thường xuyên");
        System.out.println("  ✓ Cần truy cập nhanh bằng index");
        System.out.println("  ✓ Cần linh hoạt trong việc quản lý dữ liệu");
        
        System.out.println("\nVÍ DỤ THỰC TẾ:");
        System.out.println("  Static Array:");
        System.out.println("    - Lưu điểm số của 5 môn học: int[] scores = new int[5]");
        System.out.println("    - Lưu 7 ngày trong tuần: String[] days = new String[7]");
        System.out.println("    - Làm buffer cho I/O operations");
        System.out.println("  Dynamic Array:");
        System.out.println("    - Lưu danh sách sản phẩm trong giỏ hàng (số lượng thay đổi)");
        System.out.println("    - Lưu danh sách người dùng đăng nhập (thêm/xóa thường xuyên)");
        System.out.println("    - Lưu lịch sử thao tác (không biết trước số lượng)");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nTÓM TẮT:");
        System.out.println("  - Array là cấu trúc dữ liệu cơ bản nhất");
        System.out.println("  - Static Array: kích thước cố định, truy cập nhanh O(1)");
        System.out.println("  - Dynamic Array: kích thước thay đổi, linh hoạt hơn");
        System.out.println("  - Chọn loại array phù hợp với nhu cầu của bài toán");
    }
}
