package org.conghung.datastructuresandalgorithms.dsa.queue;

public class QueueTest {
    public static void main(String[] args) {
        int numberOfOperations = 100000000;

        // Test Array-Based Queue
        QueueADT<Integer> circularArrayQueue = new CircularArrayBasedQueue<>(numberOfOperations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfOperations; i++) {
            circularArrayQueue.enqueue(i);
        }
        for (int i = 0; i < numberOfOperations / 2; i++) {
            circularArrayQueue.dequeue();
        }

        for (int i = 0; i < numberOfOperations / 4; i++) {
            circularArrayQueue.enqueue(i);
        }
        for (int i = 0; i < 3 * numberOfOperations / 4; i++) {
            circularArrayQueue.dequeue();
        }

        // O(n) = 2,5n
        long endTime = System.currentTimeMillis();
        long arrayEndTime = endTime - startTime;
        System.out.println("Circular Array-Based Queue Took Time: " + arrayEndTime + " ms" + "\n");


        // Test Linked List-Based Queue

        QueueADT<Integer> linkedListBasedQueue = new LinkedListBasedQueue<>();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.enqueue(i);
        }
        for (int i = 0; i < numberOfOperations / 2; i++) {
            linkedListBasedQueue.dequeue();
        }

        // O(n) = 2n
        endTime = System.currentTimeMillis();
        long linkedListEndTime = endTime - startTime;
        System.out.println("Linked List-Based Queue Took Time: " + linkedListEndTime + " ms" + "\n");

        System.out.println("The difference: " + (linkedListEndTime - arrayEndTime) + " ms" + "\n");
    }

}
