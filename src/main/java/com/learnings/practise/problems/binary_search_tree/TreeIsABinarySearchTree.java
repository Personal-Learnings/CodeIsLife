package com.learnings.practise.problems.binary_search_tree;

import com.learnings.practise.datastructure.Queue;

public class TreeIsABinarySearchTree<T> {

    private boolean isTreeABinarySearchTree(Node<T> tree) throws Exception {
        return findByInOrderTraversal(tree);
        //return findByMinMaxValue(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @SuppressWarnings("unused")
    private boolean findByPreOrder_failsWhenLeftTreeHasGreaterValueThanRoot(Node<T> currentNode) {
        if(null == currentNode) {
            return true;
        }
        if( (null == currentNode.getLeftNode() || getData(currentNode.getLeftNode()) <= getData(currentNode))
                && (null == currentNode.getRightNode() || getData(currentNode.getRightNode()) > getData(currentNode))) {

            return (findByPreOrder_failsWhenLeftTreeHasGreaterValueThanRoot(currentNode.getLeftNode())
                        && findByPreOrder_failsWhenLeftTreeHasGreaterValueThanRoot(currentNode.getRightNode()));
        }
        return false;
    }

    @SuppressWarnings("unused")
    private boolean findByMinMaxValue(Node<T> currentNode, int minValue, int maxValue) {
        if(null == currentNode) {
            return true;
        }
        return getData(currentNode) > minValue
                && getData(currentNode) < maxValue
                && findByMinMaxValue(currentNode.getLeftNode(), minValue, getData(currentNode))
                && findByMinMaxValue(currentNode.getRightNode(), getData(currentNode), maxValue);
    }

    private boolean findByInOrderTraversal(Node<T> currentNode) throws Exception {
        Queue<Integer> tempQueue = new Queue<>();
        return traverseInOrder(currentNode, tempQueue);
    }

    private boolean traverseInOrder(Node<T> currentNode, Queue<Integer> tempQueue) throws Exception {
        if(currentNode == null) return true;
        if(!traverseInOrder(currentNode.getLeftNode(), tempQueue)) return false;
        if(tempQueue.getSize() == 2 && tempQueue.dequeue() > getData(currentNode)) return false;

        tempQueue.enqueue(getData(currentNode));
        return traverseInOrder(currentNode.getRightNode(), tempQueue);
    }

    private int getData(Node<T> currentNode) {
        return Integer.parseInt(currentNode.getData().toString());
    }

    public static void main(String[] args) throws Exception {
        TreeIsABinarySearchTree<Integer> treeIsABinarySearchTree = new TreeIsABinarySearchTree<>();

        Node<Integer> tree1Left = new Node<>(new Node<>(null, 3, null), 6, new Node<>(null, 7, null));
        Node<Integer> tree1Right = new Node<>(new Node<>(null, 9, null), 11, new Node<>(null, 13, new Node<>(null, 16, null)));
        Node<Integer> tree1 = new Node<>(tree1Left, 8, tree1Right);

        Node<Integer> tree2Left = new Node<>(new Node<>(null, 8, null), 5, new Node<>(null, 9, null));
        Node<Integer> tree2Right = new Node<>(null, 7, null);
        Node<Integer> tree2 = new Node<>(tree2Left, 6, tree2Right);

        Node<Integer> tree3Left = new Node<>(new Node<>(null, 14, null), 15, new Node<>(null, 13, null));
        Node<Integer> tree3Right = new Node<>(new Node<>(null, 22, null), 25, new Node<>(null, 23, null));
        Node<Integer> tree3 = new Node<>(tree3Left, 20, tree3Right);

        Node<Integer> tree4Left = new Node<>(new Node<>(new Node<>(null, 5, null), 6, new Node<>(null, 21, null)), 10, new Node<>(null, 9, null));
        Node<Integer> tree4Right = new Node<>(new Node<>(new Node<>(null, 16, null), 17, null), 20, new Node<>(null, 25, null));
        Node<Integer> tree4 = new Node<>(tree4Left, 15, tree4Right);

        System.out.println("Is Tree 1 a Binary Search Tree ? " + treeIsABinarySearchTree.isTreeABinarySearchTree(tree1));
        System.out.println("Is Tree 2 a Binary Search Tree ? " + treeIsABinarySearchTree.isTreeABinarySearchTree(tree2));
        System.out.println("Is Tree 3 a Binary Search Tree ? " + treeIsABinarySearchTree.isTreeABinarySearchTree(tree3));
        System.out.println("Is Tree 4 a Binary Search Tree ? " + treeIsABinarySearchTree.isTreeABinarySearchTree(tree4));
    }

    private static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        Node(Node<T> leftNode, T element, Node<T> rightNode) {
            this.leftNode = leftNode;
            this.data = element;
            this.rightNode = rightNode;
        }

        T getData() {
            return data;
        }

        Node<T> getLeftNode() {
            return leftNode;
        }

        Node<T> getRightNode() {
            return rightNode;
        }
    }
}
