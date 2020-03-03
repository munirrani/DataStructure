package com.company;

import java.util.Random;

public class StarList {

    private char star = '*';
    private Random random;

    public StarList() {
        LinkedList<Character> firstPlayer = new LinkedList<>();
        LinkedList<Character> secondPlayer = new LinkedList<>();
        random = new Random();


        System.out.println("Player 1 start first");
        while (firstPlayer.length() < 20 || secondPlayer.length() < 20) {
            for (int i = 0; i < rollDice(); i++) {
                firstPlayer.addNode('*');
            }
            System.out.print("Player 1: ");
            firstPlayer.showList();

            for (int i = 0; i < rollDice(); i++) {
                secondPlayer.addNode('*');
            }
            System.out.print("Player 2: ");
            secondPlayer.showList();
        }
        if (firstPlayer.length() > secondPlayer.length()) {
            System.out.println("Player 1 wins the game");
        } else {
            System.out.println("Player 2 wins the game");
        }
    }

    private int rollDice() {
        return random.nextInt(6-1) + 1;
    }
}
