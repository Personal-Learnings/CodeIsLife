package com.learnings.practise.problems.leetcode.general;

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || new Integer(x).compareTo(maxStack.peek()) >= 0) maxStack.push(x);
    }

    public int pop() {
        if(maxStack.peek().compareTo(stack.peek()) == 0) maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();

        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) {
            int e = stack.pop();
            if(e == max) break;
            temp.push(e);
        }

        while(!temp.isEmpty()) push(temp.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack max = new MaxStack();
        max.push(5);
        max.push(1);
        max.push(5);
        System.out.println(max.top());
        System.out.println(max.popMax());
        System.out.println(max.top());
        System.out.println(max.peekMax());
        System.out.println(max.pop());
        System.out.println(max.top());
    }
}
