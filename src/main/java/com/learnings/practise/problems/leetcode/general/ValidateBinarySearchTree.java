package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class ValidateBinarySearchTree {

    private List<Integer> nodeList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        TreeNode currentNode = root;

        while(!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode node = stack.pop();
            queue.offer(node.val);

            if(queue.size() == 2) {
                Integer a = queue.poll();
                Integer b = queue.peek();
                if(a >= b) return false;
            }
            currentNode = node.right;
        }
        return true;
    }

    public boolean isValidBST_recursive(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;

        traverseInorder(root);
        for(int i = 0; i < nodeList.size() - 1; i++) {
            if(nodeList.get(i) >= nodeList.get(i + 1)) return false;
        }
        return true;
    }

    private void traverseInorder(TreeNode currentNode) {
        if(currentNode == null) return;
        traverseInorder(currentNode.left);
        nodeList.add(currentNode.val);
        traverseInorder(currentNode.right);
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

        System.out.println(new ValidateBinarySearchTree().isValidBST_recursive(root));
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
