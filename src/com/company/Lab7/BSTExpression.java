package com.company.Lab7;

import java.util.Stack;

public class BSTExpression {

    Stack<String> operatorStack = new Stack<>();
    Stack<BSTNode<String>> bstStack = new Stack<>();

    public BSTExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                operatorStack.push(String.valueOf(c));
            } else if (c == ')') {
                while (!operatorStack.peek().contentEquals("(")) {
                    String operator = operatorStack.pop();
                    BSTNode<String> left = bstStack.pop();
                    BSTNode<String> right = bstStack.pop();
                    BSTNode<String> bst = new BSTNode<>(operator, right, left);
                    bstStack.push(bst);
                }
                operatorStack.pop();
            } else if (!isAnOperator(String.valueOf(c))) { //operand
                BSTNode<String> bst = new BSTNode<>(String.valueOf(c), null, null);
                bstStack.push(bst);
            } else { //operator
                if (operatorStack.isEmpty() || getOperatorPrecedence(String.valueOf(c)) > getOperatorPrecedence(operatorStack.peek()) || operatorStack.peek().contentEquals("(")) {
                    operatorStack.push(String.valueOf(c));
                } else {
                    String operator = operatorStack.pop();
                    BSTNode<String> left = bstStack.pop();
                    BSTNode<String> right = bstStack.pop();
                    BSTNode<String> bst = new BSTNode<>(operator, right, left);
                    bstStack.push(bst);
                    operatorStack.push(String.valueOf(c));
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            BSTNode<String> left = bstStack.pop();
            BSTNode<String> right = bstStack.pop();
            BSTNode<String> bst = new BSTNode<>(operator, right, left);
            bstStack.push(bst);
        }
        BSTNode<String> root = bstStack.pop();

        System.out.println("The number of elements in the tree : " + getSize(root));

        System.out.print("The tree elements - INORDER : ");
        inOrder(root);
        System.out.println();

        System.out.print("The tree elements - PREORDER : ");
        preOrder(root);
        System.out.println();

        System.out.print("The tree elements - POSTORDER : ");
        postOrder(root);
        System.out.println();
    }

    private boolean isAnOperator(String c) {
        if (c.contentEquals("+") || c.contentEquals("-") ||
                c.contentEquals("*") || c.contentEquals("/") ||
                c.contentEquals("%")) return true;
        return false;
    }

    private int getOperatorPrecedence(String c) {
        if (c.contentEquals("*") || c.contentEquals("/") || c.contentEquals("%")) return 1;
        return 0;
    }

    public void inOrder(BSTNode<String> a) {
        if (a != null) {
            inOrder(a.getLeftLink());
            System.out.print("<-- " + a.getData() + " ");
            inOrder(a.getRightLink());
        }
    }

    public void preOrder(BSTNode<String> a) {
        if (a != null) {
            System.out.print("<-- " + a.getData() + " ");
            preOrder(a.getLeftLink());
            preOrder(a.getRightLink());
        }
    }

    public void postOrder(BSTNode<String> a) {
        if (a != null) {
            postOrder(a.getLeftLink());
            postOrder(a.getRightLink());
            System.out.print("<-- " + a.getData() + " ");
        }
    }

    public int getSize(BSTNode<String> a) {
        if (a == null) return 0;
        return getSize(a.getLeftLink()) + getSize(a.getRightLink()) + 1;
    }
}
