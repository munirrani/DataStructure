package com.company;

public class CircularLinkedList<T extends Comparable> {

    ListNode head;
    ListNode tail;

    public CircularLinkedList() {
        head = null;
    }

    public int length() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
            if (head == currentNode) break;
        }
        return count;
    }

    public void showCircularList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
            if (head == currentNode) {
                System.out.print(currentNode.toString().replace(" -->", ""));
                break;
            }
        }
        System.out.println();
    }

    public void addCircularNode(T data) {
        ListNode currentNode = head;
        if (head == null) {
            ListNode newNode = new ListNode(data, null);
            head = newNode;
            newNode.setLink(newNode);
        } else {
            while (currentNode.getLink() != head) {
                currentNode = currentNode.getLink();
            }
            ListNode newNode = new ListNode(data, head);
            currentNode.setLink(newNode);
        }
    }

    public void deleteCircularNode() {
        ListNode currentNode = head;
        if (length() == 1) {
            head = null;
        } else {
            while (currentNode.getLink().getLink() != head) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(head);
        }
    }

    public T getCircularItem(int index) {
        ListNode currentNode = head;
        if (index >= length()) throw new IndexOutOfBoundsException();
        int count = 0;
        while (currentNode.getLink() != head) {
            if(count == index) break;
            currentNode = currentNode.getLink();
            count++;
        }
        return (T) currentNode.getData();
    }
}
