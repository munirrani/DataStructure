package com.company.Tutorial5;

import java.util.Random;
import java.util.Scanner;

public class Tutorial5 {

    public Tutorial5() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
    }

    private void Q1() {
        System.out.println("Stack implementation using Linked List");
        System.out.println("Insert three nodes into the stack");
        Stack<Character> stack = new Stack();
        stack.push('A');
        stack.push('N');
        stack.push('D');
        stack.showStack();
        System.out.println("Pop one node from the stack");
        stack.pop();
        stack.showStack();
        System.out.println("The element on the top of the stack is " + stack.peek());
        stack.showStack();
        System.out.println("The number of elements in the stack is " + stack.getSize());
    }

    private void Q2() {
        System.out.println("Stack implementation using Array");
        System.out.println("Insert three nodes into the stack");
        ArrayStack<Character> stack = new ArrayStack();
        stack.push('A');
        stack.push('N');
        stack.push('D');
        stack.showStack();
        System.out.println("Pop one node from the stack");
        stack.pop();
        stack.showStack();
        System.out.println("The element on the top of the stack is " + stack.peek());
        stack.showStack();
        System.out.println("The number of elements in the stack is " + stack.getSize());
    }

    private void Q3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String sentence = scanner.nextLine();
        System.out.println("Original Sentence : " + sentence);
        sentence = getReverseSentence(sentence);
        System.out.println("The sentence in reverse order : " + sentence);

        String[] words = sentence.split(" ");
        String newSentence = "";
        for (String word : words) {
            newSentence+= getReverseWord(word) + " ";
        }
        System.out.println("The word in reverse order : " + newSentence);

    }

    private String getReverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> wordStack = new Stack();
        for (String word : words) wordStack.push(word);
        String str = "";
        while (!wordStack.isEmpty()) {
            str += (getReverseWord(wordStack.pop())) + " ";
        }
        return str;
    }

    private String getReverseWord(String word) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < word.length(); i++) characterStack.push(word.charAt(i));
        String str = "";
        while (!characterStack.isEmpty()) str += characterStack.pop();
        return str;
    }

    private int fibonacci(int index) {
        if(index == 1 || index == 2) return 1;
        Stack<Integer> numberStack = new Stack();
        int count = 2, sum = 0;
        int first = fibonacci(1), second = fibonacci(2);
        numberStack.push(first);
        numberStack.push(second);
        while (count != index) {
            int top = numberStack.pop();
            sum = numberStack.pop() + top;
            numberStack.push(top);
            numberStack.push(sum);
            count++;
        }
        return numberStack.peek();
    }

    private void Q4() {
        System.out.println("Fib(1): " + fibonacci(1));
        System.out.println("Fib(5): " + fibonacci(5));
        System.out.println("Fib(8): " + fibonacci(8));
        System.out.println("Fib(14): " + fibonacci(14));
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ')') {
                if (stack.peek() != null && stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    private void Q5() {
        String[] inputs = { "(())", ")()(", "((())())()", "(())()))", "())" };
        for (String input : inputs) {
            if (isBalanced(input)) {
                System.out.println(input + " is balanced");
            } else {
                System.out.println(input + " is not balanced");
            }
        }
    }

    private void Q6() {
        int[] arr = new int[10];
        Random random = new Random();
        System.out.print("The random numbers are : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Stack<Integer> stack = new Stack<>();
        boolean isOdd = true;
        int currentIndex = 0;
        int iterationRound = 0;
        while (iterationRound != 20) {
            int currentNumber = arr[currentIndex];
            if (currentNumber != -1) {
                if (isOdd && currentNumber % 2 != 0) {
                    stack.push(currentNumber);
                    arr[currentIndex] = -1; // Change value to -1 as done
                    isOdd = false;
                } else if (!isOdd && currentNumber % 2 == 0) {
                    stack.push(currentNumber);
                    arr[currentIndex] = -1;
                    isOdd = true;
                }
            }
            if (currentIndex == arr.length - 1) {
                currentIndex = 0;
                iterationRound++;
            } else {
                currentIndex++;
            }
        }
        System.out.print("The numbers in the stack : ");
        stack.showStack();
        System.out.println("The numbers remain in the array : " + stack.getSize());
    }
}
