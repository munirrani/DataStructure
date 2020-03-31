package com.company.Tutorial10;

public class Edge<E> {
    private GraphNode verticeLink;
    private E weight;

    public Edge() {
        verticeLink = null;
        weight = null;
    }

    public Edge(GraphNode verticeLink, E weight) {
        this.verticeLink = verticeLink;
        this.weight = weight;
    }

    public void setWeight(E edge) { this.weight = edge; }
    public E getWeight() { return weight; }
    public void setVerticeLink(GraphNode verticeLink) { this.verticeLink = verticeLink; }
    public GraphNode getVerticeLink() { return verticeLink; }

    public String toString() { return " -> " + verticeLink.getVertice() + " : " + weight; }
}

