package com.company.Lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5 {

    public Lab5() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
    }

    private void Q1() {
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

    private void Q2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression : ");
        String infix = scanner.nextLine();
        System.out.println("The infix expression is: " + toSymbol(infix));
        infix = toSymbol(infix);
        System.out.println("The postfix expression is: " + infixToPostfix(infix));
        infix = infixToPostfix(infix);
        countPostfixExpression(infix);
    }

    private void Q3() {
        NQueen nQueen = new NQueen();
    }

    private void Q4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a expression : ");
        String input = scanner.nextLine();
        System.out.println(input);
        checkExpression(input);
    }

    private void Q5() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("test-4.xml")));
            Stack<String> element = new Stack<>();
            String[] lines = new String[10];
            String line = "";
            String temp;
            System.out.println("Contents of XML file");

            int count = 0;
            while (scanner.hasNextLine()) {
                lines[count] = scanner.nextLine();
                System.out.println(lines[count++]);
            }
            for (int i = 0; i < lines.length; i++) {
                line = lines[i];
                if (line == null) break;
                temp = line;
                while (true) {
                    if (!temp.contains("\\/")) {
                        temp = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
                        element.push(temp);
                        element = checkXML(element);
                        line = line.replace("<" + temp + ">", "");
                    } else {
                        temp = line.substring(line.indexOf("</") + 1, line.indexOf(">"));
                        element.push(temp);
                        element = checkXML(element);
                        line = line.replace("</" + temp + ">", "");
                    }
                    if (element.isEmpty() || !line.contains("<")) break;
                }
                if (element.isEmpty()) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Q6() {
        Maze maze = new Maze();
    }

    private Stack<String> checkXML(Stack<String> stack) {
        String first, second;
        if (stack.getSize() >= 2) { //check for duplicate entries
            first = stack.pop();
            second = stack.peek();
            if (first.contentEquals(second)) {
                System.out.println("Duplicate root element " + "<" + first + ">");
                while (!stack.isEmpty()) stack.pop(); // terminate
                return stack;
            } else {
                stack.push(first);
            }
        }
        if (stack.peek().contains("/")) { //check if the closing </> is the same name
            first = stack.pop();
            second = stack.peek();
            if (first.replace("/","").contentEquals(second)) {
                stack.pop();
            }
            if (!first.replace("/","").contentEquals(second)) {
                System.out.println("Begin element : " + "<" + second + ">" + " Invalid ending element : " +
                        "<" + first + ">");
                while (!stack.isEmpty()) stack.pop(); // terminate
                return stack;
            }
        }
        if (stack.isEmpty()) {
            System.out.println("The xml document is valid");
        }
        return stack;
    }

    private void checkExpression(String expression) {
        Stack<Character> symbol = new Stack<>();
        char c, first, second, third;
        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if (c == '\\') {
                i++;
                continue;
            }

            if (isOpenBracket(c)) {
                symbol.push(c);
            } else if (isCloseBracket(c)) {
                if (!symbol.isEmpty()) {
                    first = symbol.peek();
                    if (getPair(first) == c) {
                        symbol.pop();
                    } else if (getPair(first) != c) {
                        for (int a = 0; a < i; a++) System.out.print(" ");
                        System.out.print("^ Missing " + getPair(first));
                        System.out.println();
                        break;
                    }
                } else { //Stack is empty but suddenly found a close bracket
                    for (int a = 0; a < i; a++) System.out.print(" ");
                    System.out.print("^ Extra " + c);
                    System.out.println();
                    break;
                }
            }

            if (c == ';' && !symbol.isEmpty() && isOpenBracket(symbol.peek())) {
                for (int a = 0; a < i; a++) System.out.print(" ");
                System.out.print("^ Missing " + getPair(symbol.peek()));
                System.out.println();
                break;
            }
        }

        if (symbol.getSize() == 0) {
            System.out.println("The expression is balanced, as all things should be");
        }
    }

    private boolean isOpenBracket(char c) {
        if (c == '(' || c == '{' || c == '[') return true;
        return false;
    }

    private boolean isCloseBracket(char c) {
        if (c == ')' || c == '}' || c == ']') return true;
        return false;
    }

    private char getPair(char c) {
        if (c == '(') {
            return ')';
        } else if (c == ')') {
            return '(';
        } else if (c == '[') {
            return ']';
        } else if (c == ']') {
            return '[';
        } else if (c == '{') {
            return '}';
        } else if (c == '}') {
            return '{';
        }
        return 0;
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

    private void countPostfixExpression(String expression) {
        int value;
        Stack<String> stack = new Stack<>();
        String[] split = expression.split(" ");
        for (int i = 0; i < split.length; i++) {
            stack.push(split[i]);
            if (isAnOperator(split[i])) {
                String newCharacter = evaluate(stack.pop(), stack.pop(), stack.pop());
                stack.push(newCharacter);
            }
        }
        value = Integer.valueOf(stack.pop());
        System.out.println("The result is: " + value);
    }

    private String evaluate(String operator, String operand2, String operand1) {
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
