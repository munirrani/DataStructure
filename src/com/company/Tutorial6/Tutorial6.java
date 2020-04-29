package com.company.Tutorial6;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Tutorial6 {

    public Tutorial6() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
    }

    private void Q1() {
        Queue<Character> queue = new Queue();
        System.out.println("Queue Implementation using Linked List");
        System.out.println("Enqueue three nodes");
        queue.enqueue('B');
        queue.enqueue('M');
        queue.enqueue('W');
        queue.showQueue();
        System.out.println("Dequeue one node");
        queue.dequeue();
        queue.showQueue();
        System.out.println("The front node of the queue is " + queue.peek());
        System.out.println("The queue size is " + queue.getSize());
    }

    private void Q2() {
        ArrayQueue<Character> queue = new ArrayQueue();
        System.out.println("Queue Implementation using Array");
        System.out.println("Enqueue three nodes");
        queue.enqueue('B');
        queue.enqueue('M');
        queue.enqueue('W');
        queue.showQueue();
        System.out.println("Dequeue one node");
        queue.dequeue();
        queue.showQueue();
        System.out.println("The front node of the queue is " + queue.peek());
        System.out.println("The queue size is " + queue.getSize());
    }

    private void Q3() {
        Random random = new Random();
        System.out.println("Simulating a Queue to purchase MY phone");
        ArrayQueue<Integer> phoneQueue = new ArrayQueue(30);
        while (!phoneQueue.isFull()) {
            int set = random.nextInt(3) + 1;
            for (int i = 0; i < set; i++) {
                phoneQueue.enqueue(i);
                if (phoneQueue.isFull()) break;
            }
        }
        int customerCount = 1;
        int phoneCount = 0;
        while (!phoneQueue.isEmpty()) {
            phoneQueue.dequeue();
            phoneCount++;
            if (phoneQueue.peek() != null) {
                if (phoneQueue.peek() == 0) {
                    System.out.println("Customer " + customerCount + " : " + phoneCount + " set(s) --> ");
                    phoneCount = 0;
                    customerCount++;
                }
            } else {
                System.out.println("Customer " + customerCount + " : " + phoneCount + " set(s) --> ");
            }
        }
        System.out.println("Number of Customer : " + customerCount);
    }

    private void Q4() {
        String[] examples = { "kayak", "Welcome", "Was it a car or a cat I saw?", "civic", "race car" };
        for (String example : examples) {
            if (isPalindrome(example)) {
                System.out.println(example + " is a palindrome.");
            } else {
                System.out.println(example + " is not a palindrome.");
            }
        }
    }

    private void Q5() {
        String[] examples = { "Was it a car or a cat I saw?", "?civic#", "race car", "redrawer", "put     it up" };
        for (String example : examples) {
            String modified = example.toLowerCase();
            modified = modified.replaceAll(" ", "");
            modified = modified.replaceAll("\\?", "");
            modified = modified.replaceAll("#", "");
            if (isPalindrome(modified)) {
                System.out.println(example + " is a palindrome.");
            } else {
                System.out.println(example + " is not a palindrome.");
            }
        }
    }

    private boolean isPalindrome(String word) {
        Queue<Character> queue = new Queue<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.enqueue(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (!queue.dequeue().equals(stack.pop())) return false;
        }
        return true;
    }

    private void Q6() {
        Queue<String> sentenceQueue = new Queue<>();
        Queue<String> tempQueue = new Queue<>();
        Queue<String> sentenceReverse = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        for (String word : words) sentenceQueue.enqueue(word);
        System.out.print("The original queue : ");
        sentenceQueue.showQueue();
        while (sentenceReverse.getSize() != words.length) {
            if (!sentenceQueue.isEmpty()) {
                while (sentenceQueue.getSize() != 1) tempQueue.enqueue(sentenceQueue.dequeue());
                sentenceReverse.enqueue(sentenceQueue.dequeue());
            } else if (!tempQueue.isEmpty()) {
                while (tempQueue.getSize() != 1) sentenceQueue.enqueue(tempQueue.dequeue());
                sentenceReverse.enqueue(tempQueue.dequeue());
            }
        }
        System.out.print("Reverse all the elements in the queue : ");
        sentenceReverse.showQueue();
    }
}
