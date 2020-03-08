package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInorderTraversal {

    private int index = 0;
    private int [] preOrderData = null;
    private Map<Integer, Integer> map = new HashMap<>();

    private TreeNode buildTree(int [] preOrder, int [] inOrder) {
        preOrderData = preOrder;
        for(int i = 0; i < inOrder.length; i++) map.put(inOrder[i], i);
        return build(0, inOrder.length);
    }

    private TreeNode build(int inOrderStartIndex, int inOrderEndIndex) {
        //if(preOrderCurrentIndex > preOrderData.length - 1 || inOrderStartIndex > inOrderEndIndex)
        if(inOrderStartIndex == inOrderEndIndex) return null;

        int rootVal = preOrderData[index++];
        TreeNode root = new TreeNode(rootVal);
        Integer inOrderIndex = map.get(rootVal);

        //root.left = build(preOrderData,preOrderCurrentIndex + 1, inOrderStartIndex, inOrderIndex - 1, map);
        //root.right = build(preOrderData,preOrderCurrentIndex + inOrderIndex - inOrderStartIndex + 1, inOrderIndex + 1, inOrderEndIndex, map);

        root.left = build(inOrderStartIndex, inOrderIndex);
        root.right = build(inOrderIndex + 1, inOrderEndIndex);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromPreOrderAndInorderTraversal().buildTree(new int[] {10, 19, 5, 8, 12, 15}, new int[] {5, 19, 10, 12, 8, 15}));
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