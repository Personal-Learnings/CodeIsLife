package com.learnings.practise.problems.leetcode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    // Time Complexity: O(N), where N is the number of nodes in the tree.
    // Space Complexity: O(N) where N is the number of nodes in the tree (Where variable queue will have maximum of n elements)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flip = true;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();

        if(null == root) {
            return Collections.emptyList();
        }

        //Adding a null to Track the Completion of Level
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode != null) {
                //If flip is true add to the last of the queue or else add to the first of the queue
                if(flip) levelList.offer(currentNode.val);
                else levelList.addFirst(currentNode.val);

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            } else {
                flip = !flip;
                result.add(levelList);
                levelList = new LinkedList<>();

                //Adding null as a level completion identifier
                if(!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return result;
    }

    /*private List<List<Integer>> result = new ArrayList<>();
    private Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        AtomicInteger i = new AtomicInteger();
        if(root == null) {
            return Collections.emptyList();
        }
        queue.add(root);
        result.add(Collections.singletonList(root.val));

        while(!queue.isEmpty()) {
            List<TreeNode> treeNodes = new ArrayList<>();
            while(!queue.isEmpty()) {
                treeNodes.add(queue.poll());
            }
            List<Integer> levelOrder = getLevelOrder(treeNodes);
            if(!levelOrder.isEmpty()) {
                int value = i.getAndIncrement();
                if(value % 2 == 0) {
                    Collections.reverse(levelOrder);
                }
                result.add(levelOrder);
            }
        }
        return result;
    }

    private List<Integer> getLevelOrder(List<TreeNode> treeNodes) {
        List<Integer> level = new ArrayList<>();
        for(TreeNode treeNode : treeNodes) {
            if(treeNode != null) {
                if(treeNode.left != null) {
                    level.add(treeNode.left.val);
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    level.add(treeNode.right.val);
                    queue.add(treeNode.right);
                }
            }
        }
        return level;
    }*/

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        r.left = new TreeNode(15);
        r.right = new TreeNode(7);
        t.right = r;
        //System.out.println(bt.zigzagLevelOrder(t));
        System.out.println(bt.zigzagLevelOrder(t));
        System.out.println(bt.zigzagLevelOrder(null));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
