package com.company.Lab8;

import java.util.Random;
import java.util.Scanner;

public class Lab8 {

    int[] values;

    public Lab8() {
        Q1();
    }

    private void Q1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N Special Random Number within 0-100: ");
        int N = scanner.nextInt();
        scanner.nextLine();
        System.out.print("The Special Number are : ");
        values = new int[N];
        int num;
        for (int i = 0; i < N; i++) {
            num = random.nextInt(101);
            values[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();
        mergeSort();
        System.out.print("After Merge Sort : ");
        printArray(values);
    }

    private void printArray(int arr[]) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private void selectionSort() {
        for (int i = 0; i < values.length - 1; i++) {
            swap(i, getMinimumIndex(i));
        }
    }

    private void insertionSort() {
        int j;
        for (int i = 1; i < values.length; i++) {
            for (j = 0; j < i; j++) {
                if (values[i] < values[j]) {
                    swap(i, j);
                    break;
                }
            }
            for (j = j + 1; j < i; j++) {
                swap(i, j);
            }
        }
    }

    private int getMinimumIndex(int start) {
        int temp = values[start];
        int index = start;
        for (int i = start+1; i < values.length; i++) {
            if (temp > values[i]) {
                index = i;
                temp = values[i];
            }
        }
        return index;
    }

    private void swap(int i, int j) {
        int temp = values[i];
        values[j] = values[i];
        values[i] = temp;
    }

    private void mergeSort() {
        mergeSort(0, values.length - 1);
    }

    private void mergeSort(int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        int[] temp = new int[values.length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        while (leftFirst<=leftLast && rightFirst <= rightLast) {
            if (values[leftFirst] % 2 == 0 && values[rightFirst] % 2 != 0) {
                temp[index] = values[rightFirst];
                rightFirst++;
            } else if (values[leftFirst] % 2 != 0 && values[rightFirst] % 2 == 0) {
                temp[index] = values[leftFirst];
                leftFirst++;
            } else {
                if (values[leftFirst] < values[rightFirst]) {
                    temp[index] = values[leftFirst];
                    leftFirst++;
                } else {
                    temp[index] = values[rightFirst];
                    rightFirst++;
                }
            }
            index++;
        }
        while (leftFirst <= leftLast) {
            temp[index] = values[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast) {
            temp[index] = values[rightFirst];
            rightFirst++;
            index++;
        }
        for (int i = currentIndex; i <= rightLast; i++) {
            values[i] = temp[i];
        }
    }

}
