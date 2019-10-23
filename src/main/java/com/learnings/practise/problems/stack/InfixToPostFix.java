package com.learnings.practise.problems.stack;

import com.learnings.practise.datastructure.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InfixToPostFix {

    private final Character [] ALLOWED_OPENING_PARENTHESIS = { '(', '[', '{' };
    private final Character [] ALLOWED_CLOSING_PARENTHESIS = { ')', ']', '}' };
    private static Map<Character, Byte> allowedOperatorsMap = new HashMap<>();
    static {
        allowedOperatorsMap.put('-', (byte) 1);
        allowedOperatorsMap.put('+', (byte) 2);
        allowedOperatorsMap.put('*', (byte) 3);
        allowedOperatorsMap.put('/', (byte) 4);
    }

    private String infixToPostFix(String infixExpression) throws Exception {
        Stack<Character> stack = new Stack<>();
        StringBuilder postFixExpression = new StringBuilder();
        char [] inputCharArray = infixExpression.toCharArray();

        for(Character currentChar : inputCharArray) {
            if(Character.isAlphabetic(currentChar) || Character.isDigit(currentChar)) {
                postFixExpression.append(currentChar);

            } else if(Arrays.asList(ALLOWED_OPENING_PARENTHESIS).contains(currentChar)) {
                stack.push(currentChar);

            } else if(allowedOperatorsMap.containsKey(currentChar)) {
                while(allowedOperatorsMap.containsKey(stack.top()) &&
                        isCurrentCharacterHasLowerPrecedenceThanOrEqualToStackTopCharacter(stack.top(), currentChar)) {
                    postFixExpression.append(stack.pop());
                }
                //Pushing the Current Operator after all the lower/equal precedence operators are Popped out from stack.
                stack.push(currentChar);

            } else if(Arrays.asList(ALLOWED_CLOSING_PARENTHESIS).contains(currentChar)) {
                while (!Arrays.asList(ALLOWED_OPENING_PARENTHESIS).contains(stack.top())) {
                    postFixExpression.append(stack.pop());
                }
                //Popping out the last Opened Parenthesis
                stack.pop();
            }
        }
        //Popping out the remaining Operators on Stack
        while (!stack.isEmpty()) {
            postFixExpression.append(stack.pop());
        }
        return postFixExpression.toString();
    }

    private boolean isCurrentCharacterHasLowerPrecedenceThanOrEqualToStackTopCharacter(Character stackTopCharacter, Character currentCharacter) {
        return allowedOperatorsMap.get(currentCharacter) <= allowedOperatorsMap.get(stackTopCharacter);
    }

    public static void main(String[] args) throws Exception {
        InfixToPostFix infixToPostFix = new InfixToPostFix();

        String expression = "A+B+C*D";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));

        expression = "A+B*C-D*E";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));

        expression = "A*(B+C)";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));

        expression = "((A+B)*C-D)*E";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));

        expression = "(A*(B+(C/D)))";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));

        expression = "A+B+C+D*(E-F/G)";
        System.out.println("Infix Expression: " + expression + " ::: Post Fix Expression: " + infixToPostFix.infixToPostFix(expression));
    }
}