package org.conghung.datastructuresandalgorithms.dsa.stack;

import org.conghung.datastructuresandalgorithms.dsa.linkedlist.Course8LinkedListPart3Code;
import org.conghung.datastructuresandalgorithms.dsa.linkedlist.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListBasedStack<T> implements StackADT<T>{
    private final DoublyLinkedList<T> list = new Course8LinkedListPart3Code<>();
    public LinkedListBasedStack() {}


    public LinkedListBasedStack(T element) {
        push(element);
    }


    @Override
    public void push(T element) {
        list.addLast(element);
    }

    @Override
    public T pop() {
        if (isEmpty())throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T top() {
        if (isEmpty())throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
