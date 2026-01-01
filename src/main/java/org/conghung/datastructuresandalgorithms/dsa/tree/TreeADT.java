package org.conghung.datastructuresandalgorithms.dsa.tree;

import java.util.Iterator;

// T là kiểu dữ liệu có thể compare được với nhau
// T is a data type that can be compared with each other
public interface TreeADT<T extends Comparable<T>> {

    boolean isEmpty();

    int size();

    int height();

    boolean contains(T element);

    boolean add(T element);

    boolean remove(T element);

    Iterator<T> iterator(TreeTraverseType type);
}
