package com.learnings.practise.problems.leetcode.general;

public class BinarySearchTreeToGreaterSumTree {

    int max = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode currentNode) {
        if(currentNode == null) return;
        traverse(currentNode.right);

        max += currentNode.val;
        currentNode.val = max;

        traverse(currentNode.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(new BinarySearchTreeToGreaterSumTree().bstToGst(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
