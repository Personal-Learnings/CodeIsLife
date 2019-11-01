package com.learnings.practise.datastructure;

public class Queue<T> {

    private int front;
    private int rear = -1;
    private int size;
    private Object [] data = new Object[3];

    private void enqueue(T element) {
        if(isFull()) {
            Object [] newArray = new Object[data.length * 2];
            int j = 0;
            for(int i = front; i <= getSize(); i++, j++) {
                newArray[j] = data[i % data.length];
            }
            data = newArray;
            front = 0;
            rear = j - 1;
            size = j;
        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        ++size;
    }

    @SuppressWarnings("unchecked")
    private T dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        } else {
            T element = (T) data[front % data.length];
            --size;
            ++front;
            return element;
        }
    }

    @SuppressWarnings("unchecked")
    private T peek() {
        return isEmpty() ? null : (T) data[front % data.length];
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private boolean isFull() {
        return getSize() == data.length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = front;
        for(int i = 0; i < getSize(); i++, index++) {
            stringBuilder.append("|");
            stringBuilder.append(data[index % data.length]);
            stringBuilder.append("| ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();
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
}