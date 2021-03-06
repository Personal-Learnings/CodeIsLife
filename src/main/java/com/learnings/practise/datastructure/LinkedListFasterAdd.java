package com.learnings.practise.datastructure;

import java.util.TreeMap;

public class LinkedListFasterAdd<T> {

    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    void add(T data) {
        if (isEmpty()) {
            headNode = new Node<>();
            headNode.setData(data);
            tailNode = headNode;
        } else {
            Node<T> newNode = new Node<>();
            newNode.setData(data);
            tailNode.setReference(newNode);
            tailNode = newNode;
        }
    }

    private void remove(T data) {
        Node<T> currentNode = headNode;
        Node<T> previousNode = headNode;

        if(headNode.getData().equals(data)) {
            headNode = headNode.getReference();
            --size;
        } else {
            while(currentNode != null) {
                if(currentNode.getData().equals(data)) {
                    previousNode.setReference(currentNode.getReference());
                    --size;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getReference();
            }
        }
    }

    private Node<T> get(T data) {
        Node<T> currentNode = headNode;
        if(headNode.getData().equals(data)) {
            return headNode;
        } else if(tailNode.getData().equals(data)) {
            return tailNode;
        } else {
            while(currentNode.getReference() != null) {
                if(currentNode.getData().equals(data)) {
                    return currentNode;
                }
                currentNode = currentNode.getReference();
            }
        }
        return null;
    }

    private int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        Node currentNode = headNode;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size: ");
        stringBuilder.append(getSize());

        stringBuilder.append(" :: Data: [");
        while(null != currentNode) {
            stringBuilder.append(currentNode.getData());
            currentNode = currentNode.getReference();
            if(null != currentNode) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] ");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListFasterAdd<Integer> linkedList = new LinkedListFasterAdd<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("After Adding 1 2 3 4 : " + linkedList);

        linkedList.remove(2);
        System.out.println("After Removing 2     : " + linkedList);

        linkedList.remove(4);
        System.out.println("After Removing 4     : " + linkedList);

        linkedList.remove(1);
        System.out.println("After Removing 1     : " + linkedList);

        linkedList.remove(3);
        System.out.println("After Removing 3     : " + linkedList);

        linkedList.add(2);
        linkedList.add(3);
        System.out.println("After Adding 2 3     : " + linkedList);

        linkedList.remove(3);
        System.out.println("After Removing 3     : " + linkedList);

        linkedList.add(4);
        System.out.println("After Adding 4       : " + linkedList);

        linkedList.remove(4);
        System.out.println("After Removing 4     : " + linkedList);

        System.out.println("Finding 2            : " + linkedList.get(2).getData());
        System.out.println("Finding 4            : " + linkedList.get(4));
    }

    static class Node<T> {
        private T data;
        private Node<T> reference;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node<T> getReference() {
            return reference;
        }

        void setReference(Node<T> reference) {
            this.reference = reference;
        }
    }
}