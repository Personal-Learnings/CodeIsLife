package com.learnings.practise.problems.leetcode;

import java.util.*;

public class TopKFrequentWords {

    // Here i have implemented Max Queue, we can use min queue and add only K element
    // and poll if more than k is popped.(But the Comparator should be reversed
    // and the return result should be reversed (Collections.reverse not reverse Sorted)
    //Time Complexity O(NLogN)
    public List<String> topKFrequent_1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(
                (s1, s2) -> map.get(s1).equals(map.get(s2)) ? s1.compareTo(s2) : map.get(s2).compareTo(map.get(s1))
        );
        map.keySet().forEach(queue::offer);

        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        return result;
    }

    //Time Complexity NLogN
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (entry1, entry2) -> entry1.getValue().equals(entry2.getValue())
                        ? entry1.getKey().compareTo(entry2.getKey())
                        : (entry1.getValue() > entry2.getValue() ? -1 : 1)
        );
        map.entrySet().forEach(queue::offer);

        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

        System.out.println(new TopKFrequentWords().topKFrequent_1(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequentWords().topKFrequent_1(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
