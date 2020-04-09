package com.company.Tutorial7;

public class BSTNode<T extends Comparable<T>> {
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;

    public BSTNode() {
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTNode(T data, BSTNode a, BSTNode b) {
        this.data = data;
        this.leftLink = a;
        this.rightLink = b;
    }

    public void setData(T data) { this.data = data; }

    public T getData() { return data; }

    public void setLeftLink(BSTNode a) { this.leftLink = a; }

    public BSTNode getLeftLink() { return leftLink; }

    public void setRightLink(BSTNode b) { this.rightLink = b; }

    public BSTNode getRightLink() { return rightLink; }

}
