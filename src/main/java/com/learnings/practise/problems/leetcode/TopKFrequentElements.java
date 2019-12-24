package com.learnings.practise.problems.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public List<Integer> topKFrequent_faster(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        map.entrySet().forEach(queue::offer);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }

    //Time Complexity O(N+NLogN)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {1}, 1));
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {-1, -1}, 1));

        System.out.println(new TopKFrequentElements().topKFrequent_faster(new int[] {1,1,1,2,2,3}, 2));
        System.out.println(new TopKFrequentElements().topKFrequent_faster(new int[] {1}, 1));
        System.out.println(new TopKFrequentElements().topKFrequent_faster(new int[] {-1, -1}, 1));
    }
}