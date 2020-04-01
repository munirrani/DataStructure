package com.company.Tutorial9;

import com.company.Lab8.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    Integer[] arr = new Integer[10];
    Scanner scanner = new Scanner(System.in);

    public BinarySearch() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(21);
        }
        Sort<Integer> sortArray = new Sort(arr);
        sortArray.quickSort();
        System.out.print("The Integer data set are : ");
        sortArray.printArray();
        arr = sortArray.toArray(Integer.class);

        System.out.println("Binary Search");
        System.out.print("Enter a number to search: ");
        int value = scanner.nextInt();
        if (isExists(value)) {
            System.out.println(value + " is found");
            System.out.println("The number " + value + " in the data set is " + getOccurence(value));
            System.out.print("The location of " + value + " are : ");
            ArrayList<Integer> arrayList = getIndex(value);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println(value + " is not found");
        }

        System.out.print("Enter two numbers to search (begin end) : ");
        int minimum = scanner.nextInt();
        int maximum = scanner.nextInt();
        if (ifExistsWithinRange(minimum, maximum)) {
            System.out.println("The integer can be found in between " + minimum + " " + maximum);
            System.out.println("The number of the elements in between " + minimum + " " + maximum +
                    " in the data set is " + getOccurenceWithinRange(minimum, maximum));
            System.out.print("The location of the elements in between " + minimum + " and " + maximum + " are : ");
            ArrayList<Integer> locations = getIndexWithinRange(minimum, maximum);
            for (int i = 0; i < locations.size(); i++) {
                System.out.print(locations.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("No integer can be found in between " + minimum + " " + maximum);
        }
    }


    public int binarySearch(int start, int end, int value) {
        if (arr[end] < value || arr[start] > value) return -1;
        if (arr[end] == value) return end;
        if (arr[start] == value) return start;
        if (end - start == 1) return -1; // not found, bail out

        int middle = (start + end) / 2;
        if (arr[middle] <= value) {
            return binarySearch(middle, end, value);
        } else if (arr[middle] > value) {
            return binarySearch(start, middle - 1, value);
        }
        return -1;
    }

    private boolean isExists(int value) {
        int index = binarySearch(0, arr.length - 1, value);
        if (index == -1) return false;
        return true;
    }

    private int getOccurence(int value) {
        int index = binarySearch(0, arr.length - 1, value);
        int count = 0;
        if (index == -1) {
            return count;
        } else {
            count++;
        }

        // Go left
        int left = index - 1;
        while (left >= 0 && arr[left] == arr[index]) {
            count++;
            left--;
        }

        // Go right
        int right = index + 1;
        while (right <= arr.length - 1 && arr[right] == arr[index]) {
            count++;
            right++;
        }

        return count;
    }

    private ArrayList getIndex(int value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = binarySearch(0, arr.length - 1, value);
        if (index != -1) {
            arrayList.add(index);
        } else {
            return arrayList;
        }

        // Go left
        int left = index - 1;
        while (left >= 0 && arr[left] == arr[index]) {
            arrayList.add(left);
            left--;
        }

        // Go right
        int right = index + 1;
        while (right <= arr.length - 1 && arr[right] == arr[index]) {
            arrayList.add(right);
            right++;
        }

        Collections.sort(arrayList);
        return arrayList;
    }

    private boolean ifExistsWithinRange(int minimum, int maximum) {
        for (int i = minimum; i <= maximum; i++) {
            int index = binarySearch(0, arr.length - 1, i);
            if (index != -1) return true;
        }
        return false;
    }

    private int getOccurenceWithinRange(int minimum, int maximum) {
        int count = 0;
        for (int i = minimum; i <= maximum; i++) {
            int index = binarySearch(0, arr.length - 1, i);
            if (index != -1) {
                count += getOccurence(i);
            }
        }
        return count;
    }

    private ArrayList getIndexWithinRange(int minimum, int maximum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = minimum; i <= maximum; i++) {
            int index = binarySearch(0, arr.length - 1, i);
            if (index != -1) {
                arrayList.addAll(getIndex(i));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
