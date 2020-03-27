package com.company.Lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab8 {

    public Lab8() {
        //Q1();
        Q2();
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
}
