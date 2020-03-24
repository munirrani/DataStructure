package com.company.Lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ColourCard {

    ArrayList<Card> cards = new ArrayList<>();
    Queue<Card> firstPlayer = new Queue<>();
    Queue<Card> secondPlayer = new Queue<>();
    Random random = new Random();

    int firstPlayerScore = 0, secondPlayerScore = 0;

    ColourCard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                cards.add(new Card(j, i));
            }
        }
        shuffleCard();
        drawCard(5);
        printPlayerCard();
        compareCard();
    }

    private void shuffleCard() {
        Collections.shuffle(cards, random);
    }

    public void drawCard(int n) {
        while (firstPlayer.getSize() != n && secondPlayer.getSize() != n) {
            firstPlayer.enqeue(cards.remove(random.nextInt(cards.size())));
            secondPlayer.enqeue(cards.remove(random.nextInt(cards.size())));
        }
    }

    public void compareCard() {
        Card first, second;
        while (!firstPlayer.isEmpty()) {
            first = firstPlayer.dequeue();
            second = secondPlayer.dequeue();
            if (first.compareTo(second) > 0) {
                firstPlayerScore++;
            } else {
                secondPlayerScore++;
            }
        }
        System.out.println("Player 1 Score: " + firstPlayerScore);
        System.out.println("Player 2 Score: " + secondPlayerScore);
        if (firstPlayerScore > secondPlayerScore) {
            System.out.println("Player 1 WINS!");
        } else {
            System.out.println("Player 2 WINS!");
        }
    }

    public void printPlayerCard() {
        System.out.println("Player 1 Card");
        firstPlayer.showQueue();
        System.out.println("Player 2 Card");
        secondPlayer.showQueue();
    }


}
