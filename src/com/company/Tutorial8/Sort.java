package com.company.Tutorial8;

public class Sort<T extends Comparable<T>> {

    public static final int ASCENDING_ORDER = 0;
    public static final int DESCENDING_ORDER = 1;

    private int order;

    T[] arr;

    public Sort(T[] t) {
        arr = (T[]) new Comparable[t.length];
        for (int i = 0; i < t.length; i++) {
            arr[i] = t[i];
        }
        order = ASCENDING_ORDER;
    }

    public void printArray() {
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (order == ASCENDING_ORDER) {
                swapByIndex(i, getMinimumIndex(i));
            } else {
                swapByIndex(i, getMaximumIndex(i));
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (order == ASCENDING_ORDER && arr[i].compareTo(arr[j]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                } else if (order == DESCENDING_ORDER && arr[i].compareTo(arr[j]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public void insertionSort() {
        int j;
        for (int i = 1; i < arr.length; i++) {
            for (j = 0; j < i; j++) {
                if (order == ASCENDING_ORDER && arr[i].compareTo(arr[j]) < 0) {
                    swapByIndex(i, j);
                    break;
                } else if (order == DESCENDING_ORDER && arr[i].compareTo(arr[j]) > 0) {
                    swapByIndex(i, j);
                    break;
                }
            }
            for (j = j + 1; j < i; j++) {
                swapByIndex(i, j);
            }
        }
    }

    private int getMinimumIndex(int start) {
        T temp = arr[start];
        int index = start;
        for (int i = start+1; i < arr.length; i++) {
            if(temp.compareTo(arr[i]) > 0) {
                index = i;
                temp = arr[i];
            }
        }
        return index;
    }

    private int getMaximumIndex(int start) {
        T temp = arr[start];
        int index = start;
        for (int i = start+1; i < arr.length; i++) {
            if(temp.compareTo(arr[i]) < 0) {
                index = i;
                temp = arr[i];
            }
        }
        return index;
    }

    private void swapByIndex(int i, int j) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public void mergeSort() {
        mergeSort(0, arr.length - 1);
    }

    private void mergeSort(int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        T[] temp = (T[]) new Comparable[arr.length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        while (leftFirst<=leftLast && rightFirst <= rightLast) {
            if((arr[leftFirst].compareTo(arr[rightFirst]) < 0 && order == ASCENDING_ORDER) ||
                    (arr[leftFirst].compareTo(arr[rightFirst]) > 0 && order == DESCENDING_ORDER)) {
                temp[index] = arr[leftFirst];
                leftFirst++;
            } else {
                temp[index] = arr[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while (leftFirst <= leftLast) {
            temp[index] = arr[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast) {
            temp[index] = arr[rightFirst];
            rightFirst++;
            index++;
        }
        for (int i = currentIndex; i <= rightLast; i++) {
            arr[i] = temp[i];
        }
    }

    public void quickSort() {
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int first, int last) {
        if (first < last) {
            int split = getSplitIndex(first, last);
            quickSort(first, split - 1);
            quickSort(split + 1, last);
        }
    }

    private int getSplitIndex(int first, int last) {
        T pivot = arr[last];
        int pIndex = first;
        for (int i = first; i < last; i++) {
            if ((arr[i].compareTo(pivot) <= 0 && order == ASCENDING_ORDER) || (arr[i].compareTo(pivot) >= 0 && order == DESCENDING_ORDER)) {
                swapByIndex(pIndex, i);
                pIndex++;
            }
        }
        swapByIndex(pIndex, last);
        return pIndex;
    }

    public void sort(int index, int order) {
        this.order = order;
        if (index == 0) {
            selectionSort();
        } else if (index == 1) {
            bubbleSort();
        } else if (index == 2) {
            insertionSort();
        } else if (index == 3) {
            mergeSort();
        } else if (index == 4) {
            quickSort();
        }
    }
}
