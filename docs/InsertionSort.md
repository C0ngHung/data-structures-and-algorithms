# Insertion Sort — Thuật toán "Chèn"

<!-- Hình dung thế này: bạn đang cầm một bộ bài trên tay.
     Mỗi lần rút thêm 1 lá, bạn tìm đúng vị trí trong phần đã sắp
     rồi chèn nó vào — đó chính là Insertion Sort.
     Đơn giản, trực quan, và cực kỳ hiệu quả với dữ liệu nhỏ hoặc gần sorted. -->

**Bản chất:** lấy từng phần tử → tìm vị trí đúng trong phần đã sorted → chèn vào bằng cách dịch (shift) các phần tử lớn hơn sang phải.

---

## 1. Ý tưởng cốt lõi

<!-- Khác với Bubble Sort "nổi" phần tử lớn về cuối,
     Insertion Sort "chèn" phần tử hiện tại vào đúng chỗ trong phần đã sorted.
     Kỹ thuật chính là shift (dịch), không phải swap — ít thao tác ghi hơn. -->

- Chia mảng thành 2 phần: **đã sorted** (ban đầu chỉ phần tử đầu tiên) và **chưa sorted** (phần còn lại).
- Lấy phần tử đầu tiên của phần chưa sorted (gọi là `key`).
- **Dịch** (shift) tất cả phần tử trong phần sorted mà lớn hơn `key` sang phải 1 vị trí.
- Đặt `key` vào chỗ trống vừa tạo ra.
- **Ưu điểm so với Bubble Sort:** dùng shift thay vì swap → ít thao tác ghi hơn (1 lần gán thay vì 3 lần gán mỗi swap).

---

## 2. Phân tích độ phức tạp

<!-- Insertion Sort có cùng O(n²) worst case như Bubble Sort,
     nhưng thực tế nhanh hơn nhiều vì: ít thao tác ghi hơn (shift vs swap),
     và dừng sớm tự nhiên khi gặp phần tử nhỏ hơn key. -->

| Trường hợp | Thời gian | Giải thích |
|---|---|---|
| **Tốt nhất** | **O(n)** | Mảng đã sorted → mỗi key đều lớn hơn phần tử trước → 0 shift |
| **Trung bình** | **O(n²)** | Trung bình mỗi key phải shift ~n/2 phần tử |
| **Tệ nhất** | **O(n²)** | Mảng ngược hoàn toàn → mỗi key phải shift toàn bộ phần sorted |

| Bộ nhớ | Ổn định (Stable)? |
|---|---|
| **O(1)** — in-place, không cần mảng phụ | **Có** — phần tử bằng nhau giữ nguyên thứ tự (vì chỉ shift khi `>`, không shift khi `==`) |

---

## 3. Chạy tay từng bước (Step-by-Step Trace)

<!-- Mô phỏng chính xác vòng lặp bên trong.
     Dùng mảng [5, 3, 8, 1, 2] giống Bubble Sort để dễ so sánh.
     Ký hiệu: [x] = key đang xét, ✅ = phần đã sorted. -->

**Input:** `[5, 3, 8, 1, 2]` — `n = 5`

---

### 🔄 Bước 1 (`i = 1`, `key = 3`)

<!-- i=1: phần sorted = [5], key = 3.
     So sánh 3 với 5: 5 > 3 → shift 5 sang phải → chèn 3 vào vị trí 0. -->

| Phần sorted | key | So sánh & Shift | Kết quả |
|---|---|---|---|
| `[5]` | `3` | `5 > 3` → shift `5` sang phải | `[3, 5, 8, 1, 2]` |

> Sorted: `[3, 5 ✅]` — **3 được chèn trước 5**.

---

### 🔄 Bước 2 (`i = 2`, `key = 8`)

<!-- i=2: phần sorted = [3, 5], key = 8.
     So sánh 8 với 5: 5 < 8 → DỪNG. Không shift gì → 8 ở nguyên chỗ. -->

| Phần sorted | key | So sánh & Shift | Kết quả |
|---|---|---|---|
| `[3, 5]` | `8` | `5 < 8` → DỪNG, không shift | `[3, 5, 8, 1, 2]` |

> Sorted: `[3, 5, 8 ✅]` — **8 đã đúng chỗ, 0 shift**.

---

### 🔄 Bước 3 (`i = 3`, `key = 1`)

<!-- i=3: phần sorted = [3, 5, 8], key = 1.
     1 nhỏ hơn tất cả → phải shift cả 3 phần tử sang phải → chèn 1 vào đầu.
     Đây là worst case cho 1 phần tử. -->

| Phần sorted | key | So sánh & Shift | Kết quả |
|---|---|---|---|
| `[3, 5, 8]` | `1` | `8 > 1` → shift `8` | `[3, 5, _, 8, 2]` |
| | | `5 > 1` → shift `5` | `[3, _, 5, 8, 2]` |
| | | `3 > 1` → shift `3` | `[_, 3, 5, 8, 2]` |
| | | `j = -1` → DỪNG, chèn `1` tại `[0]` | `[1, 3, 5, 8, 2]` |

> Sorted: `[1, 3, 5, 8 ✅]` — **1 chèn vào đầu, shift 3 phần tử**.

---

### 🔄 Bước 4 (`i = 4`, `key = 2`)

<!-- i=4: phần sorted = [1, 3, 5, 8], key = 2.
     2 lớn hơn 1, nhỏ hơn 3 → shift 3, 5, 8 sang phải → chèn 2 vào vị trí 1. -->

| Phần sorted | key | So sánh & Shift | Kết quả |
|---|---|---|---|
| `[1, 3, 5, 8]` | `2` | `8 > 2` → shift `8` | `[1, 3, 5, _, 8]` |
| | | `5 > 2` → shift `5` | `[1, 3, _, 5, 8]` |
| | | `3 > 2` → shift `3` | `[1, _, 3, 5, 8]` |
| | | `1 < 2` → DỪNG, chèn `2` tại `[1]` | `[1, 2, 3, 5, 8]` |

> Sorted: `[1, 2, 3, 5, 8 ✅]` — **XONG!**

---

### 📊 Tổng kết trace

<!-- So sánh với Bubble Sort cùng input:
     Bubble Sort: 10 so sánh, 6 swap (= 18 lần gán)
     Insertion Sort: 9 so sánh, 9 shift (= 9 lần gán) + 4 lần gán key = 13 lần gán
     → Insertion Sort ít thao tác ghi hơn. -->

| Chỉ số | Insertion Sort | Bubble Sort (cùng input) |
|---|---|---|
| Tổng số phép so sánh | **9** | 10 |
| Tổng số thao tác ghi | **13** (9 shift + 4 gán key) | 18 (6 swap × 3 gán) |
| Số bước vòng ngoài | **4** | 4 |

**Output:** `[1, 2, 3, 5, 8]` ✅

---

## 4. Code Java

<!-- Code dùng kỹ thuật shift: lưu arr[i] vào biến key,
     dịch các phần tử lớn hơn sang phải, rồi đặt key vào chỗ trống.
     Không cần hàm swap() trong logic chính — ít thao tác hơn. -->

```java
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
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

<!-- So sánh trực tiếp với Bubble Sort để thấy khác biệt. -->

| Dòng / Biến | Vai trò |
|---|---|
| `<T extends Comparable<T>>` | Generic — sort được mọi kiểu có thể so sánh |
| `key = arr[i]` | Lưu phần tử đang xét → tránh bị ghi đè khi shift |
| `j = i - 1` | Bắt đầu so sánh từ cuối phần sorted, đi ngược về đầu |
| `while (arr[j] > key)` | Shift phần tử lớn hơn key sang phải 1 vị trí |
| `arr[j + 1] = key` | Chèn key vào đúng vị trí (chỗ trống sau khi shift) |
| `swap()` | Hàm tiện ích, không dùng trong logic chính (shift hiệu quả hơn) |

---

## 5. Khi nào dùng / Khi nào tránh

<!-- Insertion Sort là lựa chọn tốt nhất trong nhóm O(n²) —
     nhanh hơn Bubble Sort và Selection Sort trên thực tế.
     Nhiều thư viện dùng Insertion Sort cho mảng nhỏ bên trong Quick Sort / Merge Sort. -->

| ✅ Nên dùng | ❌ Nên tránh |
|---|---|
| Mảng nhỏ (< 50 phần tử) | Mảng lớn (> 1000 phần tử) |
| Mảng gần như đã sorted (best case O(n)) | Dữ liệu hoàn toàn ngẫu nhiên, kích thước lớn |
| Cần thuật toán ổn định (stable) | Cần hiệu suất cao → dùng **Merge Sort** hoặc **Quick Sort** |
| Làm sub-routine cho thuật toán hybrid (TimSort, IntroSort) | Khi bộ nhớ không phải vấn đề và cần tốc độ |
| Dữ liệu đến liên tục (online sorting) | — |

---

## 6. So sánh với các thuật toán khác

<!-- Insertion Sort là vua của nhóm O(n²) trên thực tế.
     Java's Arrays.sort() dùng Insertion Sort cho mảng < 47 phần tử. -->

| Thuật toán | Tốt nhất | Trung bình | Tệ nhất | Bộ nhớ | Ổn định |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ |
| **Insertion Sort** | **O(n)** | **O(n²)** | **O(n²)** | **O(1)** | **✅** |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |

---

## 7. Insertion Sort vs Bubble Sort — Khác gì?

<!-- Câu hỏi phỏng vấn kinh điển. Cả hai đều O(n²), nhưng Insertion Sort
     thực tế nhanh hơn vì ít thao tác ghi và dừng sớm tự nhiên hơn. -->

| Tiêu chí | Bubble Sort | Insertion Sort |
|---|---|---|
| **Cơ chế** | So sánh cặp kề → swap | Lấy key → shift → chèn |
| **Thao tác chính** | Swap (3 lần gán/swap) | Shift (1 lần gán/shift) |
| **Hiệu quả thực tế** | Chậm hơn | **Nhanh hơn** (ít ghi hơn) |
| **Best case** | O(n) — nhờ cờ `swapped` | O(n) — tự nhiên (không shift khi đã sorted) |
| **Ứng dụng thực tế** | Chủ yếu giáo dục | Dùng trong TimSort, Arrays.sort() cho mảng nhỏ |

---
