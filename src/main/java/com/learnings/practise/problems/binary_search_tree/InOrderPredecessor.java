package com.learnings.practise.problems.binary_search_tree;

public class InOrderPredecessor<T> {

    private Integer findInOrderPredecessor(Node<T> tree, T data) throws Exception {
        Node<T> foundNode = search(tree, data);
        if(null == foundNode) {
            throw new Exception(String.format("Node %s Not Found.", data));
        } else {
            if(null == foundNode.getLeftNode()) {
                Integer predecessor = null;
                Node<T> iteratorNode = tree;

                while(!iteratorNode.getData().equals(foundNode.getData())) {
                    if((Integer) iteratorNode.getData() < (Integer) foundNode.getData()) {
                        predecessor = (Integer) iteratorNode.getData();
                        iteratorNode = iteratorNode.getRightNode();
                    } else {
                        iteratorNode = iteratorNode.getLeftNode();
                    }
                }

                if(predecessor == null) {
                    throw new Exception(String.format("Predecessor Node Not Found as Node %s is the Least Node in the Tree.", data));
                }
                return predecessor;
            } else {
                return (Integer) getMax(foundNode.getLeftNode(), foundNode.getLeftNode());
            }
        }
    }

    private T getMax(Node<T> parentNode, Node<T> currentNode) {
        if(currentNode == null) return parentNode.getData();
        return getMax(currentNode, currentNode.getRightNode());
    }

    private Node<T> search(Node<T> currentNode, T data) {
        if(currentNode == null) return null;
        else if(currentNode.getData().equals(data)) {
            return currentNode;
        } else if((Integer) currentNode.getData() > (Integer) data) {
            return search(currentNode.getLeftNode(), data);
        } else {
            return search(currentNode.getRightNode(), data);
        }
    }

    public static void main(String[] args) throws Exception {
        Node<Integer> tree = setupAndGetData();
        InOrderPredecessor<Integer> inOrderPredecessor = new InOrderPredecessor<>();
        try {
            inOrderPredecessor.findInOrderPredecessor(tree, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Inorder Predecessor of 19 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 19));
        System.out.println("Inorder Predecessor of 5 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 5));
        System.out.println("Inorder Predecessor of 7 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 7));
        System.out.println("Inorder Predecessor of 12 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 12));
        System.out.println("Inorder Predecessor of 16 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 16));
        System.out.println("Inorder Predecessor of 10 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 10));
        System.out.println("Inorder Predecessor of 13 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 13));
        System.out.println("Inorder Predecessor of 42 is: " + inOrderPredecessor.findInOrderPredecessor(tree, 42));
        try {
            inOrderPredecessor.findInOrderPredecessor(tree, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Node<Integer> setupAndGetData() {
        Node<Integer> treeLeft = new Node<>(
                new Node<>(
                        new Node<>(new Node<>(null, 3, null),
                                4,
                                null
                        ),
                        5,
                        new Node<>(
                                new Node<>(
                                        new Node<>(null, 6, null),
                                        7,
                                        null
                                ),
                                8,
                                null
                        )
                ),
                9,
                new Node<>(
                        new Node<>(null, 10, null),
                        11,
                        new Node<>(null, 12, null))
        );
        Node<Integer> treeRight = new Node<>(
                new Node<>(
                        new Node<>(
                                new Node<>(null, 14, null),
                                15,
                                null
                        ),
                        16,
                        null
                ),
                19,
                new Node<>(
                        null,
                        27,
                        new Node<>(
                                null,
                                32,
                                new Node<>(null, 42, null)
                        )));

        return new Node<>(
                treeLeft,
                13,
                treeRight
        );
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
