package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class WordBreakII {

    int maxLen = 0;
    Set<String> dictionary = new HashSet<>();

    /**
     * Time Complexity: O(N^2 * K) (Where N is the length of the String and K is the max length word in the dictionary)
     * Space Complexity: O(K) where K is the no of words in the dictionary
     * Approach: DP + Memoization + Restricting Recursion based on the max length of dictionary
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
            dictionary.add(word);
        }
        return findWordBreak(s, 0, new HashMap<>());
    }

    private List<String> findWordBreak(String s, int currentIndex, Map<Integer, List<String>> memo) {

        if(memo.containsKey(currentIndex)) return memo.get(currentIndex);

        List<String> list = new ArrayList<>();
        if(s.length() == currentIndex) list.add("");

        StringBuilder sb = new StringBuilder();
        for(int i = currentIndex; i < currentIndex + maxLen && i < s.length(); i++) {
            sb.append(s.charAt(i));
            String currentWord = sb.toString();

            if(dictionary.contains(currentWord)) {
                List<String> words = findWordBreak(s, i + 1, memo);
                for(String word : words) {
                    list.add(word.equals("") ? currentWord : currentWord + " " + word);
                }
            }
        }
        memo.putIfAbsent(currentIndex, list);
        return list;
    }
/*
    int maxLen = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();

        //Calculate Max Length so that the loop does not run more than the longest word in the dictionary
        //Adding to set for faster access
        for(String w : wordDict) {
            dictionary.add(w);
            maxLen = Math.max(maxLen, w.length());
        }
        return findWordBreaks(dictionary, s, 0, new HashMap<>());
    }

    public List<String> findWordBreaks(Set<String> dictionary, String str, int start, Map<Integer, List<String>> map) {
        //Memoize the values to avoid already processed data to process again
        if(map.containsKey(start)) return map.get(start);

        List<String> list = new ArrayList<>();
        if(start == str.length())  list.add("");

        for(int i = start; i < start + maxLen && i < str.length(); i++) {
            String currentWord = str.substring(start, i + 1);
            if(dictionary.contains(currentWord)) {
                List<String> words = findWordBreaks(dictionary, str, i + 1, map);
                for(String word : words) {
                    list.add(word.equals("") ? currentWord + word : currentWord + " " + word);
                }
            }
        }
        map.put(start, list);
        return list;
    }*/

    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreakII().wordBreak("catasanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreakII().wordBreak("catsandog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreakII().wordBreak("leetcode", Arrays.asList("leet", "code", "and", "sand", "dog")));
    }
}
