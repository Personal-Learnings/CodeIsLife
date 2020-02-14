package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class AlphabeticallyLargestLetter {

    /**
     * Time Complexity: O(N) where N -> length of String
     * Time Complexity: O(1) where N -> For any size of input the Set will always be a max of 52 (26 + 26) so space is constant.
     */
    private String getAlphabeticallyLargestLetter(String input) {
        Set<Character> set = new HashSet<>();

        for(Character c : input.toCharArray()) set.add(c);

        char result = '0';
        for(char c : input.toCharArray()) {
            if((isLowerCase(c) && set.contains(Character.toUpperCase(c))) || (isUpperCase(c) && set.contains(Character.toLowerCase(c)))) {
                result = (char) Math.max(result, c);
            }
        }
        return result == '0' ? "NO" : String.valueOf(Character.toUpperCase(result));
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        System.out.println(new AlphabeticallyLargestLetter().getAlphabeticallyLargestLetter("aaBabcDaA"));
        System.out.println(new AlphabeticallyLargestLetter().getAlphabeticallyLargestLetter("Codility"));
        System.out.println(new AlphabeticallyLargestLetter().getAlphabeticallyLargestLetter("WeTestCodErs"));

    }
}
