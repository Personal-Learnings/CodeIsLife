package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAStringII {

    public void reverseWords(char [] s) {
        if(s == null || s.length == 0) return;
        reverse(s, 0 , s.length - 1);
        reverseEachWord(s);
    }

    private void reverseEachWord(char [] s) {
        int startIndex = 0;
        while(startIndex < s.length) {
            int endIndex = findNextSpace(s, startIndex) - 1;
            reverse(s, startIndex, endIndex);
            startIndex = endIndex + 2;
        }
    }

    private int findNextSpace(char [] s, int startIndex) {
        int spaceIndex = startIndex;
        while(spaceIndex < s.length) {
            if(s[spaceIndex] == ' ') return spaceIndex;
            spaceIndex++;
        }
        return s.length;
    }

    private void reverse(char[] s, int p1, int p2) {
        while(p1 < p2) {
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;

            p1++; p2--;
        }
    }

    public void reverseWords_slower(char[] s) {
        if(s == null || s.length == 0) return;

        List<String> words = Arrays.asList(String.valueOf(s).split(" "));
        Collections.reverse(words);
        String result = String.join(" ", words);

        int i = 0;
        for(char c : result.toCharArray()) {
            s[i] = c;
            i++;
        }
    }

    public static void main(String[] args) {
        char [] c = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        new ReverseWordsInAStringII().reverseWords_slower(c);
        System.out.println(c);

        c = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        new ReverseWordsInAStringII().reverseWords(c);
        System.out.println(c);
    }
}
