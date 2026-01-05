package org.conghung.datastructuresandalgorithms.dsa.hashtable;

public class SeparateChaining {
    // Idea của Separate Chaining là: mỗi element của array nó sẽ là một tệp dữ liệu chứ nó không phải là 1 element đơn lẻ
    // The idea of Separate Chaining is: each element of the array is a data collection, not a single element
    // Ví dụ: mỗi element của array sẽ là một linked list, hoặc một binary search tree, hoặc một mảng động (dynamic array)
    // Example: each element of the array will be a linked list, or a binary search tree, or a dynamic array
    // Có nghĩa là khi chúng ta sử dụng 1 cái Separate Chaining Hashtable
    // This means when we use a Separate Chaining Hashtable
    // của chúng ta cơ bản là một cái array của linked list hoặc một cái array của array hoặc là một cái array của binary tree
    // basically ours is an array of linked lists, or an array of arrays, or an array of binary trees
    // Nhưng người ta thường sử dụng linked list hơn vì nó đơn giản và dễ triển khai hơn
    // But people usually use linked lists more because it is simpler and easier to implement
    // Hầu hết tất cả những thứ liên quan đến hash table được giải quyết như sau:
    // Most things related to hash tables are resolved as follows:
    // Chúng ta lôi tất cả các element của cái hashtable ra sau đó chúng ta tạo ra một cái array mới có kích thước lớn hơn
    // We take all elements out of the hashtable, then create a new array with a larger size
    // và sau đó chúng ta re-hash tất cả các element từ cái hashtable cũ sang cái hashtable mới
    // and then we re-hash all elements from the old hashtable to the new hashtable
    // Khi nào chúng ta cần array mới mà khi nào chúng ta không cần array mới?
    // When do we need a new array and when do we not?
    // Trong hashtable người ta có khái niệm Load Factor (Hệ số tải) là tỉ lệ giữa số lượng element hiện tại và (capacity) kích thước của array.
    // In hashtable, there is a concept called Load Factor, which is the ratio between current number of elements and array capacity.
    // Threshold (Ngưỡng) = Capacity * Load Factor. Ví dụ Load Factor là 0.75.
    // Threshold = Capacity * Load Factor. For example, Load Factor is 0.75.
    // Nếu số lượng element vượt quá Threshold, chúng ta sẽ tạo ra một cái array mới có kích thước gấp đôi (Rehashing).
    // If the number of elements exceeds the Threshold, we will create a new array with double size (Rehashing).
    // Phân tích dùng kiểu dữ liệu nào trong hashtable sẽ hợp lý:
    // Analysis of which data type is reasonable to use in hashtable:
    // Linked list: dễ triển khai, đơn giản, nhưng tìm kiếm chậm O(n)
    // Linked list: easy to implement, simple, but slow search O(n)
    // Dynamic array: tìm kiếm vẫn là O(n) như linked list nhưng thực tế nhanh hơn nhờ cache locality, tuy nhiên việc chèn và xóa phức tạp hơn
    // Dynamic array: search is still O(n) like linked list but practically faster due to cache locality, however insertion and deletion are more complex
    // Binary search tree: tìm kiếm nhanh O(log n), chèn và xóa cũng nhanh O(log n), nhưng triển khai phức tạp hơn
    // Binary search tree: fast search O(log n), insertion and deletion are also fast O(log n), but implementation is more complex
    // Lưu ý: Từ Java 8, HashMap sử dụng Linked List, nhưng khi bucket quá đầy ( > 8 phần tử), nó chuyển sang Red-Black Tree để tối ưu O(log n).
    // Note: From Java 8, HashMap uses Linked List, but when a bucket is too full (> 8 elements), it switches to Red-Black Tree to optimize to O(log n).
    // Vì vậy linked list là một cấu trúc dữ liệu cân bằng và tối ưu để bắt đầu triển khai Separate Chaining.
    // Therefore linked list is a balanced and optimal data structure to start implementing Separate Chaining.
}
