package com.company.Lab10;

import com.company.Lab5.Stack;
import com.company.Lab6.Queue;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<V extends Comparable<V>, E> {
    private GraphNode head;

    public Graph() {
        head = null;
    }

    public boolean isEmpty () {
        return head == null;
    }

    public int getSize() {
        GraphNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            currentNode = currentNode.getVerticeLink();
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public void showGraph() {
        GraphNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.toString());
            Edge edge = (Edge) currentNode.getEdgeLink();
            while (edge != null) {
                System.out.print(edge.toString());
                edge = edge.getEdgeLink();
            }
            System.out.println();
            currentNode = currentNode.getVerticeLink();
        }
    }

    public GraphNode hasVertice(V vertice) {
        GraphNode currentNode = head;
        if (isEmpty()) {
            return null;
        } else {
            while (currentNode != null) {
                if (vertice.compareTo((V)currentNode.getVertice()) == 0) {
                    return currentNode;
                }
                currentNode = currentNode.getVerticeLink();
            }
        }
        return null;
    }

    public void addVertice(V a) {
        GraphNode newNode = new GraphNode(a, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            GraphNode currentNode = head;
            while (currentNode.getVerticeLink() != null) currentNode = currentNode.getVerticeLink();
            currentNode.setVerticeLink(newNode);
        }
    }

    public void markVertice(V a) {
        if (hasVertice(a) != null) {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (a.compareTo((V)currentNode.getVertice()) == 0) {
                    currentNode.setMarked(true);
                    break;
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
    }

    public boolean isMarked(V a) {
        if (hasVertice(a) != null) {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (a.compareTo((V)currentNode.getVertice()) == 0) {
                    return currentNode.isMarked();
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }

    public boolean addEdge(V from, V to, E weight) {
        if (hasVertice(from) == null || hasVertice(to) == null) {
            return false;
        } else {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (from.compareTo((V)currentNode.getVertice()) == 0) {
                    GraphNode toNode = hasVertice(to);
                    Edge newEdge = new Edge(toNode, weight, null);
                    Edge currentEdge = (Edge) currentNode.getEdgeLink();
                    if (currentEdge != null) { // if there's edges already exist
                        while (currentEdge.getEdgeLink() != null) currentEdge = currentEdge.getEdgeLink();
                        currentEdge.setEdgeLink(newEdge);
                    } else { // if there are no existing edges
                        currentNode.setEdgeLink(newEdge);
                    }
                    return true;
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }

    public boolean removeEdge(V from, V to) {
        if (hasVertice(from) == null || hasVertice(to) == null) {
            return false;
        } else {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (from.compareTo((V)currentNode.getVertice()) == 0) {
                    GraphNode toNode = hasVertice(to);
                    Edge previousEdge = null;
                    Edge currentEdge = (Edge) currentNode.getEdgeLink();
                    while (currentEdge != null) {
                        if (to.compareTo((V)currentEdge.getVerticeLink().getVertice()) == 0) {
                            if (previousEdge != null) { // If its second edge and after
                                previousEdge.setEdgeLink(currentEdge.getEdgeLink());
                            } else { // If its the first edge
                                currentNode.setEdgeLink(currentEdge.getEdgeLink());
                            }
                            return true;
                        } else {
                            previousEdge = currentEdge;
                            currentEdge = currentEdge.getEdgeLink();
                        }
                    }
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }

    public boolean isEdge(V from, V to) {
        if (hasVertice(from) == null || hasVertice(to) == null) {
            return false;
        } else {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (from.compareTo((V)currentNode.getVertice()) == 0) {
                    GraphNode toNode = hasVertice(to);
                    Edge currentEdge = (Edge) currentNode.getEdgeLink();
                    while (currentEdge != null) {
                        if (currentNode == toNode) return true;
                        currentEdge = currentEdge.getEdgeLink();
                    }
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }

    public E getWeight(V from, V to) {
        if (hasVertice(from) == null || hasVertice(to) == null) {
            return null;
        } else {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if (from.compareTo((V)currentNode.getVertice()) == 0) {
                    GraphNode toNode = hasVertice(to);
                    Edge currentEdge = (Edge) currentNode.getEdgeLink();
                    while (currentEdge != null) {
                        if (currentEdge.getVerticeLink() == toNode) return (E)currentEdge.getWeight();
                        currentEdge = currentEdge.getEdgeLink();
                    }
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return null;
    }

    public ArrayList getAdjascent(V a) {
        ArrayList<V> arrayList = new ArrayList<>();
        if(hasVertice(a) != null) {
            GraphNode currentNode = head;
            while (currentNode != null) {
                if(a.compareTo((V)currentNode.getVertice()) == 0) {
                    Edge edge = (Edge) currentNode.getEdgeLink();
                    while (edge != null) {
                        arrayList.add((V)edge.getVerticeLink().getVertice());
                        edge = edge.getEdgeLink();
                    }
                    break;
                } else {
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return arrayList;
    }

    public void findPathDFS(V from, V to) {
        System.out.println("Find the path from " + from.toString() + " to " + to.toString());
        ArrayList<V> adjascent;
        Stack<V> nodeStack = new Stack();
        Stack<V> pathStack = new Stack();
        nodeStack.push(from);
        while (true) {
            V top = nodeStack.peek();
            markVertice(top);
            if (to.compareTo(top) == 0) {
                while (!nodeStack.isEmpty()) {
                    V node = nodeStack.pop();
                    if (isMarked(node)) pathStack.push(node);
                }
                break;
            } else {
                adjascent = getAdjascent(top);
                if (adjascent.size() == 0) { // no more adjascent vertices, dead end
                    while (true) {
                        nodeStack.pop(); // Keep popping until unmarked node is found
                        if (!isMarked(nodeStack.peek())) break;
                    }
                } else {
                    for (int i = 0; i < adjascent.size(); i++) nodeStack.push(adjascent.get(i));
                }
            }
        }
        while (!pathStack.isEmpty()) System.out.print(pathStack.pop().toString() + " --> ");
        System.out.println();
    }

    public void findPathBFS(V from, V to) {
        System.out.println("The shortest path from " + from.toString() + " to " + to.toString() + " by distance");
        ArrayList<V> adjascent;
        Queue<V> nodeQueue = new Queue<>();
        Queue<String> pathToNodeQueue = new Queue<>(); // A queue show the paths from start to finish of that node
        boolean found = false;
        nodeQueue.enqeue(from);
        pathToNodeQueue.enqeue(from.toString());
        while (!found) {
            V top = nodeQueue.dequeue();
            String topPath = pathToNodeQueue.dequeue();
            adjascent = getAdjascent(top);
            if (adjascent.size() != 0) {
                for (int i = 0; i < adjascent.size(); i++) {
                    nodeQueue.enqeue(adjascent.get(i));
                    String str = topPath + " -> " + adjascent.get(i).toString(); // Store the node before
                    pathToNodeQueue.enqeue(str);
                    if (to.compareTo(adjascent.get(i)) == 0) {
                        found = true;
                        while (pathToNodeQueue.getSize() != 1) pathToNodeQueue.dequeue();
                        System.out.println(pathToNodeQueue.dequeue() + " -> ");
                        break;
                    }
                }
            }
        }
    }

    public HashMap<V, E> getHashMap(V exclude) {
        HashMap<V,E> hashMap = new HashMap<>();
        Double val = 0.0;
        hashMap.put(exclude, (E)val);
        GraphNode currentNode = head;
        while (currentNode != null) {
            if (exclude.compareTo((V)currentNode.getVertice()) != 0) {
                Integer num = Integer.MAX_VALUE;
                hashMap.put((V)currentNode.getVertice(), (E)num);
            }
            currentNode = currentNode.getVerticeLink();
        }
        return hashMap;
    }
}
