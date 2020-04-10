package com.company.Tutorial6;

public class ArrayQueue<T> {

    private T[] arr;
    public static int MAX_SIZE = 10;
    int front = -1, back = -1;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) {
        MAX_SIZE = size;
        arr = (T[]) new Object[MAX_SIZE];
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return getSize() == MAX_SIZE;
    }

    public int getSize() {
        if (front == -1) return 0;
        if (back >= front) {
            return back - front + 1;
        } else {
            return (MAX_SIZE - front) + (back + 1);
        }
    }

    public void enqueue(T data) {
        if ((front == 0 && back == MAX_SIZE - 1) || back == front - 1) {
            System.out.println("Queue is full");
        } else if (back == MAX_SIZE - 1 && front != 0) {
            back = 0;
            arr[back] = data;
        } else if (front == -1 && back == -1) { //start
            back = front = 0;
            arr[back] = data;
        } else {
            back++;
            arr[back] = data;
        }
    }

    public T dequeue() {
        if (front == -1) return null;
        T data = arr[front];
        arr[front] = null;
        if (front == back) { // Restart
            front = back = -1;
        } else if (front == MAX_SIZE - 1) {
            front = 0;
        } else {
            front++;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) return null;
        return arr[front];
    }

    public void showQueue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
        } else if (back >= front) {
            for (int i = front; i <= back; i++) {
                System.out.print(arr[i] + " --> ");
            }
        } else {
            for (int i = front; i < MAX_SIZE; i++) {
                System.out.print(arr[i] + " --> ");
            }
            for (int i = 0; i <= back; i++) {
                System.out.print(arr[i] + " --> ");
            }
        }
        System.out.println();
    }
}
