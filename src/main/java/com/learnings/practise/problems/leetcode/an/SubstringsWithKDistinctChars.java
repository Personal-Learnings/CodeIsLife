package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class SubstringsWithKDistinctChars {

    /**
     * Only if the given string is ASCII or Extended Ascii (change array size to 256)
     * Time Complexity: O(n) where n is the length of the String
     * Space Complexity: O(1)
     */
    public int getSubstringsWithKDistinctChars(String s, int K) {
        if(s == null || s.isEmpty() || K == 0) return 0;

        int result = 0, prefix = 0;
        int[] occurrence = new int[128]; //Assuming the string is ASCII

        for (int windowEnd = 0, windowStart = 0, noOfDistinctChars = 0; windowEnd < s.length(); ++windowEnd) {
            if (occurrence[s.charAt(windowEnd)] == 0) {
                noOfDistinctChars++;
            }
            occurrence[s.charAt(windowEnd)]++;

            if (noOfDistinctChars > K) {
                occurrence[s.charAt(windowStart)]--;
                windowStart++;
                noOfDistinctChars--;
                prefix = 0;
            }
            while (occurrence[s.charAt(windowStart)] > 1) {
                prefix++;
                occurrence[s.charAt(windowStart)]--;
                windowStart++;
            }
            if (noOfDistinctChars == K) {
                result += prefix + 1;
            }
        }
        return result;
    }

    /** If String is not a ASCII we can use hashmap **/
    public int getSubstringsWithKDistinctChars_usingHashMap(String s, int K) {
        if(s == null || s.isEmpty() || K == 0) return 0;

        int result = 0, prefix = 0;
        Map<Character, Integer> occurrence = new HashMap<>();

        for (int windowEnd = 0, windowStart = 0, noOfDistinctChars = 0; windowEnd < s.length(); ++windowEnd) {
            if (occurrence.getOrDefault(s.charAt(windowEnd), 0) == 0) {
                noOfDistinctChars++;
            }
            occurrence.put(s.charAt(windowEnd), occurrence.getOrDefault(s.charAt(windowEnd), 0) + 1);

            if (noOfDistinctChars > K) {
                occurrence.put(s.charAt(windowStart), occurrence.get(s.charAt(windowStart)) - 1);
                windowStart++;
                noOfDistinctChars--;
                prefix = 0;
            }
            while (occurrence.get(s.charAt(windowStart)) > 1) {
                prefix++;
                occurrence.put(s.charAt(windowStart), occurrence.get(s.charAt(windowStart)) - 1);
                windowStart++;
            }
            if (noOfDistinctChars == K) {
                result += prefix + 1;
            }
        }
        return result;
    }


    public int getSubstringsWithKDistinctChars_2(String s, int K) {
        if(s == null || s.length() == 0 || K == 0) return 0;
        return atMostK(s.toCharArray(), K) - atMostK(s.toCharArray(), K - 1);
    }

    //pqpqs
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
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("pqpqs", 2));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("pqqps", 2));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("aabab", 3));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("aabab", 2));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madanraj", 2));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madanraj", 3));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars(null, 3));
        System.out.println(new SubstringsWithKDistinctChars().getSubstringsWithKDistinctChars("Madan", 0));
    }
}