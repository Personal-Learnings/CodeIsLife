package com.learnings.practise.problems.leetcode.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 0; i <= s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                String word = s.substring(j, i);
                if(dp[j] && dictionary.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
    }
}