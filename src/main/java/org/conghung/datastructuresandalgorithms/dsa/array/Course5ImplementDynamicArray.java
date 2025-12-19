package org.conghung.datastructuresandalgorithms.dsa.array;

import java.util.Iterator;

public class Course5ImplementDynamicArray<T> implements Iterable<T> {
    /*
    - Requirements:
    - Trong Java thì chúng ta có ArrayList là 1 dynamic array.
    1. Implement a dynamic array that can grow and shrink in size as elements are added or removed.
    2. Nếu số lượng elements vượt quá kích thước hiện tại của mảng, thì mảng sẽ tự động tăng kích thước (thường là gấp đôi).
    3. Nếu số lượng elements giảm xuống dưới một ngưỡng nhất định (ví dụ: 1/4 kích thước hiện tại), thì mảng sẽ tự động giảm kích thước (thường là giảm một nửa).
    4. Trong Dynamic Array chúng ta sẽ có 1 cái static array và có 1 size cố dịnh khi ta new Dynamic Array.
    mà chúng ta khổng bỏ 1 list hoặc cái size nào đó cho Dynamic Array đó thì nó sẽ tự động add size nào đó default vào trong static array
    ở bên trong dynamic array đó.
    5. capacity: kích thước hiện tại của mảng. sức chứa hiện tại của mảng.

     */

    private T[] array;
    private int capacity = 0; // length of array
    private int size = 0; // number of elements in array

    public Course5ImplementDynamicArray() {
        // VI: Constructor mặc định, khởi tạo capacity = 10 và cấp phát mảng bên trong
        // EN: Default constructor, initializes capacity = 10 and allocates internal array
        this(10);
    }

    public Course5ImplementDynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative" + capacity);
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds " + index);
        }
        return array[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds " + index);
        }
        array[index] = value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void add(T value) {
        if (size >= capacity - 1) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = value;
    }

    public void removeAt(int removeIndex) {
        if (removeIndex <= 0 || removeIndex >= size)
            throw new IndexOutOfBoundsException("Index out of bounds " + removeIndex);
        T[] newArray = (T[]) new Object[size - 1];
        for (int oldArrayIndex = 0, newArrayIndex = 0; oldArrayIndex < size; oldArrayIndex++, newArrayIndex++) {
            if (oldArrayIndex == removeIndex) newArrayIndex--;
            else newArray[newArrayIndex] = array[oldArrayIndex];
        }
        array = newArray;
        capacity = --size;
    }

    public T removeAtWithoutMoving(int removeIndex) {
        if (removeIndex >= size || removeIndex < 0) throw new IndexOutOfBoundsException();
        T item = array[removeIndex];
        array[removeIndex] = null;
        capacity = --size;
        return item;
    }

    public void remove(Object object) {
        int removeIndex = indexOf(object);
        removeAt(removeIndex);
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (array[i] == null) return i;
            } else {
                if (object.equals(array[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;


            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Course5ImplementDynamicArray<String> dynamicArray = new Course5ImplementDynamicArray<>();
//        dynamicArray.add("C");
//        dynamicArray.add("O");
//        dynamicArray.add("N");
//        dynamicArray.add("G");
//        dynamicArray.add("H");
//        dynamicArray.add("U");
//        dynamicArray.add("N");
//        dynamicArray.add("G");
//
//        System.out.println(dynamicArray.toString());
//        System.out.println(dynamicArray.get(2));
//        System.out.println(dynamicArray.indexOf("H"));
//        dynamicArray.removeAt(4);
//        System.out.println(dynamicArray.toString());

        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());
        dynamicArray.add("0");
        System.out.println(dynamicArray.size());

    }
}
