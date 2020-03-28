package com.company.Lab9;

import java.util.Random;
import java.util.Scanner;

public class Lab9 {

    public Lab9 () {
        Q1();
    }

    private void Q1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = scanner.nextInt();
        System.out.println("The matrix are : ");
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) matrix[i][j] = random.nextInt(19-10+1) + 10;
        for (int[] arr : matrix) {
            for (int num : arr) System.out.print(num + " ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Linear Search");
        System.out.print("Enter a number to search: ");
        int toSearch = scanner.nextInt();
        if (findElement(toSearch, matrix)) {
            System.out.println(toSearch + " is found");
            System.out.println("The number of " + toSearch + " in the matrix is " + findOccurence(toSearch, matrix));
            System.out.println("The location of " + toSearch + " are : " + findLocation(toSearch, matrix));
        } else {
            System.out.println(toSearch + " is not found");
        }
    }

    private boolean findElement(int value, int[][] arrr) {
        for (int[] arr : arrr) for (int ar : arr) if (ar == value) return true;
        return false;
    }

    private int findOccurence(int value, int[][] arrr) {
        int count = 0;
        for (int[] arr : arrr) for (int ar : arr) if (ar == value) count++;
        return count;
    }

    private String findLocation(int value, int[][] arrr) {
        String str = "";
        for (int i = 0; i < arrr.length; i++) for (int j = 0; j < arrr[i].length; j++) if (value == arrr[i][j]) str += "[" + i + "," + j + "]";
        return str;
    }
}
