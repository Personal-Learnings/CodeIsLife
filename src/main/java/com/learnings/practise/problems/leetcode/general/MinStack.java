package com.learnings.practise.problems.leetcode.general;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek().compareTo(x) >= 0) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.peek().compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        s.remove((Object)2);
        s.remove((Object)3);
        System.out.println(s.peek());

    }
}