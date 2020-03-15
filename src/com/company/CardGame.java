package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CardGame implements CardDeck {

    private ArrayList<Card> cardArrayList = new ArrayList<>();
    private LinkedList<Card> linkedList = new LinkedList<>();

    private ArrayList<ArrayList<Card>> players;

    CardGame(int player) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 36; j++) {
                Card<Integer> c = new Card<>(j, i);
                cardArrayList.add(c);
            }
        }

        players = new ArrayList<>();
        for (int i = 0; i < player; i++) {
            players.add(new ArrayList<Card>());
        }
    }

    public Card<Integer> getBiggestCard(ArrayList<Card> player) {
        Card<Integer> bigger = player.get(0);
        Card<Integer> tempCard;
        for (int j = 0; j < player.size() - 1; j++) {
            tempCard = player.get(j+1);
            if (bigger.compareTo(tempCard) < 0) {
                bigger = tempCard;
            }
        }
        return bigger;
    }

    public void compareCard() {
        Card<Integer> tempCard;
        Card<Integer> result = players.get(0).get(0); //temporary
        int player = 1;
        for (int i = 0; i < players.size(); i++) {
            tempCard = getBiggestCard(players.get(i));
            System.out.println("Player " +  (i+1) + " biggest card is " + tempCard.toString());
            if (result.compareTo(tempCard) < 0) {
                result = tempCard;
                player = i+1;
            }
        }
        System.out.println("Player " + player + " wins!");
    }

    @Override
    public void shuffle() {
        Random random = new Random();
        Collections.shuffle(cardArrayList, random);
        Collections.shuffle(linkedList, random);
    }

    @Override
    public void drawCard(int n) {
        Random random = new Random();
        ArrayList<Card> player;
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            for (int j = 0; j < n; j++) {
                player.add(cardArrayList.remove(random.nextInt(cardArrayList.size())));
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < cardArrayList.size(); i++) {
            str += cardArrayList.get(i).toString();
        }
        return str;
    }

    public void printPlayerCard() {
        for(int i = 0; i < players.size(); i++) {
            ArrayList<Card> player = players.get(i);
            System.out.println("Player " + (i+1) + ":");
            for (int j = 0; j < player.size(); j++) {
                System.out.print(player.get(j).toString());
            }
            System.out.println();
        }
    }
}
