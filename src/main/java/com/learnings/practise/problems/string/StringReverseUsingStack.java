package com.learnings.practise.problems.string;

import com.learnings.practise.datastructure.StackWithLinkedList;

public class StringReverseUsingStack {

    private String reverse(String inputString) throws Exception {
        StackWithLinkedList<Character> stack = new StackWithLinkedList<>();

        char [] inputCharArray = inputString.toCharArray();
        for (char c : inputCharArray) {
            stack.push(c);
        }
        for(int i = 0; i < inputCharArray.length; i++) {
            inputCharArray[i] = stack.pop();
        }
        return String.valueOf(inputCharArray);
    }

    public static void main(String[] args) throws Exception {
        StringReverseUsingStack stringReverseUsingStack = new StringReverseUsingStack();
        System.out.println(stringReverseUsingStack.reverse("Hello Hi"));
        System.out.println(stringReverseUsingStack.reverse("﷽﷽﷽﷽H"));
    }
}