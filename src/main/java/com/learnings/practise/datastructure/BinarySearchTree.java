package com.learnings.practise.datastructure;

public class BinarySearchTree<T> {

    private Node<T> tree;
    private int size;

    private void insert(T element) {
        if(isEmpty()) {
            tree = new Node<>();
            tree.setData(element);
        } else {
            addNewElement(tree, tree, element);
        }
        ++size;
    }

    private void addNewElement(Node<T> previousNode, Node<T> currentNode, T element)  {
        if(currentNode == null) {
            Node<T> newNode = new Node<>();
            newNode.setData(element);

            if(isGreaterThanOrEqual(previousNode.getData(), element)) {
                previousNode.setRightNode(newNode);
            } else {
                previousNode.setLeftNode(newNode);
            }
        }
        else if(isGreaterThanOrEqual(currentNode.getData(), element)) {
            addNewElement(currentNode, currentNode.getRightNode(), element);
        } else {
            addNewElement(currentNode, currentNode.getLeftNode(), element);
        }
    }

    private T search(T element) throws Exception {
        return searchElement(tree, tree, element);
    }

    private T searchElement(Node<T> previousNode, Node<T> currentNode, T element) throws Exception  {
        if(element.equals(previousNode.getData())) {
            return previousNode.getData();

        } else if(null == currentNode) {
            throw new Exception(element + " Not Found");

        } else if(isGreaterThanOrEqual(currentNode.getData(), element)) {
             return searchElement(currentNode, currentNode.getRightNode(), element);

        } else {
            return searchElement(currentNode, currentNode.getLeftNode(), element);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private boolean isGreaterThanOrEqual(T currentNode, T newNode) {
        return (Integer) newNode >= (Integer) currentNode;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(12);
        binarySearchTree.insert(7);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);

        binarySearchTree.insert(19);
        binarySearchTree.insert(27);
        binarySearchTree.insert(18);

        System.out.println("Searching 12   : " + binarySearchTree.search(12));
        System.out.println("Searching 27   : " + binarySearchTree.search(27));

        try {
            binarySearchTree.search(32);
        } catch (Exception e) {
            System.out.println("Searching 32   : " + e.getMessage());
        }
        System.out.println("Searching 5   : " + binarySearchTree.search(5));
    }

    private static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node<T> getLeftNode() {
            return leftNode;
        }

        void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        Node<T> getRightNode() {
            return rightNode;
        }

        void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }
    }
}