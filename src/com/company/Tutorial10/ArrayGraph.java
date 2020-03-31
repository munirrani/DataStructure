package com.company.Tutorial10;

import java.util.ArrayList;

public class ArrayGraph<V extends Comparable<V>, E> {

    public static final int MAX_SIZE = 20;
    GraphNode[] nodes = new GraphNode[MAX_SIZE];

    public boolean isEmpty() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) return false;
        }
        return true;
    }

    public int getVerticeSize() {
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) count++;
        }
        return count;
    }

    public void clear() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = null;
        }
    }

    public void addVertice(V v) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = new GraphNode(v);
                break;
            }
        }
    }

    public int hasVertice(V v) { //return the index, -1 if not found
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && v.compareTo((V)nodes[i].getVertice()) == 0) return i;
        }
        return -1;
    }

    public boolean addEdge(V from, V to, E weight) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && from.compareTo((V) nodes[i].getVertice()) == 0) {
                Edge[] edges = nodes[i].getEdgeArray();
                if (hasVertice(to) != -1) {
                    GraphNode toNode = nodes[hasVertice(to)];
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[j] == null) {
                            edges[j] = new Edge(toNode, weight);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteEdge(V from, V to) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && from.compareTo((V) nodes[i].getVertice()) == 0) {
                Edge[] edges = nodes[i].getEdgeArray();
                if (hasVertice(to) != -1) {
                    GraphNode toNode = nodes[hasVertice(to)];
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[j] != null && edges[j].getVerticeLink() == toNode) {
                            edges[j] = null;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isEdge(V from, V to) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && from.compareTo((V) nodes[i].getVertice()) == 0) {
                Edge[] edges = nodes[i].getEdgeArray();
                if (hasVertice(to) != -1) {
                    GraphNode toNode = nodes[hasVertice(to)];
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[j] != null && edges[j].getVerticeLink() == toNode) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public E getWeight(V from, V to) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && from.compareTo((V) nodes[i].getVertice()) == 0) {
                Edge[] edges = nodes[i].getEdgeArray();
                if (hasVertice(to) != -1) {
                    GraphNode toNode = nodes[hasVertice(to)];
                    for (int j = 0; j < edges.length; j++) {
                        if (edges[j] != null && edges[j].getVerticeLink() == toNode) {
                            return (E) edges[j].getWeight();
                        }
                    }
                }
            }
        }
        return null;
    }

    public void markVertice(V v) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && v.compareTo((V) nodes[i].getVertice()) == 0) nodes[i].setMarked(true);
        }
    }

    public boolean isMarked(V v) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && v.compareTo((V) nodes[i].getVertice()) == 0) return nodes[i].isMarked();
        }
        return false;
    }

    public ArrayList getAdjascent(V v) {
        ArrayList<V> arrayList = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && v.compareTo((V) nodes[i].getVertice()) == 0) {
                Edge[] edges = nodes[i].getEdgeArray();
                for (int j = 0; j < edges.length; j++) {
                    if(edges[j] != null) arrayList.add((V) edges[j].getVerticeLink().getVertice());
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public void showGraph() {
        for (int i = 0; i < nodes.length; i++) {
            GraphNode currentNode = nodes[i];
            if (currentNode != null) {
                System.out.println(currentNode.toString());
                Edge[] edges = currentNode.getEdgeArray();
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j] != null) {
                        System.out.print(edges[j].toString());
                    }
                }
                System.out.println();
            }
        }
    }
}
