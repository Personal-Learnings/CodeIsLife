package com.learnings.practise.problems.leetcode;

import java.util.*;

public class CriticalConnectionsInANetwork {

    private List<List<Integer>> graph;
    private List<List<Integer>> criticalConnections;
    private int[] startTime;
    private int[] lowLink;
    private boolean[] visited;
    private int time = 0;

    //Time Complexity: O(V+E) for depth first search
    //Space Complexity: O(V+E)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        criticalConnections = new ArrayList<>();
        visited = new boolean[n];
        graph = new ArrayList<>();
        startTime = new int[n];
        lowLink = new int[n];

        buildGraph(connections, n);
        traverseDepthFirst(0, -1);
        return criticalConnections;
    }

    private void traverseDepthFirst(int vertex, int parent) {
        visited[vertex] = true;
        startTime[vertex] = ++time;
        lowLink[vertex] = startTime[vertex];

        for (Integer edge : graph.get(vertex)) {
            if (edge == parent) continue;

            if (!visited[edge]) {
                traverseDepthFirst(edge, vertex);
                lowLink[vertex] = Math.min(lowLink[vertex], lowLink[edge]);

                if (startTime[vertex] < lowLink[edge]) {
                    criticalConnections.add(Arrays.asList(vertex, edge));
                }
            } else {
                lowLink[vertex] = Math.min(lowLink[vertex], startTime[edge]);
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections, int n) {
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
    }

    //Time Complexity: O(V+E) for depth first search
    //Space Complexity: O(V+E) (Leet Code throws Timeout Exception but its good)
    //Hashmap Implementation
    /*private Map<Integer, List<Integer>> graph;
    private List<List<Integer>> criticalConnections;
    private int[] startTime;
    private int[] lowLink;
    private boolean[] visited;
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        criticalConnections = new ArrayList<>();
        visited = new boolean[n];
        graph = new HashMap<>();
        startTime = new int[n];
        lowLink = new int[n];

        buildGraph(connections);
        traverseDepthFirst(0, -1);
        return criticalConnections;
    }

    private void traverseDepthFirst(int vertex, int parent) {
        visited[vertex] = true;
        startTime[vertex] = ++time;
        lowLink[vertex] = startTime[vertex];

        for (Integer edge : graph.get(vertex)) {
            if (edge == parent) {
                continue;
            }

            if (!visited[edge]) {
                traverseDepthFirst(edge, vertex);
                lowLink[vertex] = Math.min(lowLink[vertex], lowLink[edge]);

                if (startTime[vertex] < lowLink[edge]) {
                    criticalConnections.add(Arrays.asList(vertex, edge));
                }
            } else {
                lowLink[vertex] = Math.min(lowLink[vertex], startTime[edge]);
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections) {
        for(List<Integer> v : connections) {
            List<Integer> edges = graph.getOrDefault(v.get(0), new ArrayList<>());
            if(!edges.contains(v.get(1))) edges.add(v.get(1));
            graph.put(v.get(0), edges);

            List<Integer> edges1 = graph.getOrDefault(v.get(1), new ArrayList<>());
            if(!edges1.contains(v.get(0))) edges1.add(v.get(0));
            graph.put(v.get(1), edges1);
        }
    }*/

    public static void main(String[] args) {
        System.out.println("Critical Connections: " + new CriticalConnectionsInANetwork().criticalConnections(4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)
        )));
    }
}
