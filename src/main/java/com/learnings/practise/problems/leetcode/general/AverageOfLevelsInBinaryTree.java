package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<Double> result = new ArrayList<>();
        double levelSum = 0, levelCount = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        result.add((double) root.val);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                if(queue.isEmpty()) break;
                queue.offer(null);
                result.add(levelSum / levelCount);
                levelCount = 0; levelSum = 0;
            } else {
                if(currentNode.left != null) {
                    levelSum += currentNode.left.val;
                    levelCount++;
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    levelSum += currentNode.right.val;
                    levelCount++;
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        root.left = left;
        root.right = right;

        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
        System.out.println(averageOfLevelsInBinaryTree.averageOfLevels(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
