package com.learnings.practise.problems.leetcode.ms.explore;

public class WildcardMatching {

    /**
     * Time Complexity: O(sp) worst case and  O(min(s,p)) best case and O(s log p) in average case
     * Space Complexity: O(1)
     */
    public boolean isMatch(String str, String pattern) {
        if(str == null || pattern == null) return false;

        // strIndex - To Track Str String Iteration
        // patternIndex - To Track Pattern String Iteration
        // patternIndexTemp - To track the last index of *
        // strIndexTemp - To track the equivalent str index of * index
        int strIndex = 0, patternIndex = 0, strIndexTemp = 0, patternIndexTemp = -1;

        while(strIndex < str.length()) {

            //When both str and pattern characters are equal or pattern character is ? just increment both the index
            if(patternIndex < pattern.length() && (pattern.charAt(patternIndex) == '?' || str.charAt(strIndex) == pattern.charAt(patternIndex))) {
                strIndex++;
                patternIndex++;
            }
            //When the pattern index is * that could be any of the following cases
            //  1. Character * could replace no character
            //  2. Character * could replace one or more character
            //This is to track the no match situation where we just increment the pattern index and keep track of str and pattern index in temp variable
            else if(patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
                patternIndexTemp = patternIndex;
                strIndexTemp = strIndex;
                patternIndex++;
            }
            //If the previous character is * and the chars does not meet the above condition then reset the pattern index back to next position of its previously found * index
            //Similarly replace the str index too
            else if(patternIndexTemp != -1) {
                patternIndex = patternIndexTemp + 1;
                strIndex = ++strIndexTemp;
            }
            //When none of the above cases match return false
            else return false;
        }

        //when there are still characters left in pattern string and if its all star then keep incrementing
        while(patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') patternIndex++;

        //If still there are some patterns left then return false or else return true
        return pattern.length() == patternIndex;
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("mnen", "m**n"));
        System.out.println(new WildcardMatching().isMatch("madan", "*"));
        System.out.println(new WildcardMatching().isMatch("madan", "m*"));
        System.out.println(new WildcardMatching().isMatch("madan", "m?da*"));
        System.out.println(new WildcardMatching().isMatch("mnen", "m**n"));
    }
}
