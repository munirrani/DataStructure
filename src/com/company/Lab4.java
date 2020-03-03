package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Lab4 {

    public Lab4() {
//        //Q1
//        Random random = new Random();
//        int randomNumber;
//        int[] array = new int[10];
//
//        LinkedList<Integer> backLinkedList = new LinkedList<Integer>();
//        LinkedList<Integer> frontLinkedList = new LinkedList<Integer>();
//        LinkedList<Integer> sortedLinkedList = new LinkedList<Integer>();
//
//        for (int i = 0; i < 10; i++) {
//            randomNumber = random.nextInt(101);
//            array[i] = randomNumber;
//            frontLinkedList.addFrontNode(randomNumber);
//            backLinkedList.addNode(randomNumber);
//            sortedLinkedList.addSortNode(randomNumber);
//        }
//        System.out.print("The numbers are: ");
//        for (int arr : array) System.out.print(arr + " ");
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Insert random numbers at the back of linked list");
//        backLinkedList.showList();
//        System.out.println();
//        System.out.println("Insert random numbers at the front of linked list");;
//        frontLinkedList.showList();
//        System.out.println();
//
//        System.out.println("Insert the random numbers in a sorted linked list");
//        sortedLinkedList.showList();

        //Q2
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a word: ");
//        String word = scanner.nextLine();
//        LinkedList<Character> characterLinkedList = new LinkedList<>();
//        for (int i = 0; i < word.length(); i++) {
//            characterLinkedList.addNode(word.charAt(i));
//        }
//        System.out.print("The original list: ");
//        characterLinkedList.showList();
//        characterLinkedList.splitList();
//        characterLinkedList.alternateSplit();
//        characterLinkedList.mergeList();
//        System.out.println("Reverse the list. Recursive method in LinkedList");
//        characterLinkedList.reverseList(null);
//        System.out.println("Reverse the list. Recursive method in tester class");
//        reverseList(characterLinkedList, null);



        //Q3
//        Course programming = new Course("WXX101", "Programming", 5, 'B');
//        Course networking = new Course("WXX201", "Networking", 4, 'C');
//        Course operatingSystem = new Course("WXX301", "Operating System", 3, 'A');
//        LinkedList<Course> courseLinkedList = new LinkedList<>();
//        courseLinkedList.addNode(programming);
//        courseLinkedList.addNode(networking);
//        courseLinkedList.addNode(operatingSystem);
//
//        System.out.print("The list consist of");
//        courseLinkedList.showList();
//        int point = 0;
//        int credit = 0;
//        for (int i = 0; i < courseLinkedList.length(); i++) {
//            point += courseLinkedList.get(i).getCreditHours() * courseLinkedList.get(i).getPoint();
//            credit += courseLinkedList.get(i).getCreditHours();
//        }
//        double GPA = point/(credit * 1.0);
//        System.out.println("Total point is " + point);
//        System.out.println("Total credit is " + credit);
//        System.out.println("Grade point average is " + String.format("%.2f", GPA));

        //Q4
        //StarList starList = new StarList();

        //Q5
        /*
        Iterator is used to cycle through a linked list to get the data of an element or remove an element.
        Create an inner class LinkedListIterator in LinkedList.java that implements the Iterator.
        Then, insert the following word ARS, CHE, LEI, MAN, LIV, TOT into the LinkedList.
        After that, demonstrate the use of the iterator methods to remove the word that consists of the A character.
        Create the listIterator method in the LinkedList.java to return the iterator
         */
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addNode("ARS");
        linkedList.addNode("CHE");
        linkedList.addNode("LEI");
        linkedList.addNode("MAN");
        linkedList.addNode("LIV");
        linkedList.addNode("TOT");
        System.out.print("The list contains of ");
        linkedList.showList();
        System.out.println("Remove all the word that contains of the A character using iterator");

        Iterator<String> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            String it = iterator.next();
            if (it.contains("A")) {
                iterator.remove();
            }
        }
        System.out.print("The updated list contains ");
        linkedList.showList();
    }

    public static void reverseList(LinkedList<Character> linkedList, ListNode node) {
        ListNode head = linkedList.getHead();
        if (head.getLink() != null) {
            ListNode newNode = new ListNode(head.getData(), node);
            linkedList.setHead(linkedList.getHead().getLink());
            reverseList(linkedList, newNode);
        } else {
            linkedList.setHead(new ListNode(head.getData(), node)); // last node
            linkedList.showList();
        }
    }
}
