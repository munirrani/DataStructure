package com.company;

import java.util.Random;

public class Card<T extends Comparable<T>> implements Comparable<Card<T>> {

    Pattern pattern;
    private T rank;
    private int p;


    public Card(T rank, int pattern) {
        this.rank = rank;
        this.p = pattern;
        setPattern(pattern);
    }

    private void setPattern(int index) {
        switch (index) {
            case 0:
                pattern = Pattern.Diamond;
                break;
            case 1:
                pattern = Pattern.Club;
                break;
            case 2:
                pattern = Pattern.Heart;
                break;
            case 3:
                pattern = Pattern.Spade;
                break;
            default:
                break;
        }
    }

     enum Pattern {
        Diamond, Club, Heart, Spade;
    }

    public void setRandomPattern() {
        var r = new Random();
        int x = Math.abs(r.nextInt()) % 4 + 1;
        Pattern[] values = Pattern.values();
        pattern = values[x];
    }

    public Pattern getPattern() {
         return pattern;
    }

    @Override
    public int compareTo(Card<T> o) {
        if (rank.compareTo(o.getRank()) == 0) {
            return pattern.ordinal() - o.getPattern().ordinal();
        }
        return rank.compareTo(o.getRank());
    }

    public String toString() {
        int rankNumber = (Integer) rank;
        if (rankNumber >= 10) {
            char letter = (char) (rankNumber - 10 + 65);
            return pattern + " " + letter + " : ";
        } else {
            return pattern + " " + rank + " : ";
        }
    }

    public T getRank() {
        return rank;
    }

}
