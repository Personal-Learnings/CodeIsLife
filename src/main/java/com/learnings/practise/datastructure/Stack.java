package com.learnings.practise.datastructure;

public class Stack<T> {

    private Object [] data = new Object[4];
    private int size;

    public void push(T element) {
        if(getSize() < data.length) {
            data[getSize()] = element;
            ++size;
        } else {
            final int NEW_SIZE = getSize() * 2;
            Object [] newArray = new Object[NEW_SIZE];

            for(int index = 0; index < getSize(); index++) {
                newArray[index] = data[index];
            }
            data = newArray;
            data[getSize()] = element;
            ++size;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        T topElement;
        if(getSize() > 0) {
            topElement = (T) data[getSize() - 1];
            data[getSize() - 1] = null;
            --size;
        } else {
            throw new Exception("Stack is Empty");
        }
        return topElement;
    }

    @SuppressWarnings("unchecked")
    public T top() {
        return isEmpty() ? null : (T) data[getSize() - 1];
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = getSize() - 1;
        while(index >= 0) {
            stringBuilder.append("|");
            stringBuilder.append(data[index]);
            stringBuilder.append("| ");
            --index;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Push 1 2 3 4   : " + stack);

        System.out.println("Top            : |" + stack.top() + "|");

        System.out.println("Pop            : |" + stack.pop() + "|");
        System.out.println("Pop            : |" + stack.pop() + "|");
        System.out.println("Pop            : |" + stack.pop() + "|");
        System.out.println("Pop            : |" + stack.pop() + "|");

        try{
            stack.pop();
        } catch (Exception e) {
            System.out.println("Pop            : |" + e.getMessage() + "|");
        }

        System.out.println("Is Stack Empty : " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Push 1 2 3 4   : " + stack);

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("Push 5 6 7 8   : " + stack);
    }
}
