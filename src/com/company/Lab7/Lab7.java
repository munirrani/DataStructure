package com.company.Lab7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Lab7 {

    public Lab7() {
        //Q1();
        Q2();
    }

    private void Q1() {
        BST<Integer> integerBST = new BST<>();
        Random random = new Random();
        System.out.print("Random numbers are ");
        int randomNumber;
        for (int i = 0; i < 20; i++) {
            randomNumber = random.nextInt(21);
            System.out.print(randomNumber + " ");
            integerBST.addNode(randomNumber);
        }
        System.out.println();
        System.out.println("The number of elements in the tree : " + integerBST.getSize());

        System.out.print("The tree elements - PREORDER : ");
        integerBST.setOrder(BST.PREORDER);
        integerBST.showTree();

        System.out.print("The tree elements - INORDER : ");
        integerBST.setOrder(BST.INORDER);
        integerBST.showTree();

        System.out.print("The tree elements - POSTORDER : ");
        integerBST.setOrder(BST.POSTORDER);
        integerBST.showTree();

        System.out.println("The minimum number is : " + integerBST.getMinimumNumber());
        System.out.println("The maximum number is : " + integerBST.getMaximumNumber());
        System.out.println("The total is : " + integerBST.getTotal());

        System.out.print("Enter a number to search : ");
        Scanner scanner = new Scanner(System.in);
        Integer occurence = scanner.nextInt();
        System.out.println("The number of occurence of " + occurence + " is " + integerBST.getOccurence(occurence));
    }

    private void Q2() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("lab7Q2.txt")));
            String line;
            String[] values = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                line = line.replaceAll(",", "");
                line = line.replaceAll("\\(", "");
                line = line.replaceAll("\\)", "");
                line = line.replaceAll("\\.", "");
                line = line.replaceAll(":", "");
                line = line.replaceAll("\"", "");
                line = line.toLowerCase();
                values = line.split(" ");
            }

            BST<String> sentence = new BST<>();
            BST<String> words = new BST<>();
            for (int i = 0; i < values.length; i++) {
                sentence.addNode(values[i]);
                if (!words.contains(values[i])) {
                    words.addNode(values[i]);
                }
            }
            System.out.println("Word Frequency Generator Program");
            words.printInOrder(sentence);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
