package com.company.Tutorial7;

public class ArrayBST<T extends Comparable<T>> {

    public static final int MAX_SIZE = 20;
    T[] arr;

    public ArrayBST() {
        arr = (T[]) new Comparable[MAX_SIZE];
    }

    public boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) return false;
        }
        return true;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) count++;
        }
        return count;
    }

    public int getHeight() {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) maxIndex = i;
        }
        if (maxIndex % 2 == 0) maxIndex--;
        int count = 0;
        while (maxIndex != 0) {
            maxIndex = (maxIndex - 1) / 2; // k = (index - 1) / 2
            count++;
        }
        return count;
    }

    public void addNode(T data) {
        add(0, data);
    }

    private void add(int index, T data) {
        try {
            if (arr[index] == null) {
                arr[index] = data;
            } else if (data.compareTo(arr[index]) <= 0) {
                add(getLeftLink(index), data);
            } else {
                add(getRightLink(index), data);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    private int getLeftLink(int index) {
        return 2*index + 1;
    }

    private int getRightLink(int index) {
        return 2*index + 2;
    }

    public void removeNode(T data) {
        remove(0, data);
    }

    private void remove(int index, T data) {
        if (arr[index] == null) {
            return;
        } else if (data.compareTo(arr[index]) < 0) {
            remove(getLeftLink(index), data);
        } else if(data.compareTo(arr[index]) > 0) {
            remove(getRightLink(index), data);
        } else {
            removeIndex(index);
        }
    }

    // WIP - This method only works for leaf node
    private void removeIndex(int index) {
        if (arr[getLeftLink(index)] == null) {
            replace(getRightLink(index), index);
        } else if (arr[getRightLink(index)] == null) {
            replace(getLeftLink(index), index);
        }
    }

    private void replace(int oldIndex, int newIndex) {
        T temp = arr[oldIndex];
        arr[newIndex] = temp;
        arr[oldIndex] = null;
    }

    public void inOrder(int index) {
        if (index < MAX_SIZE && arr[index] != null) {
            inOrder(getLeftLink(index));
            System.out.print(arr[index] + " ");
            inOrder(getRightLink(index));
        }
    }

    public void preOrder(int index) {
        if (index < MAX_SIZE && arr[index] != null) {
            System.out.print(arr[index] + " ");
            preOrder(getLeftLink(index));
            preOrder(getRightLink(index));
        }
    }

    public void postOrder(int index) {
        if (index < MAX_SIZE && arr[index] != null) {
            postOrder(getLeftLink(index));
            postOrder(getRightLink(index));
            System.out.print(arr[index] + " ");
        }
    }
}
