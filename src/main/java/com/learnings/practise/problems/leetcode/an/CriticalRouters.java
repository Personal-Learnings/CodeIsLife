package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class CriticalRouters {

    private boolean [] criticalConnections;
    private List<List<Integer>> graph;
    private int noOfOutbound = 0;
    private boolean [] visited;
    private int [] startTimes;
    private int counter = -1;
    private int [] endTimes;

    private List<Integer> getCriticalRouters(int numNodes, List<List<Integer>> connections) {

        if(connections == null || connections.isEmpty() || numNodes == 0) return Collections.emptyList();

        graph = new ArrayList<>();
        endTimes = new int[numNodes];
        startTimes = new int[numNodes];
        visited = new boolean[numNodes];
        criticalConnections = new boolean[numNodes];

        buildGraphData(connections, numNodes);

        for(int i = 0; i < numNodes; i++) {
            if(!visited[i]) {
                noOfOutbound = 0;
                traverseDepthFirst(i, i, -1);
                criticalConnections[i] = noOfOutbound > 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < criticalConnections.length; i++) {
            if(criticalConnections[i]) result.add(i);
        }
        return result;
    }

    private void traverseDepthFirst(int root, int vertex, int parent) {
        visited[vertex] = true;
        if(root == parent) noOfOutbound++;
        startTimes[vertex] = endTimes[vertex] = counter++;

        for (Integer edge : graph.get(vertex)) {
            if (edge == parent) continue;

            if(!visited[edge]) {
                traverseDepthFirst(root, edge, vertex);
                endTimes[vertex] = Math.min(endTimes[vertex], endTimes[edge]);

                if(startTimes[vertex] <= endTimes[edge]) {
                    criticalConnections[vertex] = true;
                }
            } else {
                endTimes[vertex] = Math.min(endTimes[vertex], startTimes[edge]);
            }
        }
    }

    private void buildGraphData(List<List<Integer>> connections, int numNodes) {
        for(int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        //Assuming vertex are in sequence and starts from zero and given numNodes = num of vertices in graph
        for(List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
    }

    public static void main(String[] args) {
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(7, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(2, 5), Arrays.asList(5, 6), Arrays.asList(3, 4)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(5, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(0, 3), Arrays.asList(0, 4), Arrays.asList(4, 2)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(5, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(0, 4), Arrays.asList(1, 4), Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 1)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(5, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4), Arrays.asList(4, 1)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 0)
        )));
    }
}