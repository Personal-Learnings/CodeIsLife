package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Stack;

public class ConstructBinaryTreeFromPreOrderTraversal {

    public TreeNode constructTree(int[] preOrder) {
        if(preOrder == null || preOrder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preOrder[0]);
        stack.push(root);

        for(int i = 1; i < preOrder.length; i++) {
            int currentVal = preOrder[i];
            TreeNode currentNode = new TreeNode(currentVal);

            if(currentVal < stack.peek().value) {
                stack.peek().left = currentNode;
            } else {
                TreeNode parent = stack.peek();
                while(!stack.isEmpty() && stack.peek().value < currentVal) {
                    parent = stack.pop();
                }
                parent.right = currentNode;
            }
            stack.push(currentNode);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromPreOrderTraversal().constructTree(new int[] {8, 5, 1, 7, 10, 12}));
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            value = val;
        }
    }
}