package com.company.Lab4;

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
                while (true) {
                    if(currentNode.getLink() != null) {
                        if (t.compareTo((T)currentNode.getLink().getData()) < 0) {
                            ListNode newNode = new ListNode(t, currentNode.getLink());
                            currentNode.setLink(newNode);
                            break;
                        } else { // move to the next node
                            currentNode = currentNode.getLink();
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
                if (count == index - 1) {
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

    public LinkedList<T> splitList(int index) {
        LinkedList<T> linkedList = new LinkedList<>();
        int length = length() / 2;
        if (length() % 2 != 0) length++;

        ListNode currentNode = head;
        int count = 0;
        if (index == 1) {
            while (currentNode != null && count != length) {
                linkedList.addNode((T)currentNode.getData());
                count++;
                currentNode = currentNode.getLink();
            }
        } else {
            while (currentNode != null && count != length) {
                count++;
                currentNode = currentNode.getLink();
            }
            while (currentNode != null) {
                linkedList.addNode((T)currentNode.getData());
                currentNode = currentNode.getLink();
            }
        }
        return linkedList;
    }

    public LinkedList<T> alternateSplit(int index) {
        LinkedList<T> linkedList = new LinkedList<>();
        ListNode currentNode = head;
        while (true) {
            if (index == 1 && currentNode != null) linkedList.addNode((T)currentNode.getData());
            currentNode = currentNode.getLink();
            if (currentNode == null) break;
            if (index == 2 && currentNode != null) linkedList.addNode((T)currentNode.getData());
            currentNode = currentNode.getLink();
            if (currentNode == null) break;
        }
        return linkedList;
    }

    public LinkedList<T> mergeList(LinkedList<T> firstLinkedList, LinkedList<T> secondLinkedList) {
        LinkedList<T> linkedList = new LinkedList<>();
        ListNode firstListCurrentNode = firstLinkedList.getHead();
        ListNode secondListCurrentNode = secondLinkedList.getHead();
        while (firstListCurrentNode != null) {
            if (firstListCurrentNode != null) {
                linkedList.addNode((T)firstListCurrentNode.getData());
                firstListCurrentNode = firstListCurrentNode.getLink();
            }
            if (secondListCurrentNode != null) {
                linkedList.addNode((T) secondListCurrentNode.getData());
                secondListCurrentNode = secondListCurrentNode.getLink();
            }
        }
        return linkedList;
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

    public int getOccurence(T t) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getData()) == 0) count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }

    public boolean containsFromRange(T a, T b) {
        ListNode currentNode = head;
        T data;
        while (currentNode != null) {
            data = (T) currentNode.getData();
            if ((a.compareTo(data) == 0 || a.compareTo(data) > 0) && (b.compareTo(data) == 0 || b.compareTo(data) < 0)) return true;
            currentNode = currentNode.getLink();
        }
        return false;
    }

    public int getOccurenceFromRange(T a, T b) {
        ListNode currentNode = head;
        int count = 0;
        T data;
        while (currentNode != null) {
            data = (T) currentNode.getData();
            if ((a.compareTo(data) == 0 || a.compareTo(data) > 0) && (b.compareTo(data) == 0 || b.compareTo(data) < 0)) count++;
            currentNode = currentNode.getLink();
        }
        return count;
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
            return currentNode != null;
        }

        @Override
        public T next() {
            T data = (T) currentNode.getData();
            currentNode = currentNode.getLink();
            return data;
        }

        @Override
        public void remove() {
            removeAtIndex(count);
            count--;
        }
    }
}
