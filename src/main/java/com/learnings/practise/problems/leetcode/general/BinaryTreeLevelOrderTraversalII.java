package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);
        result.add(Collections.singletonList(root.val));

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                if(queue.isEmpty()) break;

                result.add(0, levelList);
                levelList = new ArrayList<>();
                queue.offer(null);

            } else {
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                    levelList.add(currentNode.left.val);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                    levelList.add(currentNode.right.val);
                }
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

        System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
