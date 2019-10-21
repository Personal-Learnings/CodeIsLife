package com.learnings.practise.datastructure;

public class DoublyLinkedList<T> {

    private int size;
    private Node<T> headNode;

    private void add(T data) {
        Node<T> newNode = new Node<>();

        if(isEmpty()) {
            newNode.setData(data);
            headNode = newNode;
        } else {
            Node<T> tailNode = getTailNode();

            newNode.setPreviousNode(tailNode);
            newNode.setData(data);

            tailNode.setNextNode(newNode);
        }
        ++size;
    }

    private void add(T data, int index) throws Exception {
        Node<T> newNode = new Node<>();
        newNode.setData(data);

        if(index > getSize() || index < 0) {
            throw new Exception("Cannot Insert at index " + index);
        } else if(index == getSize()) {
            Node<T> currentNode = getTailNode();
            currentNode.setNextNode(newNode);
            newNode.setPreviousNode(currentNode);
            ++size;
        } else if(index == 0) {
            newNode.setNextNode(headNode);
            headNode.setPreviousNode(newNode);
            headNode = newNode;
            ++size;
        } else {
            int currentIndex = 1;
            Node<T> currentNode = headNode.getNextNode();

            while (currentIndex < getSize()) {
                if(currentIndex == index) {
                    currentNode.getPreviousNode().setNextNode(newNode);

                    newNode.setPreviousNode(currentNode.getPreviousNode());
                    newNode.setNextNode(currentNode);

                    currentNode.setPreviousNode(newNode);
                    ++size;
                    break;
                }
                currentNode = currentNode.getNextNode();
                ++currentIndex;
            }
        }
    }

    private void flip() {
        if(getSize() > 1) {
            Node<T> currentNode = headNode;
            while(currentNode != null) {
                Node<T> previousNode = currentNode.getPreviousNode();
                Node<T> nextNode = currentNode.getNextNode();

                currentNode.setPreviousNode(nextNode);
                currentNode.setNextNode(previousNode);

                if(currentNode.getPreviousNode() == null) {
                    headNode = currentNode;
                }
                currentNode = currentNode.getPreviousNode();
            }
        }
    }

    private void displayReverse(Node<T> currentNode) {
        if(currentNode != null) {
            displayReverse(currentNode.getNextNode());
            System.out.print(currentNode.getData() + ", ");
        }
    }

    private Node<T> get(T data) {
        Node<T> currentNode = headNode;
        while(currentNode != null) {
            if(currentNode.getData().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    private void remove(T data) {
        Node<T> currentNode = headNode;

        if(null != headNode && headNode.getData().equals(data)) {
            if(getSize() == 1) {
                headNode = null;
            } else {
                headNode = headNode.getNextNode();
                headNode.setPreviousNode(null);
            }
            --size;
        } else {
            while(currentNode != null) {
                if(currentNode.getData().equals(data)) {
                    currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());

                    if(null != currentNode.getNextNode()) {
                        currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
                    }
                    --size;
                    break;
                }
                currentNode = currentNode.getNextNode();
            }
        }
    }

    private boolean isEmpty() {
        return getSize() == 0;
    }

    private int getSize() {
        return size;
    }

    private Node<T> getTailNode() {
        Node<T> currentNode = headNode;
        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    private Node<T> getHeadNode() {
        return headNode;
    }

    @Override
    public String toString() {
        Node<T> currentNode = headNode;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size: ");
        stringBuilder.append(getSize());

        stringBuilder.append(" :: Data: ");
        while(null != currentNode) {
            stringBuilder.append("|");
            stringBuilder.append(null != currentNode.getPreviousNode() ? currentNode.getPreviousNode().getData() : null);
            stringBuilder.append("|");
            stringBuilder.append(currentNode.getData());
            stringBuilder.append("|");
            stringBuilder.append(null != currentNode.getNextNode() ? currentNode.getNextNode().getData() : null);
            stringBuilder.append("|");
            currentNode = currentNode.getNextNode();
            if(null != currentNode) {
                stringBuilder.append(" -> ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        System.out.println("After Adding 1 2 3 4 : " + doublyLinkedList);

        doublyLinkedList.remove(2);
        System.out.println("After Removing 2     : " + doublyLinkedList);

        doublyLinkedList.remove(4);
        System.out.println("After Removing 4     : " + doublyLinkedList);

        doublyLinkedList.remove(1);
        System.out.println("After Removing 1     : " + doublyLinkedList);

        doublyLinkedList.remove(3);
        System.out.println("After Removing 3     : " + doublyLinkedList);

        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        System.out.println("After Adding 2 3     : " + doublyLinkedList);

        doublyLinkedList.remove(3);
        System.out.println("After Removing 3     : " + doublyLinkedList);

        doublyLinkedList.add(4);
        System.out.println("After Adding 4       : " + doublyLinkedList);

        doublyLinkedList.remove(4);
        System.out.println("After Removing 4     : " + doublyLinkedList);

        Node<Integer> nodeFound = doublyLinkedList.get(2);
        System.out.println("Finding 2            : " + (null != nodeFound ? nodeFound.getData() : null));
        System.out.println("Finding 4            : " + doublyLinkedList.get(4));

        doublyLinkedList.add(6, 0);
        System.out.println("After Adding 6 at 0  : " + doublyLinkedList);

        try {
            doublyLinkedList.add(3, 5);
        } catch (Exception e) {
            System.out.println("After Adding 3 at 5  : " + e.getMessage());
        }

        doublyLinkedList.add(4, 1);
        System.out.println("After Adding 4 at 1  : " + doublyLinkedList);

        doublyLinkedList.add(7, 3);
        System.out.println("After Adding 7 at 3  : " + doublyLinkedList);

        doublyLinkedList.remove(4);
        System.out.println("After Removing 4     : " + doublyLinkedList);

        doublyLinkedList.remove(7);
        System.out.println("After Removing 7     : " + doublyLinkedList);

        doublyLinkedList.remove(6);
        System.out.println("After Removing 6     : " + doublyLinkedList);

        doublyLinkedList.remove(2);
        System.out.println("After Removing 2     : " + doublyLinkedList);

        doublyLinkedList.add(4);
        doublyLinkedList.add(3);
        doublyLinkedList.add(2);
        doublyLinkedList.add(1);
        System.out.println("After Adding 4 3 2 1 : " + doublyLinkedList);

        doublyLinkedList.flip();
        System.out.println("After Flipping       : " + doublyLinkedList);

        doublyLinkedList.add(5);
        doublyLinkedList.add(6);
        doublyLinkedList.add(7);
        System.out.println("After Adding 5 6 7   : " + doublyLinkedList);

        System.out.print("Display Reverse Using Recursion:: Data: [");
        doublyLinkedList.displayReverse(doublyLinkedList.getHeadNode());
        System.out.print("]");
    }

    static class Node<T> {
        private Node<T> previousNode;
        private T data;
        private Node<T> nextNode;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node<T> getPreviousNode() {
            return previousNode;
        }

        void setPreviousNode(Node<T> previousNode) {
            this.previousNode = previousNode;
        }

        Node<T> getNextNode() {
            return nextNode;
        }

        void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}