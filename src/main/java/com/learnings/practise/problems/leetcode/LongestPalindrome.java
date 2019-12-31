package com.learnings.practise.problems.leetcode;

import java.util.TreeMap;

public class LongestPalindrome {

    public String longestPalindrome_BigO_N2(String s) {
        if(s == null || s.length() == 0) return "";
        char [] chars = s.toCharArray();
        boolean [][] dp = new boolean[chars.length][chars.length];
        int startIndex = 0, maxLength = 1;

        //Fill the Diagonals O(n)
        for(int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }

        //For Two Chars O(n)
        for(int i = 0, j = i + 1; j < chars.length; i++, j++) {
            boolean isEqual = (chars[i] == chars[j]);
            if(isEqual) {
                dp[i][j] = true;
                startIndex = i;
                maxLength = 2;
            }
        }

        //For Three or More Characters
        for(int k = 2; k < chars.length; k++) {
            for(int i = 0, j = k; j < chars.length; i++, j++) {
                if(chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if(k + 1 > maxLength) {
                        startIndex = i;
                        maxLength = k + 1;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public String longestPalindrome_BigO_N3(String inputString) {
        if(inputString == null || inputString.equals("")) {
            return "";
        }
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        char [] charArray = inputString.toCharArray();

        if(charArray.length == 1) {
            String s = Character.toString(charArray[0]);
            if(isPalindrome(s)) {
                treeMap.put(s.length(), s);
            }
        }
        for(int i=0;i<charArray.length;i++) {
            char c = charArray[i];
            String s = Character.toString(c);
            for(int j=i+1; j<charArray.length;j++) {
                s = s + charArray[j];
                if(isPalindrome(s)) {
                    treeMap.put(s.length(), s);
                }
            }
        }
        if(treeMap.size() == 0 && inputString.length() > 0) {
            return Character.toString(inputString.charAt(0));
        }
        return (treeMap.size() > 0) ? treeMap.lastEntry().getValue() : "";
    }

    private boolean isPalindrome(String inputString) {
        char [] inputArray = inputString.toCharArray();
        int midElement = inputArray.length / 2;
        for(int i=0, j = inputArray.length-1; i < midElement || j >= midElement; i++ , j--) {
            if(inputArray[i] != inputArray[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("cbbd"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("madam"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("aaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("a"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("madam"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("aa"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("ccc"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("madamapaq"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("aab"));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2(""));
        System.out.println(new LongestPalindrome().longestPalindrome_BigO_N2("bahbsnbaab"));
    }
}