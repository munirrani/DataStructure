package com.company.Lab9;

import java.util.LinkedList;

public class ArrayHashTableChain<K,V> {

    public final int MAX_SIZE = 20;
    private LinkedList<Entry<K,V>>[] entries = new LinkedList[MAX_SIZE];

    public boolean isEmpty() { return getArraySize() == 0; }
    public boolean isFull() { return getArraySize() == MAX_SIZE; }
    public int getArraySize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) if (entries[i] != null) count++;
        return count;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            LinkedList<Entry<K,V>> entryLinkedList = entries[i];
            if (entryLinkedList != null) count += entryLinkedList.size();
        }
        return count;
    }

    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) entries[i] = null;
    }

    public void showHashTable() {
        for (int i = 0; i < MAX_SIZE; i++) {
            LinkedList<Entry<K,V>> entryLinkedList = entries[i];
            if (entryLinkedList != null) {
                for (int j = 0; j < entryLinkedList.size(); j++) {
                    System.out.println(entryLinkedList.get(j).toString().replace(" |", ""));
                }
            }
        }
    }

    public boolean containsKey(Comparable<K> key) {
        int keyHash = getKeyHash((Integer)key);
        LinkedList<Entry<K,V>> entryLinkedList = entries[keyHash];
        if (entryLinkedList != null) {
            for (int i = 0; i < entryLinkedList.size(); i++) {
                Entry<K, V> entry = entryLinkedList.get(i);
                if (key.compareTo(entry.getKey()) == 0) return true;
            }
        }
        return false;
    }

    public boolean containsValue(Comparable<V> value) {
        for (int i = 0; i < entries.length; i++) {
            LinkedList<Entry<K,V>> entryLinkedList = entries[i];
            if (entryLinkedList != null) {
                for (int j = 0; j < entryLinkedList.size(); j++) {
                    Entry<K, V> entry = entryLinkedList.get(j);
                    if (value.compareTo(entry.getValue()) == 0) return true;
                }
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        int keyHash = getKeyHash((Integer)key);
        LinkedList<Entry<K,V>> entryLinkedList = entries[keyHash];
        if (entryLinkedList != null) {
            for (int i = 0; i < entryLinkedList.size(); i++) {
                Entry<K, V> entry = entryLinkedList.get(i);
                if (key.compareTo(entry.getKey()) == 0) {
                    V value = entry.getValue();
                    return value;
                }
            }
        }
        return null;
    }

    public void printLocation(Comparable<K> key) {
        int keyHash = getKeyHash((Integer)key);
        LinkedList<Entry<K,V>> entryLinkedList = entries[keyHash];
        if (entryLinkedList != null) {
            for (int i = 0; i < entryLinkedList.size(); i++) {
                Entry<K, V> entry = entryLinkedList.get(i);
                System.out.print(entry.toString().replace("|", "-->"));
            }
            System.out.println();
        }
    }

    public V put(Comparable<K> key, V value) {
        if (isFull()) {
            System.out.println("The Hash Table is full");
            return null;
        } else {
            int keyHash = getKeyHash((Integer)key);
            if (entries[keyHash] == null) {
                entries[keyHash] = new LinkedList<>();
                entries[keyHash].add(new Entry(key,value));
            } else {
                LinkedList<Entry<K,V>> linkedList = entries[keyHash];
                for (int i = 0; i < linkedList.size(); i++) {
                    Entry<K,V> entry = linkedList.get(i);
                    if (key.compareTo(entry.getKey()) == 0) {
                        V val = entry.getValue();
                        entry.setValue(value);
                        return val;
                    }
                }
                linkedList.add(new Entry(key,value));
            }
        }
        return null;
    }

    public V remove(Comparable<K> key) {
        if (isEmpty()) {
            return null;
        } else {
            int keyHash = getKeyHash((Integer)key);
            LinkedList<Entry<K,V>> entryLinkedList = entries[keyHash];
            if (entryLinkedList != null) {
                for (int i = 0; i < entryLinkedList.size(); i++) {
                    Entry<K, V> entry = entryLinkedList.get(i);
                    if (key.compareTo(entry.getKey()) == 0) {
                        V value = entry.getValue();
                        entryLinkedList.remove(i);
                        return value;
                    }
                }
            }
            return null;
        }
    }

    public int getKeyHash(int value) {
        return value % MAX_SIZE;
    }
}
