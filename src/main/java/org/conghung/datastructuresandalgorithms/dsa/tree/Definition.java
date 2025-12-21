package org.conghung.datastructuresandalgorithms.dsa.tree;

public class Definition {
    /**
     * Định nghĩa về Cây (Tree):
     * Definition of Tree:
     * - Cây là một cấu trúc dữ liệu phi tuyến tính bao gồm các nút (nodes) được tổ chức theo một cấu trúc phân cấp.
     * - A tree is a non-linear data structure consisting of nodes organized in a hierarchical structure.
     * - Tree là một linked list nhưng mà thay vì trong linkedList mỗi node chỉ có 1 pointer là next và mỗi node
     * - A tree is like a linked list, but instead of each node having only one pointer (next) in a linked list
     * - chỉ kết nối với 1 thằng next của nó thôi, thì trong Tree thì mỗi node có thể kết nối đến nhiều node khác nhau
     * - and each node only connecting to one next node, in a tree each node can connect to multiple other nodes.
     * - Ví dụ: Cây gia phả, thì cấu trúc dữ liệu Tree nó được implement thẳng vào trong cây gia phả.
     * - Example: Family tree, the Tree data structure is directly implemented in family trees.
     * - Tương tự như stack và queue, thì Tree cũng là một cấu trúc dữ liệu trừu tượng (Abstract Data Type - ADT).
     * - Similar to stack and queue, Tree is also an Abstract Data Type (ADT).
     * - Và cũng có nhiều loại Tree khác nhau như: Binary Tree, Expression Tree hoặc Splay Tree...
     * - There are many types of trees such as: Binary Tree, Expression Tree, or Splay Tree...
     * - Cho dù nó là cái loại nào đi nữa thì nó vẫn tuân theo các đặc điểm chung của Tree:
     * - Regardless of the type, they all follow the common characteristics of Tree:
     * - Khi làm việc với TreeADT thì cái thứ tự của những node ở trong Tree nó không quan trọng.
     * - When working with Tree ADT, the order of nodes in the tree is not important.
     * - Và muốn nếu có thứ tự ở trong Cấu trúc dữ liệu của mình thì có thể sử dụng: Stack hoặc Queue hoặc LinkedList.
     * - If you need order in your data structure, you can use: Stack, Queue, or LinkedList.
     * - Thành phần của Tree:
     * - Components of Tree:
     * - Root: là rễ của Tree, là node đầu tiên của Tree.
     * - Root: the root of the tree, the first node of the tree.
     * - Edge: là cạnh nối giữa các node với nhau. Liên kết giữa 2 node với nhau.
     * - Edge: the connection between nodes, the link between two nodes.
     * - Leaf: là các nút lá, là các nút không có con.
     * - Leaf: leaf nodes, nodes that have no children.
     * - Sibling: là các nút anh chị em, là các nút có cùng cha.
     * - Sibling: sibling nodes, nodes that share the same parent.
     * - Ancestor: là các nút tổ tiên, là các nút ở trên cùng một nhánh.
     * - Ancestor: ancestor nodes, nodes on the same branch above a given node.
     * - Descendant: là các nút con cháu, là các nút ở dưới cùng một nhánh.
     * - Descendant: descendant nodes, nodes on the same branch below a given node.
     * - Subtree: là cây con, là một phần của Tree bao gồm một nút và tất cả các con của nó.
     * - Subtree: a subtree, a part of the tree consisting of a node and all its descendants.
     * - Level: là cấp độ của nút, được tính từ gốc (root) đến nút đó. Là những node nằm cùng một hàng hoặc 1 lứa.
     * - Level: the level of a node, measured from the root to that node. Nodes at the same level are in the same row or generation.
     * - Depth: là độ sâu của nút, là khoảng cách được tính từ nút đó đến gốc (root).
     * - Depth: the depth of a node, the distance from that node to the root.
     * - Height: là chiều cao của Tree, được tính từ gốc (root) đến nút lá xa nhất, nếu cây chỉ có mỗi root thì height = 0.
     * - Height: the height of the tree, measured from the root to the farthest leaf. If the tree only has a root, height = 0.
     * - size: là kích thước của Tree, được tính bằng số lượng nút trong Tree. Size của 1 node đó chính là tổng số lượng
     * - size: the size of the tree, calculated as the number of nodes in the tree. The size of a node is the total number
     * - của con cháu có thể gọi là descendant của 1 node nào đấy cộng với chính nó.
     * - of descendants of that node plus the node itself.
     * - Skew Tree: Nếu như cây mà mỗi node nó chỉ có 1 descendant hoặc nó chỉ có 1 con thôi thì gọi là Skew Tree.
     * - Skew Tree: If a tree where each node has only one descendant or only one child, it is called a Skew Tree.
     * - Nếu ta xét về hướng của node con. Nếu như skew tree mà tất cả các node con của nó chỉ có con ở phía bên phải thôi thì chúng ta sẽ gọi là Right Skew Tree.
     * - Considering the direction of child nodes: If a skew tree where all child nodes only have children on the right side, it is called a Right Skew Tree.
     * - Còn nếu như tất cả các node con của nó chỉ có con ở phía bên trái thôi thì chúng ta sẽ gọi là Left Skew Tree.
     * - If all child nodes only have children on the left side, it is called a Left Skew Tree.
     */

}
