package com.company.Year2016Semester2;

public class LinkedList<T extends Comparable<T>> {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(T data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
        System.out.println("Adding: " + data);
    }

    public void addAfter(T data, T currentData) {
        Node currentNode = head;
        if (currentData.compareTo((T)head.getData()) != 0) {
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
                if (currentNode != null & currentData.compareTo((T) currentNode.getData()) == 0) {
                    break;
                }
            }
        }
        Node newNode = new Node(data, null);
        if (currentNode.getLink() != null) {
            newNode.setLink(currentNode.getLink());
        }
        currentNode.setLink(newNode);
        System.out.println("Adding " + data + " after " + currentData);
    }

    public void deleteFront() {
        System.out.println("Deleting front: "  + head.getData());
        System.out.println();
        head = head.getLink();
    }

    public void deleteAfter(T data) {
        Node currentNode = head;
        while (currentNode.getLink() != null) {
            if (data.compareTo((T)currentNode.getData()) == 0) {
                break;
            }
            currentNode = currentNode.getLink();
        }
        System.out.println("Testing deleteAfter:");
        if (data.compareTo((T)currentNode.getData()) != 0) {
            System.out.println("Element (" + data + ") not found");
        } else {
            System.out.println("After " + currentNode.getData() + " is " +
                    currentNode.getLink().getData() + ". Deleting " +
                    currentNode.getLink().getData());
            currentNode.setLink(currentNode.getLink().getLink());
        }
        System.out.println();
    }

    public void traverse() {
        Node currentNode = head;
        System.out.println("Showing the content of my linked list: ");
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getLink();
        }
        System.out.println();
        System.out.println();
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
