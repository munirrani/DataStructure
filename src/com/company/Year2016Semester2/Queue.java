package com.company.Year2016Semester2;

public class Queue<Item> {

    private Node head;

    public Queue() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node currentNode = head;
        while (currentNode.getLink() != null) {
            count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }

    public Item peek() {
        return (Item) head.getData();
    }

    public void enqueue(Item data) {
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
    }

    public Item dequeue() {
        Item data = (Item) head.getData();
        head = head.getLink();
        return data;
    }

    public String toString() {
        Node currentNode = head;
        String str = "";
        while (currentNode != null) {
            str += currentNode.getData() + " ";
            currentNode = currentNode.getLink();
        }
        System.out.println();
        return str;
    }

    public void ChangeOrder(int k) {
        for (int i = 0; i < k-1; i++) enqueue(dequeue());
    }

    class Node<Item> {

        private Item data;
        private Node link;

        public Node(Item data, Node link) {
            this.data = data;
            this.link = link;
        }

        public Item getData() {
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
