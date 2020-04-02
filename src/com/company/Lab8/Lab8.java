package com.company.Lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab8 {

    public Lab8() {
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N Special Random Number within 0-100: ");
        int N = scanner.nextInt();
        scanner.nextLine();
        System.out.print("The Special Number are : ");
        Integer[] values = new Integer[N];
        int num;
        for (int i = 0; i < N; i++) {
            num = random.nextInt(101);
            values[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();
        Sort<Integer> integerSort = new Sort(values);
        integerSort.mergeSort();
        System.out.print("After Merge Sort : ");
        integerSort.printArray();
    }

    private void Q2() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("lab8Q2.txt")));
            String line;
            System.out.println("Reading data from product text file");
            ArrayList<String> arrayList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                line = line.replaceAll(",", " : ");
                arrayList.add(line);
                System.out.println(line);
            }
            System.out.println("After Quick Sort (Price, PID) :");
            String[] lines = arrayList.toArray(new String[arrayList.size()]);
            Sort<String> productSort = new Sort(lines);
            productSort.quickSort();
            productSort.printArrayByLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Q3() {
        Random random = new Random();
        System.out.println("Performance Comparison of Sorting Algorithms");
        System.out.println("Running on 1000 sets of 100000 random numbers");
        SortTest sortTest = new SortTest();
        Integer[] numbers = new Integer[100000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100000; j++) numbers[j] = random.nextInt();
            sortTest.test(numbers);
        }
        sortTest.displayResult();
    }

    private void Q4() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N characters : ");
        int characterNumber = scanner.nextInt();

        ArrayList<Character> characterArrayList = new ArrayList<>();
        System.out.print("The characters are : ");
        char c;
        for (int i = 0; i < characterNumber; i++) {
            c = (char)(random.nextInt(90 - 65 + 1) + 65); // ASCII A -> Z
            characterArrayList.add(c);
            System.out.print(c + " ");
        }
        System.out.println();

        Sort<Character> characterSort = new Sort(characterArrayList.toArray(new Character[characterArrayList.size()]));
        characterSort.heapSort();
        System.out.println("Heap Sort - Ascending Order");
        characterSort.printArray();
    }
}
