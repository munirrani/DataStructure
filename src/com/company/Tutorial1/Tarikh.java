package com.company.Tutorial1;

public class Tarikh {

    private int day, month, year;

    public Tarikh(int day, int month, int year) {
        System.out.println("Day: " + day + " Month: " + month + " Year: " + year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return String.format("%02d/%02d/%4d", day, month, year);
    }
}
