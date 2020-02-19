package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    private Map<Integer, Set<Pair>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for(Set<Pair> set : map.values()) {
            List<Integer> vLevel = new ArrayList<>();
            for(Pair p : set) vLevel.add(p.getVal());
            result.add(vLevel);
        }
        return result;
    }

    private void traverse(TreeNode currentNode, int level, int position) {
        if(currentNode == null) return;

        Set<Pair> set = map.getOrDefault(position, new TreeSet<>((p1, p2) -> p1.level == p2.level ? Integer.compare(p1.val, p2.val) : Integer.compare(p1.level, p2.level)));
        set.add(new Pair(currentNode.val, level));
        map.put(position, set);

        traverse(currentNode.left, level + 1, position - 1);
        traverse(currentNode.right, level + 1, position + 1);
    }

    private static class Pair {
        private int val;
        private int level;

        Pair(int value, int level) {
            this.val = value;
            this.level = level;
        }
        public int getVal() { return val; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        root.left = left;
        root.right = right;
        System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
