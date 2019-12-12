package com.learnings.practise.datastructure;

import java.util.*;

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

    @SuppressWarnings("SameParameterValue")
    private void delete(V vertex, E edge) {
        BinarySearchTree<E> edgeTree = data.get(vertex);
        if(null != edgeTree) edgeTree.delete(edge);
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

    @SuppressWarnings({"rawtypes", "unchecked", "SuspiciousMethodCalls"})
    private List<V> getLevelOrder_breadthFirstTraversal() throws Exception {
        Queue edges = new Queue();
        List result = new ArrayList<>();
        List visitedEdges = new ArrayList();

        V root = data.keySet().stream().findFirst().orElseThrow(() -> new Exception("Graph has no vertices"));
        edges.enqueue(root);
        visitedEdges.add(root);

        while (!edges.isEmpty()) {
            BinarySearchTree<E> edgeTree = data.get(edges.peek());
            result.add(edges.dequeue());

            if(null != edgeTree) {
                edgeTree.getTreeByInOrder_depthFirst().forEach(edge -> {
                    if(!visitedEdges.contains(edge)) {
                        edges.enqueue(edge);
                        visitedEdges.add(edge);
                    }
                });
            }
        }
        return result;
    }

    @SuppressWarnings({"rawtypes", "unchecked", "SuspiciousMethodCalls"})
    private List getDepthFirstTraversal_iterative_usingStack_BigO_VPlusE() throws Exception {

        //Using LinkedHashMap to maintain the insertion order of the keys
        Map<Object, Boolean> visited = new LinkedHashMap<>();
        Stack watchStack = new Stack();

        V root = data.keySet().stream().findFirst().orElseThrow(() -> new Exception("Graph is Empty"));
        watchStack.push(root);
        visited.put(root, true);

        while(!watchStack.isEmpty()) {
            Object currentVertex = watchStack.top();

            BinarySearchTree<E> edgeTree = data.getOrDefault(currentVertex, new BinarySearchTree<>());
            List<E> edges = edgeTree.getTreeByInOrder_depthFirst();

            //Remove an item from the stack when there are no edges or all the edges are visited for that vertex
            if(edgeTree.isEmpty() || visited.keySet().containsAll(edges)) {
                watchStack.pop();
            } else {
                for(E edge : edges) {
                    if(!visited.containsKey(edge)) {
                        watchStack.push(edge);
                        visited.put(edge, true);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(visited.keySet());
    }
    
    @SuppressWarnings({"rawtypes"})
    private List getDepthFirstTraversalRecursive() throws Exception {
        List visitedEdges = new ArrayList();
        V root = data.keySet().stream().findFirst().orElseThrow(() -> new Exception("Graph is Empty"));
        traverseDepthFirstRecursive(root, visitedEdges);
        return visitedEdges;
    }

    @SuppressWarnings({"rawtypes", "unchecked", "SuspiciousMethodCalls"})
    private void traverseDepthFirstRecursive(Object currentVertex, List visitedEdges) {
        visitedEdges.add(currentVertex);
        BinarySearchTree<E> edgeTree = data.get(currentVertex);
        if(null != edgeTree) {
            List<E> edges = edgeTree.getTreeByInOrder_depthFirst();
            for(E edge : edges) {
                if(!visitedEdges.contains(edge)) {
                    traverseDepthFirstRecursive(edge, visitedEdges);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\nGraph: \n");
        if(data != null) {
            data.entrySet().forEach(vertexEntry -> {
                if(null != vertexEntry) {
                    toString.append(
                            String.format("V|%s|  E|%s| \n", vertexEntry.getKey(), vertexEntry.getValue().getTreeByInOrder_depthFirst())
                    );
                }
            });
        }
        return toString.toString();
    }

    public static void main(String[] args) throws Exception {
        Graph<Integer, Integer> graph = new Graph<>();

        graph.insert(0, 1);
        graph.insert(0, 3);

        graph.insert(1, 0);
        graph.insert(1, 2);
        graph.insert(1, 3);
        graph.insert(1, 5);
        graph.insert(1, 6);

        graph.insert(2, 1);
        graph.insert(2, 3);
        graph.insert(2, 4);
        graph.insert(2, 5);

        graph.insert(3, 0);
        graph.insert(3, 1);
        graph.insert(3, 2);
        graph.insert(3, 4);

        graph.insert(4, 2);
        graph.insert(4, 3);
        graph.insert(4, 6);

        graph.insert(5, 1);
        graph.insert(5, 2);
        graph.insert(5, 7);

        graph.insert(6, 1);
        graph.insert(6, 4);

        graph.insert(7, 5);
        graph.insert(7, 8);
        graph.insert(7, 9);
        graph.insert(7, 10);

        graph.insert(8, 7);
        graph.insert(8, 9);
        graph.insert(8, 10);

        graph.insert(10, 7);
        graph.insert(10, 8);
        graph.insert(10, 9);

        graph.insert(10, 11);

        graph.insert(11, 12);

        System.out.println(graph.get(1));
        System.out.println(graph.get(2));
        System.out.println(graph.get(3));
        System.out.println(graph.get(4));

        System.out.println(graph.get(1, 3));
        try{
            graph.get(4, 5);
        } catch (Exception e) {
            System.out.println("The Edge 4 with " + e.getMessage());
        }
        System.out.println(graph);

        System.out.println("Deleting Vertex 4 Edge 3");
        graph.delete(4, 3);
        System.out.println(graph);

        System.out.println("Level Order Traversal of Graph                 : " + graph.getLevelOrder_breadthFirstTraversal());
        System.out.println("Depth First Traversal of Graph Using Recursion : " + graph.getDepthFirstTraversalRecursive());
        System.out.println("Depth First Traversal of Graph Iterative       : " + graph.getDepthFirstTraversal_iterative_usingStack_BigO_VPlusE());
    }
}