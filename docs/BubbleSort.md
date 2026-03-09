# Bubble Sort — Thuật toán "Nổi Bọt"

<!-- Hình dung thế này: bạn có một hàng số lộn xộn. Bạn đi từ đầu đến cuối,
     so sánh từng cặp kề nhau, cặp nào sai thứ tự thì đổi chỗ.
     Mỗi lượt đi như vậy, phần tử lớn nhất sẽ "nổi" lên cuối mảng —
     giống bong bóng nổi lên mặt nước. Lặp lại cho đến khi hết lộn xộn. -->

**Bản chất:** so sánh cặp kề → đổi chỗ → phần tử lớn "nổi" dần về cuối mảng.

---

## 1. Ý tưởng cốt lõi

<!-- Đừng nghĩ Bubble Sort chỉ là "swap liên tục".
     Trick duy nhất đáng nhớ ở đây là biến swapped — nếu đi hết 1 lượt
     mà không swap lần nào, nghĩa là mảng đã đúng thứ tự → dừng sớm. -->

- Duyệt mảng nhiều lượt, mỗi lượt so sánh **từng cặp phần tử liền kề**.
- Nếu cặp nào sai thứ tự → **swap** (đổi chỗ).
- Sau mỗi lượt, phần tử lớn nhất trong phần chưa sắp xếp sẽ **trôi về đúng vị trí cuối**.
- **Tối ưu:** dùng cờ `swapped` — nếu 1 lượt mà không swap gì → mảng đã sorted → **dừng ngay**.

---

## 2. Phân tích độ phức tạp

<!-- Bubble Sort chậm với dữ liệu lớn, nhưng nó có giá trị giáo dục cao
     vì giúp hiểu rõ khái niệm so sánh, swap, và tối ưu thuật toán. -->

| Trường hợp | Thời gian | Giải thích |
|---|---|---|
| **Tốt nhất** | **O(n)** | Mảng đã sorted sẵn → 1 lượt, 0 swap, dừng |
| **Trung bình** | **O(n²)** | Phải duyệt ~n lượt, mỗi lượt ~n phép so sánh |
| **Tệ nhất** | **O(n²)** | Mảng ngược hoàn toàn → mọi cặp đều phải swap |

| Bộ nhớ | Ổn định (Stable)? |
|---|---|
| **O(1)** — in-place, không cần mảng phụ | **Có** — phần tử bằng nhau giữ nguyên thứ tự |

---

## 3. Chạy tay từng bước (Step-by-Step Trace)

<!-- Phần này mô phỏng chính xác những gì xảy ra bên trong 2 vòng lặp.
     Đọc từ trên xuống như đang debug — mỗi dòng là 1 phép so sánh.
     Dùng mảng nhỏ [5, 3, 8, 1, 2] để dễ theo dõi.
     Ký hiệu: [x] = phần tử đang so sánh, ✅ = đã sorted (không duyệt nữa). -->

**Input:** `[5, 3, 8, 1, 2]` — `n = 5`

---

### 🔄 Lượt 1 (`i = 0`, vòng trong chạy `j < 4 => j = 0 1 2 3`)

<!-- i=0: lượt đầu tiên, chưa có phần tử nào đúng chỗ.
     Vòng trong chạy j từ 0 đến n-1-i = 4-0 = 3, tức j = 0,1,2,3.
     Mỗi bước so sánh arr[j] với arr[j+1]. -->

| Bước | `j` | So sánh | Kết quả | Mảng sau bước |
|---|---|---|---|---|
| 1 | 0 | `arr[0]=5` vs `arr[1]=3` | 5 > 3 → **SWAP** | `[3, 5, 8, 1, 2]` |
| 2 | 1 | `arr[1]=5` vs `arr[2]=8` | 5 < 8 → giữ nguyên | `[3, 5, 8, 1, 2]` |
| 3 | 2 | `arr[2]=8` vs `arr[3]=1` | 8 > 1 → **SWAP** | `[3, 5, 1, 8, 2]` |
| 4 | 3 | `arr[3]=8` vs `arr[4]=2` | 8 > 2 → **SWAP** | `[3, 5, 1, 2, 8]` |

> `swapped = true` → tiếp tục. Kết quả: `[3, 5, 1, 2, | 8 ✅]` — **8 nổi lên cuối**.

---

### 🔄 Lượt 2 (`i = 1`, vòng trong chạy `j = 0 → 2`)

<!-- i=1: vị trí cuối (index 4) đã đúng chỗ, không cần duyệt nữa.
     Vòng trong chạy j từ 0 đến n-1-i = 4-1 = 2, tức j = 0,1,2. -->

| Bước | `j` | So sánh | Kết quả | Mảng sau bước |
|---|---|---|---|---|
| 5 | 0 | `arr[0]=3` vs `arr[1]=5` | 3 < 5 → giữ nguyên | `[3, 5, 1, 2, 8]` |
| 6 | 1 | `arr[1]=5` vs `arr[2]=1` | 5 > 1 → **SWAP** | `[3, 1, 5, 2, 8]` |
| 7 | 2 | `arr[2]=5` vs `arr[3]=2` | 5 > 2 → **SWAP** | `[3, 1, 2, 5, 8]` |

> `swapped = true` → tiếp tục. Kết quả: `[3, 1, 2, | 5 ✅, 8 ✅]` — **5 nổi lên vị trí đúng**.

---

### 🔄 Lượt 3 (`i = 2`, vòng trong chạy `j = 0 → 1`)

<!-- i=2: 2 vị trí cuối đã đúng chỗ.
     Vòng trong chạy j từ 0 đến n-1-i = 4-2 = 1, tức j = 0,1. -->

| Bước | `j` | So sánh | Kết quả | Mảng sau bước |
|---|---|---|---|---|
| 8 | 0 | `arr[0]=3` vs `arr[1]=1` | 3 > 1 → **SWAP** | `[1, 3, 2, 5, 8]` |
| 9 | 1 | `arr[1]=3` vs `arr[2]=2` | 3 > 2 → **SWAP** | `[1, 2, 3, 5, 8]` |

> `swapped = true` → tiếp tục. Kết quả: `[1, 2, | 3 ✅, 5 ✅, 8 ✅]` — **3 nổi lên vị trí đúng**.

---

### 🔄 Lượt 4 (`i = 3`, vòng trong chạy `j = 0 → 0`)

<!-- i=3: chỉ còn 2 phần tử chưa xác nhận, so sánh 1 cặp duy nhất.
     Vòng trong chạy j từ 0 đến n-1-i = 4-3 = 0, tức j = 0. -->

| Bước | `j` | So sánh | Kết quả | Mảng sau bước |
|---|---|---|---|---|
| 10 | 0 | `arr[0]=1` vs `arr[1]=2` | 1 < 2 → giữ nguyên | `[1, 2, 3, 5, 8]` |

> `swapped = false` → **DỪNG SỚM** ✅ (nhờ cờ `swapped`)

---

### 📊 Tổng kết trace

<!-- Đếm lại để thấy rõ chi phí thực tế. -->

| Chỉ số | Giá trị |
|---|---|
| Tổng số phép so sánh | **10** |
| Tổng số phép swap | **6** |
| Số lượt vòng ngoài (`i`) | **4** (tối đa là 4, dừng sớm ở lượt 4) |
| Tiết kiệm nhờ `swapped` | Không chạy thêm lượt nào thừa |

**Output:** `[1, 2, 3, 5, 8]` ✅

---

## 4. Code Java

<!-- Code này dùng Generics <T extends Comparable<T>> nên chạy được
     với mọi kiểu dữ liệu có thể so sánh: Integer, String, v.v.
     Biến swapped là mấu chốt tối ưu — best case từ O(n²) xuống O(n). -->

```java
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
}
```

### Giải thích code

<!-- Chi tiết từng phần, không dài dòng, chỉ nói cái cần nói. -->

| Dòng / Biến | Vai trò |
|---|---|
| `<T extends Comparable<T>>` | Generic — sort được mọi kiểu có thể so sánh |
| `n - 1 - i` | Bỏ qua phần cuối mảng đã sorted sau mỗi lượt |
| `swapped` | Cờ tối ưu: không swap = đã sorted → thoát vòng lặp |
| `swap()` | Tách riêng hàm swap → code sạch, tái sử dụng |

---

## 5. Khi nào dùng / Khi nào tránh

<!-- Đây là phần thực chiến — biết thuật toán thôi chưa đủ,
     phải biết lúc nào nên dùng và lúc nào là sai lầm. -->

| ✅ Nên dùng | ❌ Nên tránh |
|---|---|
| Mảng nhỏ (< 50 phần tử) | Mảng lớn (> 1000 phần tử) |
| Mảng gần như đã sorted | Dữ liệu hoàn toàn ngẫu nhiên |
| Cần thuật toán ổn định (stable) | Cần hiệu suất cao → dùng **Merge Sort** hoặc **Quick Sort** |
| Học thuật / giảng dạy | Production code với dataset lớn |

---

## 6. So sánh với các thuật toán khác

<!-- Đặt cạnh nhau để thấy Bubble Sort nằm ở đâu trong bức tranh tổng thể. -->

| Thuật toán | Tốt nhất | Trung bình | Tệ nhất | Bộ nhớ | Ổn định |
|---|---|---|---|---|---|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |

---
