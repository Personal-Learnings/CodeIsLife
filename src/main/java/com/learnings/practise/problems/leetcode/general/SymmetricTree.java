package com.learnings.practise.problems.leetcode.general;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2 == null) continue;
            else if(t1 == null || t2 == null) return false;
            else if(t1.val != t2.val) return false;

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public boolean isSymmetric_recursive(TreeNode root) {
        if(root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        else if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isSymmetricTree(t1.left, t2.right) && isSymmetricTree(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);

        root.left = left;
        root.right = right;

        System.out.println(new SymmetricTree().isSymmetric(root));
        System.out.println(new SymmetricTree().isSymmetric_recursive(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
