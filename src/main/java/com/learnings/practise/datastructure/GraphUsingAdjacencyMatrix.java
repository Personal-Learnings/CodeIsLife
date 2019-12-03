package com.learnings.practise.datastructure;

import java.util.*;

public class GraphUsingAdjacencyMatrix<V, E> {

    private Map<V, Map<E, Boolean>> adjacencyMatrix = new HashMap<>();

    private void insert(V vertex, E edge) {
        Map<E, Boolean> edgeMap = adjacencyMatrix.getOrDefault(vertex, new HashMap<>());
        edgeMap.put(edge, true);
        adjacencyMatrix.put(vertex, edgeMap);
    }

    private List<E> get(V vertex) {
        return new ArrayList<>(adjacencyMatrix.getOrDefault(vertex, Collections.emptyMap()).keySet());
    }

    private E get(V vertex, E edge) {
        return adjacencyMatrix.getOrDefault(vertex, Collections.emptyMap()).keySet().stream().filter(e -> e.equals(edge)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        GraphUsingAdjacencyMatrix<Integer, Integer> graph = new GraphUsingAdjacencyMatrix<>();
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
