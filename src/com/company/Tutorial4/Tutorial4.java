package com.company.Tutorial4;

import com.company.Lab4.LinkedList;

public class Tutorial4 {

    public Tutorial4() {
        Q3();
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
}
