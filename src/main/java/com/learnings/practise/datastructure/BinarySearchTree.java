package com.learnings.practise.datastructure;

public class BinarySearchTree<T> {

    private Node<T> tree;
    private int size;

    public void insert(T element) {
        tree = addNewElement(tree, element);
        ++size;
    }

    private Node<T> addNewElement(Node<T> currentNode, T element)  {
        if(currentNode == null) {
            return new Node<>(element);
        }
        else if(isGreater(currentNode.getData(), element)) {
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

        } else if(isGreater(currentNode.getData(), element)) {
             return searchElement(currentNode.getRightNode(), element);

        } else {
            return searchElement(currentNode.getLeftNode(), element);
        }
    }

    private T getMin() throws Exception {
        if(isEmpty()) {
            throw new Exception("Binary Search Tree is Empty.");
        }
        return findMin(tree, tree).getData();
    }

    private Node<T> findMin(Node<T> previousNode, Node<T> currentNode) {
        if(currentNode == null) {
           return previousNode;
        } else {
            return findMin(currentNode, currentNode.getLeftNode());
        }
    }

    private T getMax() throws Exception {
        if(isEmpty()) {
            throw new Exception("Binary Search Tree is Empty.");
        }
        return findMax(tree, tree).getData();
    }

    private Node<T>  findMax(Node<T> previousNode, Node<T> currentNode) {
        if(currentNode == null) {
            return previousNode;
        } else {
            return findMax(currentNode, currentNode.getRightNode());
        }
    }

    private int getHeight() {
        return findHeight(tree);
    }

    private int findHeight(Node<T> node) {
        if(node == null) {
            return -1;
        }
        return Math.max(findHeight(node.getLeftNode()), findHeight(node.getRightNode())) + 1;
    }

    /** Enabled for Practise Purpose */
    public Node<T> getTree() {
        return tree;
    }

    private String getTreeByLevelOrder_breadthFirst() throws Exception {
        Queue<String> levelOrderQueue = new Queue<>();
        Queue<Node<T>> levelData = new Queue<>();
        levelData.enqueue(tree);

        while(!levelData.isEmpty()) {
            Node<T> currentNode = levelData.dequeue();
            if(null != currentNode) {
                if(null != currentNode.getLeftNode()) {
                    levelData.enqueue(currentNode.getLeftNode());
                }
                if(null != currentNode.getRightNode()) {
                    levelData.enqueue(currentNode.getRightNode());
                }
                levelOrderQueue.enqueue(currentNode.getData().toString());
            }
        }
        return levelOrderQueue.toString();
    }

    private String getTreeByPreOrder_depthFirst() {
        StringBuilder result = new StringBuilder();
        traversePreOrder(tree, result);
        return result.toString();
    }

    private void traversePreOrder(Node<T> currentNode, StringBuilder result) {
        if(currentNode == null) return;
        result.append(formatData(currentNode.getData()));
        traversePreOrder(currentNode.getLeftNode(), result);
        traversePreOrder(currentNode.getRightNode(), result);
    }

    private String getTreeByInOrder_depthFirst() {
        StringBuilder result = new StringBuilder();
        traverseInOrder(tree, result);
        return result.toString();
    }

    private void traverseInOrder(Node<T> currentNode, StringBuilder result) {
        if(currentNode == null) return;
        traverseInOrder(currentNode.getLeftNode(), result);
        result.append(formatData(currentNode.getData()));
        traverseInOrder(currentNode.getRightNode(), result);
    }

    private String getTreeByPostOrder_depthFirst() {
        StringBuilder result = new StringBuilder();
        traversePostOrder(tree, result);
        return result.toString();
    }

    private void traversePostOrder(Node<T> currentNode, StringBuilder result) {
        if(currentNode == null) return;
        traversePostOrder(currentNode.getLeftNode(), result);
        traversePostOrder(currentNode.getRightNode(), result);
        result.append(formatData(currentNode.getData()));
    }

    private String formatData(T data) {
        return "|" + data + "| ";
    }

    private void delete(T data) {
        if(tree == null) {
            System.out.println("Tree is Empty");
            return;
        }
        deleteEntry(tree, tree, data);
    }

    private void deleteEntry(Node<T> parentNode, Node<T> currentNode, T data) {
        if(currentNode != null) {
            if (data.equals(currentNode.getData())) {

                if(isLeafNode(currentNode)) {
                    if((Integer) currentNode.getData() > (Integer) parentNode.getData()) {
                        parentNode.setRightNode(null);
                    } else {
                        parentNode.setLeftNode(null);
                    }
                } else if(hasOneChild(currentNode)) {
                    if(currentNode.getLeftNode() != null) {
                        parentNode.setLeftNode(currentNode.getLeftNode());
                    } else {
                        parentNode.setRightNode(currentNode.getRightNode());
                    }
                } else {
                    Node<T> minNode = findMin(currentNode.getRightNode(), currentNode.getRightNode());
                    currentNode.setData(minNode.getData());

                    deleteEntry(currentNode, currentNode.getRightNode(), minNode.getData());
                }
            } else if ((Integer) data > (Integer) currentNode.getData()) {
                deleteEntry(currentNode, currentNode.getRightNode(), data);
            } else {
                deleteEntry(currentNode, currentNode.getLeftNode(), data);
            }
        } else {
            System.out.println(String.format("Node %s Not Found", data));
        }
    }

    private boolean hasOneChild(Node<T> currentNode) {
        return (currentNode.getLeftNode() == null ^ currentNode.getRightNode() == null);
    }

    private boolean isLeafNode(Node<T> currentNode) {
        return (currentNode.getLeftNode() == null && currentNode.getRightNode() == null);
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

    private boolean isGreater(T currentNode, T newNode) {
        return (Integer) newNode > (Integer) currentNode;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        try {
            binarySearchTree.getMin();
        } catch (Exception e) {
            System.out.println("Min of Tree   : " + e.getMessage());
        }

        try {
            binarySearchTree.getMax();
        } catch (Exception e) {
            System.out.println("Max of Tree   : " + e.getMessage());
        }
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 13  : ");
        binarySearchTree.insert(13);
        System.out.println("Min of Tree   : " + binarySearchTree.getMin());
        System.out.println("Max of Tree   : " + binarySearchTree.getMax());
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 9   : ");
        binarySearchTree.insert(9);
        System.out.println("Min of Tree   : " + binarySearchTree.getMin());
        System.out.println("Max of Tree   : " + binarySearchTree.getMax());
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 5   : ");
        binarySearchTree.insert(5);

        System.out.println("Inserting 8   : ");
        binarySearchTree.insert(8);

        System.out.println("Inserting 19  : ");
        binarySearchTree.insert(19);

        System.out.println("Inserting 27  : ");
        binarySearchTree.insert(27);

        System.out.println("Inserting 16  : ");
        binarySearchTree.insert(16);

        System.out.println("Inserting 15  : ");
        binarySearchTree.insert(15);

        System.out.println("Inserting 14  : ");
        binarySearchTree.insert(14);

        System.out.println("Min of Tree   : " + binarySearchTree.getMin());
        System.out.println("Max of Tree   : " + binarySearchTree.getMax());
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Searching 12  : " + binarySearchTree.search(13));
        System.out.println("Searching 27  : " + binarySearchTree.search(27));

        try {
            binarySearchTree.search(32);
        } catch (Exception e) {
            System.out.println("Searching 32  : " + e.getMessage());
        }
        System.out.println("Searching 5   : " + binarySearchTree.search(5));

        System.out.println("Inserting 4   : ");
        binarySearchTree.insert(4);
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 3   : ");
        binarySearchTree.insert(3);
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 32  : ");
        binarySearchTree.insert(32);
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 42  : ");
        binarySearchTree.insert(42);
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 52  : ");
        binarySearchTree.insert(52);
        System.out.println("Tree Height   : " + binarySearchTree.getHeight());

        System.out.println("Inserting 62  : ");
        binarySearchTree.insert(62);

        System.out.println("Inserting 7  : ");
        binarySearchTree.insert(7);

        System.out.println("Inserting 11  : ");
        binarySearchTree.insert(11);

        System.out.println("Inserting 10  : ");
        binarySearchTree.insert(10);

        System.out.println("Inserting 12  : ");
        binarySearchTree.insert(12);

        System.out.println("Tree Height   : " + binarySearchTree.getHeight());
        System.out.println("Min of Tree   : " + binarySearchTree.getMin());
        System.out.println("Max of Tree   : " + binarySearchTree.getMax());

        System.out.println("Print Level Order / Breadth First Binary Tree Traversal : " + binarySearchTree.getTreeByLevelOrder_breadthFirst());
        System.out.println("Print Pre Order / Depth First Binary Tree Traversal     : " + binarySearchTree.getTreeByPreOrder_depthFirst());
        System.out.println("Print In Order / Depth First Binary Tree Traversal      : " + binarySearchTree.getTreeByInOrder_depthFirst());
        System.out.println("Print Post Order / Depth First Binary Tree Traversal    : " + binarySearchTree.getTreeByPostOrder_depthFirst());

        binarySearchTree.delete(8);
        binarySearchTree.delete(62);

        binarySearchTree.delete(92);

        binarySearchTree.delete(42);
        binarySearchTree.delete(4);

        binarySearchTree.delete(19);
        binarySearchTree.delete(9);
        binarySearchTree.delete(13);
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