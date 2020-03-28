package com.company.Lab9;

public class ArrayHashTable<K,V> {

    private static final int MAX_SIZE = 20;
    private Entry<K,V>[] nodes = new Entry[MAX_SIZE];

    public boolean isEmpty() { return getSize() == 0; }
    public boolean isFull() { return getSize() == MAX_SIZE; }
    public int getSize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) if (nodes[i] != null) count++;
        return count;
    }

    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) nodes[i] = null;
    }

    public void showHashTable() {
        for (int i = 0; i < MAX_SIZE; i++) if (nodes[i] != null) System.out.print(nodes[i].toString() + " ");
        System.out.println();
    }

    public boolean containsKey(Comparable<K> key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (nodes[i] != null && key.compareTo(nodes[i].getKey()) == 0) return true;
        }
        return false;
    }

    public boolean containsValue(Comparable<V> value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (nodes[i] != null && value.compareTo(nodes[i].getValue()) == 0) return true;
        }
        return false;
    }

    public V get(Comparable<K> key) {
        for (int i = 0; i < MAX_SIZE; i++) if (nodes[i] != null && key.compareTo(nodes[i].getKey()) == 0) return nodes[i].getValue();
        return null;
    }

    public V put(Comparable<K> key, V value) {
        if (isFull()) {
            System.out.println("The Hash Table is full");
            return null;
        }
        if (containsKey(key)) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if(nodes[i] != null && key.compareTo(nodes[i].getKey()) == 0) {
                    V temp = nodes[i].getValue();
                    nodes[i].setValue(value);
                    return temp;
                }
            }
        } else {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (nodes[i] == null) {
                    nodes[i] = new Entry(key, value);
                    break;
                }
            }
        }
        return null;
    }

    public V remove(Comparable<K> key) {
        if (isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (nodes[i] != null && key.compareTo(nodes[i].getKey()) == 0) {
                    V value = nodes[i].getValue();
                    nodes[i] = null;
                    return value;
                }
            }
        }
        return null;
    }

}
