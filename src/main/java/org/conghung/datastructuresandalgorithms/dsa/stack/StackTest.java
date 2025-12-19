package org.conghung.datastructuresandalgorithms.dsa.stack;

public class StackTest {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;

        // Test ArrayBasedStack
        StackADT<Integer> arrayBasedStack = new ArrayBasedStack<>(10);

        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfOperations; i++) {
            arrayBasedStack.push(i);
        }

        for (int i = 0; i < numberOfOperations; i++) {
            arrayBasedStack.pop();
        }

        long endTime = System.nanoTime();
        System.out.println("ArrayBasedStack time: " + (endTime - startTime) + "\n");

        // Test LinkedListBasedStack
        StackADT<Integer> linkedListBasedStack = new LinkedListBasedStack<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("LinkedListBasedStack time: " + (endTime - startTime) + "\n");
    }
}
