package com.learnings.practise.problems.leetcode.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        List<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                result.add(levelList.get(levelList.size() - 1));
                if(queue.isEmpty()) break;
                queue.offer(null);
                levelList = new ArrayList<>();
            } else {
                levelList.add(currentNode.val);
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return result;
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
