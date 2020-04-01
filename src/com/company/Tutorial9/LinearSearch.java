package com.company.Tutorial9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    Character[] characters = new Character[10];
    Scanner scanner = new Scanner(System.in);

    char start = 'A';
    char end = 'Z';
    public LinearSearch() {
        Random random = new Random();
        System.out.print("The Character data set are : ");
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char)(random.nextInt(end-start+1) + start);
            System.out.print(characters[i] + " ");
        }
        System.out.println();
        System.out.println("Linear Search");
        System.out.print("Enter a letter to search: ");
        String input = scanner.nextLine();
        char value = input.charAt(0);
        if (isExists(value)) {
            System.out.println(value + " is found");
            System.out.println("The letter " + value + " in the data set is " + getOccurence(value));
            System.out.print("The location of " + value + " are : ");
            ArrayList<Integer> arrayList = getIndex(value);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println(value + " is not found");
        }

        System.out.print("Enter two letters to search (begin end) : ");
        input = scanner.nextLine();
        char minimum = input.charAt(0);
        char maximum = input.charAt(2);
        if (ifExistsWithinRange(minimum, maximum)) {
            System.out.println("The character can be found in between " + minimum + " " + maximum);
            System.out.println("The number of the elements in between " + minimum + " " + maximum +
                    " in the data set is " + getOccurenceWithinRange(minimum, maximum));
            System.out.print("The location of the elements in between " + minimum + " and " + maximum + " are : ");
            ArrayList<Integer> locations = getIndexWithinRange(minimum, maximum);
            for (int i = 0; i < locations.size(); i++) {
                System.out.print(locations.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("No character can be found in between " + minimum + " " + maximum);
        }

    }

    private boolean isExists(char value) {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == value) return true;
        }
        return false;
    }

    private int getOccurence(char value) {
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == value) count++;
        }
        return count;
    }

    private ArrayList getIndex(char value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == value) arrayList.add(i);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private boolean ifExistsWithinRange(char minimum, char maximum) {
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] >= minimum && characters[i] <= maximum) return true;
        }
        return false;
    }

    private int getOccurenceWithinRange(char minimum, char maximum) {
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] >= minimum && characters[i] <= maximum) count++;
        }
        return count;
    }

    private ArrayList getIndexWithinRange(char minimum, char maximum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] >= minimum && characters[i] <= maximum) arrayList.add(i);
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
