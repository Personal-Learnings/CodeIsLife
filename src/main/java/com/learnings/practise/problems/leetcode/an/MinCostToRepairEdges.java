package com.learnings.practise.problems.leetcode.an;


import java.util.*;

public class MinCostToRepairEdges {

    /**
     * Time Complexity: O(e log e + e)
     * Space Complexity: O(e + v) where v is n that is number of vertices, e is the number of edges
     */
    private int getMinCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {
        if(n == 0 || edges == null || edges.length == 0 || edges[0].length < 2 || edgesToRepair == null || edgesToRepair[0].length < 3) return 0;

        //Collect all the Broken Edges
        Set<String> brokenEdges = new HashSet<>();
        for(int [] edge : edgesToRepair) {
            brokenEdges.add(edge[0] + "-" + edge[1]);
        }

        //n + 1 because my union find implementation starts from index zero
        //Merge all edges except the broken edges
        UnionFind uf = new UnionFind(n + 1);
        for(int [] edge : edges) {
            if(!brokenEdges.contains(edge[0] + "-" + edge[1])) {
                uf.union(edge[0], edge[1]);
            }
        }

        Queue<int[]> queue = new PriorityQueue<>(edgesToRepair.length, Comparator.comparingInt(a -> a[2]));
        //Add the broken edges to Min Heap
        for(int [] edge : edgesToRepair) {
            queue.offer(edge);
        }

        int costToRepair = 0;

        //checking for 2 because my union find implementation starts with index zero
        while(!queue.isEmpty() && uf.getNumOfComponents() > 2) {
            int[] connection = queue.poll();

            //Skipping if the vertex are already connected.
            if(!uf.isComponentConnected(connection[0], connection[1])) {
                uf.union(connection[0], connection[1]);
                costToRepair += connection[2];
            }
        }
        return costToRepair;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                5, new int [][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}, new int[][] {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}})
        );

        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                6, new int [][] {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}}, new int[][] {{1, 6, 410}, {2, 4, 800}})
        );

        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                6, new int [][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}}, new int[][] {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}})
        );
    }
}
