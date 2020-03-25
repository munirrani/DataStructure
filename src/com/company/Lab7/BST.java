package com.company.Lab7;

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

    public T getElement(T data) {
        return (T) getElement(root, data);
    }

    public T getElement(BSTNode<T> a, T data) {
        if (a == null) {
            return null;
        } else if (data.compareTo(a.getData()) < 0) {
            return (T) getElement(a.getLeftLink(), data);
        } else if (data.compareTo(a.getData()) > 0) {
            return (T) getElement(a.getRightLink(), data);
        } else {
            return a.getData();
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
            a.setLeftLink(remove(a, data));
        } else if(data.compareTo(a.getData()) > 0) {
            a.setRightLink(remove(a, data));
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

    public T getMinimumNumber() { return (T) getMinimumNumber(root, (T) root.getData()); }

    private T getMinimumNumber(BSTNode<T> a, T data) {
        if (a.getLeftLink() == null) {
            return (T) a.getData();
        } else {
            return (T) getMinimumNumber(a.getLeftLink(), (T) a.getLeftLink().getData());
        }
    }

    public T getMaximumNumber() {
        return (T) getMaximumNumber(root, (T) root.getData());
    }

    private T getMaximumNumber(BSTNode<T> a, T data) {
        if (a.getRightLink() == null) {
            return data;
        } else {
            return (T) getMaximumNumber(a.getRightLink(), (T) a.getRightLink().getData());
        }
    }

    public Integer getTotal() {
        return (Integer) getTotal(root, 0);
    }

    private Integer getTotal(BSTNode<T> a, Integer total) {
        total += (Integer) a.getData();
        if (a.getRightLink() != null) {
            total = getTotal(a.getRightLink(), total);
        }
        if (a.getLeftLink()!= null) {
            total = getTotal(a.getLeftLink(), total);
        }
        return total;
    }

    public Integer getOccurence(T value) {
        return getOccurence(root, value, 0);
    }

    private Integer getOccurence(BSTNode<T> a, T value, Integer currentCount) {
        if (value.compareTo(a.getData()) == 0) {
            ++currentCount;
        }
        if (a.getRightLink() != null) {
            currentCount = getOccurence(a.getRightLink(), value, currentCount);
        }
        if (a.getLeftLink() != null) {
            currentCount = getOccurence(a.getLeftLink(), value, currentCount);
        }
        return currentCount;
    }

    public void printInOrder(BST<T> bst) {
        printInOrder(root, bst);
    }

    private void printInOrder(BSTNode<T> a, BST<T> bst) {
        if (a != null) {
            printInOrder(a.getLeftLink(), bst);
            System.out.println(String.format("%04d", bst.getOccurence(a.getData())) + " " + a.getData() + " --> ");
            printInOrder(a.getRightLink(), bst);
        }
    }

}
