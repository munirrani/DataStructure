package com.company.Tutorial8;

import com.company.Lab4.ListNode;

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

    public void swapByIndex(int i, int j) {
        T first = get(i);
        T second = get(j);
        set(i, second);
        set(j, first);
    }

    public int getMinimumAfterIndex(int index) {
        if (index >= length() || index < 0 || isEmpty()) {
            return -1;
        } else {
            int count = 0;
            ListNode currentNode = head;
            while (currentNode.getLink() != null && count != index+1) {
                count++;
                currentNode = currentNode.getLink();
            }
            int minIndex = count;
            T min = (T) currentNode.getData();
            while (currentNode.getLink() != null) {
                if (min.compareTo((T)currentNode.getData()) > 0) {
                    min = (T) currentNode.getData();
                    minIndex = count;
                }
                count++;
                currentNode = currentNode.getLink();
            }
            return minIndex;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < length() - 1; i++) {
            swapByIndex(i, getMinimumAfterIndex(i));
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < length() - 1; i++) {
            for (int j = 0; j < length() - 1; j++) {
                T first = get(j);
                T second = get(j + 1);
                if (first.compareTo(second) < 0) {
                    swapByIndex(j, j + 1);
                }
            }
        }
    }
}
