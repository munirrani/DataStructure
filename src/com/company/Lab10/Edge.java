package com.company.Lab10;

public class Edge<E> {

    private GraphNode verticeLink;
    private Edge edgeLink;
    private E weight;

    public Edge() {
        verticeLink = null;
        edgeLink = null;
        weight = null;
    }

    public Edge(GraphNode verticeLink, E weight, Edge edgeLink) {
        this.verticeLink = verticeLink;
        this.weight = weight;
        this.edgeLink = edgeLink;
    }

    public void setWeight(E edge) { this.weight = edge; }
    public E getWeight() { return weight; }
    public void setVerticeLink(GraphNode verticeLink) { this.verticeLink = verticeLink; }
    public GraphNode getVerticeLink() { return verticeLink; }
    public void setEdgeLink(Edge edgeLink) { this.edgeLink = edgeLink; }
    public Edge getEdgeLink() { return edgeLink; }

    public String toString() { return " -> " + verticeLink.getVertice() + " : " + weight; }
}
