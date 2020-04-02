package com.company.Lab9;

import com.company.Lab4.LinkedList;
import com.company.Lab8.SortTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Lab9 {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Lab9 () {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
    }

    private void Q1() {
        System.out.print("Enter N : ");
        int N = scanner.nextInt();
        System.out.println("The matrix are : ");
        Integer[][] matrix = new Integer[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) matrix[i][j] = random.nextInt(19-10+1) + 10;

        for (Integer[] arr : matrix) {
            for (Integer num : arr) System.out.print(num + " ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Linear Search");
        System.out.print("Enter a number to search: ");
        int toSearch = scanner.nextInt();
        SortTest<Integer> sortTest = new SortTest<>();

        if (sortTest.findElement(toSearch, matrix)) {
            System.out.println(toSearch + " is found");
            System.out.println("The number of " + toSearch + " in the matrix is " + sortTest.findOccurence(toSearch, matrix));
            System.out.println("The location of " + toSearch + " are : " + sortTest.findLocation(toSearch, matrix));
        } else {
            System.out.println(toSearch + " is not found");
        }
    }

    private void Q2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) linkedList.addNode(random.nextInt(21));
        System.out.print("The random integers are : ");
        linkedList.showList();
        System.out.println("Linear Search");
        System.out.print("Enter a number to search: ");
        int toSearch = scanner.nextInt();
        if (linkedList.contains(toSearch)) {
            System.out.println(toSearch + " is found");
            System.out.println("The number of " + toSearch + " in the data set is " + linkedList.getOccurence(toSearch));
        } else {
            System.out.println(toSearch + " is not found");
        }
        System.out.print("Enter two numbers to search (begin end) : ");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        if (linkedList.containsFromRange(firstNumber, secondNumber)) {
            System.out.println("The number of elements in between " + firstNumber + " and " + secondNumber +
                    " in the data set is " + linkedList.getOccurenceFromRange(firstNumber, secondNumber));
        } else {
            System.out.println("No integer can be found in between " + firstNumber + " and " + secondNumber);
        }
    }

    private void Q3() {
        ArrayHashTable<String, String> arrayHashTable = new ArrayHashTable<>();
        arrayHashTable.put("100-101", "ICND1");
        arrayHashTable.put("200-101", "ICND2");
        arrayHashTable.put("200-120", "CCNA Routing and Switching");
        arrayHashTable.put("210-260", "CCNA Security");

        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Adding a new course");
        arrayHashTable.put("300-101", "ROUTE");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Modifying 210-260");
        arrayHashTable.put("210-260", "CCNA RS Security");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Remove the course 200-101");
        arrayHashTable.remove("200-101");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.print("Enter a code to search : ");
        String input = scanner.nextLine();
        System.out.println("Course " + input + " : " + arrayHashTable.get(input));
    }

    private void Q4() {
        ArrayHashTableHashing<Integer, String> products = new ArrayHashTableHashing<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(new File("lab9Q4.txt")));
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                products.put(Integer.valueOf(line.substring(0, 5)), line.substring(6));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The data set from the File");
        products.showHashTable();
        System.out.println("The Hash Table size is " + products.getSize());
        System.out.print("Enter a PID to search : ");
        String input = scanner.nextLine();
        if (products.containsKey(Integer.valueOf(input))) {
            System.out.println("Product ID : " + input + " " + products.get(Integer.valueOf(input)));
            System.out.println("Location : " + products.getLocation(Integer.valueOf(input)));
        } else {
            System.out.println("Product ID " + input + " cannot be found");
        }
    }

    private void Q5() {
        ArrayHashTableChain<Integer, String> products = new ArrayHashTableChain<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(new File("lab9Q4.txt")));
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                products.put(Integer.valueOf(line.substring(0, 5)), line.substring(6));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The data set from the File");
        products.showHashTable();
        System.out.println("The Hash Table size is " + products.getSize());
        System.out.print("Enter a PID to search : ");
        String input = scanner.nextLine();
        if (products.containsKey(Integer.valueOf(input))) {
            System.out.println("Product ID : " + input + " " + products.get(Integer.valueOf(input)));
            System.out.println("The elements in the same location are : ");
            products.printLocation(Integer.valueOf(input));
        } else {
            System.out.println("Product ID " + input + " cannot be found");
        }
    }
}
