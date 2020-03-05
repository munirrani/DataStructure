package com.company;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class L2Q1<T extends Comparable> {

    private T[] arr;
    private LinkedList<T> linkedList;
    private int N;
    int index; // for array
    int bound;

    public L2Q1(int N, int bound) {
        index = -1;
        this.N = N;
        this.bound = bound;
        linkedList = new LinkedList<>();
        arr = (T[]) new Comparable[N];
    }

    public void start() {
        generate();
        sortLinkedList();
        sortArray();
        System.out.println("Generating " + N + " non-duplicate integer within 0-100");
        display();
    }

    public void generate() {
        Random random = new Random();
        Integer x;
        while (linkedListSize() != N) {
            x = random.nextInt(101);
            insertLinkedList((T) x);
        }
        while (arraySize() != N) {
            x = random.nextInt(101);
            insertArray((T) x);
        }
    }

    public void insertLinkedList(T t) {
        if (!linkedListIsFull()) {
            if (!linkedList.contains(t)) linkedList.add(t);
        } else {
            System.out.println("Linked List is full");
        }
    }

    private boolean arrayContains(T t) { ;
        for (int i = 0; i < index + 1; i++) {
            if (arr[i].equals(t)) return true;
        }
        return false;
    }

    public void insertArray(T t) {
        if (!arrayIsFull()) {
            if (!arrayContains(t)) {
                index++;
                arr[index] = t;
                //System.out.print(index + " ");
            }
        } else {
            System.out.println("Array is full");
        }
    }

    public void display() {
        System.out.println("Linked list implementation");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();

        System.out.println("Array Implementation");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sortLinkedList() {
        Collections.sort(linkedList);
    }

    public void sortArray() {
        int firstNumber, secondNumber;
        T temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j != arr.length - 1) {
                    firstNumber = (int) arr[j];
                    secondNumber = (int) arr[j + 1];
                    if (firstNumber > secondNumber) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    public boolean arrayIsFull() {
        return N == index + 1; //starts at -1 initially
    }

    public int arraySize() {
        return index + 1;
    }

    public boolean linkedListIsFull() {
        return N == linkedList.size();
    }

    public int linkedListSize() {
        return linkedList.size();
    }
}
