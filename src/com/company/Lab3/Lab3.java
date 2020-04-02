package com.company.Lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Lab3 {

    public Lab3() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
    }

    private void Q1() {
        int n = 7;
        System.out.println("Mesh topology");
        System.out.println("There are " + n + " switches in the campus");
        System.out.println("The total amount of connections required is " + combination(n, 2));
    }

    private void Q2() {
        String fileName = "lab1.txt";
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName.replace("lab1", "lab1-reversed"), true));
            reverse(scanner.nextLine(), scanner, printWriter);
        } catch (IOException e) { }
    }

    private void Q3() {
        int n;
        System.out.print("Number of elements: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Random random = new Random();

        String str = "";
        for (int i = 0; i < n; i++) {
            str += random.nextInt(10);
        }
        System.out.println("The elements of the array: " + str);
        printCombination(str);
    }

    private void Q4() {
        String day, searchDate;
        Calendar today = Calendar.getInstance(TimeZone.getDefault());
        day = getDay(today.getTime().toString());
        String todayDate = today.get(Calendar.DAY_OF_MONTH) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.YEAR);

        System.out.println("Today Date (dd/mm/yyyy): "  + todayDate);
        System.out.println("Today is on " + day);

        searchDate = "20/8/2015";
        System.out.println("Search Date (dd/mm/yyyy): "  + searchDate);
        int daysCount = findDay(todayDate, searchDate, 0);
        int daysBack = (daysCount % 7);
        int dayIndexNum = getDayIndex(day);
        int index = dayIndexNum - daysBack;
        if (index < 0) {
            index = 7 - Math.abs(dayIndexNum - daysBack);
        }
        System.out.println("Search date is on " + dayIndex[index]);
    }

    private void Q5() {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        int input;
        int count = 0;
        while (true) {
            try {
                System.out.print("Enter an integer: ");
                input = scanner.nextInt();
                arr[count] = Integer.valueOf(input);
                count++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The array of integers is");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                break;
            } catch (InputMismatchException m) {
                System.out.println("Invalid input type");
                scanner.nextLine();
            }
        }
    }

    private int findDay(String currentDate, String searchDate, int daysCount) {
        String[] part = currentDate.split("/");
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

        currentDate = day + "/" + month + "/" + year;
        if (currentDate.equals(searchDate)) {
            return daysCount;
        } else {
            return findDay(currentDate, searchDate, daysCount);
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

    private void printCombination(String input) {
        ArrayList<String> arrayList = new ArrayList<>();
        printCombination(arrayList, "", input);
        Collections.sort(arrayList);
        for (String result : arrayList) {
            int i = 0;
            while (result.charAt(i) == '0') i++; //avoid zero digits at the initials
            System.out.println(result.substring(i));
        }
    }

    private void printCombination(ArrayList<String> arrayList, String result, String remaining) {
        int size = remaining.length();
        if (size == 0) {
            if (!arrayList.contains(result)) arrayList.add(result); // avoid duplicates
        } else {
            for (int i = 0; i < size; i++) {
                printCombination(arrayList, result + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, size));
            }
        }
    }

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
