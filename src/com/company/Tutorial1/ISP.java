package com.company.Tutorial1;

public class ISP implements Comparable<ISP> {

    protected String name;
    protected double price;

    public ISP(String name) {
        this.name = name;
    }

    protected void displayPlan() {
        System.out.println("Plan : " + name + " with price RM: " + price);
    }

    private double getPrice() { return price; }

    @Override
    public int compareTo(ISP isp) {
        if (price - isp.getPrice() > 0) {
            return 1;
        } else if (price - isp.getPrice() < 0) {
            return -1;
        }
        return 0;
    }
}
