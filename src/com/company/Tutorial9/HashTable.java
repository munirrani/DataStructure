package com.company.Tutorial9;

public class HashTable<K, V> {

    private MapNode head;

    public HashTable() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        int count = 0;
        MapNode currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }

    public void showHashTable() {
        MapNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();
    }

    public void clear() {
        head = null;
    }

    public V put(Comparable<K> key, V value) {
        if (isEmpty()) {
            head = new MapNode(key, value, null);
        } else {
            MapNode currentNode = head;
            MapNode previousNode = null;
            MapNode newNode = new MapNode(key, value, null);
            while (currentNode != null) {
                if (key.compareTo((K)currentNode.getKey()) == 0) {
                    V temp = (V) currentNode.getValue();
                    currentNode.setValue(value);
                    return temp;
                }
                previousNode = currentNode;
                currentNode = currentNode.getLink();
            }
            if (previousNode != null) {
                previousNode.setLink(newNode);
            }
        }
        return null;
    }

    public V get(Comparable<K> key) {
        if (isEmpty()) {
            return null;
        } else {
            MapNode currentNode = head;
            while (currentNode != null) {
                if (key.compareTo((K)currentNode.getKey()) == 0) {
                    return (V) currentNode.getValue();
                }
                currentNode = currentNode.getLink();
            }
        }
        return null;
    }

    public boolean containsKey(Comparable<K> key) {
        if (isEmpty()) {
            return false;
        } else {
            MapNode currentNode = head;
            while (currentNode != null) {
                if (key.compareTo((K)currentNode.getKey()) == 0) {
                    return true;
                }
                currentNode = currentNode.getLink();
            }
        }
        return false;
    }

}
