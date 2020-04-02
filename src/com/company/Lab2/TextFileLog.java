package com.company.Lab2;

public class TextFileLog<T extends Comparable<T>> implements SimpleLog<T> {

    public T[] log;
    private int index, maxsize;

    public TextFileLog(int maxsize) {
        index = -1;
        this.maxsize = maxsize;
        log = (T[]) new Comparable[maxsize];
        System.out.println("Text File Log Size " + maxsize);
    }

    @Override
    public void insert(T t) {
        if (!isFull()) {
            index++;
            log[index] = t;
            System.out.println(t);
        } else {
            System.out.println("The log is full");
        }
    }

    @Override
    public boolean isFull() {
        return maxsize == index + 1;
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean search(T t) {
        System.out.println("Searching for " + t + " in the file");
        for (int i = 0; i <= index; i++) {
            if (log[i].equals(t)) {
                System.out.println("Text File Log contains " + t);
                return true;
            }
        }
        return  false;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= index; i++) {
            log[i] = (T) null;
        }
        index = -1;
        System.out.println("Clear the text file log");
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= index; i++) {
            str += log[i] + " ";
        }
        return str;
    }
}
