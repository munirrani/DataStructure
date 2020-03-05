package com.company.Lab5;

public class Lab5 {

    public Lab5() {
        Stack<String> stack = new Stack<>();
        stack.push("Blue");
        stack.push("Yellow");
        stack.push("Yellow");
        stack.push("Orange");
        stack.push("Blue");
        stack.push("Red");
        stack.push("Orange");
        System.out.println("The candies in the container");
        stack.showStack();
        System.out.println("Ali takes all the candies one by one from the container and eats the blue ones.");
        System.out.println("He puts back the rest of candies in the container");
        System.out.println("The candies in container: ");
        Stack<String> newStack = new Stack<>();
        while(!stack.isEmpty()) {
            String popped = stack.pop();
            if (!popped.contains("Blue")) newStack.push(popped);
        }
        newStack.showStack();
    }
}
