package com.company.Lab10;

public class Lab10 {

    public Lab10 () {
        //Q1();
        Q2();
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

    private void Q2() {
        Graph<String, Double> graph = new Graph<>();
        System.out.println("Creating a graph with 8 vertices and 10 edges");
        for (char i = 'A'; i <= 'H'; i++) {
            graph.addVertice(i + "");
        }
        graph.addEdge("A","B", 0.4);
        graph.addEdge("A","C", 0.7);
        graph.addEdge("A","G", 0.8);
        graph.addEdge("B","C", 0.1);
        graph.addEdge("B","D", 0.2);
        graph.addEdge("B","E", 0.7);
        graph.addEdge("C","F", 0.3);
        graph.addEdge("E","H", 0.5);
        graph.addEdge("F","H", 0.4);
        graph.addEdge("G","H", 0.8);
        graph.showGraph();
        // (a) Use breadth-first search
        graph.findPathBFS("A", "H");
    }
}
