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
        sortingNames.add("Heap Sort");

        ArrayList<Integer> timeTaken = new ArrayList<>();
        for(int i = 0; i < sortingNames.size(); i++) timeTaken.add(0);

        long before, after;
        int time;

        System.out.println("Performance Comparison of Sorting Algorithms");
        System.out.println("Running on 1000 sets of 100000 random numbers");
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 100000; b++) numbers[b] = random.nextInt();
            for (int i = 0; i < sortingNames.size(); i++) {
                time = timeTaken.get(i);
                before = System.currentTimeMillis();
                new Sort<>(numbers).sort(i);
                after = System.currentTimeMillis();
                timeTaken.set(i, time + (int)(after - before));
            }
        }

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
}
