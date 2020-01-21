package com.learnings.practise.problems.leetcode.an;

public class SubtreeOfAnotherTree {

    /**
     * Time Complexity: O(N * M) after removing smaller terms  O((n+m) + n*m) where n and m are number of nodes in Trees S and T.
     * Takes n + m time for Pre Order Traversal and n*m time for indexOf
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuffer sPreOrder = new StringBuffer();
        StringBuffer tPreOrder = new StringBuffer();

        traversePreOrder(sPreOrder, s);
        traversePreOrder(tPreOrder, t);

        return sPreOrder.toString().contains(tPreOrder.toString());
    }

    private void traversePreOrder(StringBuffer s, TreeNode treeNode) {
        if(treeNode == null) {
            s.append("null");
            return;
        }
        s.append("#").append(treeNode.val);
        traversePreOrder(s, treeNode.left);
        traversePreOrder(s, treeNode.right);
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