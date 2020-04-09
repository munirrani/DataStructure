package com.company.Tutorial7;

import com.company.Lab6.Queue;

public class BST<T extends Comparable<T>> {

    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;
    private Queue<T> queue;
    private int traverse;

    private BSTNode root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    public int getSize(BSTNode<T> a) {
        if (a == null) return 0;
        return getSize(a.getLeftLink()) + getSize(a.getRightLink()) + 1;
    }

    public boolean contains(T data) {
        return find(root, data);
    }

    public boolean find(BSTNode<T> a, T data) {
        if (a == null) {
            return false;
        } else if (data.compareTo(a.getData()) < 0) {
            return find(a.getLeftLink(), data);
        } else if (data.compareTo(a.getData()) > 0) {
            return find(a.getRightLink(), data);
        } else {
            return true;
        }
    }

    public void addNode(T data) {
        root = add(root, data);
    }

    public BSTNode<T> add(BSTNode<T> a, T data) {
        if (a == null) {
            a = new BSTNode<>(data, null, null);
        } else if (data.compareTo(a.getData()) <= 0) {
            a.setLeftLink(add(a.getLeftLink(), data));
        } else {
            a.setRightLink(add(a.getRightLink(), data));
        }
        return a;
    }

    private boolean found;

    public boolean remove(T data) {
        root = remove(root, data);
        return found;
    }

    public BSTNode<T> remove(BSTNode<T> a, T data) {
        if (a == null) {
            found = false;
        } else if (data.compareTo(a.getData()) < 0) {
            a.setLeftLink(remove(a.getLeftLink(), data));
        } else if(data.compareTo(a.getData()) > 0) {
            a.setRightLink(remove(a.getRightLink(), data));
        } else {
            a = removeNode(a);
            found = true;
        }
        return a;
    }

    public BSTNode<T> removeNode(BSTNode<T> a) {
        if (a.getLeftLink() == null) {
            return a.getRightLink();
        } else if (a.getRightLink() == null) {
            return a.getLeftLink();
        } else {
            T data = (T) getPredecessor(a.getLeftLink());
            a.setData(data);
            a.setLeftLink(remove(a.getLeftLink(), data));
            return a;
        }
    }

    public T getPredecessor(BSTNode<T> a) {
        while (a.getRightLink() != null) {
            a = a.getRightLink();
        }
        return a.getData();
    }

    public void showTree() {
        queue.showQueue();
    }

    public void setOrder(int a) {
        traverse = a;
        queue = new Queue<>();
        if (traverse == INORDER) {
            inOrder(root);
        } else if (traverse == PREORDER) {
            preOrder(root);
        } else {
            postOrder(root);
        }
    }

    public void inOrder(BSTNode<T> a) {
        if (a != null) {
            inOrder(a.getLeftLink());
            queue.enqeue(a.getData());
            inOrder(a.getRightLink());
        }
    }

    public void preOrder(BSTNode<T> a) {
        if (a != null) {
            queue.enqeue(a.getData());
            preOrder(a.getLeftLink());
            preOrder(a.getRightLink());
        }
    }

    public void postOrder(BSTNode<T> a) {
        if (a != null) {
            postOrder(a.getLeftLink());
            postOrder(a.getRightLink());
            queue.enqeue(a.getData());
        }
    }
}
