package com.learnings.practise.problems.leetcode.an;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubtreeWithMaximumAverage {

    private Node maxNode = null;
    private double maxAverage = -1;

    /**
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public int getSubTreeWithMaximumAverage(Node root) {
        if(root == null) return 0;
        if(root.children == null || root.children.isEmpty()) return root.val;

        findAverage(root);
        return maxNode.val;
    }

    //Recursively travel down the tree and start calculating the average once the bottom of the tree is reached and get the maximum
    public double[] findAverage(Node node){
        if(node == null) return new double[] { 0, 0 };

        double currentSum = node.val;
        double noOfNodes = 1;

        for(Node child : node.children) {
            double [] temp = findAverage(child);
            noOfNodes += temp[0];
            currentSum += temp[1];
        }

        double average = currentSum / noOfNodes;

        //Checking for > 1 as the question says the node should have 1 child so ignoring the leaf nodes
        if (noOfNodes > 1 && average > maxAverage) {
            maxAverage = average;
            maxNode = node;
        }
        return new double[] { noOfNodes, currentSum };
    }

    static class Node {
        public int val;
        public List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node left = new Node(12);
        left.children = Arrays.asList(new Node(11), new Node(2), new Node(3));

        Node right = new Node(18);
        right.children = Arrays.asList(new Node(15), new Node(8));

        Node root = new Node(20);
        root.children = Arrays.asList(left, right);

        System.out.println(new SubtreeWithMaximumAverage().getSubTreeWithMaximumAverage(root));
        System.out.println(new SubtreeWithMaximumAverage().getSubTreeWithMaximumAverage(new Node(20)));
    }
}