package com.learnings.practise.datastructure;

import java.util.*;

public class GraphUsingAdjacencyMatrix2DArray {

    private int [][] adjacencyMatrix = null;
    private int size;

    private GraphUsingAdjacencyMatrix2DArray() { }

    private GraphUsingAdjacencyMatrix2DArray(int size) {
        this.adjacencyMatrix = new int[size][size];
        this.size = size;
    }

    /**
     * 0 - Has No Connection
     * 1 - Has Connection
     *
     * @param vertex - vertex
     * @param edge   - edge
     */
    private void insert(int vertex, int edge) throws Exception {
        if(vertex >= size || edge >= size) throw new Exception("Adjacency Matrix is Full");
        adjacencyMatrix[vertex][edge] = 1;
    }

    private int[] get(int vertex) throws Exception {
        if(vertex >= size) throw new Exception(String.format("Vertex %s does not exists", vertex));
        return adjacencyMatrix[vertex];
    }

    private int get(int vertex, int edge) throws Exception {
        if(vertex >= size || edge >= size) throw new Exception(String.format("Vertex %s Edge %s does not exists", vertex, edge));
        return adjacencyMatrix[vertex][edge];
    }

    private void delete(int vertex, int edge) throws Exception {
        if(vertex >= size || edge >= size) throw new Exception(String.format("Vertex %s Edge %s does not exists", vertex, edge));
        adjacencyMatrix[vertex][edge] = 0;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\nAdjacency Matrix: \n");
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            toString.append(String.format("V|%s|  E|%s| \n", i, Arrays.toString(adjacencyMatrix[i])));
        }
        return toString.toString();
    }

    public static void main(String[] args) throws Exception {
        GraphUsingAdjacencyMatrix2DArray graph = new GraphUsingAdjacencyMatrix2DArray(10);
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

        System.out.println("Vertex : 1 Edges: " + Arrays.toString(graph.get(1)));
        System.out.println("Vertex : 2 Edges: " + Arrays.toString(graph.get(2)));
        System.out.println("Vertex : 3 Edges: " + Arrays.toString(graph.get(3)));
        System.out.println("Vertex : 4 Edges: " + Arrays.toString(graph.get(4)));

        System.out.println(graph);

        System.out.println("Vertex : 3 Edge: 2 => " + graph.get(3, 2));
        System.out.println("Vertex : 4 Edge: 3 => " + graph.get(4, 3));

        graph.delete(4, 3);
        System.out.println("Deleting Vertex: 4 Edge: 3");
        graph.delete(2, 1);
        System.out.println("Deleting Vertex: 2 Edge: 1");
        System.out.println(graph);

        try {
            graph.insert(10, 3);
        } catch (Exception e) {
            System.out.println("Inserting Vertex: 10 Edge: 3 => " + e.getMessage());
        }

        try {
            graph.delete(3, 10);
        } catch (Exception e) {
            System.out.println("Deleting Vertex: 10 Edge: 3 => " + e.getMessage());
        }
    }
}