package com.learnings.practise.problems.stack;

import com.learnings.practise.datastructure.Stack;

public class PreFixAndPostFixExpressionEvaluator {

    private float evaluatePreFixExpression(String expression) throws Exception {
        char [] inputCharArray = expression.toCharArray();
        Stack<Float> stack = new Stack<>();

        for(int i = inputCharArray.length - 1; i >= 0; i--) {
            if(Character.isDigit(inputCharArray[i])) {
                stack.push(Float.parseFloat(Character.toString(inputCharArray[i])));
            } else if(isOperator(inputCharArray[i])) {
                try {
                    float operand1 = stack.pop();
                    float operand2 = stack.pop();
                    stack.push(performCalculation(inputCharArray[i], operand1, operand2));
                } catch (Exception e) {
                    throw new Exception("Invalid Post Fix Expression");
                }
            } else {
                throw new Exception("Invalid Post Fix Expression");
            }
        }
        return stack.top();
    }

    private float evaluatePostFixExpression(String expression) throws Exception {
        char [] inputCharArray = expression.toCharArray();
        Stack<Float> stack = new Stack<>();

        for(char c : inputCharArray) {
            if(Character.isDigit(c)) {
                stack.push(Float.parseFloat(Character.toString(c)));
            } else if(isOperator(c)) {
                try {
                    float operand1 = stack.pop();
                    float operand2 = stack.pop();
                    stack.push(performCalculation(c, operand2, operand1));
                } catch (Exception e) {
                    throw new Exception("Invalid Post Fix Expression");
                }
            } else {
                throw new Exception("Invalid Post Fix Expression");
            }
        }
        return stack.top();
    }

    private float performCalculation(char operator, float operand1, float operand2) {
        if(operator == '+') {
            return operand1 + operand2;
        } else if(operator == '-') {
            return operand1 - operand2;
        } else if(operator == '*') {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) throws Exception {
        PreFixAndPostFixExpressionEvaluator evaluator = new PreFixAndPostFixExpressionEvaluator();

        String expression = "64+3*2+";
        System.out.println("Expression: " + expression + " | Output: " + evaluator.evaluatePostFixExpression(expression));

        expression = "23*54*+9-";
        System.out.println("Expression: " + expression + " | Output: " + evaluator.evaluatePostFixExpression(expression));

        expression = "-+*23*549";
        System.out.println("Expression: " + expression + " | Output: " + evaluator.evaluatePreFixExpression(expression));
    }
}