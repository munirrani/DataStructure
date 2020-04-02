package com.company.Lab6;

import com.company.Lab4.ListNode;

public class PriorityQueue<T extends Comparable<T>> {

    private ListNode<T> head;

    public PriorityQueue() {
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

    public void priorityEnqueue (T data) {
        if (head == null) {
            head = new ListNode(data, null);
        } else if (data.compareTo((head.getData())) > 0) {
            head = new ListNode<>(data, head);
        } else {
            ListNode currentNode = head;
            while (true) {
                if(currentNode.getLink() != null) {
                    if (data.compareTo((T)currentNode.getLink().getData()) > 0) {
                        ListNode newNode = new ListNode(data, currentNode.getLink());
                        currentNode.setLink(newNode);
                        break;
                    } else { // move to the next node
                        currentNode = currentNode.getLink();
                    }
                } else { // add to the last element
                    ListNode newNode;
                    newNode = new ListNode(data, null);
                    currentNode.setLink(newNode);
                    break;
                }
            }
        }
    }

    public void enqueue(T data) {
        ListNode newNode = new ListNode(data, null);
        if (head == null) {
            head = newNode;
        } else {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) currentNode = currentNode.getLink();
            currentNode.setLink(newNode);
        }
    }

    public T priorityDequeue() {
        if (head == null) {
            return null;
        } else if (getSize() == 1) {
            T data =  (T) head.getData();
            head = head.getLink();
            return data;
        } else {
            ListNode currentNode = head;
            Packet data = (Packet) head.getData();
            int highestPriority = getHighestPriorityInQueue();
            if (data.getPriority() == highestPriority) { // Remove the head if its the highest priority
                head = head.getLink();
                return (T) data;
            }

            while (currentNode != null) {
                data = (Packet) currentNode.getLink().getData();
                if (data.getPriority() == highestPriority) {
                    ListNode tempNode = currentNode.getLink().getLink();
                    currentNode.setLink(tempNode);
                    break;
                }
                currentNode = currentNode.getLink();
            }
            return (T) data;
        }
    }

    private int getHighestPriorityInQueue() {
        int priority = 0;
        if (isEmpty()) {
            return -1;
        } else {
            ListNode currentNode = head;
            Packet data;
            while (currentNode != null) {
                data = (Packet) currentNode.getData();
                if (priority < data.getPriority()) priority = data.getPriority();
                currentNode = currentNode.getLink();
            }
        }
        return priority;
    }

    public void minQueue(T data) {
        if (head == null) {
            head = new ListNode(data, null);
        } else if (data.compareTo((head.getData())) < 0) {
            head = new ListNode<>(data, head);
        } else if(data.compareTo(head.getData()) == 0) {
            head.setData(data);
        } else {
            ListNode currentNode = head;
            while (true) {
                if(currentNode.getLink() != null) {
                    if (data.compareTo((T)currentNode.getLink().getData()) < 0) {
                        ListNode newNode = new ListNode(data, currentNode.getLink());
                        currentNode.setLink(newNode);
                        break;
                    } else if(data.compareTo((T)currentNode.getLink().getData()) == 0) {
                        currentNode.getLink().setData(data);
                        break;
                    } else { // move to the next node
                        currentNode = currentNode.getLink();
                    }
                } else { // add to the last element
                    ListNode newNode;
                    newNode = new ListNode(data, null);
                    currentNode.setLink(newNode);
                    break;
                }
            }
        }
    }

    public T deqeue() {
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
