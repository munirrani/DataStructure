package com.company.Lab2;

public class Lab2 {

    public Lab2() {
        Q1();
        Q2();
        Q3();
    }

    private void Q1() {
        Generate<Integer> generate = new Generate(20, 101);
        generate.start();
    }

    private void Q2() {
        int size = 5;
        System.out.println("Create a text file with maximum record equal to " + size);
        TextFileLog<String> textFileLog = new TextFileLog<>(size);
        textFileLog.insert("James");
        textFileLog.insert("Ahmad");
        textFileLog.insert("Siti");
        textFileLog.insert("Ramesh");
        textFileLog.insert("John");

        System.out.println();
        System.out.println("Adding another record");
        textFileLog.insert("Fairuz");
        textFileLog.search("Siti");
        textFileLog.clear();
        System.out.println("The Text File Log Size " + textFileLog.size());
    }

    private void Q3() {
        UNOArrayImplementation<String> game = new UNOArrayImplementation<String>("Player 1");
    }
}
