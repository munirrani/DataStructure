package com.company.Lab4;

public class DoubleListNode<T> {

    private DoubleListNode<T> next;
    private DoubleListNode<T> previous;
    private T data;

    public DoubleListNode() {
        next = null;
        previous = null;
        data = null;
    }

    public DoubleListNode(T data, DoubleListNode<T> next, DoubleListNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleListNode<T> nextLink() {
        return next;
    }

    public DoubleListNode<T> previousLink() {
        return previous;
    }

    public void setNextLink(DoubleListNode<T> doubleListNode) {
        next = doubleListNode;
    }

    public void setPreviousLink(DoubleListNode<T> doubleListNode) {
        previous = doubleListNode;
    }

    public String toString() {
        return " <--" + data + "--> ";
    }

}
