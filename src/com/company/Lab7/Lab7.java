package com.company.Lab7;

import java.util.Random;
import java.util.Scanner;

public class Lab7 {

    public Lab7() {
        Q1();
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
}
