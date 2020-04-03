package com.company.Tutorial8;

import java.util.ArrayList;
import java.util.Random;

public class Tutorial8 {

    ArrayList<String> sortingNames = new ArrayList<>();
    Random random = new Random();

    public Tutorial8() {
        sortingNames.add("Selection Sort");
        sortingNames.add("Bubble Sort");
        sortingNames.add("Insertion Sort");
        sortingNames.add("Merge Sort");
        sortingNames.add("Quick Sort");
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        for (int i = 0; i < sortingNames.size(); i++) {
            Character[] chars = new Character[10];
            System.out.print("The random characters are : ");
            for (int j = 0; j < chars.length; j++) {
                chars[j] = (char) (random.nextInt(90-65+1) + 65);
                System.out.print(chars[j] + " ");
            }
            System.out.println();
            System.out.println(sortingNames.get(i) + " - Descending Order");
            SortTest<Character> sortTest = new SortTest(chars);
            sortTest.sort(i, Sort.DESCENDING_ORDER);
            sortTest.printArray();
        }
    }

    private void Q2() {
        for (int i = 3; i <= 4; i++) {
            String[] strings = new String[10];
            System.out.print("The random String are : ");
            for (int a = 0; a < strings.length; a++) {
                String str = "";
                for (int j = 0; j < 8; j++) {
                    str += (char)(random.nextInt(122-97+1) + 97);
                }
                strings[a] = str;
                System.out.print(str + " ");
            }
            System.out.println();
            System.out.println(sortingNames.get(i) + " - Ascending Order");
            SortTest<String> stringSortTest = new SortTest(strings);
            stringSortTest.sort(i, Sort.ASCENDING_ORDER);
            stringSortTest.printArray();
        }
    }

    private void Q3() {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addNode(random.nextInt(101));
        }
        System.out.print("The random integers are : ");
        linkedList.showList();
        System.out.println("Selection Sort - Ascending Order");
        linkedList.selectionSort();
        linkedList.showList();
    }

    private void Q4() {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addNode(random.nextInt(101));
        }
        System.out.print("The random integers are : ");
        linkedList.showList();
        System.out.println("Bubble Sort - Descending Order");
        linkedList.bubbleSort();
        linkedList.showList();
    }
}
