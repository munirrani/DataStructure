package com.company;

import com.company.Lab5.Lab5;
import com.company.Viva1.Viva1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*
        LAB 1
         */
        // Q1
        //Time time = new Time(17, 59);

        //Q2
        //Polynomial polynomial = new Polynomial(3, 2, 4, 2 , -0.5, -20);

        //Q3
        //SimpleNetwork simpleNetwork = new SimpleNetwork();

        //Q4
//        CharacterAtoG letterF = new CharacterAtoG('F');
//        CharacterOtoT letterS = new CharacterOtoT('S');
//        CharacterHtoN letterK = new CharacterHtoN('K');
//        CharacterOtoT letterT = new CharacterOtoT('T');
//        CharacterHtoN letterM = new CharacterHtoN('M');
//
//        for (int i = 0; i < 5; i++) {
//            System.out.print(letterF.getLineAt(i));
//            System.out.print("  ");
//            System.out.print(letterS.getLineAt(i));
//            System.out.print("  ");
//            System.out.print(letterK.getLineAt(i));
//            System.out.print("  ");
//            System.out.print(letterT.getLineAt(i));
//            System.out.print("  ");
//            System.out.print(letterM.getLineAt(i));
//            System.out.println();
//        }


        //Q5
//        String textFileName = "lab1.txt";
//        String binaryFileName = "lab1.dat";
//        TextFile textFile = new TextFile();
//        BinaryFile binaryFile = new BinaryFile();
//        try {
//            System.out.println("Write to text file");
//
//            String line1 = "Welcome to FSKTM!";
//            System.out.println(line1);
//            textFile.write(textFileName, line1);
//
//            String line2 = "Please register your matric number.";
//            System.out.println(line2);
//            textFile.write(textFileName, line2);
//
//            String line3 = "Please register your UMMail account.";
//            System.out.println(line3);
//            textFile.write(textFileName, line3);
//
//            System.out.println("Read from text file");
//            textFile.read(textFileName);
//
//            System.out.println("Write to binary file");
//
//            System.out.println(line1);
//            binaryFile.write(binaryFileName, line1);
//
//            System.out.println(line2);
//            binaryFile.write(binaryFileName, line2);
//
//            System.out.println(line3);
//            binaryFile.write(binaryFileName, line3);
//
//            System.out.println("Read from binary file");
//            binaryFile.read(binaryFileName);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        /*
        LAB 2
         */
         //Q1
        //L2Q1<Integer> test = new L2Q1<Integer>(20, 101);
        //test.start();

        //Q2
//        int size = 5;
//        System.out.println("Create a text file with maximum record equal to " + size);
//        TextFileLog<String> textFileLog = new TextFileLog<>(size);
//        textFileLog.insert("James");
//        textFileLog.insert("Ahmad");
//        textFileLog.insert("Siti");
//        textFileLog.insert("Ramesh");
//        textFileLog.insert("John");
//
//        System.out.println();
//        System.out.println("Adding another record");
//        textFileLog.insert("Fairuz");
//        textFileLog.search("Siti");
//        textFileLog.clear();
//        System.out.println("The Text File Log Size " + textFileLog.size());

        //Q3
       // UNOArrayImplementation<String> game = new UNOArrayImplementation<String>("Player 1");

        /*
         LAB3
         */
        //Lab3 lab3 = new Lab3();

        /*
        LAB4
         */
        //Lab4 lab4 = new Lab4();
        //Tutorial1 tutorial1 = new Tutorial1();

        /*
        LAB 5
         */
       Lab5 lab5 = new Lab5();


//        CardGame cardGame = new CardGame(4);
//        cardGame.shuffle();
//        cardGame.drawCard(5);
//        cardGame.printPlayerCard();
//        cardGame.compareCard();
        //writeBinary(4);
        //Viva1 viva1 = new Viva1();
//        int[] set = { 1, 2, 3, 4, 5, 6, 9};
//        int size = set.length;
//        int powerSetSize = (int) Math.pow(2, size);
//        for (int i = 0; i < powerSetSize; i++) {
//            for (int j = 0; j < size; j++) {
//                if ((i & (1 << j)) > 0) {
//                    System.out.print(set[j]);
//                }
//            }
//            System.out.println();
//        }
    }

    public static void writeBinary(int n) {
        if (n % 2 == 0) {
            System.out.print(0);
        } else if (n % 2 == 1){
        }
        writeBinary(n / 2);
    }

    public int sum(int a[], int n) {
        if (n == 0) {
            return a[0];
        } else {
            return a[n-1] + sum(a, n-1); // a[n-1] sebab index = 2
        }
    }

    private static void countCurrency(int amount) {
        LinkedList<Integer> currencyNotes = new LinkedList<>();
        LinkedList<Integer> numberOfNotes = new LinkedList<>();

        currencyNotes.addNode(100);
        currencyNotes.addNode(50);
        currencyNotes.addNode(20);
        currencyNotes.addNode(10);
        currencyNotes.addNode(5);
        currencyNotes.addNode(1);

        for (int i = 0; i < currencyNotes.length(); i++) numberOfNotes.addNode(0); //set semua number of notes to 0 dulu

        int remainder = amount;
        for (int i = 0; i < currencyNotes.length(); i++) {
            int note = currencyNotes.get(i);
            if (remainder > note) {
                numberOfNotes.set(i, remainder / note);
                remainder = amount % note;
            }
        }

        for (int i = 0; i < currencyNotes.length(); i++) {
            System.out.println("MYR "+ currencyNotes.get(i) + " : " + numberOfNotes.get(i));
        }

    }
}
