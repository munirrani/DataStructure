package com.company.Lab6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab6 {

    public Lab6() {
        //Q1();
        //Q2();
        Q3();
    }

    private void Q1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transactions : ");
        String input = scanner.nextLine();
        String[] values = input.split("\\|");

        Queue<String> atm = new Queue<>();
        for (String value : values) {
            atm.enqeue(value);
        }
        atm.showQueue();

        System.out.print("Initial Balance : ");
        int balance = scanner.nextInt();
        scanner.nextLine();

        while (!atm.isEmpty()) {
            String command = atm.dequeue();
            String number;
            int value = 0;

            if (command.contains("D")) {
                command = command.replace("D", "");
                number = command.replaceAll(" ", "");
                value = Integer.valueOf(number);
                System.out.printf("%-25s ", "Deposit  " + number);
                balance += value;
            } else {
                command = command.replace("W", "");
                number = command.replaceAll(" ", "");
                value = Integer.valueOf(number);
                if (value > balance) {
                    System.out.printf("%-25s ", "Withdraw " + number + " Rejected");
                } else {
                    System.out.printf("%-25s ", "Withdraw " + number);
                    balance -= value;
                }
            }
            System.out.println("New Balance " + balance);
        }
    }

    private void Q2() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("lab6Q2.txt")));
            // Use ArrayList
            ArrayList<String> products = new ArrayList<>();
            ArrayList<Queue<String>> queueArrayList = new ArrayList<>();

            String line;
            String[] elements;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                elements = line.split(" ");
                int index = 0;
                for (String element : elements) {
                    if (element.contains("P0")) {
                        if (!products.contains(element)) {
                            products.add(element);
                            Queue<String> queue = new Queue<>();
                            queueArrayList.add(queue);
                        }
                        index = products.indexOf(element);
                    } else {
                        Queue<String> queue = queueArrayList.get(index);
                        queue.enqeue(element);
                    }
                }
            }
            System.out.print("Product Code in Queue : ");
            for (int i  = 0; i < products.size(); i++) System.out.print(products.get(i) + " --> ");
            System.out.println();

            System.out.println("List of product by categories");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("Product : " + products.get(i));
                queueArrayList.get(i).showQueue();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Q3() {
        ColourCard colourCard = new ColourCard();
    }
}
