package com.learnings.practise.problems.leetcode.ms.oa;

public class Sample1 {

    private int solution(String S) {

        int result = 0;
        int maxLimit = 1000000007;

        int [] fChar = new int[26];
        int [] sChar = new int[26];

        for(int i = 0, current = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'A';
            current = current + 1 + i - fChar[c] * 2 + sChar[c];
            result = (result + current) % maxLimit;
            sChar[c] = fChar[c];
            fChar[c] = i + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Sample1().solution("ACAX"));
        System.out.println(new Sample1().solution("CODILITY"));
    }
}
