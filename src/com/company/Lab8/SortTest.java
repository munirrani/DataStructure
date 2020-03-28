package com.company.Lab8;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest<T extends Comparable<T>> {

    ArrayList<String> sortingNames = new ArrayList<>();
    ArrayList<Integer> timeTaken = new ArrayList<>();

    long before, after;
    int time;

    public SortTest() {
        sortingNames.add("Selection Sort");
        sortingNames.add("Bubble Sort");
        sortingNames.add("Insertion Sort");
        sortingNames.add("Merge Sort");
        sortingNames.add("Quick Sort");
        sortingNames.add("Heap Sort");
        for(int i = 0; i < sortingNames.size(); i++) timeTaken.add(0);
    }

    public void displayResult() {
        for (int i = 0; i < timeTaken.size(); i++) {
            for (int j = 0; j < timeTaken.size(); j++) {
                if (timeTaken.get(i) < timeTaken.get(j)) {
                    Collections.swap(timeTaken, i, j);
                    Collections.swap(sortingNames, i, j);
                }
            }
        }

        for (int i = 0; i < sortingNames.size(); i++) {
            System.out.println(sortingNames.get(i) + " : " + timeTaken.get(i));
        }
        System.out.println("The fastest sorting algo is " + sortingNames.get(0));
    }

    public void test(T[] arr) {
        for (int i = 0; i < sortingNames.size(); i++) {
            time = timeTaken.get(i);
            before = System.currentTimeMillis();
            new Sort(arr).sort(i);
            after = System.currentTimeMillis();
            timeTaken.set(i, time + (int)(after - before));
        }
    }

    public boolean findElement(T t, T[][] arrr) {
        for (T[] arr : arrr) for (T ar : arr) if (ar.compareTo(t) == 0) return true;
        return false;
    }

    public int findOccurence(T t, T[][] arrr) {
        int count = 0;
        for (T[] arr : arrr) for (T ar : arr) if (ar.compareTo(t) == 0) count++;
        return count;
    }

    public String findLocation(T value, T[][] arrr) {
        String str = "";
        for (int i = 0; i < arrr.length; i++) for (int j = 0; j < arrr[i].length; j++) if (value.compareTo(arrr[i][j]) == 0) str += "[" + i + "," + j + "]";
        return str;
    }
}
