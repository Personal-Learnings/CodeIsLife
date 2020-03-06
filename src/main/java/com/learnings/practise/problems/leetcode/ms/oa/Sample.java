package com.learnings.practise.problems.leetcode.ms.oa;

import java.util.Stack;

public class Sample {

    public String solution(String S) {
        if(S == null || S.length() == 0) return S;

        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));

        for(int i = 1; i < S.length(); i++) {
            Character c = S.charAt(i);
            if(!stack.isEmpty() && isAdjacentConsecutive(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) result.append(stack.pop());

        return result.reverse().toString();
    }

    private static boolean isAdjacentConsecutive(Character current, Character previous) {
        String pair = previous + Character.toString(current);
        return pair.equalsIgnoreCase("AB") || pair.equalsIgnoreCase("CD") || pair.equalsIgnoreCase("BA") || pair.equalsIgnoreCase("DC");
    }

    public static void main(String[] args) {
        System.out.println(new Sample().solution("CBACD"));
        System.out.println(new Sample().solution("ACBDACBD"));
        System.out.println(new Sample().solution("CABABD"));
    }
}



//S = S.replaceAll("BA", "").replaceAll("AB", "").replaceAll("CD", "").replaceAll("DC", "");
//return S;

        /*StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length() - 1; i++) {
            if(
                    ((S.charAt(i) == 'A' && S.charAt(i + 1) == 'B') || (S.charAt(i) == 'B' && S.charAt(i + 1) == 'A')) ||
                    ((S.charAt(i) == 'C' && S.charAt(i + 1) == 'D') || (S.charAt(i) == 'D' && S.charAt(i + 1) == 'C'))
            ) {
                i = i + 2;
                continue;
            }
            sb.append(S.charAt(i));
        }
        return sb.toString();*/
