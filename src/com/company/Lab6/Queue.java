package com.company.Lab6;

import com.company.Lab4.ListNode;

public class Queue<T> {

    private ListNode<T> head;

    public Queue() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        int count = 0;
        if (isEmpty()) return count;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void enqeue (T data) {
        ListNode newNode = new ListNode(data, null);
        if (head == null) {
            head = newNode;
        } else {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) currentNode = currentNode.getLink();
            currentNode.setLink(newNode);
        }
    }


    public T dequeue() {
        if (head == null) {
            return null;
        } else {
            T data =  (T) head.getData();
            head = head.getLink();
            return data;
        }
    }

    public T peek() {
        if (head == null) return null;
        return (T) head.getData();
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            ListNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
            System.out.println();
        }
    }
}
