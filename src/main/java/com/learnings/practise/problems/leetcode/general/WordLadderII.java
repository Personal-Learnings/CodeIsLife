package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class WordLadderII {

    //INCOMPLETE
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) return Collections.emptyList();

        Set<String> lookup = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        List<String> transformations = new ArrayList<>();

        queue.offer(beginWord);
        lookup.remove(beginWord);
        transformations.add(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int q = 0; q < size; q++) {
                String current = queue.poll();
                transformations.add(current);


                for (int i = 0; i < current.length(); i++) {
                    char[] chars = current.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);

                        if (lookup.contains(newWord)) {
                            if (newWord.equals(endWord)) return Collections.singletonList(transformations);
                            queue.add(newWord);
                            lookup.remove(newWord);
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        System.out.println(new WordLadderII().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(new WordLadderII().findLadders("a", "c", Arrays.asList("a","b","c")));
    }
}
