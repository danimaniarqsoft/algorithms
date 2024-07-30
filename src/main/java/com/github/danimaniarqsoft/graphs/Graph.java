package com.github.danimaniarqsoft.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Integer, Set<Integer>> adjacencyList = new Hashtable<>();
    private Integer numberOfNodes = 0;

    public Graph addVertex(int vertex) {

        if (this.adjacencyList.get(vertex) == null) {
            this.adjacencyList.put(vertex, new HashSet<>());
        }

        this.numberOfNodes = this.numberOfNodes + 1;
        return this;
    }

    public Graph addEdge(int i, int j) {

        if (this.adjacencyList.get(i) == null) {
            this.addVertex(i);
        }
        this.adjacencyList.get(i).add(j);

        if (this.adjacencyList.get(j) == null) {
            this.addVertex(j);
        }
        this.adjacencyList.get(j).add(i);

        return this;
    }

    public Graph showConnections() {

        for (Map.Entry<Integer, Set<Integer>> set : this.adjacencyList.entrySet()) {
            System.out.print(set.getKey() + " : ");
            Iterator<Integer> iterator = set.getValue().iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ",");
            }
            System.out.println();
        }

        System.out.println("Number of nodes : " + this.numberOfNodes);

        return this;
    }

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph
                .addVertex(0)
                .addVertex(1)
                .addVertex(2)
                .addVertex(3)
                .addVertex(4)
                .addVertex(5)
                .addVertex(6)
                .addEdge(3, 1)
                .addEdge(3, 4)
                .addEdge(4, 2)
                .addEdge(4, 5)
                .addEdge(1, 2)
                .addEdge(1, 0)
                .addEdge(0, 2)
                .addEdge(6, 5)
                .showConnections();

    }

}
