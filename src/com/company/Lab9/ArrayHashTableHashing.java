package com.company.Lab9;

public class ArrayHashTableHashing<K,V> {

    public final int MAX_SIZE = 20;
    private Entry<K,V>[] entries = new Entry[MAX_SIZE];

    public boolean isEmpty() { return getSize() == 0; }
    public boolean isFull() { return getSize() == MAX_SIZE; }
    public int getSize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) if (entries[i] != null) count++;
        return count;
    }

    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) entries[i] = null;
    }

    public void showHashTable() {
        for (int i = 0; i < MAX_SIZE; i++) if (entries[i] != null) System.out.println(entries[i].toString().replace(" |", ""));
    }

    public boolean containsKey(Comparable<K> key) {
        int probeCount = 1;
        int keyHash = getKeyHash((Integer)key);
        int index = keyHash;

        if (entries[keyHash] != null && key.compareTo(entries[keyHash].getKey()) == 0) return true;
        while (entries[index] != null) {
            index = keyHash + P(probeCount);
            probeCount++;
            if (entries[index] != null && key.compareTo(entries[index].getKey()) == 0) return true;
        }
        return false;
    }

    public boolean containsValue(Comparable<V> value) {
        for (int i = 0; i < MAX_SIZE; i++) { // Use traditional method
            if (entries[i] != null && value.compareTo(entries[i].getValue()) == 0) return true;
        }
        return false;
    }

    public V get(Comparable<K> key) {
        int probeCount = 1;
        int keyHash = getKeyHash((Integer)key);
        int index = keyHash;

        if (entries[keyHash] != null && key.compareTo(entries[keyHash].getKey()) == 0) return entries[keyHash].getValue();
        while (entries[index] != null) {
            index = keyHash + P(probeCount);
            probeCount++;
            if (entries[index] != null && key.compareTo(entries[index].getKey()) == 0) return entries[index].getValue();
        }
        return null;
    }

    public int getLocation(Comparable<K> key) {
        int probeCount = 1;
        int keyHash = getKeyHash((Integer)key);
        int index = keyHash;

        if (entries[keyHash] != null && key.compareTo(entries[keyHash].getKey()) == 0) return keyHash;
        while (entries[index] != null) {
            index = keyHash + P(probeCount);
            probeCount++;
            if (entries[index] != null && key.compareTo(entries[index].getKey()) == 0) return index;
        }
        return -1;
    }

    public V put(Comparable<K> key, V value) {
        if (isFull()) {
            System.out.println("The Hash Table is full");
            return null;
        } else {
            int probeCount = 1;
            int keyHash = getKeyHash((Integer)key);
            int index = keyHash;

            if (entries[keyHash] != null && key.compareTo(entries[keyHash].getKey()) == 0) {
                V temp = entries[keyHash].getValue();
                entries[keyHash].setValue(value);
                return temp;
            }

            while (entries[index] != null) {
                index = keyHash + P(probeCount);
                probeCount++;
                if (entries[index] != null && key.compareTo(entries[index].getKey()) == 0) {
                    V temp = entries[index].getValue();
                    entries[index].setValue(value);
                    return temp;
                }
            }
            entries[index] = new Entry(key, value);
        }
        return null;
    }

    public V remove(Comparable<K> key) {
        if (isEmpty()) {
            return null;
        } else {
            int probeCount = 1;
            int keyHash = getKeyHash((Integer) key);
            int index = keyHash;

            if (entries[keyHash] != null && key.compareTo(entries[keyHash].getKey()) == 0) {
                V value = entries[keyHash].getValue();
                entries[keyHash] = null;
                return value;
            }
            while (entries[index] != null) {
                index = keyHash + P(probeCount);
                probeCount++;
                if (entries[index] != null && key.compareTo(entries[index].getKey()) == 0) {
                    V value = entries[index].getValue();
                    entries[index] = null;
                    return value;
                }
            }
            return null;
        }
    }

    public int getKeyHash(int value) {
        return value % MAX_SIZE;
    }

    public int P(int count) {
        return 1 * count; // Probing function: P(k) = 1x
    }
}
