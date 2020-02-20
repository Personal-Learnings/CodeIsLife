package com.learnings.practise.problems.leetcode.general;

public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
    }

    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor_recursive(root.left, p, q);
        TreeNode right = lowestCommonAncestor_recursive(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
