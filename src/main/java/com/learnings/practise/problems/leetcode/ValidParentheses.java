package com.learnings.practise.problems.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        char [] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : chars) {
            if(isOpenBracket(c)) {
                stack.push(c);
            }
            else if(!stack.isEmpty() && isClosingBracketOfSimilarType(c, stack.peek())) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isClosingBracketOfSimilarType(char c, char peek) {
        return (peek == '(' && c == ')')
                || (peek == '[' && c == ']')
                || (peek == '{' && c =='}');
    }

    public static void main(String[] args) {

    }
}