package com.company.Tutorial4;

import java.util.Random;

public class LinkedList<T extends Comparable<T>> {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public int length() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void showList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();
    }

    public void addNode(T t) {
        ListNode newNode = new ListNode(t, null);
        ListNode currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    public void addTenPointFive() {
        ListNode<T> currentNode = head;
        Double value;
        while (currentNode != null) {
            value = (Double) currentNode.getData();
            if (value > 20) {
                value += 10.5;
                currentNode.setData((T) value);
            }
            currentNode = currentNode.getLink();
        }
    }

    public T get(int index) {
        if (index >= length() || index < 0 || head == null) {
            return  null;
        } else {
            int count = 0;
            ListNode currentNode = head;
            while (currentNode.getLink() != null && count != index) {
                currentNode = currentNode.getLink();
                count++;
            }
            return (T) currentNode.getData();
        }
    }

    public void set(int index, T data) {
        if (index >= length() || index < 0 || head == null) {
            return;
        } else {
            int count = 0;
            ListNode currentNode = head;
            while (currentNode.getLink() != null && count != index) {
                currentNode = currentNode.getLink();
                count++;
            }
            currentNode.setData(data);
        }
    }

    public int getSumOfInteger() {
        int sum = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            Integer num = (Integer) currentNode.getData();
            sum += num;
            currentNode = currentNode.getLink();
        }
        return sum;
    }

    public int getTotalEvenNumber() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            Integer num = (Integer) currentNode.getData();
            if (num % 2 == 0) count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }

    Random random = new Random();

    public void addRandom(int min, int max) {
        Integer t = random.nextInt(max - min + 1) + min;
        addNode((T)t);
    }

    public void removeAll(T t) {
        T data = (T) head.getData();
        if (isEmpty()) return;
        if (t.compareTo(data) == 0) {
            while (t.compareTo(data) == 0) { // Consider when two same numbers are beside one another
                head = head.getLink();
                data = (T) head.getData();
            }
        }
        ListNode currentNode = head;
        while (currentNode.getLink() != null) {
            data = (T) currentNode.getLink().getData();
            if (data.compareTo(t) == 0) {
                while (data.compareTo(t) == 0) { // Same case
                    currentNode.setLink(currentNode.getLink().getLink());
                    if(currentNode.getLink() != null) {
                        data = (T) currentNode.getLink().getData();
                    } else {
                        break;
                    }
                }
            } else {
                currentNode = currentNode.getLink();
            }
        }
    }

    public void addFrontNode(T t) {
        head =  new ListNode(t, head);
    }

    public T getMiddle() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode.getLink() != null && count != length()/2) {
            currentNode = currentNode.getLink();
            count++;
        }
        return (T) currentNode.getData();
    }
}
