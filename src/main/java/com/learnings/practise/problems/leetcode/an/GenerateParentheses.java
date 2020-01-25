package com.learnings.practise.problems.leetcode.an;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

    private static final String OPEN = "(";
    private static final String CLOSE = ")";
    /**
     * Time Complexity: O(2^n) Every time you go down the recursive tree we are growing by double
     * Space Complexity: O(2^n) Every time you go down the recursive tree we are growing by double and using 2^n space
     */
    public List<String> generateParenthesis(int n) {
        if(n == 0) return Collections.emptyList();

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(list, sb, 0, 0, n);

        return list;
    }

    public void generate(List<String> result, StringBuilder sb, int openCount, int closeCount, int n) {
        if(sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if(openCount < n) {
            generate(result, sb.append(OPEN), openCount + 1, closeCount, n);
            sb.setLength(sb.length() - 1);
        }

        if(closeCount < openCount) {
            generate(result, sb.append(CLOSE), openCount, closeCount + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(0));
        System.out.println(new GenerateParentheses().generateParenthesis(1));
        System.out.println(new GenerateParentheses().generateParenthesis(2));
        System.out.println(new GenerateParentheses().generateParenthesis(3));
        System.out.println(new GenerateParentheses().generateParenthesis(4));
    }
}
