package com.learnings.practise.problems.leetcode.general;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return ((left == 0 || right == 0) ? (left + right) : Math.min(left, right)) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
