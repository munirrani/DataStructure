package com.company.Tutorial2;

public class SpecialEncoding<T> {

    T[] arr;

    public SpecialEncoding(T[] array) {
        arr = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
    }

    private String encode(T t) {
        if (t instanceof Integer) {
            Integer num = (Integer) t;
            if (num == 0) {
                return "Copy";
            } else if (num == 1) {
                return "Delete";
            } else if (num == 2) {
                return "Insert";
            } else if (num == 3) {
                return "Print";
            } else if (num == 4) {
                return "Rename";
            } else if (num == 5) {
                return "Paste";
            }
        } else if (t instanceof Character) {
            Character c = (Character) t;
            if (c == 'C') {
                return "Copy";
            } else if (c == 'D') {
                return "Delete";
            } else if (c == 'I') {
                return "Insert";
            } else if (c == 'P') {
                return "Print";
            } else if (c == 'R') {
                return "Rename";
            } else if (c == 'V') {
                return "Paste";
            }
        }
        return "";
    }

    public String toString() {
        String str = "The Code is ";
        for (T t : arr) str += t + " ";
        str += "\nThe Command is ";
        for (T t : arr) str += encode(t) + " ";
        return str;
    }
}
