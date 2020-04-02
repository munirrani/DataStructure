package com.company.Lab2;

public class UNOArrayImplementation<T extends Comparable> {

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
