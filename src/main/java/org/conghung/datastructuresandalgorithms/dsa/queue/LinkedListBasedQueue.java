package org.conghung.datastructuresandalgorithms.dsa.queue;

import org.conghung.datastructuresandalgorithms.dsa.linkedlist.Course8LinkedListPart3Code;
import org.conghung.datastructuresandalgorithms.dsa.linkedlist.DoublyLinkedList;

import java.util.Iterator;

public class LinkedListBasedQueue<T> implements QueueADT<T> {

   private final DoublyLinkedList<T> linkedList = new Course8LinkedListPart3Code<>();


    public LinkedListBasedQueue(DoublyLinkedList<T> linkedList) {
    }
    public LinkedListBasedQueue() {
    }

    public LinkedListBasedQueue(T firstElement) {
        enqueue(firstElement);
    }

    @Override
    public void enqueue(T element) {linkedList.addLast(element);}

    @Override
    public T dequeue() {
        if (isEmptyQueue()) throw new RuntimeException("Queue is empty!");
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmptyQueue()) throw new RuntimeException("Queue is empty!");
        return linkedList.peekFirst();
    }

    @Override
    public int size() { return linkedList.size(); }

    @Override
    public boolean isEmptyQueue() { return linkedList.isEmpty(); }

    @Override
    public Iterator<T> iterator() { return linkedList.iterator(); }
}
