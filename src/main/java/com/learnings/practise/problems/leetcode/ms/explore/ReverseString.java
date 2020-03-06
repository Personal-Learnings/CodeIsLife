package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;

        int p1 = 0, p2 = s.length - 1;
        while(p1 < p2) {
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;

            p1++; p2--;
        }
    }

    public static void main(String[] args) {
        char [] c = new char[] { 'H','a','n','n','a','h' };
        new ReverseString().reverseString(c);
        System.out.println(Arrays.toString(c));

        c = new char[] { 'h','e','l','l','o' };
        new ReverseString().reverseString(c);
        System.out.println(Arrays.toString(c));
    }
}