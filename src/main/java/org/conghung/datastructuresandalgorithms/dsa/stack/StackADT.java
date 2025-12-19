package org.conghung.datastructuresandalgorithms.dsa.stack;

public interface StackADT<T> extends Iterable<T> {
    void push(T element);
    T pop();
    T top();
    boolean isEmpty();
    int size();
}
