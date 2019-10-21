package com.learnings.practise.datastructure;

public class StackWithLinkedList<T> {

    private Node<T> topNode;
    private int size;

    public void push(T data) {
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNextNode(topNode);
        topNode = newNode;
        ++size;
    }

    public T pop() throws Exception {
        if(getSize() > 0) {
            T topElement = topNode.getData();
            topNode = topNode.getNextNode();
            --size;
            return topElement;
        } else {
            throw new Exception("Stack is Empty");
        }
    }

    T top() {
        if(getSize() > 0) {
            return topNode.getData();
        }
        return null;
    }

    boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> currentNode = topNode;
        while(currentNode != null) {
            stringBuilder.append("|");
            stringBuilder.append(currentNode.getData());
            stringBuilder.append("| ");
            currentNode = currentNode.getNextNode();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        StackWithLinkedList<Integer> stackWithLinkedList = new StackWithLinkedList<>();

        stackWithLinkedList.push(1);
        stackWithLinkedList.push(2);
        stackWithLinkedList.push(3);
        stackWithLinkedList.push(4);
        System.out.println("Push 1 2 3 4   : " + stackWithLinkedList);

        System.out.println("Top            : |" + stackWithLinkedList.top() + "|");

        System.out.println("Pop            : |" + stackWithLinkedList.pop() + "|");
        System.out.println("Pop            : |" + stackWithLinkedList.pop() + "|");
        System.out.println("Pop            : |" + stackWithLinkedList.pop() + "|");
        System.out.println("Pop            : |" + stackWithLinkedList.pop() + "|");

        try {
            stackWithLinkedList.pop();
        } catch (Exception e) {
            System.out.println("Pop            : |" + e.getMessage() + "|");
        }

        System.out.println("Is Stack Empty : " + stackWithLinkedList.isEmpty());

        stackWithLinkedList.push(1);
        stackWithLinkedList.push(2);
        stackWithLinkedList.push(3);
        stackWithLinkedList.push(4);
        System.out.println("Push 1 2 3 4   : " + stackWithLinkedList);

        stackWithLinkedList.push(5);
        stackWithLinkedList.push(6);
        stackWithLinkedList.push(7);
        stackWithLinkedList.push(8);
        System.out.println("Push 5 6 7 8   : " + stackWithLinkedList);
    }

    static class Node<T> {
        T data;
        Node<T> nextNode;

        Node<T> getNextNode() {
            return nextNode;
        }

        public T getData() {
            return data;
        }

        void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
