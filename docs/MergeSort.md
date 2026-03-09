# Merge Sort — Thuật toán "Chia để trị" đảm bảo

<!-- Hình dung thế này: bạn cắt mảng làm đôi, cắt tiếp cho đến khi mỗi mảnh chỉ còn 1 phần tử.
     Rồi ghép (merge) các mảnh lại theo thứ tự — giống xếp 2 bộ bài đã sorted thành 1 bộ.
     Luôn O(n log n) mọi trường hợp, stable, nhưng cần mảng phụ O(n). -->

**Bản chất:** chia đôi mảng → đệ quy sort từng nửa → merge 2 nửa đã sorted thành 1 mảng sorted.

---

## 1. Ý tưởng cốt lõi

<!-- Merge Sort dùng chiến lược Divide and Conquer (Chia để trị).
     Khác với Quick Sort chia theo giá trị (partition), Merge Sort chia đều tại midpoint.
     Công việc chính nằm ở bước MERGE (khi ghép lại), không phải bước chia. -->

- **Chia (Divide):** cắt đôi mảng tại `mid = (left + right) / 2`.
- **Đệ quy (Conquer):** sort nửa trái `[left..mid]` và nửa phải `[mid+1..right]`.
- **Ghép (Merge):** merge 2 nửa đã sorted thành 1 mảng sorted — dùng 2 con trỏ so sánh từng cặp.
- **Base case:** mảng 0 hoặc 1 phần tử → đã sorted.
- **Ưu điểm:** luôn O(n log n), stable, dễ dự đoán performance.
- **Nhược điểm:** cần O(n) bộ nhớ phụ cho mảng tạm trong bước merge.

### So sánh tư duy với Quick Sort

<!-- Hai thuật toán cùng Divide and Conquer nhưng khác ở chỗ "công việc nặng" nằm đâu.
     Quick Sort: nặng ở CHIA (partition), nhẹ ở ghép.
     Merge Sort: nhẹ ở CHIA (cắt đôi), nặng ở GHÉP (merge). -->

| | Quick Sort | Merge Sort |
|---|---|---|
| **Chia** | Partition (nặng — phải duyệt + swap) | Cắt đôi (nhẹ — chỉ tính `mid`) |
| **Ghép** | Không cần (in-place) | Merge (nặng — phải duyệt + copy) |
| **Bộ nhớ** | O(log n) — in-place | **O(n)** — cần mảng tạm |
| **Ổn định** | ❌ Không | **✅ Có** |

---

## 2. Thuật ngữ: Divide, Merge & Two-Pointer

<!-- Ba khái niệm cốt lõi để hiểu Merge Sort:
     1. Divide: cách chia mảng
     2. Merge: cách ghép 2 mảng sorted
     3. Two-Pointer: kỹ thuật dùng trong merge -->

### ✂️ Divide (Chia đôi)

Mỗi lần đệ quy, mảng bị **cắt đôi** tại `mid`:

```
[5, 3, 8, 1, 2]
       ↓ chia
[5, 3, 8]  [1, 2]
    ↓           ↓
[5, 3] [8]  [1] [2]
  ↓
[5] [3]
```

> Chia cho đến khi mỗi mảnh chỉ còn **1 phần tử** — 1 phần tử luôn sorted.

### 🔀 Merge (Ghép)

Merge 2 mảng **đã sorted** thành 1 mảng sorted:

> Hình dung: bạn có 2 bộ bài đã xếp từ nhỏ → lớn, úp trên bàn.
> Lật lá trên cùng của mỗi bộ, lấy lá nhỏ hơn đặt sang đống mới.
> Lặp lại cho đến khi hết cả 2 bộ.
> → Đống mới chính là mảng sorted.

```
leftArr:  [3, 5]    rightArr: [1, 8]
           ↑ i=0               ↑ j=0

Bước 1: 3 vs 1 → lấy 1   → result: [1]
Bước 2: 3 vs 8 → lấy 3   → result: [1, 3]
Bước 3: 5 vs 8 → lấy 5   → result: [1, 3, 5]
Bước 4: hết left → lấy 8 → result: [1, 3, 5, 8]
```

### 👆 Two-Pointer trong Merge

Kỹ thuật dùng **2 con trỏ `i` và `j`** — mỗi con trỏ duyệt 1 mảng:

```
leftArr:  [3, 5]       rightArr: [1, 8]
           ↑ i                    ↑ j

So sánh leftArr[i] vs rightArr[j]:
  - Nếu left <= right → lấy left, i++
  - Nếu right < left  → lấy right, j++
  - Khi 1 mảng hết    → copy phần còn lại của mảng kia
```

**Tại sao Merge Sort stable?**

Vì trong bước merge, khi `leftArr[i] == rightArr[j]`, ta **luôn lấy leftArr trước** (`<=`). Phần tử bên trái luôn xuất hiện trước trong mảng gốc → **thứ tự bằng nhau được giữ nguyên**.

---

## 3. Phân tích độ phức tạp

<!-- Merge Sort LUÔN O(n log n) — không có worst case O(n²) như Quick Sort.
     Trade-off: cần O(n) bộ nhớ phụ cho mảng tạm.
     Log n tầng đệ quy (chia đôi), mỗi tầng merge tổng cộng n phần tử. -->

| Trường hợp     | Thời gian      | Giải thích                                                                |
| -------------- | -------------- | ------------------------------------------------------------------------- |
| **Tốt nhất**   | **O(n log n)** | Luôn chia đôi → log n tầng, mỗi tầng merge O(n)                          |
| **Trung bình** | **O(n log n)** | Không phụ thuộc input — luôn chia đôi                                     |
| **Tệ nhất**    | **O(n log n)** | Vẫn chia đôi, vẫn merge — **không có worst case như Quick Sort**          |

| Bộ nhớ                                          | Ổn định (Stable)?                                         |
| ----------------------------------------------- | --------------------------------------------------------- |
| **O(n)** — cần mảng tạm cho merge               | **Có** — phần tử bằng nhau giữ nguyên thứ tự ban đầu     |

### Tại sao luôn O(n log n)?

```
Tầng 0: [████████████████]           → 1 mảng, n phần tử
Tầng 1: [████████] [████████]         → 2 mảng, merge tổng n
Tầng 2: [████] [████] [████] [████]   → 4 mảng, merge tổng n
...
Tầng k: [█] [█] [█] [█] [█] [█] ...  → n mảng, merge tổng n

Tổng tầng = log₂(n)
Mỗi tầng merge = O(n)
→ Tổng = O(n × log n)
```

> Quick Sort phụ thuộc vào pivot — pivot xấu → chia 0/n-1 → O(n²).
> Merge Sort **luôn** chia đôi → **luôn** log n tầng → **luôn** O(n log n).

---

## 4. Chạy tay từng bước (Step-by-Step Trace)

<!-- Dùng mảng [5, 3, 8, 1, 2] giống Quick Sort để dễ so sánh.
     Ký hiệu: ↓ = chia, ↑ = merge, ✅ = đã sorted. -->

**Input:** `[5, 3, 8, 1, 2]` — `n = 5`

---

### ✂️ Phase 1: Chia (Divide)

```
                    [5, 3, 8, 1, 2]
                   /               \
              [5, 3, 8]           [1, 2]
             /        \          /     \
          [5, 3]      [8]      [1]    [2]
         /     \
        [5]   [3]
```

> Chia cho đến khi mỗi mảnh chỉ còn 1 phần tử.

---

### 🔀 Phase 2: Merge (Conquer) — từ dưới lên

---

#### Merge 1: `[5]` + `[3]` → `[3, 5]`

| Bước | `leftArr[i]` | `rightArr[j]` | So sánh    | Lấy | Kết quả  |
| ---- | ------------ | -------------- | ---------- | --- | -------- |
| 1    | 5            | 3              | `5 > 3`    | 3   | `[3]`    |
| 2    | 5            | (hết)          | copy left  | 5   | `[3, 5]` |

---

#### Merge 2: `[3, 5]` + `[8]` → `[3, 5, 8]`

| Bước | `leftArr[i]` | `rightArr[j]` | So sánh    | Lấy | Kết quả      |
| ---- | ------------ | -------------- | ---------- | --- | ------------ |
| 1    | 3            | 8              | `3 <= 8`   | 3   | `[3]`        |
| 2    | 5            | 8              | `5 <= 8`   | 5   | `[3, 5]`     |
| 3    | (hết)        | 8              | copy right | 8   | `[3, 5, 8]`  |

---

#### Merge 3: `[1]` + `[2]` → `[1, 2]`

| Bước | `leftArr[i]` | `rightArr[j]` | So sánh    | Lấy | Kết quả  |
| ---- | ------------ | -------------- | ---------- | --- | -------- |
| 1    | 1            | 2              | `1 <= 2`   | 1   | `[1]`    |
| 2    | (hết)        | 2              | copy right | 2   | `[1, 2]` |

---

#### Merge 4 (Final): `[3, 5, 8]` + `[1, 2]` → `[1, 2, 3, 5, 8]`

| Bước | `leftArr[i]` | `rightArr[j]` | So sánh    | Lấy | Kết quả          |
| ---- | ------------ | -------------- | ---------- | --- | ---------------- |
| 1    | 3            | 1              | `3 > 1`    | 1   | `[1]`            |
| 2    | 3            | 2              | `3 > 2`    | 2   | `[1, 2]`         |
| 3    | 3            | (hết)          | copy left  | 3   | `[1, 2, 3]`      |
| 4    | 5            | —              | copy left  | 5   | `[1, 2, 3, 5]`   |
| 5    | 8            | —              | copy left  | 8   | `[1, 2, 3, 5, 8]`|

---

### 📊 Tổng kết trace

<!-- Merge Sort với 5 phần tử: 7 phép so sánh, 4 lần merge.
     Đệ quy sâu 3 tầng = ceil(log₂(5)) = 3. -->

| Chỉ số               | Merge Sort | Quick Sort | Bubble Sort | Insertion Sort |
| -------------------- | ---------- | ---------- | ----------- | -------------- |
| Tổng số phép so sánh | **7**      | 6          | 10          | 9              |
| Tổng số lần merge    | **4**      | —          | —           | —              |
| Độ sâu đệ quy        | **3 tầng** | 3 tầng     | —           | —              |
| Bộ nhớ phụ            | **O(n)**   | O(1)       | O(1)        | O(1)           |

**Output:** `[1, 2, 3, 5, 8]` ✅

---

## 5. Code Java

<!-- Chia đôi tại mid → đệ quy sort 2 nửa → merge bằng 2 mảng tạm + two-pointer.
     Dùng (T[]) new Comparable[n] vì Java không cho tạo generic array trực tiếp. -->

```java
public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Đệ quy sort nửa trái và nửa phải
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge 2 nửa đã được sort
            merge(arr, left, mid, right);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        // Tạo 2 mảng tạm chứa 2 nửa
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArr = (T[]) new Comparable[n1];
        T[] rightArr = (T[]) new Comparable[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge 2 mảng tạm trở lại arr
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy phần còn lại của leftArr (nếu có)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy phần còn lại của rightArr (nếu có)
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
```

### Giải thích code

<!-- 3 hàm chính: sort (entry point) → mergeSort (đệ quy chia đôi) → merge (ghép 2 nửa). -->

| Hàm / Biến                  | Vai trò                                                            |
| --------------------------- | ------------------------------------------------------------------|
| `sort()`                    | Entry point — kiểm tra null/empty rồi gọi mergeSort                |
| `mergeSort()`               | Đệ quy: chia đôi → sort trái → sort phải → merge                  |
| `merge()`                   | Ghép 2 nửa đã sorted bằng kỹ thuật two-pointer                    |
| `mid = left + (right-left)/2` | Tính điểm giữa — tránh integer overflow so với `(left+right)/2`  |
| `leftArr`, `rightArr`       | Mảng tạm chứa 2 nửa — **đây là lý do Merge Sort cần O(n) bộ nhớ** |
| `<= 0` trong compareTo      | Lấy left trước khi bằng → **đảm bảo stable**                      |

### Tại sao `left + (right - left) / 2` thay vì `(left + right) / 2`?

```
left = 1_500_000_000
right = 2_000_000_000

(left + right) / 2 = 3_500_000_000 / 2  → ❌ INTEGER OVERFLOW! (> Integer.MAX_VALUE)
left + (right - left) / 2 = 1_500_000_000 + 250_000_000 = 1_750_000_000  → ✅ an toàn
```

---

## 6. Khi nào dùng / Khi nào tránh

<!-- Merge Sort phù hợp khi cần stable sort hoặc cần đảm bảo O(n log n).
     Java's Arrays.sort() cho Object dùng TimSort (dựa trên Merge Sort).
     Phù hợp sort linked list vì merge không cần random access. -->

| ✅ Nên dùng                                         | ❌ Nên tránh                                             |
| --------------------------------------------------- | -------------------------------------------------------- |
| Cần **stable sort** (giữ thứ tự phần tử bằng nhau)  | Bộ nhớ rất hạn chế → dùng **Quick Sort** (in-place)     |
| Cần **đảm bảo O(n log n)** mọi trường hợp           | Mảng nhỏ → dùng **Insertion Sort** (overhead đệ quy)    |
| Sort **Linked List** (merge không cần random access) | Dữ liệu đã gần sorted → dùng **Insertion Sort** O(n)    |
| Sort dữ liệu lớn trên đĩa (External Sort)           | Cần sort nhanh nhất thực tế → **Quick Sort** (cache-friendly) |

---

## 7. So sánh với các thuật toán khác

<!-- Merge Sort đảm bảo O(n log n) mọi trường hợp — đối lập với Quick Sort có worst case O(n²).
     Trade-off: Merge Sort cần O(n) bộ nhớ phụ, Quick Sort chỉ cần O(log n).
     Java dùng TimSort (hybrid Merge Sort + Insertion Sort) cho Object. -->

| Thuật toán     | Tốt nhất       | Trung bình     | Tệ nhất        | Bộ nhớ       | Ổn định |
| -------------- | -------------- | -------------- | -------------- | ------------ | ------- |
| Bubble Sort    | O(n)           | O(n²)          | O(n²)          | O(1)         | ✅      |
| Insertion Sort | O(n)           | O(n²)          | O(n²)          | O(1)         | ✅      |
| Quick Sort     | O(n log n)     | O(n log n)     | O(n²)          | O(log n)     | ❌      |
| **Merge Sort** | **O(n log n)** | **O(n log n)** | **O(n log n)** | **O(n)**     | **✅**  |

> **Java's sorting strategy:**
> - `Arrays.sort(int[])` → **Dual-Pivot Quick Sort** (primitive, unstable OK)
> - `Arrays.sort(Object[])` → **TimSort** (dựa trên Merge Sort, stable cần thiết)

---

## 8. Merge hoạt động thế nào?

<!-- Đây là phần cốt lõi của Merge Sort. Hiểu merge = hiểu toàn bộ thuật toán.
     Dùng sơ đồ để hình dung 2 con trỏ i, j di chuyển. -->

```
Trước merge:
  leftArr:  [3, 5, 8]       rightArr: [1, 2]
             ↑ i=0                     ↑ j=0

Trong merge (two-pointer):
  So sánh leftArr[i] vs rightArr[j]
  → Lấy cái nhỏ hơn, tăng con trỏ tương ứng

            leftArr          rightArr
  Bước 1:  [3, 5, 8]        [1, 2]      → 3 > 1, lấy 1     → result[0] = 1
  Bước 2:  [3, 5, 8]        [_, 2]      → 3 > 2, lấy 2     → result[1] = 2
  Bước 3:  [3, 5, 8]        [_, _]      → right hết, copy left
  Result:  [1, 2, 3, 5, 8]  ✅

Sau merge:
  arr[left..right] = [1, 2, 3, 5, 8]   ← sorted!
```

**Bất biến (Invariant) trong merge:**

- `leftArr[0..i-1]`: **đã được merge** vào result
- `rightArr[0..j-1]`: **đã được merge** vào result
- `arr[left..k-1]`: **đã sorted**
- Khi `leftArr[i] == rightArr[j]` → **lấy left trước** → stable ✅

---
