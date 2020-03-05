package com.company.Lab5;


public class ListNode<T> {

    private T data;
    private ListNode listNode;

    public ListNode() {
        data = null;
        listNode = null;
    }

    public ListNode (T t, ListNode listNode) {
        data = t;
        this.listNode = listNode;
    }

    public void setData(T t) { data = t; }
    public T getData() { return data; }
    public void setLink(ListNode listNode) { this.listNode = listNode; }
    public ListNode getLink() { return listNode; }
    public String toString() {
        return "<-- " + data +  " ";
    }
}
