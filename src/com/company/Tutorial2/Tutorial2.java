package com.company.Tutorial2;

public class Tutorial2 {

    public Tutorial2() {
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        compare("Hello", "World");
        compare(12.4, 64.3);
        compare(20, 35);
        compare("Welcome", "Welcome");
    }

    private void Q2() {
        Integer[] num = {3, 2, 5, 0, 1};
        Character[] letter = { 'P', 'I', 'V', 'C', 'D' };
        SpecialEncoding<Integer> a = new SpecialEncoding<>(num);
        SpecialEncoding<Character> b = new SpecialEncoding<>(letter);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }

    private void Q3() {
        maximum(42, 15, 58);
        maximum(12.45, 41.28, 19.82);
    }

    private void Q4() {
        ArrayDice<Integer> arrayDice = new ArrayDice<>();
        arrayDice.rollDice(5);
        System.out.println(arrayDice.toString());
        arrayDice.rollDice(4);
        System.out.println(arrayDice.toString());

        LinkedListDice<Integer> linkedListDice = new LinkedListDice<>();
        linkedListDice.rollDice(3);
        System.out.println(linkedListDice.toString());
        linkedListDice.rollDice(4);
        System.out.println(linkedListDice.toString());
    }

    private static <T extends Comparable<T>> void maximum (T x, T y, T z) {
        System.out.print("The maximum value of " + x + " " + y + " " + z + " is ");
        if (x.compareTo(y) > 0 && x.compareTo(z) > 0) {
            System.out.print(x);
        }
        if (y.compareTo(x) > 0 && y.compareTo(z) > 0) {
            System.out.print(y);
        }
        if (z.compareTo(x) > 0 && z.compareTo(y) > 0) {
            System.out.print(z);
        }
        System.out.println();
    }

    private <K extends Comparable<K>> void compare(K firstValue, K secondValue) {
        System.out.println("The parameters are : " + firstValue.toString() + " and " + secondValue.toString());
        if (firstValue instanceof String) {
            if (firstValue.compareTo(secondValue) == 0) {
                System.out.println("The string is equal");
            } else {
                System.out.println("The string is not equal");
            }
        } else if (firstValue instanceof Double) {
            Double value = (Double) firstValue + (Double)secondValue;
            System.out.println("The sum of the double is " + value);
        } else if (firstValue instanceof Integer) {
            Integer value = (Integer) firstValue + (Integer) secondValue;
            System.out.println("The sum of the integer is " + value);
        }
    }
}
