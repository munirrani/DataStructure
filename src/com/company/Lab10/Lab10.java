package com.company.Lab10;

public class Lab10 {

    public Lab10 () {
        Q1();
    }

    private void Q1() {
        Graph<String, Integer> graph = new Graph<>();
        System.out.println("Creating a graph with 7 vertices and 6 edges");
        for (char i = 'A'; i <= 'G'; i++) {
            graph.addVertice(i + "");
        }
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 1);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "F", 1);
        graph.addEdge("F", "G", 1);
        graph.showGraph();
        graph.findPathDFS("A", "G");
    }
}
