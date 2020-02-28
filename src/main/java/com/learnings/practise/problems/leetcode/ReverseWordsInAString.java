package com.learnings.practise.problems.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public String reverseWords_lesserSpace(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        s = s + " ";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(sb.length() != 0) {
                    result.insert(0, " " + sb.toString());
                    sb = new StringBuilder();
                }
            }
            else sb.append(s.charAt(i));
        }
        return result.length() == 0 ? "" : result.deleteCharAt(0).toString();
    }

    public String reverseWords_1(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s = s + " ";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(sb.length() != 0) stack.push(sb.toString());
                sb = new StringBuilder();

            } else {
                sb.append(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("the sky is blue"));
        System.out.println(new ReverseWordsInAString().reverseWords(""));
        System.out.println(new ReverseWordsInAString().reverseWords("Madan         is   hi"));
        System.out.println(new ReverseWordsInAString().reverseWords("  hello world!  "));
    }
}