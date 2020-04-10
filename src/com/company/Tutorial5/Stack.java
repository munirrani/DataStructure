package com.company.Tutorial5;

public class Stack<T extends Comparable> {

    private ListNode top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        int count = 0;
        ListNode currentNode = top;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void push(T data) {
        top = new ListNode(data, top);
    }

    public T pop() {
        if (top == null) return null;
        ListNode topNode = top;
        ListNode belowNode = top.getLink();
        top.setLink(null);
        top = belowNode;
        return (T) topNode.getData();
    }

    public T peek() {
        if (top == null) {
            return null;
        } else {
            return (T) top.getData();
        }
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            ListNode currentNode = top;
            while (currentNode != null) {
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
            System.out.println();
        }
    }
}
