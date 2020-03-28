package com.company.Lab9;

import com.company.Lab8.SortTest;
import com.company.LinkedList;

import java.util.Random;
import java.util.Scanner;

public class Lab9 {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Lab9 () {
        //Q1();
        Q2();
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
}
