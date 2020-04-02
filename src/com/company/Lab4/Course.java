package com.company.Lab4;

public class Course implements Comparable<Course> {

    private String code, name;
    private int creditHours;
    private char grade;
    private int point;

    public Course(String code, String name, int creditHours, char grade) {
        this.code = code;
        this.name = name;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCreditHours() { return creditHours; }
    public char getGrade() { return grade; }
    public int getPoint() {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }

    public String toString() {
        return "\nCourse : " + code +  " (" + name + ") - " + creditHours + " credit hours. Grade : " + grade + " ";
    }

    @Override
    public int compareTo(Course o) {
        return 0;
    }
}
