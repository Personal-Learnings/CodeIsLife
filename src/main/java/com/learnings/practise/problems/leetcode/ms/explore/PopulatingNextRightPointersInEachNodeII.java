package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    private Node previous = null;
    private Node leftmostNode = null;

    public Node connect(Node root) {
        if(root == null) return null;

        leftmostNode = root;
        while(leftmostNode != null) {
            Node current = leftmostNode;

            previous = null;
            leftmostNode = null;

            while(current != null) {
                createConnection(current.left);
                createConnection(current.right);
                current = current.next;
            }
        }
        return root;
    }

    private void createConnection(Node current) {
        if(current != null ) {
            if(previous != null) previous.next = current;
            if(leftmostNode == null) leftmostNode = current;
            previous = current;
        }
    }

    public Node connect_extraSpace(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        Node previous = null;
        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current != null) {
                if(previous != null) previous.next = current;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                previous = current;

            } else {
                if(queue.isEmpty()) break;
                else {
                    queue.offer(null);
                    previous = null;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right = new Node(3);
        n.right.right = new Node(7);

        new PopulatingNextRightPointersInEachNodeII().connect(n);
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) { val = x; }
    }
}