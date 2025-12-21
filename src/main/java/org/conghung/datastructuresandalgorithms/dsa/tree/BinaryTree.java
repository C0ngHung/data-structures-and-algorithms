package org.conghung.datastructuresandalgorithms.dsa.tree;

public class BinaryTree {
    /**
     * - Định nghĩa:
     * - Binary Tree (Cây nhị phân) là một cái tree và nó sẽ chứa tất cả những tính chất, và những thứ liên quan đến 1 tree cơ bản
     * - Có nghĩa là mỗi node cha nó chỉ có từ 0 đến 2 node con
     * - Chúng ta có tổng cộng 3 loại Binary Tree:
     * - Skewed Binary Tree: có nghĩa là đối với mỗi node cha chỉ có 2 trường hợp xảy ra:
     *      + Không có node con nào cả
     *      + Có đủ 2 node con
     * - Full Binary Tree: có nghĩa là tất cả các node đều có đủ 2 node con và những node lá (leaf node) sẽ cùng nằm trên 1 tầng với nhau
     * - Complete Binary Tree: Bản chất của Complete Binary Tree là một Full Binary Tree nhưng nó sẽ khác một chút ở chỗ:
     * - Thằng complete binary tree nó có thể thiếu bớt đi 1 vài node lá nhưng quy tắc của nó là
     * - tất cả những node đều phải dồn qua phía bên trái
     * - Vì là 1 cây nhị phân nên hầu hết tất cả mọi thứ tính theo cơ số 2.
     * - ví dụ: cho 1 cây có độ cao là h (height = h) thì:
     * - root node sẽ nằm ở tầng 0 h = 0
     * - tầng 1 sẽ có h = 1
     * - tầng 2 sẽ có h = 2
     * - tầng 3 sẽ có h = 3
     * - Muốn đưa đống node vào để tạo thành full binary tree thì tổng số node sẽ là: 2^(h+1) - 1 = tổng = 2^0 + 2^1 + 2^2 + ... + 2^h-1 + 2^h
     * - Muốn đưa đống node vào để tạo thành complete binary tree với chiều cao là h thì số lượng node tối thiểu sẽ là: 2^h và số lượng node tối đa sẽ là: 2^(h+1) - 1
     * - Tổng số lượng node lá (leaf node) trong một complete binary tree hoặc full binary tree sẽ là: 2^h
     * - Cấu trúc của node trong binary tree sẽ bao gồm:
     * - data: chứa giá trị của node
     * - left: con trỏ hoặc tham chiếu đến node con bên trái
     * - right: con trỏ hoặc tham chiếu đến node con bên phải
     * - 1 binary tree thì nó sẽ có những functionality cơ bản như của 1 tree bình thường:
     * - Ứng dụng: Binary Tree là binary search tree cho phép chúng ta insert hoặc là search những cái node ở trong cái cây
     * - với độ phức tạp của thuật toán nằm ở mức trung bình đó là O(log n)
     * - Duyệt cây dựa trên 3: d là (data/node root hiện tại), l là (left), r là (right): DLR, LDR, LRD...
     * - Traversal LDR (Inorder Traversal): left -> data -> right
     * - Traversal DLR (Preorder Traversal): data -> left -> right
     * - Traversal LRD (Postorder Traversal): left -> right -> data
     * - Nếu level order traversal (BFS) thì ta sẽ duyệt từ trên xuống dưới, từ trái sang phải
     */
}
