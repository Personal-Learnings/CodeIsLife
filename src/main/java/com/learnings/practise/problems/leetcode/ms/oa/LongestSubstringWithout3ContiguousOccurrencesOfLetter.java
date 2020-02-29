package com.learnings.practise.problems.leetcode.ms.oa;

public class LongestSubstringWithout3ContiguousOccurrencesOfLetter {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private String getLongestSubstring(String s) {
        if(s == null || s.length() == 0) return null;

        String maxSubstring = "";
        StringBuilder sb = new StringBuilder();
        char [] occurrence = new char[2];

        for(int i = 0; i < s.length(); i++) {

            //Updating the Character Occurrence
            char c = s.charAt(i);
            int index = c - 'a';
            occurrence[index]++;

            //If current char is 'a' then resetting 'b' and vice versa
            if(c == 'a') occurrence[1] = 0;
            else occurrence[0] = 0;

            //If current char occurrence is > 3 then updating the maxValue and resetting the count
            if(occurrence[index] > 3) {
                if(sb.length() > maxSubstring.length()) maxSubstring = sb.toString();

                sb = new StringBuilder();
                occurrence[0] = 0; occurrence[1] = 0; occurrence[index] = 1;
            }
            sb.append(c);
        }
        //If neither 'a' or 'b' is repeated then take the value from string builder
        return maxSubstring.equals("") ? sb.toString() : maxSubstring;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aabbaaaaabb"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aabbaabbaabbaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaaaaaaaaaaaaaaaa"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaabbbb"));
        System.out.println(new LongestSubstringWithout3ContiguousOccurrencesOfLetter().getLongestSubstring("aaa"));
    }
}
