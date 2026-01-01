package org.conghung.datastructuresandalgorithms.dsa.tree;

public class BinaryTree {
    /**
     * - Định nghĩa:
     * - Definition:
     * - Binary Tree (Cây nhị phân) là một cái tree và nó sẽ chứa tất cả những tính chất, và những thứ liên quan đến 1 tree cơ bản
     * - Binary Tree is a tree that contains all the properties and characteristics of a basic tree
     * - Có nghĩa là mỗi node cha nó chỉ có từ 0 đến 2 node con
     * - This means each parent node has at most 2 child nodes (0, 1, or 2)
     * - Chúng ta có tổng cộng 3 loại Binary Tree:
     * - There are 3 types of Binary Tree:
     * - Skewed Binary Tree: có nghĩa là đối với mỗi node cha chỉ có 2 trường hợp xảy ra:
     * - Skewed Binary Tree: for each parent node, only 2 cases occur:
     *      + Không có node con nào cả
     *      + Has no children at all
     *      + Có đủ 2 node con
     *      + Has exactly 2 children
     * - Full Binary Tree: có nghĩa là tất cả các node đều có đủ 2 node con và những node lá (leaf node) sẽ cùng nằm trên 1 tầng với nhau
     * - Full Binary Tree: all nodes have exactly 2 children, and all leaf nodes are at the same level
     * - Complete Binary Tree: Bản chất của Complete Binary Tree là một Full Binary Tree nhưng nó sẽ khác một chút ở chỗ:
     * - Complete Binary Tree: essentially a Full Binary Tree but differs slightly in that:
     * - Complete binary tree có thể thiếu bớt đi 1 vài node lá nhưng quy tắc của nó là
     * - A complete binary tree may be missing some leaf nodes, but the rule is
     * - tất cả những node đều phải dồn qua phía bên trái
     * - all nodes must be filled from left to right
     * - Vì là 1 cây nhị phân nên hầu hết tất cả mọi thứ tính theo cơ số 2.
     * - Since it's a binary tree, almost everything is calculated in base 2.
     * - ví dụ: cho 1 cây có độ cao là h (height = h) thì:
     * - Example: for a tree with height h (height = h):
     * - root node sẽ nằm ở tầng 0 h = 0
     * - root node is at level 0, h = 0
     * - tầng 1 sẽ có h = 1
     * - level 1 has h = 1
     * - tầng 2 sẽ có h = 2
     * - level 2 has h = 2
     * - tầng 3 sẽ có h = 3
     * - level 3 has h = 3
     * - Muốn đưa đống node vào để tạo thành full binary tree thì tổng số node sẽ là: 2^(h+1) - 1 = tổng = 2^0 + 2^1 + 2^2 + ... + 2^h-1 + 2^h
     * - To create a full binary tree, the total number of nodes will be: 2^(h+1) - 1 = sum = 2^0 + 2^1 + 2^2 + ... + 2^(h-1) + 2^h
     * - Muốn đưa đống node vào để tạo thành complete binary tree với chiều cao là h thì số lượng node tối thiểu sẽ là: 2^h và số lượng node tối đa sẽ là: 2^(h+1) - 1
     * - To create a complete binary tree with height h, the minimum number of nodes is: 2^h and the maximum number of nodes is: 2^(h+1) - 1
     * - Tổng số lượng node lá (leaf node) trong một complete binary tree hoặc full binary tree sẽ là: 2^h
     * - The total number of leaf nodes in a complete binary tree or full binary tree is: 2^h
     * - Cấu trúc của node trong binary tree sẽ bao gồm:
     * - The structure of a node in a binary tree includes:
     * - data: chứa giá trị của node
     * - data: contains the value of the node
     * - left: con trỏ hoặc tham chiếu đến node con bên trái
     * - left: pointer or reference to the left child node
     * - right: con trỏ hoặc tham chiếu đến node con bên phải
     * - right: pointer or reference to the right child node
     * - 1 binary tree thì nó sẽ có những functionality cơ bản như của 1 tree bình thường:
     * - A binary tree has the basic functionality of a normal tree:
     * - Ứng dụng: Binary Tree là binary search tree cho phép chúng ta insert hoặc là search những cái node ở trong cái cây
     * - Application: Binary Search Tree allows us to insert or search nodes in the tree
     * - với độ phức tạp của thuật toán nằm ở mức trung bình đó là O(log n)
     * - with average algorithm complexity of O(log n)
     * - Duyệt cây dựa trên 3: d là (data/node root hiện tại), l là (left), r là (right): DLR, LDR, LRD...
     * - Tree traversal based on 3 elements: d is (data/current root node), l is (left), r is (right): DLR, LDR, LRD...
     * - Traversal LDR (Inorder Traversal): left -> data -> right
     * - Traversal DLR (Preorder Traversal): data -> left -> right
     * - Traversal LRD (Postorder Traversal): left -> right -> data
     * - Nếu level order traversal (BFS) thì ta sẽ duyệt từ trên xuống dưới, từ trái sang phải
     * - For level order traversal (BFS), we traverse from top to bottom, left to right
     */
}
