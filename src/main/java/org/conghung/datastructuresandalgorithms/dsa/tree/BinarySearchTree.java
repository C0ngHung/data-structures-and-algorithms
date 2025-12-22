package org.conghung.datastructuresandalgorithms.dsa.tree;

public class BinarySearchTree {
    /**
     * - Định nghĩa về Binary Search Tree:
     * - Definition of Binary Search Tree:
     * - Binary Search Tree (Cây tìm kiếm nhị phân) là một loại cây nhị phân đặc biệt mà trong đó: log(n)
     * - A Binary Search Tree (BST) is a special kind of binary tree with average operations at O(log n).
     * - Binary Search Tree thì luôn luôn cái bên phải luôn luôn lớn nhất
     * - In a BST, the right subtree always contains values greater than the current node.
     * - Cái bên trái luôn luôn nhỏ nhất
     * - The left subtree always contains values smaller than the current node.
     * - Cái giữa là ở giữa
     * - The current node's value sits between its left and right subtrees.
     * - Ví dụ BST:
     * - Example BST:
     * - Nếu 1 BST bạn cho phép nó bị duplicate (trùng lặp giá trị) thì bạn có thể quy ước: có nghĩa là node của nó có thể bị duplicate
     * - If a BST allows duplicate values, you can define a rule to handle duplicates.
     * - Nếu giá trị mới <= giá trị hiện tại thì nó sẽ đi về bên trái
     * - If the new value <= current value, it goes to the left subtree.
     * - Nếu giá trị mới > giá trị hiện tại thì nó sẽ đi về bên phải
     * - If the new value > current value, it goes to the right subtree.
     * - Nếu như BST chữ thì vẫn được
     * - Storing duplicates is allowed if your rule supports it.
     * - BST hỗi trợ cho những dữ liệu có thể comparable được với nhau
     * - A BST supports data types that can be compared with each other.
     * - Ứng dụng của Binary Search Tree:
     * - Applications of Binary Search Tree:
     * - 1 số loại map và set chúng ta có thể sử dụng BST để implement chúng
     * - Some map and set implementations can be built using BST.
     * - Ví dụ: TreeMap, TreeSet trong Java
     * - Examples: TreeMap, TreeSet in Java.
     * - BST cũng được sử dụng trong các thuật toán tìm kiếm và sắp xếp
     * - BST is also used in search and sort algorithms.
     * - Các thuật toán như: binary search, in-order traversal để lấy dữ liệu đã được sắp xếp
     * - Algorithms such as binary search, in-order traversal to retrieve sorted data.
     * - Hiệu suất của Binary Search Tree:
     * - Performance of Binary Search Tree:
     * - Binary Search Tree cho phép chúng ta thực hiện các thao tác như: insert, delete, search một cách hiệu quả với độ phức tạp trung bình là O(log n)
     * - BST allows efficient insert, delete, search with average complexity O(log n).
     * - Điều này làm cho BST trở thành một cấu trúc dữ liệu lý tưởng cho các ứng dụng yêu cầu tìm kiếm nhanh và sắp xếp dữ liệu.
     * - This makes BST ideal for applications requiring fast lookup and sorting.
     * - Ngoài ra, BST còn hỗ trợ các thao tác như tìm kiếm phần tử lớn nhất, phần tử nhỏ nhất, và duyệt cây theo thứ tự (in-order traversal) để lấy dữ liệu đã được sắp xếp.
     * - BST also supports finding max/min elements and in-order traversal to obtain sorted data.
     * - Cấu trúc của node trong Binary Search Tree:
     * - Structure of a node in a Binary Search Tree:
     * - data: chứa giá trị của node
     * - data: holds the node's value
     * - left: con trỏ hoặc tham chiếu đến node con bên trái
     * - left: pointer/reference to the left child node
     * - right: con trỏ hoặc tham chiếu đến node con bên phải
     * - right: pointer/reference to the right child node
     * - Độ phức tạp của BST:
     * - Complexity of BST:
     * - Insert: Khi muốn insert 1 element vào trong BST thì đầu tiên phải so sánh element đó với root node
     * - Insert: To insert an element, first compare it with the root node.
     * - Nếu element đó nhỏ hơn root node thì sẽ đi về bên trái, nếu lớn hơn thì sẽ đi về bên phải
     * - If the element is smaller than root, go left; if larger, go right.
     * - Quá trình này sẽ tiếp tục lặp lại cho đến khi tìm được vị trí thích hợp để chèn element mới vào
     * - Repeat until you find the appropriate position to insert.
     * - Độ phức tạp trung bình của thao tác insert trong BST là O(log n), tuy nhiên trong trường hợp xấu nhất (khi cây bị lệch hoàn toàn về một bên)
     * - Average insert complexity is O(log n); worst case (highly skewed tree) is O(n).
     * - độ phức tạp có thể lên đến O(n)
     * - Complexity can degrade to O(n).
     * - Remove: Khi muốn remove một element trong BST đầu tiên có value chekc với root node
     * - Remove: To remove an element, first compare its value with the root node.
     * - Check trường hợp dễ trước nhỏ hơn hay lớn hơn root nếu nhỏ hơn thì đi về bên trái, lớn hơn thì đi về bên phải
     * - Check if smaller/greater than root: if smaller go left, if greater go right.
     * - Quá trình này tiếp tục cho đến khi tìm thấy element cần xóa hoặc đến khi không còn node nào để duyệt
     * - Continue until the element is found or traversal ends.
     * - Nếu node đó là cái lá (không có con) thì chỉ cần loại bỏ node đó
     * - If the node is a leaf, simply remove it.
     * - Nếu node đó là parent của một thằng nào đấy thì ta sẽ đi qua phía bên phải và tìm min của phía bên phải để thay thế
     * - If the node has children, replace it with the minimum node from the right subtree (in-order successor).
     * - Search: Tương tự như thao tác insert, khi muốn tìm kiếm một element trong BST thì cũng bắt đầu từ root node nếu root null thì trả về false
     * - Search: Similar to insert; start at root, if root is null return false.
     * - và so sánh element đó với giá trị của node
     * - Compare the element with the node's value.
     * - Nếu element nhỏ hơn thì đi về bên trái, nếu lớn hơn thì đi về bên phải
     * - If smaller, go left; if larger, go right.
     * - Quá trình này tiếp tục cho đến khi tìm thấy element hoặc đến khi không còn node nào để duyệt
     * - Continue until the element is found or traversal ends.
     * - Độ phức tạp trung bình của thao tác search trong BST cũng là O(log n), và trong trường hợp xấu nhất có thể lên đến O(n)
     * - Average search complexity is O(log n); worst case can be O(n).
     * - Delete: Khi muốn xóa một element trong BST, có ba trường hợp cần xem xét:
     * - Delete: When deleting an element in BST, three cases exist:
     * - Nếu node cần xóa là lá (không có con), chỉ cần loại bỏ node đó
     * - If the node is a leaf, just remove it.
     * - Nếu node cần xóa có một con, thay thế node đó bằng con của nó
     * - If the node has one child, replace the node with its child.
     * - Nếu node cần xóa có hai con, tìm node kế tiếp (in-order successor) hoặc node trước đó (in-order predecessor) để thay thế, sau đó xóa node kế tiếp hoặc trước đó
     * - If the node has two children, find the in-order successor or predecessor to replace it, then remove that successor or predecessor.
     * - Độ phức tạp trung bình của thao tác delete trong BST là O(log n), và trong trường hợp xấu nhất có thể lên đến O(n)
     * - Average delete complexity is O(log n); worst case can be O(n).
     */
}
