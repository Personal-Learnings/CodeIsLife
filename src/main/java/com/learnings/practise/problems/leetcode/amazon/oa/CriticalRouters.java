package com.learnings.practise.problems.leetcode.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CriticalRouters {

    private List<List<Integer>> graph;
    private List<Integer> result;
    private boolean [] visited;
    private int [] startTimes;
    private int [] endTimes;
    private int counter = -1;

    private List<Integer> getCriticalRouters(int numNodes, int numEdges, List<List<Integer>> connections) {

        if(connections == null) return Collections.emptyList();

        graph = new ArrayList<>();
        result = new ArrayList<>();
        endTimes = new int[numNodes];
        startTimes = new int[numNodes];
        visited = new boolean[numNodes];

        buildGraphData(connections, numNodes);
        traverseDepthFirst(0, -1);
        return result;
    }

    private void buildGraphData(List<List<Integer>> connections, int numNodes) {

        //Assuming vertex are in sequence
        for(int i = 0; i < numNodes; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
    }

    private void traverseDepthFirst(int vertex, int parent) {
        visited[vertex] = true;
        startTimes[vertex] = endTimes[vertex] = ++counter;

        for (Integer edge : graph.get(vertex)) {
            if (edge == parent) continue;

            if(!visited[edge]) {
                traverseDepthFirst(edge, vertex);
                endTimes[vertex] = Math.min(endTimes[vertex], endTimes[edge]);

                if(startTimes[vertex] < endTimes[edge]) {
                    result.add(edge);
                }

            } else {
                endTimes[vertex] = Math.min(endTimes[vertex], startTimes[edge]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(7, 7, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(2, 5), Arrays.asList(5, 6), Arrays.asList(3, 4)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(4, 4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)
        )));
        System.out.println("Critical Connections: " + new CriticalRouters().getCriticalRouters(5, 5, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(0, 3), Arrays.asList(0, 4), Arrays.asList(4, 2)
        )));
    }
}