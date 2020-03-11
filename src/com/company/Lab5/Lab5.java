package com.company.Lab5;

import java.util.Scanner;

public class Lab5 {

    public Lab5() {
//        //Q1
//        Stack<String> stack = new Stack<>();
//        stack.push("Blue");
//        stack.push("Yellow");
//        stack.push("Yellow");
//        stack.push("Orange");
//        stack.push("Blue");
//        stack.push("Red");
//        stack.push("Orange");
//        System.out.println("The candies in the container");
//        stack.showStack();
//        System.out.println("Ali takes all the candies one by one from the container and eats the blue ones.");
//        System.out.println("He puts back the rest of candies in the container");
//        System.out.println("The candies in container: ");
//        Stack<String> newStack = new Stack<>();
//        while(!stack.isEmpty()) {
//            String popped = stack.pop();
//            if (!popped.contains("Blue")) newStack.push(popped);
//        }
//        newStack.showStack();
        //Q2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression : ");
        String infix = scanner.nextLine();
        System.out.println("The infix expression is: " + toSymbol(infix));
        infix = toSymbol(infix);
        System.out.println("The postfix expression is: " + infixToPostfix(infix));
        infix = infixToPostfix(infix);
        countPrefixExpression(infix);

    }

    private String toSymbol(String expression) {
        String newExpression = expression;
        newExpression = newExpression.replace("mul", "*");
        newExpression = newExpression.replace("add", "+");
        newExpression = newExpression.replace("sub", "-");
        newExpression = newExpression.replace("div", "/");
        newExpression = newExpression.replace("mod", "%");
        newExpression = newExpression.replace("ob", "(");
        newExpression = newExpression.replace("cb", ")");
        return newExpression;
    }

    private String infixToPostfix(String expression) {
        String newExpression = "";
        Stack<String> operator = new Stack<>();
        String[] split = expression.split(" ");
        for (int i = 0; i < split.length; i++) {
            String c = split[i];
            if (!isAnOperator(c)) { // its an operand
                newExpression += c + " ";
            } else { // its an operator
                if (operator.isEmpty() || getOperatorPrecedence(c) > getOperatorPrecedence(operator.peek()) || operator.peek().contentEquals("(")) {
                    operator.push(c);
                } else {
                    if (!ifParenthesis(c)) {
                        while (!operator.isEmpty() && getOperatorPrecedence(c) <= getOperatorPrecedence(operator.peek())) {
                            if (operator.peek().contentEquals("(") || operator.peek().contentEquals(")")) break;
                            newExpression += operator.pop() + " ";
                        }
                        operator.push(c);
                    } else { //if got parentheses
                        if (c.contentEquals("(")) {
                            operator.push(c);
                        } else { // close bracket )
                            while (!operator.peek().contentEquals("(")) {
                                newExpression += operator.pop() + " ";
                            }
                            operator.pop();
                        }
                    }
                }
            }
        }
        while (!operator.isEmpty()) newExpression += operator.pop() + " ";
        return newExpression;
    }

    private void countPrefixExpression(String expression) {
        int value;
        Stack<String> stack = new Stack<>();
        String[] split = expression.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            stack.push(split[i]); //read from behind
            if (i <= split.length - 3) {
                String first = stack.pop();
                String second = stack.pop();
                if (!isAnOperator(first) && !isAnOperator(second)) {
                    String newCharacter = evaluate(first, second, stack.pop());
                    stack.push(newCharacter);
                } else {
                    stack.push(second);
                    stack.push(first);
                }
            }
        }
        while(stack.getSize() != 1) {
            String newCharacter = evaluate(stack.pop(), stack.pop(), stack.pop());
            stack.push(newCharacter);
        }
        value = Integer.valueOf(stack.pop());
        System.out.println("The result is: " + value);
    }

    private String evaluate(String operand1, String operand2, String operator) {
        int finalValue = 0;
        int value1 = Integer.valueOf(operand1);
        int value2 = Integer.valueOf(operand2);
        if (operator.contentEquals("+")) {
            finalValue = value1 + value2;
        } else if (operator.contentEquals("-")) {
            finalValue = value1 - value2;
        } else if (operator.contentEquals("*")) {
            finalValue = value1 * value2;
        } else if (operator.contentEquals("/")) {
            finalValue = value1 / value2;
        } else if (operator.contentEquals("%")) {
            finalValue = value1 % value2;
        }
        return String.valueOf(finalValue);
    }

    private boolean isAnOperator(String c) {
        if (c.contentEquals("+") || c.contentEquals("-") ||
                c.contentEquals("*") || c.contentEquals("/") ||
                c.contentEquals("%") || c.contentEquals("(") || c.contentEquals(")")) return true;
        return false;
    }

    private int getOperatorPrecedence(String c) {
        if (c.contentEquals("*") || c.contentEquals("/") || c.contentEquals("%")) return 1;
        return 0;
    }

    private boolean ifParenthesis(String c) {
        if (c.contentEquals("(") || c.contentEquals(")")) return true;
        return false;
    }
}
