package com.learnings.practise.datastructure;

public class QueueWithLinkedList<T> {

    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    private void enqueue(T data) {
        if(isEmpty()) {
            headNode = new Node<>();
            headNode.setData(data);
            tailNode = headNode;
        } else {
            Node<T> newNode = new Node<>();
            newNode.setData(data);
            tailNode.setNextNode(newNode);
            tailNode = newNode;
        }
        ++size;
    }

    private T dequeue() {
        T data = headNode.getData();
        headNode = headNode.getNextNode();
        --size;
        return data;
    }

    private T peek() {
        return isEmpty() ? null : headNode.getData();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> currentNode = headNode;
        while(null != currentNode) {
            stringBuilder.append("|");
            stringBuilder.append(currentNode.getData());
            stringBuilder.append("| ");
            currentNode = currentNode.getNextNode();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
        queue.enqueue(1);
        System.out.println("Enqueue 1 to Queue  : " + queue);

        queue.enqueue(2);
        System.out.println("Enqueue 2 to Queue  : " + queue);

        queue.enqueue(3);
        System.out.println("Enqueue 3 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(4);
        System.out.println("Enqueue 4 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(5);
        System.out.println("Enqueue 5 to Queue  : " + queue);
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
