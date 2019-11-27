package com.learnings.practise.datastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple Graph Implementation Using Adjacency List. With List and Binary Search Tree
 * Where V is the Vertex and E is the Edge
 */
public class Graph<V, E> {

    private Map<V, BinarySearchTree<E>> data = new HashMap<>();

    private void insert(V vertex, E edge) {
        BinarySearchTree<E> tree = data.getOrDefault(vertex, new BinarySearchTree<>());
        tree.insert(edge);
        data.put(vertex, tree);
    }

    /**
     * Get All Edges for the given Vertex
     * @param vertex - given vertex
     * @return list of Edges
     */
    private List<E> get(V vertex) {
        return this.data.getOrDefault(vertex, new BinarySearchTree<>()).getTreeByInOrder_depthFirst();
    }

    private E get(V vertex, E edge) throws Exception {
        return this.data.getOrDefault(vertex, new BinarySearchTree<>()).search(edge);
    }

    public static void main(String[] args) throws Exception {
        Graph<Integer, Integer> graph = new Graph<>();
        graph.insert(1, 2);
        graph.insert(1, 3);
        graph.insert(1, 4);

        graph.insert(2,  1);
        graph.insert(2, 3);

        graph.insert(3, 2);
        graph.insert(3, 1);
        graph.insert(3, 4);

        graph.insert(4, 1);
        graph.insert(4, 3);

        System.out.println(graph.get(1));
        System.out.println(graph.get(2));
        System.out.println(graph.get(3));
        System.out.println(graph.get(4));

        System.out.println(graph.get(1, 3));
        try{
            graph.get(4, 2);
        } catch (Exception e) {
            System.out.println("The Edge 4 with " + e.getMessage());
        }
    }
}
