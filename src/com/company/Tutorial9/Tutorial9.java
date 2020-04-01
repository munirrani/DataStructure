package com.company.Tutorial9;

import java.util.Scanner;

public class Tutorial9 {

    Scanner scanner = new Scanner(System.in);

    public Tutorial9() {
        Q1();
        Q2();
        Q3();
    }

    private void Q1() {
        LinearSearch linearSearch = new LinearSearch();
    }

    private void Q2() {
        BinarySearch binarySearch = new BinarySearch();
    }

    private void Q3() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("100-101", "ICND1");
        hashTable.put("200-101", "ICND2");
        hashTable.put("200-120", "CCNA Routing and Switching");
        hashTable.put("210-260", "CCNA Security");
        System.out.println("Hash Table");
        System.out.println("The number of elements in the Hash Table " + hashTable.getSize());
        hashTable.showHashTable();
        System.out.print("Enter a code to search : ");
        String input = scanner.nextLine();
        if (hashTable.containsKey(input)) {
            System.out.println("Course " + input + " : " + hashTable.get(input));
        } else {
            System.out.println("The  course " + input + " cannot be found");
        }
    }
}
