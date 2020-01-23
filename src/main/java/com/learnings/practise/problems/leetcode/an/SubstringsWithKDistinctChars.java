package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class SubstringsWithKDistinctChars {

    public int getSubstringsWithKDistinctChars(String s, int K) {
        if(s == null || s.length() == 0 || K == 0) return 0;
        return atMostK(s.toCharArray(), K) - atMostK(s.toCharArray(), K - 1);
    }

    int atMostK(char[] A, int K) {
        int i = 0, res = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    // Slow
    public int getSubstringsWithKDistinctChars_1(String s, int k) {
        if(s == null || s.isEmpty() || k == 0) return 0;

        int result = 0;
        for(int i = 0; i <= s.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                String curr = s.substring(i, j);
                if(containsKDistinctChars(curr, k)) ++result;
            }
        }
        return result;
    }

    private boolean containsKDistinctChars(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == k;
    }

    public static void main(String[] args) {
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("pqpqs", 2));
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("aabab", 3));
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("aabab", 2));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madanraj", 2));
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madanraj", 3));
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars(null, 3));
        //System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madan", 0));
    }
}