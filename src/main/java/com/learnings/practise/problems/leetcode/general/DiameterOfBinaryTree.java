package com.learnings.practise.problems.leetcode.general;

public class DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    private int findMax(TreeNode currentNode) {
        if(currentNode == null) return 0;
        int leftMax = findMax(currentNode.left);
        int rightMax = findMax(currentNode.right);

        max = Math.max(max, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
