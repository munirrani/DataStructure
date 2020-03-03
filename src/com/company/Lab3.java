package com.company;

import com.sun.jdi.InvalidTypeException;

import java.io.PrintWriter;
import java.util.*;

public class Lab3 {

    private String sDate;
    int daysCount = 0;
    int daysBack;
    String day;

    public Lab3() {
        //Q1
//        int n = 7;
//        System.out.println("Mesh topology");
//        System.out.println("There are " + n + " switches in the campus");
//        System.out.println("The total amount of connections required is " + combination(n, 2));

        //Q2
        /*
        Define a recursive method that read lines of text from one file and then output the lines in reverse order in another file.
         */

//        String fileName = "lab1.txt";
//        try {
//            Scanner scanner = new Scanner(new FileInputStream(fileName));
//            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName.replace("lab1", "lab1-reversed"), true));
//            reverse(scanner.nextLine(), scanner, printWriter);
//        } catch (IOException e) { }

        /*
        Define a recursive method that displays all n! Permutations of an integer array elements.
        The main method will accept the number of elements from user and generate the random number
        within 0 and 9 for the elements of the array. Example output:
        */
//        int n;
//        System.out.print("Number of elements: ");
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        Random random = new Random();
//
//        int[] digit = new int[n];
//        for (int i = 0; i < n; i++) {
//            digit[i] = random.nextInt(10);
//        }
//
//        System.out.print("The elements of the array: ");
//        for (int num : digit) System.out.print(num);
//        System.out.println();

//        int[] arr = { 1, 2, 3, 4, 5};
//        int length = arr.length;
//        int r = 5;
//        int[] data = new int[r];
//
//        printCombination(arr, data, 0, length-1, 0, 3);

        //Q4
        /*
        Create a program to display the day, month, year and the name of the day for today date.
         Write a recursive method to display the name of the day of the past date.
          (Tip: use the today date as the parameters for the recursive method).
         */
//        Calendar today = Calendar.getInstance(TimeZone.getDefault());
//        day = getDay(today.getTime().toString());
//
//        String todayDate = today.get(Calendar.DAY_OF_MONTH) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.YEAR);
//
//        System.out.println("Today Date (dd/mm/yyyy): "  + todayDate);
//        System.out.println("Today is on " + day);
//
//        sDate = "18/8/2015";
//        System.out.print("Search Date (dd/mm/yyyy): "  + sDate);
//        System.out.println();
//        findDay(todayDate);

//        //Q5
//        int[] arr = new int[5];
//        Scanner scanner = new Scanner(System.in);
//        int input;
//        int count = 0;
//
//        while (true) {
//            try {
//                System.out.print("Enter an integer: ");
//                input = scanner.nextInt();
//                arr[count] = Integer.valueOf(input);
//                count++;
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("The array of integers is");
//                for (int i = 0; i < arr.length; i++) {
//                    System.out.print(arr[i] + " ");
//                }
//                break;
//            } catch (InputMismatchException m) {
//                System.out.println("Invalid input type");
//                scanner.nextLine();
//            }
//        }


    }

    private void findDay(String searchDate) {

        String[] part = searchDate.split("/");
        int day = Integer.valueOf(part[0]);
        int month = Integer.valueOf(part[1]);
        int year = Integer.valueOf(part[2]);

        daysCount++;

        if (day == 1) {
            day = 31;
            if (month == 3) {
                //Check if leap year
                if (year % 400 == 0) {
                    day = 29;
                } else if (year % 100 != 0 && year % 4 == 0) {
                    day = 29;
                } else {
                    day = 28;
                }
            }
            if (month == 12 || month == 10 || month == 7 || month == 5) {
                day = 30;
            }
            if (month == 1) {
                year--;
                month = 12;
            } else {
                month--;
            }
        } else {
            day--;
        }

        searchDate = day + "/" + month + "/" + year;
        //System.out.println(searchDate);

        if (this.sDate.equals(searchDate)) {
            //System.out.println("Days past = " + daysCount + " days");
            daysBack = (daysCount % 7);
            int dayIndexNum = getDayIndex(this.day);
            int index = dayIndexNum - daysBack;
            if (index < 0) {
                index = 7 - Math.abs(dayIndexNum - daysBack);
            }

            System.out.println("Search date is on " + dayIndex[index]);
        } else {
            findDay(searchDate);
        }
     }

     String[] dayIndex = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private int getDayIndex(String day) {
        for (int i = 0; i < dayIndex.length; i++) {
            if(dayIndex[i].contains(day)) return i;
        }
        return -1;
    }

    private String getDay (String day) {
        if (day.contains("Sun")) {
            return dayIndex[0];
        } else if (day.contains("Mon")) {
            return dayIndex[1];
        } else if (day.contains("Tue")) {
            return dayIndex[2];
        } else if (day.contains("Wed")) {
            return dayIndex[3];
        } else if (day.contains("Thu")) {
            return dayIndex[4];
        } else if (day.contains("Fri")) {
            return dayIndex[5];
        } else if (day.contains("Sat")) {
            return dayIndex[6];
        } else {
            return "";
        }
    }

//    private void printCombination(int[] arr, int[] data, int start, int end, int index, int r) {
//
//        if (index == r) {
//            for (int i = 0; i < r; i++) {
//                System.out.print(data[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = start; i <= end && end-i+1 >= r-index; i++) {
//            data[index] = arr[i];
//            printCombination(arr, data, i+1, end, index+1, r);
//        }
//    }

//    private void permutate(int[] n, int firstIndex) {
//        int currentIndex = firstIndex;
//
//        if (currentIndex != firstIndex) {
//            currentIndex++;
//            permutate(n, currentIndex);
//        } else {
//            currentIndex = n[index+1];
//            permutate(n,currentIndex);
//        }
//
//        for (int num : n) System.out.print(num);
//        System.out.println();
//    }

    private void reverse(String s, Scanner scanner, PrintWriter printWriter) {
        StringBuffer stringBuffer = new StringBuffer(s);
        if (!scanner.hasNextLine()) {
            printWriter.println(stringBuffer.reverse());
        } else {
            printWriter.println(stringBuffer.reverse());
            reverse(scanner.nextLine(), scanner, printWriter);
        }
        printWriter.flush();
    }

    private int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    private int combination(int n, int r) {
        return fact(n) / (fact(n-r) * fact(r));
    }
}
