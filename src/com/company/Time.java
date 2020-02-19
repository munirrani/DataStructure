package com.company;

public class Time {

    /*
    Create a class Time that represents time of the day. The class consists of attributes for the hour and minute.
    The hour value ranges from 0 to 23 and the minute value ranges from 0 to 59.
    The class consists of constructor that initializes the time and hour.
    The class also consists of a method to check whether the time is valid and a method to display
    the time in hh:mm AM or hh:mm PM. Create a Tester class to test the program, given output below.
     */

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
