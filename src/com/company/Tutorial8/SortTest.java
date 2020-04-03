package com.company.Tutorial8;

public class SortTest<T extends Comparable<T>> {

    T[] arr;
    Sort<T> sort;

    public SortTest(T t[]) {
        arr = (T[]) new Comparable[t.length];
        for (int i = 0; i < t.length; i++) {
            arr[i] = t[i];
        }
        sort = new Sort(arr);
    }

    public void sort(int sortType, int order) {
        sort.sort(sortType, order);
    }

    public void printArray() {
        sort.printArray();
    }
}
