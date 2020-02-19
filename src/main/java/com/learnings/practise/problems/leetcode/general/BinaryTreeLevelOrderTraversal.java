package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        result.add(Collections.singletonList(root.val));

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode != null) {
                if(currentNode.left != null) {
                    tempResult.add(currentNode.left.val);
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    tempResult.add(currentNode.right.val);
                    queue.offer(currentNode.right);
                }
            } else {
                if(queue.isEmpty()) break;

                queue.offer(null);
                result.add(tempResult);
                tempResult = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        root.left = left;
        root.right = right;

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}