package com.learnings.practise.problems.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

    //Time Complexity: O(N^2)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int length = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(sb.toString().contains(String.valueOf(c))) {
                String temp = sb.toString();
                sb = new StringBuilder();
                sb.append(temp.substring(temp.indexOf(String.valueOf(c)) + 1));
            }
            sb.append(c);
            length = Math.max(sb.length(), length);
        }
        return length;
    }

    //Time Complexity: O(N)
    public int lengthOfLongestSubstring_1(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_1("abcabcbb"));
    }
}
