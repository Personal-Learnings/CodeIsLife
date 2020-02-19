package com.learnings.practise.problems.leetcode.general;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

    private TreeNode prevNode = null, aNode = null, bNode = null;

    public void recoverTree(TreeNode root) {
        traverseInOrder(root);
        int temp = aNode.val;
        aNode.val = bNode.val;
        bNode.val = temp;
    }

    private void traverseInOrder(TreeNode currentNode) {
        if(currentNode == null) return;
        traverseInOrder(currentNode.left);
        if(prevNode != null && currentNode.val < prevNode.val) {
            bNode = currentNode;
            if(aNode == null) aNode = prevNode;
            else return;
        }
        prevNode = currentNode;
        traverseInOrder(currentNode.right);
    }

    private TreeNode xNode = null, yNode = null;

    public void recoverTree_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseInorder_1(root, list);

        int x = -1, y = -1;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i + 1) < list.get(i)) {
                y = list.get(i + 1);
                if(x == -1) x = list.get(i);
                else break;
            }
        }
        traverseInorderFindX_And_Y_Node_1(root, x, y);
        xNode.val = y;
        yNode.val = x;
    }

    private void traverseInorderFindX_And_Y_Node_1(TreeNode current, int x, int y) {
        if(current == null) return;
        if(current.val == x) {
            xNode = current;
        }
        if(current.val == y) {
            yNode = current;
        }
        traverseInorderFindX_And_Y_Node_1(current.left, x, y);
        traverseInorderFindX_And_Y_Node_1(current.right, x, y);
    }

    private void traverseInorder_1(TreeNode current, List<Integer> list) {
        if(current == null) return;
        traverseInorder_1(current.left, list);
        list.add(current.val);
        traverseInorder_1(current.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        root.left = left;
        left.right = new TreeNode(2);

        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(root);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}