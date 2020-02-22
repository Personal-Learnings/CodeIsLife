package com.learnings.practise.problems.leetcode.general;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        Node leftMostNode = root;

        while(leftMostNode != null) {
            Node currentNode = leftMostNode;

            while(currentNode != null){
                if(currentNode.left != null) currentNode.left.next = currentNode.right;
                if(currentNode.right != null && currentNode.next != null) currentNode.right.next = currentNode.next.left;
                currentNode = currentNode.next;
            }
            leftMostNode = leftMostNode.left;
        }
        return root;
    }

    public Node connect_usingNSpace(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        Node previousNode = null;
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode == null) {
                if(queue.isEmpty()) break;
                queue.offer(null);
                previousNode = null;
            } else {
                if(previousNode != null) previousNode.next = currentNode;
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
                previousNode = currentNode;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) { val = x; }
    }
}