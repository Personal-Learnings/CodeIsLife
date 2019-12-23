package com.learnings.practise.problems.leetcode;

public class SubtreeOfAnotherTree {

    //Time Complexity is O(nm) where n and m are the number of nodes in tree s and t
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuffer sPreOrder = new StringBuffer();
        StringBuffer tPreOrder = new StringBuffer();

        traversePreOrder(sPreOrder, s);
        traversePreOrder(tPreOrder, t);

        return sPreOrder.toString().contains(tPreOrder.toString());
    }

    private void traversePreOrder(StringBuffer s, TreeNode treeNode) {
        if(treeNode == null) {
            s.append("null ");
            return;
        }
        s.append("#").append(treeNode.val);
        traversePreOrder(s, treeNode.left);
        traversePreOrder(s, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);
        tree1.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);

        System.out.println(new SubtreeOfAnotherTree().isSubtree(tree1, tree2));

        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(4);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(2);
        tree3.left.right.left = new TreeNode(0);
        tree3.right = new TreeNode(5);

        System.out.println(new SubtreeOfAnotherTree().isSubtree(tree3, tree2));

        System.out.println(new SubtreeOfAnotherTree().isSubtree(new TreeNode(12), new TreeNode(2)));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
