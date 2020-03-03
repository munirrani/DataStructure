package com.company;

public class SmartPhone implements Comparable {

    private String name;
    private int price;

    public SmartPhone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() { return price; };

    @Override
    public int compareTo(Object o) {
        SmartPhone smartPhone = (SmartPhone) o;
        return price - smartPhone.getPrice();
    }

    @Override
    public String toString() {
        return name + " (RM " + price  + ") ";
    }
}
