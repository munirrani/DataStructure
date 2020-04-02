package com.company.Lab10;

import com.company.Lab6.PriorityQueue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Lab10 {

    public Lab10 () {
        Q1();
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

        String source = "A";
        String destination = "H";
        // (a) Use breadth-first search
        graph.findPathBFS(source, destination);
        // (b) Use Dijkstra's algorithm
        dijkstra(graph, source, destination);
    }

    public void dijkstra(Graph graph, String from, String to) {
        HashMap<String, Double> totalCosts = graph.getHashMap(from);
        HashMap<String, String> previousNodes = new HashMap<>();
        PriorityQueue<NodeAndWeight<String, Double>> queue = new PriorityQueue<>();
        DecimalFormat df = new DecimalFormat("#.0"); //1dp

        queue.minQueue(new NodeAndWeight(from, 0.0));
        while (!queue.isEmpty()) {
            NodeAndWeight node = queue.deqeue();
            String vertice = (String) node.getNode();
            graph.markVertice(vertice);

            ArrayList<String> adjascent = graph.getAdjascent(vertice);
            for (int i = 0; i < adjascent.size(); i++) {
                String neighbour = adjascent.get(i);
                if (!graph.isMarked(neighbour)) {
                    Double altPath = Double.sum(totalCosts.get(vertice), (Double) graph.getWeight(vertice, neighbour));
                    altPath = Double.valueOf(df.format(altPath));

                    Double currentValueOnNeighbour = Double.valueOf(String.valueOf(totalCosts.get(neighbour)));
                    if(altPath.compareTo(currentValueOnNeighbour) < 0) {
                        totalCosts.put(neighbour, altPath);
                        previousNodes.put(neighbour, vertice);
                        queue.minQueue(new NodeAndWeight(neighbour, altPath));
                    }
                }
            }
        }

        System.out.println("The shortest path from A - H by cost");
        System.out.println(getPath(previousNodes, from, to));
    }

    public String getPath(HashMap<String, String> hashMap, String from, String to) {
        String str = "";
        String hash = hashMap.toString(); // result: {B=A, C=B, D=B, E=B, F=C, G=A, H=F}
        hash = hash.replace("{", "");
        hash = hash.replace("}", "");
        hash = hash.replaceAll(" ", "");
        String[] values = hash.split(",");

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) { arrayList.add(values[i]); }

        String destination = to;
        str += destination + " -> ";
        while (true) {
            for (int i = 0; i < arrayList.size(); i++) {
                String s = arrayList.get(i);
                if (s.contains(destination)) {
                    String[] elem = s.split("=");
                    str = elem[1] + " -> " + str;
                    if (str.contains(from)) {
                        return str;
                    } else {
                        destination = elem[1];
                    }
                    arrayList.remove(s);
                    break;
                }
            }
        }
    }

    public class NodeAndWeight<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<NodeAndWeight<A,B>>{
        private A node;
        private B weight;

        public NodeAndWeight(A node, B weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(NodeAndWeight<A, B> o) {
            if(node.compareTo(o.getNode()) == 0) {
                return 0;
            }
            return weight.compareTo(o.getWeight());
        }

        public A getNode() { return node; }
        public B getWeight() { return weight; }

        public String toString() {
            return node + " : " + weight;
        }
    }
}
