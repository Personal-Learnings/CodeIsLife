package com.learnings.practise.algorithm;

import java.util.*;

import static com.learnings.practise.algorithm.DijkstraAlgorithm.Cities.*;

public class DijkstraAlgorithm<V> {

    private Map<V, Node<V>> explored;
    private Map<V, Integer> distanceMap;
    private Map<V, Map<V, Integer>> graphData;
    private Queue<Node<V>> queue;

    DijkstraAlgorithm(Map<V, Map<V, Integer>> graphData) {
        this.graphData = graphData;
        this.explored = new HashMap<>();
        this.distanceMap = new HashMap<>();
        this.queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
    }

    @SuppressWarnings("ConstantConditions")
    private Map<V, Integer> findShortestPath(V startVertex) {

        // Initialize the distance of all vertex to Infinity
        graphData.forEach((key, value) -> distanceMap.put(key, Integer.MAX_VALUE));

        // Add the root Node to the Queue and set its distance to 0
        queue.offer(new Node<>(startVertex, null, 0));
        distanceMap.put(startVertex, 0);

        while(explored.size() != graphData.size()) {

            //Poll the Minimum distance edge from the Queue and add to explored
            Node<V> currentNode = queue.poll();
            explored.put(currentNode.getVertex(), currentNode);

            //Process Edges
            processEdges(currentNode);
        }
        return distanceMap;
    }

    private void processEdges(Node<V> currentNode) {
        int edgeDistance, newDistance;

        //Process All Edges of the Current Vertex
        for (Map.Entry<V, Integer> entry : graphData.get(currentNode.getVertex()).entrySet()) {
            V edge = entry.getKey();

            //Process only if it is not explored
            if(!explored.containsKey(edge)) {
                edgeDistance = entry.getValue();

                //Edge Distance + Vertex distance (Distance from that vertex to Start vertex)
                newDistance = distanceMap.get(currentNode.getVertex()) + edgeDistance;

                if(newDistance < distanceMap.get(edge)) {
                    distanceMap.put(edge, newDistance);
                }
                queue.offer(new Node<>(edge, null, distanceMap.get(edge)));
            }
        }
    }

    public static void main(String[] args) {

        Map<Integer, Map<Integer, Integer>> graphData = new HashMap<>();

        Map<Integer, Integer> zero = new HashMap<>();
        zero.put(1, 9);
        zero.put(2, 6);
        zero.put(3, 5);
        zero.put(4, 3);

        Map<Integer, Integer> two = new HashMap<>();
        two.put(1, 2);
        two.put(3, 4);

        graphData.put(0, zero);
        graphData.put(1, Collections.emptyMap());
        graphData.put(2, two);
        graphData.put(3, Collections.emptyMap());
        graphData.put(4, Collections.emptyMap());

        Map<Integer, Integer> shortestPath = new DijkstraAlgorithm<>(graphData).findShortestPath(0);
        System.out.println(shortestPath);

        Map<Cities, Map<Cities, Integer>> dataMap = new HashMap<>();

        Map<Cities, Integer> chennaiMap = new HashMap<>();
        chennaiMap.put(KOLKATTA, 600);
        chennaiMap.put(JAMMU, 1400);
        chennaiMap.put(NEW_DELHI, 800);
        chennaiMap.put(MUMBAI, 600);
        chennaiMap.put(BANGALORE, 350);
        dataMap.put(CHENNAI, chennaiMap);

        Map<Cities, Integer> bangaloreMap = new HashMap<>();
        dataMap.put(BANGALORE, bangaloreMap);
        bangaloreMap.put(CHENNAI, 350);
        bangaloreMap.put(MUMBAI, 300);
        bangaloreMap.put(NEW_DELHI, 600);

        Map<Cities, Integer> mumbaiMap = new HashMap<>();
        dataMap.put(MUMBAI, mumbaiMap);
        mumbaiMap.put(JAMMU, 200);
        mumbaiMap.put(BANGALORE, 300);
        mumbaiMap.put(CHENNAI, 600);

        Map<Cities, Integer> delhiMap = new HashMap<>();
        dataMap.put(NEW_DELHI, delhiMap);
        delhiMap.put(CHENNAI, 800);
        delhiMap.put(BANGALORE, 600);
        delhiMap.put(JAMMU, 200);
        delhiMap.put(MUMBAI, 700);

        Map<Cities, Integer> jammuMap = new HashMap<>();
        dataMap.put(JAMMU, jammuMap);
        jammuMap.put(NEW_DELHI, 200);
        jammuMap.put(CHENNAI, 1400);
        jammuMap.put(KOLKATTA, 1000);
        jammuMap.put(MUMBAI, 200);

        Map<Cities, Integer> kolkattaMap = new HashMap<>();
        dataMap.put(KOLKATTA, kolkattaMap);
        kolkattaMap.put(JAMMU, 1000);
        kolkattaMap.put(CHENNAI, 600);
        kolkattaMap.put(NEW_DELHI, 900);

        Map<Cities, Integer> shortestPath1 = new DijkstraAlgorithm<>(dataMap).findShortestPath(CHENNAI);
        System.out.println(shortestPath1);
    }

    static class Node<V> {
        private V vertex;
        private V parent;
        private Integer distance;

        Node(V value, V parent, Integer distance) {
            this.vertex = value;
            this.parent = parent;
            this.distance = distance;
        }

        public V getVertex() {
            return vertex;
        }

        public Integer getDistance() {
            return distance;
        }

        public V getParent() {
            return parent;
        }
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
