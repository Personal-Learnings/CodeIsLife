package com.learnings.practise.problems.leetcode.ms.explore;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

    public String serialize(TreeNode root) {
        if(root == null) return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                sb.append("null ");
            } else {
                sb.append(currentNode.val).append(" ");
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;

        String[] nodes = data.split(" ");

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> dataQueue = new LinkedList<>();

        for(String node : nodes)
            dataQueue.offer(node.equals("null") ? null : Integer.parseInt(node));

        TreeNode treeNode = new TreeNode(dataQueue.poll());
        nodeQueue.offer(treeNode);

        while(dataQueue.size() > 2) {
            Integer left = dataQueue.poll();
            Integer right = dataQueue.poll();

            TreeNode currentNode = nodeQueue.poll();
            if(currentNode != null) {
                if(left != null) {
                    currentNode.left = new TreeNode(left);
                    nodeQueue.offer(currentNode.left);
                }
                if(right != null) {
                    currentNode.right = new TreeNode(right);
                    nodeQueue.offer(currentNode.right);
                }
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        String serialize = new SerializeAndDeserializeBST().serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = new SerializeAndDeserializeBST().deserialize(serialize);
        System.out.println(deserialize);
    }

    static class TreeNode implements Serializable {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
