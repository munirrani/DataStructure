package com.company.Year2016Semester2;

// Doubly Circular Linked List
public class Day<T> {

    private Node head;

    public Day() {
        head = null;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node(data, null);
            head.setLink(head);
        } else {
            Node currentNode = head;
            Node newNode = new Node(data, head);
            while (currentNode.getLink() != head) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    public void showDay() {
        int index = 1;
        Node currentNode = head;
        while (currentNode.getLink() != head) {
            System.out.println(index + " for " + currentNode.toString());
            currentNode = currentNode.getLink();
            index++;
        }
        System.out.println(index + " for " + currentNode.toString());
    }

    public T getDay(int index) {
        if (index == 1) {
            return (T) head.getData();
        } else {
            int count = 1;
            Node currentNode = head;
            while (currentNode.getLink() != head && count != index) {
                count++;
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }

    public T getPreviousDay(int number) {
        if (number == 1) {
            return getDay(7);
        } else {
            return getDay(number - 1);
        }
    }

    public T getNextDay(int number) {
        if (number == 7) {
            return getDay(1);
        } else {
            return getDay(number + 1);
        }
    }

    public T getDaysAfter(int index, int daysAfter) {
        Node currentNode = head;
        if (daysAfter == 1) {
            return getPreviousDay(index);
        } else {
            int count = 1;
            while (currentNode.getLink() != head && count != index) {
                count++;
                currentNode = currentNode.getLink();
            }
            while (daysAfter != 0) {
                currentNode = currentNode.getLink();
                daysAfter--;
            }
            return (T) currentNode.getData();
        }
    }

    class Node<T> {
        private T data;
        private Node link;

        public Node(T data, Node link) {
            this.data = data;
            this.link = link;
        }

        public T getData() {
            return data;
        }

        public Node getLink() {
            return link;
        }

        public void setLink(Node newLink) {
            link = newLink;
        }

        public String toString() {
            return data.toString() + " ->";
        }
    }
}
