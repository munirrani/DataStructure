package com.company.Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortTest {

    Integer[] numbers = new Integer[100000];

    public SortTest() {
        Random random = new Random();
        ArrayList<String> sortingNames = new ArrayList<>();
        sortingNames.add("Selection Sort");
        sortingNames.add("Bubble Sort");
        sortingNames.add("Insertion Sort");
        sortingNames.add("Merge Sort");
        sortingNames.add("Quick Sort");

        ArrayList<Integer> timeTaken = new ArrayList<>();
        for(int i = 0; i < 5; i++) timeTaken.add(0);

        long before, after;
        int time;

        System.out.println("Performance Comparison of Sorting Algorithms");
        System.out.println("Running on 1000 sets of 100000 random numbers");
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 100000; b++) numbers[b] = random.nextInt();
            time = timeTaken.get(0);
            before = System.currentTimeMillis();
            new Sort<>(numbers).selectionSort();
            after = System.currentTimeMillis();
            timeTaken.set(0, time + (int)(after-before));

            time = timeTaken.get(1);
            before = System.currentTimeMillis();
            new Sort<>(numbers).bubbleSort();
            after = System.currentTimeMillis();
            timeTaken.set(1, time + (int)(after-before));

            time = timeTaken.get(2);
            before = System.currentTimeMillis();
            new Sort<>(numbers).insertionSort();
            after = System.currentTimeMillis();
            timeTaken.set(2, time + (int)(after-before));

            time = timeTaken.get(3);
            before = System.currentTimeMillis();
            new Sort<>(numbers).mergeSort();
            after = System.currentTimeMillis();
            timeTaken.set(3, time + (int)(after-before));

            time = timeTaken.get(4);
            before = System.currentTimeMillis();
            new Sort<>(numbers).quickSort();
            after = System.currentTimeMillis();
            timeTaken.set(4, time + (int)(after-before));
        }

        for (int i = 0; i < timeTaken.size(); i++) {
            for (int j = 0; j < timeTaken.size(); j++) {
                if (timeTaken.get(i) < timeTaken.get(j)) {
                    Collections.swap(timeTaken, i, j);
                    Collections.swap(sortingNames, i, j);
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(sortingNames.get(i) + " : " + timeTaken.get(i));
        }
        System.out.println("The fastest sorting algo is " + sortingNames.get(0));
    }
}
