package com.learnings.practise.problems.leetcode.an;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllNodes {

    /**
     * Time Complexity: O(e log e + e)
     * Space Complexity: O(e + v) where v is n that is number of vertices, e is the number of edges
     */
    private int getMinimumCostToConnectAllNodes(int n, int [][] edges, int [][] newEdges) {

        if(n == 0 || edges == null || edges.length == 0 || edges[0].length < 2 || newEdges == null || newEdges[0].length < 3) return 0;

        //n + 1 because my union find implementation starts from index zero
        UnionFind uf = new UnionFind(n + 1);
        int minCost = 0;

        //Merge the edges
        for(int [] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        Queue<int[]> queue = new PriorityQueue<>(newEdges.length, Comparator.comparingInt(a -> a[2]));
        //Add the new edges to Min Heap
        for(int [] newEdge : newEdges) {
            queue.offer(newEdge);
        }

        //checking for 2 because my union find implementation starts with index zero
        while(!queue.isEmpty() && uf.getNumOfComponents() > 2) {
            int[] connection = queue.poll();

            //Skipping if the vertex are already connected.
            if(!uf.isComponentConnected(connection[0], connection[1])) {
                uf.union(connection[0], connection[1]);
                minCost += connection[2];
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToConnectAllNodes().getMinimumCostToConnectAllNodes(
                6, new int [][] {{1, 4}, {4, 5}, {2, 3}}, new int[][] {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}})
        );
    }
}

class UnionFind {

    //To Track the number of Vertices
    private int size;

    //To Track id of the Parent
    private int [] id;

    //To Track each Component Sizes
    private int [] perComponentSize;

    //To Track the number of connected components
    private int numOfComponents;

    /**
     * @param size - Number of Vertices
     */
    UnionFind(int size) {
        if(size <= 0) throw new IllegalArgumentException("Cannot process with zero vertices");
        id = new int[size];
        perComponentSize = new int[size];
        this.size = this.numOfComponents = size;

        //Initialize all vertices as parent or self-loop and initialize all components to size one
        for(int i = 0; i < size; i++) {
            id[i] = i;
            perComponentSize[i] = 1;
        }
    }

    /**
     * Finds the parent / group of the given vertex and does path compression for easy access
     */
    public int find(int vertex) {
        if(vertex >= getSize()) throw new IllegalArgumentException("Invalid Vertex");

        //Find the parent of the Vertex.
        int root = vertex;
        while(root != id[root]) {
            root = id[root];
        }

        //Perform Path Compression for Enhanced Performance
        //Starting from vertex converting all parent to point to root node
        while(vertex != root) {
            int parent = id[vertex];
            id[vertex] = root;
            vertex = parent;
        }
        return root;
    }

    /**
     * Merges two dis-joined sets
     */
    public void union(int vertexA, int vertexB) {

        int aRoot = find(vertexA);
        int bRoot = find(vertexB);

        //If they belong to the same group just skip.
        if(aRoot == bRoot) return;

        //Merge the component to the other component who's component size is greater.
        //While merging also increase the component size of the parent
        if(perComponentSize[aRoot] > perComponentSize[bRoot]) {
            perComponentSize[aRoot] += perComponentSize[bRoot];
            id[bRoot] = id[aRoot];
        } else {
            perComponentSize[bRoot] += perComponentSize[aRoot];
            id[aRoot] = id[bRoot];
        }

        //After the merge the number of connected components is reduced.
        numOfComponents--;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfComponents() {
        return numOfComponents;
    }

    public boolean isComponentConnected(int vertexA, int vertexB) {
        return find(vertexA) == find(vertexB);
    }

    /*
    public int getComponentSize(int vertex) {
        return perComponentSize[find(vertex)];
    }
    */
}
