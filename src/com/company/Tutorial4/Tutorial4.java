package com.company.Tutorial4;

public class Tutorial4 {

    public Tutorial4() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
    }

    private void Q1() {
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.addNode(23.1);
        linkedList.addNode(36.5);
        linkedList.addNode(12.8);
        linkedList.addNode(42.6);
        linkedList.addNode(32.8);
        System.out.println("The number in the linked list");
        linkedList.showList();
    }

    private void Q2() {
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.addNode(23.1);
        linkedList.addNode(36.5);
        linkedList.addNode(12.8);
        linkedList.addNode(42.6);
        linkedList.addNode(32.8);
        System.out.println("The number in the linked list after updated");
        linkedList.addTenPointFive();
        linkedList.showList();
    }

    private void Q3() {
        countCurrency(1468);
    }

    private void countCurrency(int amount) {
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

    private void Q4() {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addNode(23);
        linkedList.addNode(15);
        linkedList.addNode(17);
        linkedList.addNode(28);
        linkedList.addNode(12);
        linkedList.addNode(40);
        linkedList.showList();
        System.out.println("Linked List has " + linkedList.length() + " node(s)");
        System.out.println("Total is " + linkedList.getSumOfInteger());
        System.out.println("Total even number is " + linkedList.getTotalEvenNumber());
    }

    private void Q5() {
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 15; i++) linkedList.addRandom(0, 10);
        System.out.println("Linked List has " + linkedList.length() + " node(s)");
        linkedList.showList();
        int numberToRemove = 4;
        System.out.println("Delete the number " + numberToRemove + " from the list.");
        System.out.println();
        linkedList.removeAll(numberToRemove);
        System.out.println("Linked List has " + linkedList.length() + " node(s)");
        linkedList.showList();
    }

    private void Q6() {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addFrontNode(78);
        linkedList.addFrontNode(45);
        linkedList.addFrontNode(34);
        linkedList.addFrontNode(23);
        linkedList.addFrontNode(17);
        linkedList.addFrontNode(10);
        linkedList.addFrontNode(8);
        linkedList.showList();
        System.out.println("The median is " + linkedList.getMiddle());
    }
}
