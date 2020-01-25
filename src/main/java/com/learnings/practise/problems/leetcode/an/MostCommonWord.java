package com.learnings.practise.problems.leetcode.an;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MostCommonWord {

    /**
     * Time Complexity: O(b + c) where n is the number of characters in the given String and b is the length of the banned words array (time taken to add to set)
     * Space Complexity: O(w) where w is the number of words in the String.
     */
    public String mostCommonWord(String paragraph, String [] banned) {
        if(paragraph == null || paragraph.length() == 0) return "";

        int max = 0;
        String result = "";

        //Collecting to set for faster access
        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        //Keep Track of single word
        StringBuilder sb = new StringBuilder();

        //To Track Words and their occurrences
        Map<String, Integer> map = new HashMap<>();

        //To Cover a case where there is only one word without any special characters at the end
        paragraph = paragraph + ",";

        //Iterating character by character
        for(int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if(Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else if(sb.length() > 0) {
                String word = sb.toString();

                //Adding to map if not a banned word
                if(!bannedWords.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);

                    if(map.get(word) > max) {
                        max = map.get(word);
                        result = word;
                    }
                }
                //Resetting String Builder to keep track of next word.
                sb = new StringBuilder();
            }
        }
        return result;
    }

    //Slow Solution and fails with few edge cases
    public String mostCommonWord_slow(String s, List<String> banned) {
        if(s == null || s.length() == 0) return "";

        Set<String> bannedWords = new HashSet<>(banned);
        Map<String, Integer> map = new HashMap<>();

        String [] words = s.split(" ");
        for(String word : words) {
            word = formatString(word);
            if(!bannedWords.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        AtomicInteger max = new AtomicInteger();
        AtomicReference<String> result = new AtomicReference<>("");
        map.forEach((key, value) -> {
            if (value > max.get()) {
                max.set(value);
                result.set(key);
            }
        });

        return result.get();
    }

    private String formatString(String s) {
        return s.replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\?", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }
}