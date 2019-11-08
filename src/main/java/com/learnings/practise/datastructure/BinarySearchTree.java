package com.learnings.practise.datastructure;

public class BinarySearchTree<T> {

    private Node<T> tree;
    private int size;

    private void insert(T element) {
        tree = addNewElement(tree, element);
        ++size;
    }

    private Node<T> addNewElement(Node<T> currentNode, T element)  {
        if(currentNode == null) {
            return new Node<>(element);
        }
        else if(isGreaterThanOrEqual(currentNode.getData(), element)) {
            currentNode.setRightNode(addNewElement(currentNode.getRightNode(), element));

        } else {
            currentNode.setLeftNode(addNewElement(currentNode.getLeftNode(), element));
        }
        return currentNode;
    }

    private T search(T element) throws Exception {
        return searchElement(tree, element);
    }

    private T searchElement(Node<T> currentNode, T element) throws Exception  {
        if(null == currentNode) {
            throw new Exception(element + " Not Found");
        }
        else if(element.equals(currentNode.getData())) {
            return currentNode.getData();

        } else if(isGreaterThanOrEqual(currentNode.getData(), element)) {
             return searchElement(currentNode.getRightNode(), element);

        } else {
            return searchElement(currentNode.getLeftNode(), element);
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

        Node(T element) {
            this.data = element;
        }

        public T getData() {
            return data;
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