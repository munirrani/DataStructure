package com.company.Lab1;

public class Time {

    private int hour, minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;

        if (!isValid()) System.out.println("Enter the correct time!");
        else displayTime();
    }

    private boolean isValid() {
        if (hour >= 24 || minute >= 60) return false;
        return true;
    }

    private void displayTime() {
        if (hour < 12) {
            if (minute < 10) {
                System.out.printf("%d:0%d AM", hour, minute);
            } else {
                System.out.printf("%d:%d AM", hour, minute);
            }
        } else {
            if (hour > 12) hour -= 12;
            if (minute < 10) {
                System.out.printf("%d:0%d PM", hour, minute);
            } else {
                System.out.printf("%d:%d PM", hour, minute);
            }
        }
    }
}
