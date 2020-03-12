package com.learnings.practise.problems.leetcode.ms.explore;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        StringBuilder sb1 = new StringBuilder();
        traverseTree(p, sb1);

        StringBuilder sb2 = new StringBuilder();
        traverseTree(q, sb2);

        return sb1.toString().equals(sb2.toString());
    }

    private void traverseTree(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null").append("#");
            return;
        }
        sb.append(node.val).append("#");
        traverseTree(node.left, sb);
        traverseTree(node.right, sb);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            val = value;
        }
    }
}
