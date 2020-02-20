package com.learnings.practise.problems.leetcode.general;

public class FlattenBinaryTreeToLinkedList {
    
    private TreeNode previousNode = null;

    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = previousNode;
        previousNode = root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
