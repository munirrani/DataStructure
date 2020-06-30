package com.company.Finals;

public class LinkedList<T extends Comparable<T>> {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
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

    public void showList() {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
            System.out.println();
        } else {
            System.out.println("List is empty");
        }
    }

    public T get(int index) {
        if (index >= length() || index < 0 || head == null) {
            return null;
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

    public void deleteNode(T a) {
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head != null) {
            if (a.compareTo((T)head.getData()) == 0) { //head
                head = head.getLink();
            } else {
                while (currentNode.getLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                    if (a.compareTo((T)currentNode.getData()) == 0) {
                        break;
                    }
                }
                previousNode.setLink(currentNode.getLink());
            }
        } else {
            System.out.println("List is empty");
        }
    }

    public boolean addSpecialNode(T t) {
        Integer number = (Integer) t;
        if (number < 100 || number > 999) return false;
        int firstDigit = number/100;

        ListNode currentNode = head;
        while (currentNode.getLink() != null) {
            currentNode = currentNode.getLink();
        }

        Integer currentNumber = (Integer) currentNode.getData();
        int lastDigit = (currentNumber%100) % 10;
        if (firstDigit == lastDigit) {
            ListNode newNode = new ListNode(t, null);
            currentNode.setLink(newNode);
            return true;
        } else {
            return false;
        }
    }
}
