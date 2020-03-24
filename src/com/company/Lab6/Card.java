package com.company.Lab6;

public class Card implements Comparable<Card> {

    private Color color;
    private int number;
    private int p;

    public Card(int number, int pattern) {
        this.number = number;
        this.p = pattern;
        setColor(pattern);
    }

    private void setColor(int index) {
        switch (index) {
            case 0:
                color = Color.Yellow;
                break;
            case 1:
                color = Color.Red;
                break;
            case 2:
                color = Color.Green;
                break;
            case 3:
                color = Color.Blue;
                break;
            default:
                break;
        }
    }

    enum Color {
        Yellow, Red, Green, Blue;
    }

    public Color getColor() {
         return color;
    }

    @Override
    public int compareTo(Card o) {
        if (number == o.getNumber()) {
            return color.ordinal() - o.getColor().ordinal();
        }
        return number - o.getNumber();
    }

    // TODO Print Card Number
    public String toString() {
        int rankNumber = (Integer) number;
        String str = "";
        switch (rankNumber) {
            case 0:
                str += "One ";
                break;
            case 1:
                str += "Two ";
                break;
            case 2:
                str += "Three ";
                break;
            case 3:
                str += "Four ";
                break;
            case 4:
                str += "Five ";
                break;
            case 5:
                str += "Six ";
                break;
            case 6:
                str += "Seven ";
                break;
            case 7:
                str += "Eight ";
                break;
            case 8:
                str += "Nine ";
                break;
            case 9:
                str += "Ten ";
                break;
        }

        str += color + " ";
        return  str;
    }

    public int getNumber() {
        return number;
    }

}
