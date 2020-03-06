package com.learnings.practise.problems.leetcode.ms.oa;

public class LongestSubstringWithout3ContiguousOccurrencesOfLetter {

    /**
     * Algorithm: Sliding Window
     *
     * Each time the code will make sure the characters within the window is does not repeat more than twice,
     * if it repeats it will shrink the window and always ensures the condition is satisfied
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private String getLongestSubstring(String s) {
        if(s == null || s.length() == 0) return null;

        //Having two occurrence variables, one to track the total occurrence and other one to track the occurrence without repeating
        char [] occurrence = new char[2];
        char [] totalOccurrence = new char[2];
        int maxSize = 0, startIndex = 0, endIndex = 0;

        for(int wStart = 0, wEnd = 0; wEnd < s.length(); wEnd++) {
            //Updating the Character Occurrence
            char c = s.charAt(wEnd);
            int charIndex = c - 'a';

            occurrence[charIndex]++;
            totalOccurrence[charIndex]++;

            //If current char is 'a' then resetting 'b' and vice versa
            if(c == 'a') occurrence[1] = 0;
            else occurrence[0] = 0;

            if(occurrence[charIndex] > 2) {
                while(totalOccurrence[charIndex] > 2) {
                    char c1 = s.charAt(wStart);
                    int newCharIndex = c1 - 'a';
                    totalOccurrence[newCharIndex]--;
                    wStart++;
                }
                occurrence[charIndex] = totalOccurrence[charIndex];
            }

            //Calculating the max size each time to avoid substring each time
            if(wEnd - wStart + 1 > maxSize) {
                maxSize = wEnd - wStart + 1;
                startIndex = wStart;
                endIndex = wEnd + 1;
            }
        }
        return s.substring(startIndex, endIndex);
    }

    /** Test Cases **/
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaabaaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaaabbbbaaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aabbbbaaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aabbaaaaabb"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aabbaabbaabbaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaaaaaaaaaaaaaaaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaaaaaababbabbabbabb"));
    }
}
