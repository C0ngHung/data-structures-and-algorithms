package org.conghung.datastructuresandalgorithms.dsa.tree;
// Khai báo package chứa class này

import org.conghung.datastructuresandalgorithms.dsa.queue.LinkedListBasedQueue;
import org.conghung.datastructuresandalgorithms.dsa.queue.QueueADT;
import org.conghung.datastructuresandalgorithms.dsa.stack.LinkedListBasedStack;
import org.conghung.datastructuresandalgorithms.dsa.stack.StackADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Binary Search Tree (BST) implementation.
 * Cài đặt Cây Nhị Phân Tìm Kiếm (Binary Search Tree - BST).
 * This class provides standard BST operations and various traversal methods.
 * Class này cung cấp các thao tác chuẩn của BST và các phương pháp duyệt cây khác nhau.
 *
 * @param <T> the type of elements in this tree, must be Comparable
 *            kiểu dữ liệu trong cây, phải so sánh được (implement Comparable) để sắp xếp
 */
public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    // Khai báo class BinarySearchTree thực thi interface TreeADT.
    // T extends Comparable<T> nghĩa là dữ liệu T phải so sánh được (lớn hơn/nhỏ hơn) để sắp xếp trong cây.

    private int nodeCount = 0;
    // Biến đếm tổng số node hiện có trong cây, ban đầu là 0.
    private Node<T> root = null;
    // Node gốc (root) của cây, ban đầu chưa có gì nên là null.

    @Override
    public boolean isEmpty() {
        // Hàm kiểm tra cây có rỗng hay không
        return size() == 0;
        // Trả về true nếu kích thước (số node) bằng 0.
    }

    @Override
    public int size() {
        // Hàm lấy kích thước (số lượng phần tử) của cây
        return nodeCount;
        // Trả về giá trị của biến nodeCount.
    }

    @Override
    public int height() {
        // Hàm tính chiều cao của cây
        return height(root);
        // Gọi hàm hỗ trợ height(Node node) bắt đầu tính từ gốc (root).
    }

    @Override
    public boolean contains(T element) {
        // Hàm kiểm tra xem một phần tử có tồn tại trong cây không
        return contains(root, element);
        // Gọi hàm hỗ trợ contains(Node node, T element) bắt đầu tìm từ gốc.
    }

    @Override
    public boolean add(T element) {
        // Hàm thêm một phần tử mới vào cây
        if (contains(element)) return false;
        // Nếu phần tử đã tồn tại rồi thì không thêm nữa (tránh trùng lặp), trả về false.
        
        root = add(root, element);
        // Gọi hàm hỗ trợ add(Node node, T element) để thêm vào và cập nhật lại node gốc (nếu cần).
        
        nodeCount++;
        // Tăng số lượng node lên 1.
        
        return true;
        // Trả về true báo hiệu đã thêm thành công.
    }

    @Override
    public boolean remove(T element) {
        // Hàm xóa một phần tử khỏi cây
        if (!contains(element)) return false;
        // Nếu phần tử không có trong cây thì không xóa được, trả về false.
        
        root = remove(root, element);
        // Gọi hàm hỗ trợ remove(Node node, T element) để xóa và cập nhật lại cấu trúc cây.
        
        nodeCount--;
        // Giảm số lượng node đi 1.
        
        return true;
        // Trả về true báo hiệu đã xóa thành công.
    }

    @Override
    public Iterator<T> iterator(TreeTraverseType type) {
        // Hàm trả về bộ duyệt (Iterator) tùy theo kiểu duyệt (PRE_ORDER, IN_ORDER, v.v.)
        return switch (type) {
            // Dùng cấu trúc switch để chọn logic dựa trên type truyền vào
            case PRE_ORDER -> preOrderTraverse();
            // Nếu là Tiền thứ tự (Pre-order) -> gọi hàm preOrderTraverse().
            case IN_ORDER -> inOrderTraverse();
            // Nếu là Trung thứ tự (In-order) -> gọi hàm inOrderTraverse().
            case POST_ORDER -> postOrderTraverse();
            // Nếu là Hậu thứ tự (Post-order) -> gọi hàm postOrderTraverse().
            case LEVEL_ORDER -> levelOrderTraverse();
            // Nếu là Theo cấp độ (Level-order) -> gọi hàm levelOrderTraverse().
            default -> throw new IllegalArgumentException("Unsupported traversal type: " + type);
            // Nếu kiểu duyệt không hợp lệ -> ném lỗi.
        };
    }

    /**
     * Returns an iterator for Level-Order traversal (Breadth-First Search).
     * Trả về iterator duyệt theo cấp độ (Duyệt chiều rộng - BFS).
     *
     * @return an iterator for level-order traversal
     */
    private Iterator<T> levelOrderTraverse() {
        final int expectedNodeCount = nodeCount;
        // Lưu lại số lượng node hiện tại để kiểm tra tính toàn vẹn dữ liệu khi duyệt.
        
        QueueADT<Node<T>> queue = new LinkedListBasedQueue<>();
        // Tạo một hàng đợi (Queue) để lưu các node cần duyệt.
        
        if (root != null) {
            queue.enqueue(root);
            // Nếu cây không rỗng, đưa node gốc (root) vào hàng đợi đầu tiên.
        }

        return new Iterator<T>() {
            // Tạo một đối tượng Iterator ẩn danh
            @Override
            public boolean hasNext() {
                // Kiểm tra xem còn phần tử để duyệt không
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Nếu số lượng node bị thay đổi trong lúc duyệt -> báo lỗi.
                
                return !queue.isEmptyQueue();
                // Còn phần tử nếu hàng đợi chưa rỗng.
            }

            @Override
            public T next() {
                // Lấy phần tử tiếp theo
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra lại xem cây có bị thay đổi không.
                
                if (!hasNext()) throw new NoSuchElementException();
                // Nếu không còn phần tử nào -> ném lỗi.

                Node<T> node = queue.dequeue();
                // Lấy node đầu tiên ra khỏi hàng đợi.
                
                if (node.getLeft() != null) queue.enqueue(node.getLeft());
                // Nếu có con trái, đưa con trái vào hàng đợi (để duyệt sau).
                
                if (node.getRight() != null) queue.enqueue(node.getRight());
                // Nếu có con phải, đưa con phải vào hàng đợi.
                
                return node.getData();
                // Trả về dữ liệu của node vừa lấy ra.
            }
        };
    }

    /**
     * Returns an iterator for Post-Order traversal (Left -> Right -> Root).
     * Trả về iterator duyệt Hậu thứ tự (Trái -> Phải -> Gốc).
     *
     * @return an iterator for post-order traversal
     */
    private Iterator<T> postOrderTraverse() {
        final int expectedNodeCount = nodeCount;
        // Lưu trạng thái số lượng node để kiểm tra đồng bộ.
        
        StackADT<Node<T>> stack = new LinkedListBasedStack<>();
        // Tạo ngăn xếp (Stack) để hỗ trợ duyệt DFS (Deep First Search) theo kiểu Hậu thứ tự.
        
        return new Iterator<T>() {
            Node<T> current = root;
            // Biến con trỏ hiện tại, bắt đầu từ root.
            Node<T> lastVisited = null;
            // Biến lưu node vừa mới được duyệt (để biết đường quay lui).

            @Override
            public boolean hasNext() {
                // Kiểm tra còn phần tử để duyệt không
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ dữ liệu.
                
                return !stack.isEmpty() || current != null;
                // Còn tiếp tục nếu stack còn phần tử HOẶC con trỏ hiện tại chưa null.
            }

            @Override
            public T next() {
                // Lấy phần tử tiếp theo
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ.
                
                if (!hasNext()) throw new NoSuchElementException();
                // Nếu hết phần tử -> ném lỗi.

                while (!stack.isEmpty() || current != null) {
                    // Vòng lặp tìm node tiếp theo để trả về
                    
                    if (current != null) {
                        // Nếu con trỏ hiện tại còn trỏ vào node
                        stack.push(current);
                        // Đẩy node này vào stack (để lát nữa quay lại xử lý).
                        current = current.getLeft();
                        // Di chuyển sang con trái (ưu tiên duyệt trái trước).
                    } else {
                        // Nếu không thể đi sang trái được nữa (current == null)
                        Node<T> peekNode = stack.top();
                        // Xem node đang nằm trên đỉnh stack.
                        
                        if (peekNode.getRight() != null && lastVisited != peekNode.getRight()) {
                            // Nếu node đỉnh stack có con phải VÀ con phải đó chưa được duyệt
                            current = peekNode.getRight();
                            // Chuyển sang duyệt nhánh bên phải.
                        } else {
                            // Nếu không có con phải HOẶC con phải đã duyệt rồi -> Đến lượt duyệt chính node này (Gốc).
                            lastVisited = stack.pop();
                            // Lấy node ra khỏi stack và đánh dấu là đã duyệt (lastVisited).
                            return lastVisited.getData();
                            // Trả về dữ liệu của node này.
                        }
                    }
                }
                throw new NoSuchElementException();
                // Nếu thoát vòng lặp mà không trả về được gì -> ném lỗi.
            }
        };
    }

    /**
     * Returns an iterator for In-Order traversal (Left -> Root -> Right).
     * Trả về iterator duyệt Trung thứ tự (Trái -> Gốc -> Phải).
     * Thứ tự này giúp duyệt các phần tử từ nhỏ đến lớn trong BST.
     *
     * @return an iterator for in-order traversal
     */
    private Iterator<T> inOrderTraverse() {
        final int expectedNodeCount = nodeCount;
        // Lưu trạng thái số lượng node.
        
        StackADT<Node<T>> stack = new LinkedListBasedStack<>();
        // Tạo stack hỗ trợ duyệt.
        
        return new Iterator<T>() {
            Node<T> traverse = root;
            // Con trỏ dùng để duyệt, bắt đầu từ root.

            @Override
            public boolean hasNext() {
                // Kiểm tra còn phần tử
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ.
                
                return !stack.isEmpty() || traverse != null;
                // Còn nếu stack không rỗng HOẶC con trỏ chưa null.
            }

            @Override
            public T next() {
                // Lấy phần tử tiếp theo
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ.
                
                if (!hasNext()) throw new NoSuchElementException();
                // Hết phần tử -> báo lỗi.

                while (traverse != null) {
                    // Đi sang trái sâu nhất có thể
                    stack.push(traverse);
                    // Lưu node vào stack.
                    traverse = traverse.getLeft();
                    // Nhảy sang con trái.
                }

                Node<T> node = stack.pop();
                // Lấy node ra khỏi stack (đây là node trái nhất chưa duyệt - bước 'Trái' xong đến 'Gốc').
                
                traverse = node.getRight();
                // Sau khi xử lý node này, chuẩn bị chuyển sang nhánh phải của nó.
                
                return node.getData();
                // Trả về dữ liệu.
            }
        };
    }

    /**
     * Returns an iterator for Pre-Order traversal (Root -> Left -> Right).
     * Trả về iterator duyệt Tiền thứ tự (Gốc -> Trái -> Phải).
     *
     * @return an iterator for pre-order traversal
     */
    private Iterator<T> preOrderTraverse() {
        final int expectedNodeCount = nodeCount;
        // Lưu trạng thái số lượng node.
        
        StackADT<Node<T>> stack = new LinkedListBasedStack<>();
        // Tạo stack hỗ trợ duyệt.
        
        if (root != null) {
            stack.push(root);
            // Nếu cây không rỗng, đẩy root vào stack đầu tiên.
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                // Kiểm tra còn phần tử
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ.
                
                return !stack.isEmpty();
                // Còn nếu stack chưa rỗng.
            }

            @Override
            public T next() {
                // Lấy phần tử tiếp theo
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                // Kiểm tra đồng bộ.
                
                if (!hasNext()) throw new NoSuchElementException();
                // Hết phần tử -> báo lỗi.

                Node<T> node = stack.pop();
                // Lấy node trên đỉnh stack ra (xử lý 'Gốc' trước).
                
                if (node.getRight() != null) stack.push(node.getRight());
                // Đẩy con phải vào stack trước (vì stack là LIFO - vào sau ra trước, nên phải đẩy Phải trước để Trái được lấy ra trước).
                
                if (node.getLeft() != null) stack.push(node.getLeft());
                // Đẩy con trái vào stack sau (để nó nằm trên đỉnh và được lấy ra xử lý tiếp theo).
                
                return node.getData();
                // Trả về dữ liệu.
            }
        };
    }

    // PRIVATE HELPER METHODS - CÁC HÀM HỖ TRỢ (RIÊNG TƯ)

    private int height(Node<T> node) {
        // Hàm đệ quy tính chiều cao cây từ một node cho trước
        if (node == null) return 0;
        // Nếu node là null (cây con rỗng), chiều cao là 0.
        
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        // Chiều cao = 1 (node hiện tại) + max(chiều cao cây con trái, chiều cao cây con phải).
    }

    private boolean contains(Node<T> node, T element) {
        // Hàm đệ quy tìm kiếm phần tử
        if (node == null) return false;
        // Nếu đi đến cuối nhánh (null) mà chưa thấy -> không tìm thấy, trả về false.

        int result = element.compareTo(node.getData());
        // So sánh phần tử cần tìm với node hiện tại.

        if (result < 0) return contains(node.getLeft(), element);
        // Nếu nhỏ hơn (< 0) -> tìm tiếp bên trái (vì BST bên trái luôn nhỏ hơn).
        
        else if (result > 0) return contains(node.getRight(), element);
        // Nếu lớn hơn (> 0) -> tìm tiếp bên phải.
        
        else return true;
        // Nếu bằng nhau (0) -> đã tìm thấy, trả về true.
    }

    private Node<T> add(Node<T> node, T element) {
        // Hàm đệ quy thêm phần tử vào cây
        if (node == null) {
            // Nếu vị trí này đang trống (null)
            return new Node<>(element, null, null);
            // Tạo một node mới chứa element và trả về node đó để gắn vào cây.
        }
        
        if (element.compareTo(node.getData()) > 0) {
            // Nếu phần tử cần thêm lớn hơn node hiện tại
            node.setRight(add(node.getRight(), element));
            // Đệ quy thêm vào bên phải và cập nhật lại liên kết phải.
        } else {
            // Nếu phần tử cần thêm nhỏ hơn node hiện tại
            node.setLeft(add(node.getLeft(), element));
            // Đệ quy thêm vào bên trái và cập nhật lại liên kết trái.
        }
        return node;
        // Trả về node hiện tại sau khi (có thể) đã cập nhật con.
    }

    private Node<T> remove(Node<T> node, T element) {
        // Hàm đệ quy xóa phần tử khỏi cây
        if (node == null) return null;
        // Nếu node null (không tìm thấy phần tử để xóa) -> trả về null.

        int result = element.compareTo(node.getData());
        // So sánh phần tử cần xóa với node hiện tại.

        if (result > 0) {
            // Nếu lớn hơn -> tìm xóa bên phải.
            node.setRight(remove(node.getRight(), element));
        } else if (result < 0) {
            // Nếu nhỏ hơn -> tìm xóa bên trái.
            node.setLeft(remove(node.getLeft(), element));
        } else {
            // Nếu bằng nhau -> Đã tìm thấy node cần xóa!
            
            if (node.getLeft() == null) {
                // Trường hợp 1 & 2: Node chỉ có con phải hoặc không có con nào.
                return node.getRight();
                // Trả về con phải để thay thế vị trí node hiện tại (nếu con phải null -> trả về null cũng đúng).
            } else if (node.getRight() == null) {
                // Trường hợp 2: Node chỉ có con trái.
                return node.getLeft();
                // Trả về con trái để thay thế.
            } else {
                // Trường hợp 3: Node có đủ 2 con.
                
                T temp = minRight(node.getRight());
                // Tìm giá trị nhỏ nhất bên nhánh phải (người thừa kế - successor) để thay thế.
                
                node.setData(temp);
                // Gán giá trị đó vào node hiện tại (thay vì xóa node này, ta thay ruột nó).
                
                node.setRight(remove(node.getRight(), temp));
                // Sau đó xóa node thừa kế kia đi (nó nằm ở nhánh phải).
            }
        }
        return node;
        // Trả về node (đã được cập nhật cấu trúc) cho lớp cha.
    }

    private T minRight(Node<T> node) {
        // Tìm giá trị nhỏ nhất của một nhánh (đi tận cùng về bên trái)
        while (node.getLeft() != null) node = node.getLeft();
        // Cứ đi sang trái cho đến khi hết đường.
        return node.getData();
        // Trả về dữ liệu nhỏ nhất đó.
    }

    private T maxLeft(Node<T> node) {
        // Tìm giá trị lớn nhất của một nhánh (đi tận cùng về bên phải) - Hàm này chưa được dùng trong code trên nhưng để dự phòng.
        while (node.getRight() != null) node = node.getRight();
        // Cứ đi sang phải cho đến khi hết đường.
        return node.getData();
        // Trả về dữ liệu lớn nhất đó.
    }
}
