package com.company.Lab6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab6 {

    public Lab6() {
        //Q1();
        //Q2();
        //Q3();
        //Q4();
        Q5();
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

    private void Q4() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("lab6Q4.txt")));
            Queue<Integer> shareQueue = new Queue<>();
            Queue<Integer> sharePriceQueue = new Queue<>();

            String[] values;
            int sellPrice = 0;
            int shareSell = 0;
            System.out.println("List of Transcations");
            while (scanner.hasNextLine()) {
                values = scanner.nextLine().split(" ");
                System.out.print("Day " + values[0] + " : ");
                if (values[1].contentEquals("B")) {
                    System.out.print("Buy ");
                    shareQueue.enqeue(Integer.valueOf(values[2]));
                    sharePriceQueue.enqeue(Integer.valueOf(values[3]));
                } else {
                    System.out.print("Sell ");
                    shareSell = Integer.valueOf(values[2]);
                    sellPrice = Integer.valueOf(values[3]);
                }
                System.out.print(values[2] + " shares at RM " + values[3]);
                System.out.println();
            }

            int gain = 0; // No pain, no gain
            int share, price;
            while (!shareQueue.isEmpty()) {
                share = shareQueue.dequeue();
                price = sharePriceQueue.dequeue();
                if (shareSell > share) {
                    shareSell -= share;
                    gain += (share * (sellPrice - price));
                } else {
                    gain += (shareSell * (sellPrice - price));
                }
            }
            System.out.println("Total Gain " + gain);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Q5() {
        PriorityQueue<Packet> packetPriorityEnqueue = new PriorityQueue<>();
        PriorityQueue<Packet> packetPriorityDequeue = new PriorityQueue<>();
        Random rand = new Random();
        Packet newPacket;

        System.out.println();
        System.out.println("________________");
        System.out.println("Priority Enqueue");
        System.out.println("________________");
        System.out.println();
        System.out.println("10 packets arrived");
        for (int i = 0; i < 10; i++) {
            newPacket = new Packet(rand.nextInt(3), (i+1));
            System.out.println(newPacket.toString());
            packetPriorityEnqueue.priorityEnqueue(newPacket);
        }

        System.out.println();
        System.out.println("Processing 10 network packets");
        while (!packetPriorityEnqueue.isEmpty()) {
            newPacket = packetPriorityEnqueue.priorityDequeue();
            System.out.println(newPacket.toString() + (" (Priority=" + newPacket.getPriority() + ")"));
        }

        System.out.println();
        System.out.println("________________");
        System.out.println("Priority Dequeue");
        System.out.println("________________");
        System.out.println();
        System.out.println("10 packets arrived");
        for (int i = 0; i < 10; i++) {
            newPacket = new Packet(rand.nextInt(3), (i+1));
            System.out.println(newPacket.toString());
            packetPriorityDequeue.enqueue(newPacket);
        }

        System.out.println();
        System.out.println("Processing 10 network packets");
        while (!packetPriorityDequeue.isEmpty()) {
            newPacket = packetPriorityDequeue.priorityDequeue();
            System.out.println(newPacket.toString() + (" (Priority=" + newPacket.getPriority() + ")"));
        }
    }
}
