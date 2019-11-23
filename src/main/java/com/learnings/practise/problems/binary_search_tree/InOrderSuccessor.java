package com.learnings.practise.problems.binary_search_tree;

public class InOrderSuccessor<T> {

    private Integer findInOrderSuccessorNode(Node<T> tree, T data) throws Exception {
        return traverseInOrder(tree, data);
    }

    private Integer traverseInOrder(Node<T> tree, T data) throws Exception {
        if(tree == null) return null;
        Node<T> nodeFound = search(tree, data);
        if(null == nodeFound) throw new Exception(String.format("Node %s not found", data));
        return (nodeFound.getRightNode() == null)
                ? findMaxOfAncestors(tree, nodeFound.getData())
                : findMinOfRightNode(nodeFound.getRightNode(), nodeFound.getRightNode());
    }

    private Integer findMaxOfAncestors(Node<T> tree, T data) {
        T ancestor =  null;
        Node<T> iteratorNode =  tree;

        while(!iteratorNode.getData().equals(data)) {
            if((Integer) iteratorNode.getData() > (Integer) data) {
                ancestor = iteratorNode.getData();
                iteratorNode = iteratorNode.getLeftNode();
            } else {
                iteratorNode = iteratorNode.getRightNode();
            }
        }
        return (Integer) ancestor;

        /** Using Stack
         *  Stack<T> ancestors = new Stack<>();
            getAncestorsOfGivenElement(tree, data, ancestors);
            while(!ancestors.isEmpty()) {
                T ancestor = ancestors.pop();
                if((Integer) ancestor > (Integer) data) {
                    return (Integer) ancestor;
                }
            }
            throw new Exception(String.format("Node %s is the last node hence does not have any Inorder Successor", data));
        */
    }

    /** Using Stack
     * private void getAncestorsOfGivenElement(Node<T> node, T data, Stack<T> ancestors) {
        if(node != null) {
            ancestors.push(node.getData());
            if ((Integer) data > (Integer) node.getData()) {
                getAncestorsOfGivenElement(node.getRightNode(), data, ancestors);
            } else {
                getAncestorsOfGivenElement(node.getLeftNode(), data, ancestors);
            }
        }
    } */

    private Node<T> search(Node<T> currentNode, T data) {
        if(currentNode == null) {
            return null;
        } else if(data.equals(currentNode.getData())) {
            return currentNode;
        } else if((Integer) data > (Integer) currentNode.getData()) {
            return search(currentNode.getRightNode(), data);
        } else {
            return search(currentNode.getLeftNode(), data);
        }
    }

    private Integer findMinOfRightNode(Node<T> parentNode, Node<T> currentNode) {
        if(currentNode == null) {
            return (Integer) parentNode.getData();
        }
        return findMinOfRightNode(currentNode, currentNode.getLeftNode());
    }

    public static void main(String[] args) throws Exception {
        Node<Integer> tree = setupAndGetData();
        InOrderSuccessor<Integer> inOrderSuccessor = new InOrderSuccessor<>();
        try {
            inOrderSuccessor.findInOrderSuccessorNode(tree, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Inorder Successor of 19 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 19));
        System.out.println("Inorder Successor of 5 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 5));
        System.out.println("Inorder Successor of 7 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 7));
        System.out.println("Inorder Successor of 12 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 12));
        System.out.println("Inorder Successor of 16 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 16));
        System.out.println("Inorder Successor of 10 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 10));
        System.out.println("Inorder Successor of 13 is: " + inOrderSuccessor.findInOrderSuccessorNode(tree, 13));
        try {
            inOrderSuccessor.findInOrderSuccessorNode(tree, 42);
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
        //private Node<T> parentNode;

        Node(Node<T> leftNode, T element, Node<T> rightNode) {//, Node<T> parentNode) {
            this.leftNode = leftNode;
            this.data = element;
            this.rightNode = rightNode;
            //this.parentNode = parentNode;
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

        //Node<T> getParentNode() { return parentNode; }
    }
}
