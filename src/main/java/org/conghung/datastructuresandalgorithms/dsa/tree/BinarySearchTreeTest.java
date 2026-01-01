package org.conghung.datastructuresandalgorithms.dsa.tree;

import java.util.Iterator;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        TreeADT<Integer> bst = new BinarySearchTree<>();

        bst.add(5);
        bst.add(4);
        bst.add(6);
        bst.add(7);
        bst.add(3);
        bst.add(2);
        bst.add(10);

        Iterator traverser = bst.iterator(TreeTraverseType.IN_ORDER);

        while (traverser.hasNext()) {
            System.out.print(traverser.next() + " ");
        }

        System.out.println(bst.height());
        System.out.println(bst.contains(10));
        System.out.println(bst.contains(19));
    }
}
