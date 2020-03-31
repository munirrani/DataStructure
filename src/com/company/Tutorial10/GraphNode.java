package com.company.Tutorial10;

public class GraphNode<V> {
    private V vertice;
    private Edge[] edges = new Edge[ArrayGraph.MAX_SIZE];
    private boolean marked;

    public GraphNode() {
        vertice = null;
        marked = false;
    }

    public GraphNode(V a) {
        this.vertice = a;
        marked = false;
    }

    public void setVertice(V vertice) { this.vertice = vertice; }
    public V getVertice() { return vertice; }
    public Edge[] getEdgeArray() { return edges; }
    public void setMarked(boolean marked) { this.marked = marked; }
    public boolean isMarked() { return marked; }

    public String toString() {
        return vertice + " --> ";
    }
}