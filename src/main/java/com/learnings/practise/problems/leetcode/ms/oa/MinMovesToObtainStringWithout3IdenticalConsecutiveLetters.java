package com.learnings.practise.problems.leetcode.ms.oa;

public class MinMovesToObtainStringWithout3IdenticalConsecutiveLetters {

    private int getMinimumMoves(String s) {
        if(s == null || s.length() == 0) return 0;
        int result = 0, aCount = 0, bCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
                bCount = 0;
                if(aCount % 3 == 0) ++result;
            } else {
                bCount++;
                aCount = 0;
                if(bCount % 3 == 0) ++result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinMovesToObtainStringWithout3IdenticalConsecutiveLetters().getMinimumMoves("baaaaa"));
        System.out.println(new MinMovesToObtainStringWithout3IdenticalConsecutiveLetters().getMinimumMoves("baaabbaabbba"));
        System.out.println(new MinMovesToObtainStringWithout3IdenticalConsecutiveLetters().getMinimumMoves("baabab"));
        System.out.println(new MinMovesToObtainStringWithout3IdenticalConsecutiveLetters().getMinimumMoves("aaaaaaaaa"));
    }
}
