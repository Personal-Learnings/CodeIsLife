package com.learnings.practise.datastructure;

import java.util.ArrayList;
import java.util.List;

public class GraphUsingAdjacencyList {

    private List<List<Integer>> adjacencyList = null;

    @SuppressWarnings("unused")
    private GraphUsingAdjacencyList() { }

    @SuppressWarnings("WeakerAccess")
    GraphUsingAdjacencyList(Integer initialCapacity) {
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < initialCapacity; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
    }

    private void insert(int vertex, int edge) {
        if(vertex < adjacencyList.size()) {
            adjacencyList.get(vertex).add(edge);
        }
    }

    private List<Integer> get(int vertex) {
        return (vertex < adjacencyList.size()) ? adjacencyList.get(vertex) : null;
    }

    private Integer get(int vertex, int edge) {
        if(vertex < adjacencyList.size()) {
            List<Integer> edgeList = adjacencyList.get(vertex);
            return edgeList.stream().filter(e -> e.equals(edge)).findAny().orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(100);

        graph.insert(1, 2);
        graph.insert(1, 3);
        graph.insert(1, 4);

        graph.insert(2, 1);
        graph.insert(2, 3);

        graph.insert(3, 2);
        graph.insert(3, 1);
        graph.insert(3, 4);

        graph.insert(4, 1);
        graph.insert(4, 3);

        System.out.println("Vertex : 1 Edges: " + graph.get(1));
        System.out.println("Vertex : 2 Edges: " + graph.get(2));
        System.out.println("Vertex : 3 Edges: " + graph.get(3));
        System.out.println("Vertex : 4 Edges: " + graph.get(4));

        System.out.println("Vertex : 3 Edge: 2 => " + graph.get(3, 2));
        System.out.println("Vertex : 4 Edge: 3 => " + graph.get(4, 3));
    }
}