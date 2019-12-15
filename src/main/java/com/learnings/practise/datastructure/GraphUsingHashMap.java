package com.learnings.practise.datastructure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static com.learnings.practise.datastructure.GraphUsingHashMap.Cities.*;

/**
 *
 * Weighted Graph
 * @param <V> - Type of Vertices and Edges
 * @param <D> - Type of Data
 */
public class GraphUsingHashMap<V, D> {

    private Map<V, Map<V, D>> graphData = new HashMap<>();

    private void insert(V vertex, V edge, D data) throws Exception {
        if(vertex == null || edge == null) throw new Exception("Vertex / Edge cannot be null");
        Map<V, D> edgeMap = graphData.getOrDefault(vertex, new HashMap<>());
        edgeMap.put(edge, data);
        graphData.put(vertex, edgeMap);
    }

    private List<V> get(V vertex) {
        return new ArrayList<>(graphData.getOrDefault(vertex, Collections.emptyMap()).keySet());
    }

    private D get(V vertex, V edge) {
        return graphData.getOrDefault(vertex, Collections.emptyMap()).entrySet()
                .stream()
                .filter(e -> e.getKey().equals(edge))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private void delete(V vertex) {
        graphData.remove(vertex);
        graphData.forEach((key, value) -> value.remove(vertex));
    }

    private void delete(V vertex, V edge) {
        graphData.getOrDefault(vertex, new HashMap<>()).remove(edge);
    }

    private Short findMinimumSpanningTree() throws Exception {
        //Remove All Cycles
        //Remove All Parallel Edges that has maximum value in it.
        return null;
    }

    private V getMinimumEdge(Map<V, D> vertexWeightMap) {
        AtomicReference<Integer> minWeight = new AtomicReference<>(Integer.MAX_VALUE);
        AtomicReference<V> minVertex = new AtomicReference<>();

        vertexWeightMap.forEach((key, value) -> {
            if((Integer) value < minWeight.get()) {
                minVertex.set(key);
            }
        });
        return minVertex.get();
    }

    private void findShortestPath(V source, V destination) {

    }

    public static void main(String[] args) throws Exception {
        GraphUsingHashMap<Cities, Short> graph = new GraphUsingHashMap<>();

        graph.insert(CHENNAI, KOLKATTA, Short.valueOf("600"));
        graph.insert(CHENNAI, JAMMU, Short.valueOf("1400"));
        graph.insert(CHENNAI, NEW_DELHI, Short.valueOf("800"));
        graph.insert(CHENNAI, MUMBAI, Short.valueOf("650"));
        graph.insert(CHENNAI, BANGALORE, Short.valueOf("350"));

        graph.insert(BANGALORE, CHENNAI, Short.valueOf("350"));
        graph.insert(BANGALORE, MUMBAI, Short.valueOf("300"));
        graph.insert(BANGALORE, NEW_DELHI, Short.valueOf("600"));

        graph.insert(MUMBAI, JAMMU, Short.valueOf("1500"));
        graph.insert(MUMBAI, BANGALORE, Short.valueOf("300"));
        graph.insert(MUMBAI, CHENNAI, Short.valueOf("650"));

        graph.insert(NEW_DELHI, CHENNAI, Short.valueOf("800"));
        graph.insert(NEW_DELHI, BANGALORE, Short.valueOf("600"));
        graph.insert(NEW_DELHI, JAMMU, Short.valueOf("200"));
        graph.insert(NEW_DELHI, MUMBAI, Short.valueOf("700"));

        graph.insert(JAMMU, NEW_DELHI, Short.valueOf("200"));
        graph.insert(JAMMU, CHENNAI, Short.valueOf("1400"));
        graph.insert(JAMMU, KOLKATTA, Short.valueOf("1000"));
        graph.insert(JAMMU, MUMBAI, Short.valueOf("1500"));

        graph.insert(KOLKATTA, JAMMU, Short.valueOf("1000"));
        graph.insert(KOLKATTA, CHENNAI, Short.valueOf("600"));
        graph.insert(KOLKATTA, NEW_DELHI, Short.valueOf("900"));

        System.out.println("Chennai Connections: " + graph.get(CHENNAI));
        System.out.println("Chennai - Bangalore Distance: " + graph.get(CHENNAI, BANGALORE) + " Miles");

        System.out.println("Removing Kolkatta - New Delhi Connection: ");
        graph.delete(KOLKATTA, NEW_DELHI);

        System.out.println("Removing New Delhi - Mumbai Connection: ");
        graph.delete(NEW_DELHI, MUMBAI);

        System.out.println("Jammu Connections: " + graph.get(JAMMU));
        System.out.println("Jammu - Chennai Distance: " + graph.get(JAMMU, CHENNAI) + " Miles");
    }

    enum Cities {
        CHENNAI("Chennai/TN"),
        BANGALORE("Bangalore/KA"),
        KOLKATTA("Kolkatta/WB"),
        JAMMU("Jammu/JK"),
        NEW_DELHI("New Delhi/DL"),
        MUMBAI("Mumbai/MH");

        Cities(String description) {
        }
    }
}
