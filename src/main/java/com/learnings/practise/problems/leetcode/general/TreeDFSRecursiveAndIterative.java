package com.learnings.practise.problems.leetcode.general;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeDFSRecursiveAndIterative {

    private String getLevelOrder_Iterative(TreeNode root) {
        if(root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode != null) {
                result.append(currentNode.val).append(" ");
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        return result.toString();
    }

    private String getPreOrder_recursive(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        traversePreOrder(root, sb);
        return sb.toString();
    }

    private void traversePreOrder(TreeNode currentNode, StringBuilder sb) {
        if(currentNode == null) return;
        sb.append(currentNode.val).append(" ");
        traversePreOrder(currentNode.left, sb);
        traversePreOrder(currentNode.right, sb);
    }

    private String getPreOrder_Iterative(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if(currentNode != null) {
                sb.append(currentNode.val).append(" ");
                if(currentNode.right != null) stack.push(currentNode.right);
                if(currentNode.left != null) stack.push(currentNode.left);
            }
        }
        return sb.toString();
    }

    private String getInOrder_recursive(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        traverseInOrder(root, sb);
        return sb.toString();
    }

    private void traverseInOrder(TreeNode currentNode, StringBuilder sb) {
        if(currentNode == null) return;
        traverseInOrder(currentNode.left, sb);
        sb.append(currentNode.val).append(" ");
        traverseInOrder(currentNode.right, sb);
    }

    private String getInOrder_Iterative(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while(!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode backTrackNode = stack.pop();
            sb.append(backTrackNode.val).append(" ");
            currentNode = backTrackNode.right;
        }
        return sb.toString();
    }

    private String getPostOrder_recursive(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePostOrder(root, sb);
        return sb.toString();
    }

    private String getPostOrder_Iterative(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            outputStack.push(currentNode.val);

            if(currentNode.left != null) nodeStack.push(currentNode.left);
            if(currentNode.right != null) nodeStack.push(currentNode.right);
        }

        while(!outputStack.isEmpty()) sb.append(outputStack.pop()).append(" ");
        return sb.toString();
    }

    private void traversePostOrder(TreeNode currentNode, StringBuilder sb) {
        if(currentNode == null) return;
        traversePostOrder(currentNode.left, sb);
        traversePostOrder(currentNode.right, sb);
        sb.append(currentNode.val).append(" ");
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

        System.out.println("Level Order: " + new TreeDFSRecursiveAndIterative().getLevelOrder_Iterative(root) + "\n");

        System.out.println("Pre Order Recursive: " + new TreeDFSRecursiveAndIterative().getPreOrder_recursive(root));
        System.out.println("Pre Order Iterative: " + new TreeDFSRecursiveAndIterative().getPreOrder_Iterative(root) + "\n");

        System.out.println("In Order Recursive: " + new TreeDFSRecursiveAndIterative().getInOrder_recursive(root));
        System.out.println("In Order Iterative: " + new TreeDFSRecursiveAndIterative().getInOrder_Iterative(root) + "\n");

        System.out.println("Post Order Recursive: " + new TreeDFSRecursiveAndIterative().getPostOrder_recursive(root));
        System.out.println("Post Order Iterative: " + new TreeDFSRecursiveAndIterative().getPostOrder_Iterative(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
