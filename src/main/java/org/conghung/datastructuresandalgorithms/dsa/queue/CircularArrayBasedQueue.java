package org.conghung.datastructuresandalgorithms.dsa.queue;

import java.util.Iterator;

public class CircularArrayBasedQueue<T> implements QueueADT<T> {
    private T[] array;
    private int front;
    private int end;
    private final int size;

    public CircularArrayBasedQueue(int maxSize){
        front = end = 0;
        size = maxSize + 1;
        array = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T element) {
        array[end] = element;
        if(++end == size) end = 0;
        if (front == end) throw new RuntimeException("Queue is full!");
    }

    @Override
    public T dequeue() {
        if (isEmptyQueue()) throw new RuntimeException("Queue is empty!");
        T dequeuedElement = array[front];
        if (++front == size) front = 0;
        return dequeuedElement;
    }

    @Override
    public T peek() {
        if (isEmptyQueue()) throw new RuntimeException("Queue is empty!");
        return array[front];
    }

    @Override
    public int size() {
        if (front > end) return (end + size - front);
        return end - front;
    }

    @Override
    public boolean isEmptyQueue() { return (front == end); }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
