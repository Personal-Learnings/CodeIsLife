package com.learnings.practise.problems.leetcode.an;

public class LongestPalindromicSubstring {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;

        int startIndex = 0;
        int endIndex = 1;
        int strLength = s.length();
        char [] cArray = s.toCharArray();
        boolean [][] dp = new boolean[strLength][strLength];

        //Comparing each characters and it will obviously be a palindrome.
        for(int i = 0; i < cArray.length; i++) {
            dp[i][i] = true;
        }

        //Compare two characters and check whether both of equal
        for(int i = 0, j = i + 1; j < cArray.length; i++, j++) {
            if(cArray[i] == cArray[j]) {
                dp[i][j] = true;
                startIndex = i;
                endIndex = j + 1;
            }
        }

        //Compare from three to n characters and check whether they are palindrome
        for(int m = 2; m < cArray.length; m++) {
            for(int i = 0, j = m; j < cArray.length; i++, j++) {
                if(cArray[i] == cArray[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    startIndex = i;
                    endIndex = j + 1;
                }
            }
        }
        return s.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("madam"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("madan"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("sss"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("s"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("idhumalayalamam"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(null));
    }
}