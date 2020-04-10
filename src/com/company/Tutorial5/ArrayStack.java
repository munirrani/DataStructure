package com.company.Tutorial5;

public class ArrayStack<T> {

    private T[] arr;
    public static final int MAX_SIZE = 10;
    private int currentIndex = -1;

    public ArrayStack() {
        arr = (T[]) new Object[MAX_SIZE];
    }

    public boolean isEmpty() {
        return getSize() == -1;
    }

    public boolean isFull() {
        return getSize() == MAX_SIZE - 1;
    }

    public int getSize() {
        return currentIndex + 1;
    }

    public void push(T data) {
        currentIndex++;
        arr[currentIndex] = data;
    }

    public T pop() {
        T data = arr[currentIndex];
        arr[currentIndex] = null;
        currentIndex--;
        return data;
    }

    public T peek() {
        return arr[currentIndex];
    }

    public void showStack() {
        for (int i = currentIndex; i >= 0; i--) {
            System.out.print(" <-- " + arr[i]);
        }
        System.out.println();
    }
}
