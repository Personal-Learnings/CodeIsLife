package com.learnings.practise.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    //Time Complexity: O(2N) => O(N) //Sliding Window Pattern //Assuming the string is ASCII //Using Array //Best Running Time
    public int lengthOfLongestSubstring_3(String s) {
        if(s == null || s.length() == 0) return 0;

        int [] cache = new int[128];
        int result = Integer.MIN_VALUE;

        char[] charArray = s.toCharArray();
        for(int windowEnd = 0, windowStart = 0; windowEnd < charArray.length; windowEnd++) {
            char currentChar = charArray[windowEnd];
            cache[currentChar]++;

            while(cache[currentChar] > 1) {
                char startWindowChar = charArray[windowStart];
                cache[startWindowChar]--;
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

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

    //Time Complexity: O(2N) => O(N) //Sliding Window Pattern
    public int lengthOfLongestSubstring_2(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;

        char[] charArray = s.toCharArray();
        for(int windowEnd = 0, windowStart = 0; windowEnd < charArray.length; windowEnd++) {
            char currentChar = charArray[windowEnd];
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while(map.get(currentChar) > 1) {
                char startWindowChar = charArray[windowStart];
                map.put(startWindowChar, map.get(startWindowChar) - 1);
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    //Time Complexity: O(N) // From Solution
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

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_2("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_2("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_2("tmmzuxt"));

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_3("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_3("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_3("tmmzuxt"));
    }
}
