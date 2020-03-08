package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while(!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode backTrackNode = stack.pop();
            list.add(backTrackNode.val);
            currentNode = backTrackNode.right;
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        TreeNode(int x) { val = x; }
    }
}
