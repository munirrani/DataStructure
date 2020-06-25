package com.company.Year2016Semester2;

import com.company.Lab5.Stack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year2016Semester2 {

    public Year2016Semester2() {
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        Day<String> day = new Day();
        day.add("Monday");
        day.add("Tuesday");
        day.add("Wednesday");
        day.add("Thursday");
        day.add("Friday");
        day.add("Saturday");
        day.add("Sunday");

        System.out.println("Specify your day in number: ");
        day.showDay();

        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("The name of the day is : " + day.getDay(number));
        System.out.println("The following day of " + day.getDay(number) + " is : " +
                day.getNextDay(number));
        System.out.println("The previous day of " + day.getDay(number) + " is : " +
                day.getPreviousDay(number));

        System.out.println("How many days to add to the specified/current day (" +
                day.getDay(number) + ")? : ");
        int secondInput = scanner.nextInt();

        System.out.println("The new day after the addition of " + secondInput + " day(s) is " +
                day.getDaysAfter(number, secondInput));
    }

    private void checkBracket(String input) {
        Stack<Character> stack = new Stack<>();
        boolean foundBracket = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!isABracket(c)) {
                continue;
            } else {
                foundBracket = true;
                if (!stack.isEmpty() && c == getPair(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) {
            if (foundBracket) System.out.println("YES - all matched!");
                else System.out.println("There is no brakcet in the input");
        } else {
            System.out.println("Not all brackets are matched");
        }
    }

    private boolean isABracket(char c) {
        if (c == '{' || c == '}' || c == '[' || c == ']' || c == '(' ||
        c == ')' || c == '<' || c == '>') return true;
        return false;
    }

    private char getPair(char c) {
        if (c == '{') {
            return '}';
        } else if (c == '(') {
            return ')';
        } else if (c == '[') {
            return ']';
        } else {
            return '>';
        }
    }

    private void Q2() {
        try {
            Scanner scanner = new Scanner(new FileInputStream("src/com/company/Year2016Semester2/BracMatch.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("For line " + line);
                checkBracket(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Q3() {
        Queue<Integer> numberQueue = new Queue<>();
        for (int i = 10; i <= 90; i+=10) numberQueue.enqueue(i);
        System.out.println(numberQueue.toString());
        numberQueue.ChangeOrder(4);
        System.out.println(numberQueue.toString());
    }

    private void Q4() {
        LinkedList s1 = new LinkedList();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11, 10);
        s1.addAfter(21, 20);
        s1.addAfter(31, 30);
        s1.addAfter(41, 40);
        s1.addAfter(51, 50);
        s1.traverse();
        s1.deleteFront();
        s1.deleteFront();
        s1.traverse();
        s1.deleteAfter(40);
        s1.deleteAfter(40);
        s1.deleteAfter(31);
        s1.deleteAfter(40);
        s1.traverse();
    }
}
