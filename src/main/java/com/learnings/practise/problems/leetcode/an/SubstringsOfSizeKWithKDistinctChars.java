package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class SubstringsOfSizeKWithKDistinctChars {

    /**
     * Time Complexity: O(n) using Sliding Window Technique
     * Space Complexity: O(1) in worst case the hash map is gonna have a max of 26 elements in it, we can also use array[26] as the input will be a - z.
     */
    public Set<String> getSubstringOfSizeKWithKDistinctChars(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return Collections.emptySet();

        Set<String> result = new LinkedHashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int windowStart = 0, windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character c = s.charAt(windowEnd);
            map.put(c, map.getOrDefault(c, 0) + 1);

            //When a duplicate character is found then slide the window start
            while(map.get(c) > 1) {
                Character sc = s.charAt(windowStart);
                map.put(sc, map.get(sc) - 1);
                windowStart++;
            }

            //When K distinct value is reached add the value to Set and increment the window start
            if(windowEnd - windowStart + 1 == k) {
                result.add(s.substring(windowStart, windowEnd + 1));

                Character sc = s.charAt(windowStart);
                map.put(sc, map.get(sc) - 1);
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("madan", 4));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("madan", 3));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("madan", 2));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("abcabc", 3));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("abacab", 3));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("awaglknagawunagwkwagl", 4));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("aaaa", 2));
        System.out.println(new SubstringsOfSizeKWithKDistinctChars().getSubstringOfSizeKWithKDistinctChars("aaaa", 1));
    }
}