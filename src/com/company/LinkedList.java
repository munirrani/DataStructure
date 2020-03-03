package com.company;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
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

    public void deleteNode() {
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head != null) {
            if (currentNode.getLink() == null) {
                head = null;
            } else {
                while (currentNode.getLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        } else {
            System.out.println("List is empty");
        }
    }

    public void addFrontNode(T t) {
        head =  new ListNode(t, head);
    }

    public void addSortNode(T t) {
        if (head == null) { //if there's nothing on the linked
            addNode(t);
        } else {
            T currentNodeData = (T) head.getData();
            if (t.compareTo(currentNodeData) < 0) {
                addFrontNode(t);
            } else {
                ListNode currentNode = head;
                T number;
                while (true) {
                    //System.out.println(t + " " + number);
                    if(currentNode.getLink() != null) {
                        if (t.compareTo((T)currentNode.getLink().getData()) < 0) { //IT WORKS!!!
                            ListNode newNode = new ListNode(t, currentNode.getLink());
                            currentNode.setLink(newNode);
                            break;
                        } else { // move to the next node
                            currentNode = currentNode.getLink();
                            number = (T) currentNode.getData();
                        }
                    } else { // add to the last element
                        ListNode newNode;
                        newNode = new ListNode(t, null);
                        currentNode.setLink(newNode);
                        break;
                    }

                }

            }
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

    public void removeAtIndex(int index) {
        if (index >= length() || index < 0 || head == null) {
            return;
        } else if (index == 0) {
            deleteFrontNode();
        } else if (index == length()-1) {
            deleteNode();
        } else {
            int count = 0;
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                if (count == index) {
                    break;
                } else {
                    currentNode = currentNode.getLink();
                    count++;
                }
            }
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
        }
    }

    public void splitList() {
        System.out.println("Split the list into two");
        ListNode currentNode = head;
        ListNode secondNode;
        ListNode middleNode;
        int length = length() / 2;
        if (length() % 2 != 0) length++;

        int index;
        System.out.print("First List: ");
        for (index = 0; index < length; index++) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();

        secondNode = currentNode;
        middleNode = currentNode;

        for (int i = index; i < length(); i++) {
            secondNode.setLink(currentNode.getLink());
            if (currentNode.getLink() != null) {
                secondNode = secondNode.getLink();
                currentNode = currentNode.getLink();
            }
        }

        secondNode = middleNode;
        System.out.print("Second List: ");
        while (secondNode != null) {
            System.out.print(secondNode.toString());
            secondNode = secondNode.getLink();
        }
        System.out.println();
    }

    public void alternateSplit() {
        System.out.println("Split the list by alternating the nodes");
        ListNode currentNode = head;

        ListNode currentFirstNode = new ListNode(head.getData(), null);
        ListNode firstListFirstNode = currentFirstNode;
        ListNode currentSecondNode = new ListNode(head.getLink().getData(), null);
        ListNode secondListFirstNode = currentSecondNode;

        while (currentNode.getLink() != null) {
            currentNode = currentNode.getLink();
            if (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
                ListNode newNode = new ListNode(currentNode.getData(), null);
                currentFirstNode.setLink(newNode);
                currentFirstNode = currentFirstNode.getLink();
            }
            if (currentNode.getLink() != null) {
                ListNode newNode2 = new ListNode(currentNode.getLink().getData(), null);
                currentSecondNode.setLink(newNode2);
                currentSecondNode = currentSecondNode.getLink();
            }
        }

        currentFirstNode = firstListFirstNode;
        System.out.print("First list: ");
        while (currentFirstNode != null) {
            System.out.print(currentFirstNode.toString());
            currentFirstNode = currentFirstNode.getLink();
        }
        System.out.println();

        currentSecondNode = secondListFirstNode;
        System.out.print("Second list: ");
        while (currentSecondNode != null) {
            System.out.print(currentSecondNode.toString());
            currentSecondNode = currentSecondNode.getLink();
        }
        System.out.println();
    }

    public void mergeList() {
        System.out.println("Merge the First List and Second List by alternating the nodes");
        ListNode currentNode = head;

        ListNode currentFirstNode = new ListNode(head.getData(), null);
        ListNode firstListFirstNode = currentFirstNode;
        ListNode currentSecondNode = new ListNode(head.getLink().getData(), null);
        ListNode secondListFirstNode = currentSecondNode;

        while (currentNode.getLink() != null) {
            currentNode = currentNode.getLink();
            if (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
                ListNode newNode = new ListNode(currentNode.getData(), null);
                currentFirstNode.setLink(newNode);
                currentFirstNode = currentFirstNode.getLink();
            }
            if (currentNode.getLink() != null) {
                ListNode newNode2 = new ListNode(currentNode.getLink().getData(), null);
                currentSecondNode.setLink(newNode2);
                currentSecondNode = currentSecondNode.getLink();
            }
        }

        currentFirstNode = firstListFirstNode;
        currentSecondNode = secondListFirstNode;

        ListNode mergeList = new ListNode(currentFirstNode.getData(), new ListNode(currentSecondNode.getData(), null));
        ListNode mergeListFirstNode = mergeList;
        mergeList = mergeList.getLink();
        while (currentFirstNode.getLink() != null || currentSecondNode.getLink() != null) {
            currentFirstNode = currentFirstNode.getLink(); //traverse awal
            mergeList.setLink(new ListNode(currentFirstNode.getData(), null));
            mergeList = mergeList.getLink();

            if (currentSecondNode.getLink() != null) { //Avoid NPE for words with odd total number of characters
                currentSecondNode = currentSecondNode.getLink();
                mergeList.setLink(new ListNode(currentSecondNode.getData(), null));
                mergeList = mergeList.getLink();
            }
        }

        mergeList = mergeListFirstNode;
        while (mergeList != null) {
            System.out.print(mergeList.toString());
            mergeList = mergeList.getLink();
        }
        System.out.println();
    }

    public void reverseList(ListNode node) {
        if (head.getLink() != null) {
            ListNode newNode = new ListNode(head.getData(), node);
            head = head.getLink();
            reverseList(newNode);
        } else {
            head = new ListNode(head.getData(), node); // last node
            showList();
        }
    }

    public void deleteFrontNode() {
        if (head != null) {
            head = head.getLink();
        } else {
            System.out.println("List is empty");
        }
    }

    public boolean contains(T t) {
        ListNode currentNode = head;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getData()) == 0) return true;
            currentNode = currentNode.getLink();
        }
        return false;
    }

    public LinkedListIterator listIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<T> implements Iterator<T> {

        private ListNode<T> currentNode = head;
        private int count = -1;

        @Override
        public boolean hasNext() {
            count++;
            return currentNode.getLink() != null;
        }

        @Override
        public T next() {
            T data = (T) currentNode.getData();
            currentNode = currentNode.getLink();
            return data;
        }

        @Override
        public void remove() {
            System.out.println(count);
            removeAtIndex(count);
        }
    }
}
