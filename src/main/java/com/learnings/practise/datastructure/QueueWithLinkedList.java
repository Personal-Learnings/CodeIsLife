package com.learnings.practise.datastructure;

public class QueueWithLinkedList<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private void enqueue(T data) {
        if(isEmpty()) {
            front = new Node<>();
            front.setData(data);
            rear = front;
        } else {
            Node<T> newNode = new Node<>();
            newNode.setData(data);
            rear.setNextNode(newNode);
            rear = newNode;
        }
        ++size;
    }

    private T dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        } else {
            T data = front.getData();
            front = front.getNextNode();
            --size;
            return data;
        }
    }

    private T peek() {
        return isEmpty() ? null : front.getData();
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
        Node<T> currentNode = front;
        while(null != currentNode) {
            stringBuilder.append("|");
            stringBuilder.append(currentNode.getData());
            stringBuilder.append("| ");
            currentNode = currentNode.getNextNode();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
        queue.enqueue(1);
        System.out.println("Enqueue 1 to Queue  : " + queue);

        queue.enqueue(2);
        System.out.println("Enqueue 2 to Queue  : " + queue);

        queue.enqueue(3);
        System.out.println("Enqueue 3 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(4);
        System.out.println("Enqueue 4 to Queue  : " + queue);

        queue.enqueue(5);
        System.out.println("Enqueue 5 to Queue  : " + queue);

        queue.enqueue(6);
        System.out.println("Enqueue 6 to Queue  : " + queue);

        queue.enqueue(7);
        System.out.println("Enqueue 7 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(8);
        System.out.println("Enqueue 8 to Queue  : " + queue);

        queue.enqueue(9);
        System.out.println("Enqueue 9 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(10);
        System.out.println("Enqueue 10 to Queue : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        System.out.println("Peek from Queue     : |" + queue.peek() + "|");

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        try{
            queue.dequeue();
        } catch (Exception e) {
            System.out.println("Dequeue from Queue  : " + e.getMessage());
        }
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
