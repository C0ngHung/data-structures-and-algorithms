# Quick Sort — Thuật toán "Chia để trị"

<!-- Hình dung thế này: bạn chọn 1 phần tử làm "chuẩn" (pivot),
     rồi chia mảng thành 2 nhóm: nhóm nhỏ hơn pivot và nhóm lớn hơn pivot.
     Lặp lại cho từng nhóm cho đến khi mọi thứ đúng chỗ.
     Nhanh nhất trong các thuật toán sort phổ biến — trung bình O(n log n). -->

**Bản chất:** chọn pivot → partition mảng thành 2 phần (≤ pivot | > pivot) → đệ quy sort từng phần.

---

## 1. Ý tưởng cốt lõi

<!-- Quick Sort dùng chiến lược Divide and Conquer (Chia để trị).
     Khác với Merge Sort chia đều rồi merge, Quick Sort chia theo giá trị (partition)
     nên không cần mảng phụ — sort in-place. -->

- **Chọn pivot:** lấy 1 phần tử làm mốc (ở đây chọn phần tử cuối).
- **Partition:** duyệt mảng, đưa tất cả phần tử ≤ pivot sang trái, > pivot sang phải. Pivot về đúng vị trí cuối cùng.
- **Đệ quy:** sort nửa trái (trước pivot) và nửa phải (sau pivot).
- **Base case:** mảng 0 hoặc 1 phần tử → đã sorted.
- **Ưu điểm:** in-place (không cần mảng phụ), cache-friendly, trung bình nhanh nhất trong nhóm comparison sort.

---

## 2. Thuật ngữ: Pivot, Partition & Stable

<!-- Ba khái niệm này là xương sống của việc hiểu Quick Sort.
     Hiểu sai pivot/partition = hiểu sai toàn bộ thuật toán.
     Hiểu sai stable = không biết khi nào nên/không nên dùng Quick Sort.
     Giải thích bằng ví dụ đời thực để dễ hình dung. -->

### ⚖️ Stable Sort là gì?

**Stable Sort** (sắp xếp ổn định) là thuật toán sort mà **các phần tử có giá trị bằng nhau giữ nguyên thứ tự ban đầu**.

> Hình dung: bạn có danh sách học sinh đã **xếp theo tên A-Z**.
> Giờ bạn sort lại **theo điểm số**.
> - **Stable sort:** Những học sinh cùng điểm vẫn **giữ thứ tự tên A-Z** ban đầu ✅
> - **Unstable sort:** Những học sinh cùng điểm **bị xáo trộn thứ tự tên** ❌

#### Ví dụ trực quan:

```
Input (đã sorted theo tên):
  ("An", 8), ("Bình", 7), ("Cường", 8), ("Dũng", 7)

Sort theo điểm:

  Stable (Merge Sort, Insertion Sort):
    ("Bình", 7), ("Dũng", 7), ("An", 8), ("Cường", 8)
     ↑ Bình trước Dũng (giữ nguyên thứ tự tên A-Z) ✅
     ↑ An trước Cường (giữ nguyên thứ tự tên A-Z) ✅

  Unstable (Quick Sort):
    ("Dũng", 7), ("Bình", 7), ("Cường", 8), ("An", 8)
     ↑ Dũng nhảy trước Bình (thứ tự tên bị xáo trộn) ❌
     ↑ Cường nhảy trước An (thứ tự tên bị xáo trộn) ❌
```

#### Tại sao Quick Sort không stable?

<!-- Vì partition dùng swap khoảng cách xa — phần tử có thể nhảy qua
     phần tử bằng nhau, phá vỡ thứ tự ban đầu. -->

Vì trong partition, **swap xảy ra ở khoảng cách xa** — phần tử có thể "nhảy" qua phần tử cùng giá trị:

```
Input: [3a, 2, 3b, 1]     (3a và 3b có cùng giá trị 3)
Pivot = 3a

Partition: 2 ≤ 3a → swap, 3b ≤ 3a → swap, 1 ≤ 3a → swap
Kết quả có thể: [2, 1, 3b, 3a]  ← 3b nhảy trước 3a → UNSTABLE!
```

#### Khi nào cần stable?

| Cần Stable ✅ | Không cần Stable |
|---|---|
| Sort theo **nhiều tiêu chí** (điểm → tên) | Sort primitive (`int[]`, `double[]`) |
| Giữ **thứ tự hiển thị** trên UI | Sort 1 tiêu chí duy nhất |
| **Database** ordering cần consistent | Khi chỉ cần giá trị đúng thứ tự |

> **Đó là lý do Java dùng TimSort (stable) cho Object, và Quick Sort (unstable) cho primitive** — vì `3 == 3` trong int không cần phân biệt, nhưng 2 Student cùng điểm thì khác nhau.

### 🎯 Pivot là gì?

**Pivot** (điểm xoay / phần tử mốc) là **1 phần tử được chọn** từ mảng để làm **chuẩn so sánh**.

> Hình dung: bạn là giáo viên, chọn 1 học sinh có chiều cao 1m60 làm "mốc".
> Bảo cả lớp: "Ai ≤ 1m60 đứng bên trái, ai > 1m60 đứng bên phải."
> → Học sinh 1m60 đó chính là **pivot**.

**Sau khi partition xong, pivot nằm ở đúng vị trí cuối cùng** — không cần di chuyển nữa.

#### Các chiến lược chọn pivot:

<!-- Cách chọn pivot ảnh hưởng trực tiếp đến performance.
     Chọn sai = worst case O(n²). Chọn tốt = avg O(n log n). -->

| Chiến lược | Cách chọn | Ưu điểm | Nhược điểm |
|---|---|---|---|
| **Phần tử đầu** (code của ta) | `pivot = arr[low]` | Đơn giản, dễ hình dung | Worst case khi mảng đã sorted |
| **Phần tử cuối** | `pivot = arr[high]` | Đơn giản | Worst case khi mảng đã sorted |
| **Phần tử giữa** | `pivot = arr[(low+high)/2]` | Tránh worst case sorted | Vẫn có thể xấu |
| **Random** | `pivot = arr[random(low, high)]` | Tránh worst case có chủ đích | Cần random generator |
| **Median-of-three** | Lấy median của `arr[low]`, `arr[mid]`, `arr[high]` | **Tốt nhất thực tế** | Phức tạp hơn |

### 🔀 Partition là gì?

**Partition** (phân hoạch) là quá trình **sắp xếp lại mảng quanh pivot** sao cho:

```
[ tất cả phần tử ≤ pivot | PIVOT | tất cả phần tử > pivot ]
```

> Hình dung: bạn có 1 đống bài trên bàn. Chọn 1 lá làm pivot (ví dụ lá 5).
> Lật từng lá: ≤ 5 → đặt bên trái, > 5 → đặt bên phải.
> Cuối cùng đặt lá 5 vào giữa.
> → Quá trình lật + chia đó chính là **partition**.

**Sau partition:**
- Pivot ở **đúng vị trí cuối cùng** (sorted position)
- Phần trái **chưa sorted** nhưng đều ≤ pivot
- Phần phải **chưa sorted** nhưng đều > pivot
- → Đệ quy partition từng phần cho đến khi mảng sorted

#### Ví dụ trực quan:

```
Input:  [5, 3, 8, 1, 2]     pivot = 5 (phần tử đầu)

Trước:  [  5  |  3,  8,  1,  2  ]
        pivot   ← chưa phân loại →

Partition (duyệt từ index 1 đến 4):
  3 ≤ 5 → trái     [5, 3, 8, 1, 2]  (i=1, swap arr[1]↔arr[1], tự swap)
  8 > 5 → phải     [5, 3, 8, 1, 2]  (bỏ qua)
  1 ≤ 5 → trái     [5, 3, 1, 8, 2]  (i=2, swap arr[2]↔arr[3])
  2 ≤ 5 → trái     [5, 3, 1, 2, 8]  (i=3, swap arr[3]↔arr[4])
  Đặt pivot:        [2, 3, 1, 5, 8]  ← swap pivot (arr[0]) với arr[3]

Sau:    [  2,  3,  1  |  5  |  8  ]
            ≤ 5        PIVOT   > 5
                       ✅ đúng chỗ rồi!
```

#### Lomuto vs Hoare Partition:

<!-- Hai scheme phổ biến nhất. Code của ta dùng Lomuto vì dễ hiểu.
     Hoare nhanh hơn ~3x về số swap nhưng khó implement đúng. -->

| Scheme | Cách hoạt động | Số swap trung bình | Độ khó |
|---|---|---|---|
| **Lomuto** (code của ta) | 1 con trỏ `j` duyệt từ trái → phải, `i` đánh dấu ranh giới | ~n/2 | ⭐ Dễ |
| **Hoare** | 2 con trỏ đi từ 2 đầu vào giữa, swap khi gặp cặp sai vị trí | ~n/6 | ⭐⭐⭐ Khó |

---

## 3. Phân tích độ phức tạp

<!-- Trung bình O(n log n) — nhanh nhất thực tế.
     Worst case O(n²) xảy ra khi pivot luôn là min/max (mảng đã sorted + chọn pivot cuối).
     Thực tế hiếm khi xảy ra, có thể tránh bằng random pivot hoặc median-of-three. -->

| Trường hợp     | Thời gian      | Giải thích                                                              |
| -------------- | -------------- | ----------------------------------------------------------------------- |
| **Tốt nhất**   | **O(n log n)** | Pivot luôn chia mảng thành 2 nửa đều → log n tầng đệ quy, mỗi tầng O(n) |
| **Trung bình** | **O(n log n)** | Pivot chia mảng tương đối đều                                           |
| **Tệ nhất**    | **O(n²)**      | Pivot luôn là min hoặc max → mảng chia 0/n-1 → n tầng đệ quy            |

| Bộ nhớ                                              | Ổn định (Stable)?                                         |
| --------------------------------------------------- | --------------------------------------------------------- |
| **O(log n)** — in-place, nhưng cần stack cho đệ quy | **Không** — swap có thể thay đổi thứ tự phần tử bằng nhau |

---

## 4. Chạy tay từng bước (Step-by-Step Trace)

<!-- Dùng mảng [5, 3, 8, 1, 2] giống các thuật toán trước để dễ so sánh.
     Mỗi bước partition sẽ được mô phỏng chi tiết.
     Ký hiệu: [P] = pivot, | = ranh giới i, ✅ = đã đúng vị trí. -->

**Input:** `[5, 3, 8, 1, 2]` — `n = 5`

---

### 🔄 Lần 1: `quickSort(arr, 0, 4)` — pivot = `5` (arr[0])

<!-- partition(arr, 0, 4): pivot = 5, i = 0, j duyệt từ 1 đến 4.
     Tìm tất cả phần tử <= 5 và đưa về bên trái. -->

| Bước | `j` | So sánh `arr[j]` vs pivot `5` | Hành động                       | `i` | Mảng              |
| ---- | --- | ----------------------------- | ------------------------------- | --- | ----------------- |
| 1    | 1   | `3 <= 5`? ✅                  | `i=1`, swap `arr[1]` ↔ `arr[1]` (tự swap) | 1   | `[5, 3, 8, 1, 2]` |
| 2    | 2   | `8 <= 5`? ❌                  | Bỏ qua                          | 1   | `[5, 3, 8, 1, 2]` |
| 3    | 3   | `1 <= 5`? ✅                  | `i=2`, swap `arr[2]` ↔ `arr[3]` | 2   | `[5, 3, 1, 8, 2]` |
| 4    | 4   | `2 <= 5`? ✅                  | `i=3`, swap `arr[3]` ↔ `arr[4]` | 3   | `[5, 3, 1, 2, 8]` |
| End  | —   | —                             | swap pivot: `arr[0]` ↔ `arr[3]` | —   | `[2, 3, 1, 5, 8]` |

> Pivot `5` về đúng vị trí `[3]` ✅. Trái: `[2, 3, 1]`, Phải: `[8]`

---

### 🔄 Lần 2: `quickSort(arr, 0, 2)` — pivot = `2` (arr[0])

<!-- partition(arr, 0, 2): pivot = 2, i = 0, j duyệt từ 1 đến 2. -->

| Bước | `j` | So sánh `arr[j]` vs pivot `2` | Hành động                       | `i` | Mảng              |
| ---- | --- | ----------------------------- | ------------------------------- | --- | ----------------- |
| 1    | 1   | `3 <= 2`? ❌                  | Bỏ qua                          | 0   | `[2, 3, 1, 5, 8]` |
| 2    | 2   | `1 <= 2`? ✅                  | `i=1`, swap `arr[1]` ↔ `arr[2]` | 1   | `[2, 1, 3, 5, 8]` |
| End  | —   | —                             | swap pivot: `arr[0]` ↔ `arr[1]` | —   | `[1, 2, 3, 5, 8]` |

> Pivot `2` về đúng vị trí `[1]` ✅. Trái: `[1]`, Phải: `[3]`

---

### 🔄 Lần 3: `quickSort(arr, 0, 0)` — mảng `[1]`

> 1 phần tử → **base case**, không làm gì ✅

---

### 🔄 Lần 4: `quickSort(arr, 2, 2)` — mảng `[3]`

> 1 phần tử → **base case**, không làm gì ✅

---

### 🔄 Lần 5: `quickSort(arr, 4, 4)` — mảng `[8]`

> 1 phần tử → **base case**, không làm gì ✅

---

### 📊 Tổng kết trace

<!-- Quick Sort với 5 phần tử chỉ cần 6 phép so sánh — ít hơn
     Bubble Sort (10) và Insertion Sort (9).
     Đệ quy sâu 3 tầng = log₂(5) ≈ 2.3, làm tròn = 3. -->

| Chỉ số               | Quick Sort | Bubble Sort | Insertion Sort |
| -------------------- | ---------- | ----------- | -------------- |
| Tổng số phép so sánh | **6**      | 10          | 9              |
| Tổng số phép swap    | **5**      | 6           | — (dùng shift) |
| Độ sâu đệ quy        | **3 tầng** | —           | —              |

**Output:** `[1, 2, 3, 5, 8]` ✅

---

## 5. Code Java

<!-- Dùng Lomuto partition scheme: pivot = phần tử đầu.
     Đơn giản, dễ hình dung (pivot là phần tử đầu tiên ta nhìn thấy).
     Production code thường dùng Hoare partition hoặc median-of-three để tránh worst case. -->

```java
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
        // Chọn phần tử đầu làm pivot
        T pivot = arr[low];

        // i theo dõi ranh giới giữa vùng <= pivot và vùng > pivot
        int i = low;

        // Duyệt từ low+1 đến high, so sánh từng phần tử với pivot
        for (int j = low + 1; j <= high; j++) {
            // Nếu phần tử hiện tại <= pivot → đưa nó vào vùng bên trái
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        // Đặt pivot vào đúng vị trí (giữa vùng <= và vùng >)
        swap(arr, low, i);
        return i;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### Giải thích code

<!-- 3 hàm chính: sort (entry point) → quickSort (đệ quy) → partition (chia mảng). -->

| Hàm / Biến          | Vai trò                                                  |
| ------------------- | -------------------------------------------------------- |
| `sort()`            | Entry point — kiểm tra null/empty rồi gọi quickSort      |
| `quickSort()`       | Đệ quy: partition → sort nửa trái → sort nửa phải        |
| `partition()`       | Chia mảng thành 2 vùng: ≤ pivot (trái) và > pivot (phải) |
| `pivot = arr[low]`  | Chọn phần tử đầu làm mốc (Lomuto scheme)                 |
| `i`                 | Ranh giới: mọi phần tử từ `low+1` đến `i` đều ≤ pivot    |
| `swap(low, i)`      | Đặt pivot vào đúng vị trí cuối cùng                      |

---

## 6. Khi nào dùng / Khi nào tránh

<!-- Quick Sort là lựa chọn mặc định cho hầu hết trường hợp thực tế.
     Java's Arrays.sort() cho primitive dùng Dual-Pivot Quick Sort.
     C++ std::sort dùng Introsort (Quick Sort + Heap Sort + Insertion Sort). -->

| ✅ Nên dùng                                      | ❌ Nên tránh                                                    |
| ------------------------------------------------ | --------------------------------------------------------------- |
| Mảng lớn, dữ liệu ngẫu nhiên                     | Dữ liệu gần sorted + pivot cố định (worst case O(n²))           |
| Cần sort nhanh, bộ nhớ hạn chế (in-place)        | Cần thuật toán ổn định (stable) → dùng **Merge Sort**           |
| General-purpose sorting                          | Khi worst case O(n²) không chấp nhận được → dùng **Merge Sort** |
| Kết hợp với Insertion Sort cho mảng nhỏ (hybrid) | Dữ liệu có nhiều phần tử trùng lặp (cần 3-way partition)        |

---

## 7. So sánh với các thuật toán khác

<!-- Quick Sort thống trị thực tế nhờ cache-friendly và constant factor nhỏ.
     Merge Sort đảm bảo O(n log n) nhưng cần O(n) bộ nhớ phụ. -->

| Thuật toán     | Tốt nhất       | Trung bình     | Tệ nhất    | Bộ nhớ       | Ổn định |
| -------------- | -------------- | -------------- | ---------- | ------------ | ------- |
| Bubble Sort    | O(n)           | O(n²)          | O(n²)      | O(1)         | ✅      |
| Insertion Sort | O(n)           | O(n²)          | O(n²)      | O(1)         | ✅      |
| Merge Sort     | O(n log n)     | O(n log n)     | O(n log n) | O(n)         | ✅      |
| **Quick Sort** | **O(n log n)** | **O(n log n)** | **O(n²)**  | **O(log n)** | **❌**  |

---

## 8. Partition hoạt động thế nào?

<!-- Đây là phần khó nhất của Quick Sort. Hiểu partition = hiểu Quick Sort.
     Dùng sơ đồ để hình dung con trỏ i và j di chuyển. -->

```
Trước partition:  [  pivot  |  chưa xét  ]
                  low                  high

Trong partition:  [ pivot | <= pivot | > pivot | chưa xét ]
                  low             i          j           high

Sau partition:    [ <= pivot | PIVOT | > pivot ]
                  low         i       high
```

**Bất biến (Invariant):**

- `arr[low]`: **pivot** (chưa di chuyển cho đến cuối)
- Mọi phần tử từ `low+1` đến `i`: **≤ pivot**
- Mọi phần tử từ `i+1` đến `j-1`: **> pivot**
- Phần tử từ `j` đến `high`: **chưa xét**

---
