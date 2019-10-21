package com.learnings.practise.problems.stack;

import com.learnings.practise.datastructure.Stack;

import java.util.Arrays;
import java.util.List;

public class ParenthesisValidation {

    private final Character [] ALLOWED_PARENTHESIS_ARRAY = {'(', '{', '[', ']', '}', ')'};
    private final List<Character> ALLOWED_PARENTHESIS = Arrays.asList(ALLOWED_PARENTHESIS_ARRAY);

    private boolean verify(String snippet) throws Exception {
        Stack stack = new Stack();
        char[] inputCharArray = snippet.toCharArray();
        for(char c : inputCharArray) {
            if(ALLOWED_PARENTHESIS.contains(c)) {
                if(stack.top() != null && stack.top().equals(reverseParenthesis(c))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private char reverseParenthesis(char c) {
        if(c == ')') {
            return '(';
        } else if(c == ']') {
            return '[';
        } else if(c == '}') {
            return '{';
        } else {
            return '0';
        }
    }

    public static void main(String[] args) throws Exception {
        ParenthesisValidation parenthesisValidation = new ParenthesisValidation();

        String inputString = "(A + B)";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "({[A + B]})";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "({[A + B + c})";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "({[A + B]";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "({[A + B}])";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "[A + B]})";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));

        inputString = "(A) * (B)";
        System.out.println(inputString + ": " + parenthesisValidation.verify(inputString));
    }
}