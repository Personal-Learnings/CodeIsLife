package com.learnings.practise.problems.leetcode;

import java.util.Iterator;

public class ValidAnagram {

    // Time Complexity O(N)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char [] sArray = new char[26];

        for(int i = 0; i < s.length(); i++) {
            ++sArray[s.charAt(i) - 'a'];
            --sArray[t.charAt(i) - 'a'];
        }

        for (char c : sArray) {
            if (c > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
