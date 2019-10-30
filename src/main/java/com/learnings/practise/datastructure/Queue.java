package com.learnings.practise.datastructure;

public class Queue<T> {

    private int front;
    private int rear;
    private int size;
    private int maxSize = 5;
    private Object [] data = new Object[maxSize];

    private void enqueue(T element) throws Exception {
        if(isFull()) {
            Object [] newArray = new Object[maxSize * 2];
            int i = 0;
            while(!isEmpty()) {
                newArray[i] = dequeue();
                ++i;
            }
            data = newArray;
            front = 0;
            rear = size = i;
            maxSize = maxSize * 2;
        }
        data[rear] = element;
        ++rear;
        ++size;
    }

    @SuppressWarnings("unchecked")
    private T dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty");
        } else {
            T element = (T) data[front];
            --size;
            if(isEmpty()) {
                front = rear = 0;
            } else {
                ++front;
            }
            return element;
        }
    }

    @SuppressWarnings("unchecked")
    private T peek() {
        return isEmpty() ? null : (T) data[front];
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private boolean isFull() {
        return rear == maxSize;
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
            stringBuilder.append(data[index]);
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

        queue.enqueue(4);
        System.out.println("Enqueue 4 to Queue  : " + queue);

        queue.enqueue(5);
        System.out.println("Enqueue 5 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        queue.enqueue(6);
        System.out.println("Enqueue 6 to Queue  : " + queue);

        queue.enqueue(7);
        System.out.println("Enqueue 7 to Queue  : " + queue);

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

        try{
            queue.dequeue();
        } catch (Exception e) {
            System.out.println("Dequeue from Queue  : " + e.getMessage());
        }

        queue.enqueue(8);
        System.out.println("Enqueue 8 to Queue  : " + queue);

        queue.dequeue();
        System.out.println("Dequeue from Queue  : " + queue);

        System.out.println("Pop from Queue      : " + queue.peek());
    }
}