package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class PracticeGraph {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    PracticeGraph(List<List<Integer>> connections) {
        for(List<Integer> connection : connections) {
            int e1 = connection.get(0), e2 = connection.get(1);

            //Forward Connection
            List<Integer> edges1 = graph.getOrDefault(e1, new ArrayList<>());
            edges1.add(e2);
            graph.put(e1, edges1);

            //Reverse Connection
            List<Integer> edges2 = graph.getOrDefault(e2, new ArrayList<>());
            edges2.add(e1);
            graph.put(e2, edges2);
        }
    }

    private void breadthFirstTraversal() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>(graph.size());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while(!queue.isEmpty()) {
            Integer v = queue.poll();

            if(!visited.contains(v)) {
                sb.append(v).append(" ");
                visited.add(v);
                graph.get(v).forEach(queue::offer);
            }
        }
        System.out.println("Breadth First Search: " + sb);
    }

    private void depthFirstTraversal() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>(graph.size());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()) {
            Integer v = stack.pop();

            if(!visited.contains(v)) {
                sb.append(v).append(" ");
                visited.add(v);
                graph.get(v).forEach(stack::push);
            }
        }
        System.out.println("Depth First Search: " + sb);
    }

    public static void main(String[] args) {

        List<List<Integer>> connections = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 1),
                Arrays.asList(4, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 5),
                Arrays.asList(6, 4)
        );
        PracticeGraph graph = new PracticeGraph(connections);
        System.out.println(graph.graph);
        graph.breadthFirstTraversal();
        graph.depthFirstTraversal();
    }
}
