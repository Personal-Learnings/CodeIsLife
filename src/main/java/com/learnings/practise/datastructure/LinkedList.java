package com.learnings.practise.datastructure;

public class LinkedList<T> {

    private Node<T> headNode;
    private int size;

    private void add(T data) {
        if(isEmpty()) {
            headNode = new Node<>();
            headNode.setData(data);
        } else {
            Node<T> tailNode = getTailNode();
            Node<T> newNode = new Node<>();

            newNode.setData(data);
            tailNode.setReference(newNode);
        }
        ++size;
    }

    private void add(T data, int index) throws Exception {
        if(index > size || index < 0) {
            throw new Exception("Cannot Insert at index " + index);
        } else if(index == 0) {
            insertAtHead(data);
        } else if(index == getSize()) {
            insertAtTail(data);
        } else {
            insertAtMiddle(data, index);
        }
    }

    private void insertAtTail(T data) {
        Node<T> currentNode = headNode.getReference();
        int currentIndex = 1;
        while (currentIndex <= getSize()) {

            if(currentNode.getReference() == null) {
                Node<T> newNode = new Node<>();
                newNode.setData(data);
                currentNode.setReference(newNode);
                size++;
                break;
            } else {
                currentNode = currentNode.getReference();
            }
            ++currentIndex;
        }
    }

    private void insertAtMiddle(T data, int index) {
        Node<T> currentNode = headNode.getReference();
        Node<T> previousNode = headNode;

        int currentIndex = 1;
        while(currentNode != null) {
            if(currentIndex == index) {
                Node<T> newNode = new Node<>();
                newNode.setData(data);
                newNode.setReference(currentNode);

                previousNode.setReference(newNode);
                size++;
            }
            currentNode = currentNode.getReference();
            ++currentIndex;
        }
    }

    private void insertAtHead(T data) {
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setReference(headNode);

        headNode = newNode;
        size++;
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

    private Node<T> getTailNode() {
        Node<T> currentNode = headNode;
        if(currentNode != null) {
            while(currentNode.getReference() != null) {
                currentNode = currentNode.getReference();
            }
        }
        return currentNode;
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

    private void flip() {
        if(!(getSize() <= 1)) {
            Node<T> previousNode = null;
            Node<T> currentNode = headNode;

            while(currentNode != null) {
                Node<T> temp = currentNode.getReference();
                currentNode.setReference(previousNode);
                previousNode = currentNode;
                currentNode = temp;
            }
            headNode = previousNode;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
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

        linkedList.add(6, 0);
        System.out.println("After Adding 6 at 0  : " + linkedList);

        try {
            linkedList.add(3, 5);
        } catch (Exception e) {
            System.out.println("After Adding 3 at 5  : " + e.getMessage());
        }

        linkedList.add(4, 1);
        System.out.println("After Adding 4 at 1  : " + linkedList);

        linkedList.add(7, 3);
        System.out.println("After Adding 7 at 3  : " + linkedList);

        linkedList.remove(4);
        System.out.println("After Removing 4     : " + linkedList);

        linkedList.remove(7);
        System.out.println("After Removing 7     : " + linkedList);

        linkedList.remove(6);
        System.out.println("After Removing 6     : " + linkedList);

        linkedList.remove(2);
        System.out.println("After Removing 2     : " + linkedList);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("After Adding 1 2 3 4 : " + linkedList);

        linkedList.flip();
        System.out.println("After Flipping       : " + linkedList);

        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        System.out.println("After Adding 5 6 7   : " + linkedList);

        linkedList.remove(1);
        System.out.println("After Removing 1     : " + linkedList);
    }
}

class Node<T> {
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