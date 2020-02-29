package com.learnings.practise.problems.leetcode.ms.oa;

public class LexicographicallySmallestString {

    private String getSmallestString(String num) {
        if(num == null || num.length() == 0) return "";

        int i = 0;
        while(i < num.length() - 1) {
            if(num.charAt(i) > num.charAt(i + 1)) break;
            i++;
        }
        return new StringBuilder(num).deleteCharAt(i).toString();
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicallySmallestString().getSmallestString("abczd"));
        System.out.println(new LexicographicallySmallestString().getSmallestString("abcdz"));
        System.out.println(new LexicographicallySmallestString().getSmallestString("abcdz"));
    }
}
