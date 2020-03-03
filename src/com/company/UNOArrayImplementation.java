package com.company;

import jdk.jshell.EvalException;

import java.util.Random;

public class UNOArrayImplementation<T extends Comparable> {
    /*
    Create an ADT for the UNO card. This ADT contains the following specifications. 􏰀
       A method to draw the card for a number of times.
􏰀       A toString method that returns the value of each card drawed.
    Implement the ADT using Array and LinkedList. Create a Tester class to test the program, given output below.
     */

    /*
    Cards:
    Pick Color
    Draw Four
    <color> Draw Two
    <color> <numbers 0-9>
    <color> Reverse
    <color> skip
     */


    private T[] arr;
    int card;
    int index;
    String player;

    public UNOArrayImplementation(String player) {
        this.player = player;
        index = -1;
    }

    public void drawCard(int amount) {
        System.out.println(player + " draws " + amount + " times");
        card = amount;
        arr = (T[]) new Comparable[card];
        int count = 0;
        while (count != amount) {

            count++;
        }
    }

    private void insert(T t) {
        if (!isFull()) {
            index++;
            arr[index] = t;
        }
    }

    private boolean isFull() {
        return card == index + 1;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < card; i++) {
            str += arr[i] + " :: ";
        }
        return str;
    }
}
