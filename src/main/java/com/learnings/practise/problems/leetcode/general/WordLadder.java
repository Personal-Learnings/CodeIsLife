package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class WordLadder {

    /**
     * Time Complexity: O(m * n) where m is the length of the begin word and n is the size of the word list.
     *      wordList.length to create Set + ((beginWord.length * 26 to generate combination) * wordList.length for Queue)
     * Space Complexity: O(n) where n is the size of the word list.
     * Approach: Start from the begin word, generate combinations of it and check if the word is present increment the transformation when the word is changed
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) return 0;
        if(beginWord.equals(endWord)) return 1;

        Set<String> lookup = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        lookup.remove(beginWord);
        int transformation = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int q = 0; q < size; q++) {
                String current = queue.poll();

                for(int i = 0; i < current.length(); i++) {
                    char[] chars = current.toCharArray();

                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);

                        if(lookup.contains(newWord)) {
                            if(newWord.equals(endWord)) return transformation + 1;
                            queue.add(newWord);
                            lookup.remove(newWord);
                        }
                    }
                }
            }
            transformation++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(new WordLadder().ladderLength("a", "c", Arrays.asList("a","b","c")));
    }
}
