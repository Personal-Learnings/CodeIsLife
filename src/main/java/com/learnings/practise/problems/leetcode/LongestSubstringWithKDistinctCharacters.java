package com.learnings.practise.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    private int findLongestSubstringLength(String inputString, int k) {
        if(null == inputString || inputString.length() == 0) return 0;

        int result = Integer.MIN_VALUE;
        char[] charArray = inputString.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(int windowStart = 0, windowEnd = 0; windowEnd < charArray.length; windowEnd++) {

            char currentChar = charArray[windowEnd];
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = charArray[windowStart];
                int charCount = map.get(leftChar) - 1;

                map.put(leftChar, charCount);
                if(charCount == 0) map.remove(leftChar);

                windowStart++;
            }
            result = Math.max(windowEnd - windowStart + 1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithKDistinctCharacters().findLongestSubstringLength("AAAHHIBC", 2));
        System.out.println(new LongestSubstringWithKDistinctCharacters().findLongestSubstringLength("AAAHHIBCDEF", 1));
        System.out.println(new LongestSubstringWithKDistinctCharacters().findLongestSubstringLength("AABAHHIIIIIBCDEF", 3));
        System.out.println(new LongestSubstringWithKDistinctCharacters().findLongestSubstringLength("ABCDEFGHIIIIIKKKLLLL", 3));
        System.out.println(new LongestSubstringWithKDistinctCharacters().findLongestSubstringLength("", 100));
    }
}