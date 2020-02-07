package com.learnings.practise.problems.leetcode.general;

import java.io.*;
import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if(root == null) return null;

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if(tree != null) {
                result.append(tree.val).append(",");
                queue.offer(tree.left);
                queue.offer(tree.right);
            } else {
                result.append((String) null).append(",");
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;

        String [] a = data.split(",");
        if(a[0] == null || a[0].equals("null")) return null;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<String> dataQueue = new LinkedList<>(Arrays.asList(a));

        TreeNode root = new TreeNode(Integer.parseInt(dataQueue.poll()));
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty() && dataQueue.size() > 1) {
            String leftElement = dataQueue.poll();
            String rightElement = dataQueue.poll();
            TreeNode node = treeNodeQueue.poll();

            if(node != null) {
                if(leftElement != null && !leftElement.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(leftElement));
                    treeNodeQueue.offer(node.left);
                }
                if(rightElement != null && !rightElement.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(rightElement));
                    treeNodeQueue.offer(node.right);
                }
            }
        }
        return root;
    }

    //Solved using Java ObjectStream and ByteArrayStream
    public String serialize_stream(TreeNode root) {
        try {
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( byteOutputStream );
            objectOutputStream.writeObject(root);
            objectOutputStream.close();
            return Base64.getEncoder().encodeToString(byteOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TreeNode deserialize_stream(String data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(data));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (TreeNode) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class TreeNode implements Serializable {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String serializedData = serializeAndDeserializeBinaryTree.serialize(treeNode);
        System.out.println(serializedData);
        serializeAndDeserializeBinaryTree.deserialize(serializedData);

        treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(7);
        treeNode.right.right.right.right = new TreeNode(9);

        serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        serializedData = serializeAndDeserializeBinaryTree.serialize(treeNode);
        System.out.println(serializedData);
        serializeAndDeserializeBinaryTree.deserialize(serializedData);
    }
}