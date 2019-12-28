package com.learnings.practise.problems.leetcode;

import java.util.*;

public class GroupAnagrams {

    //TimeComplexity: O(N KLogK) N is the no of strings in array and K is the no of characters in each string
    //Even though the time complexity is higher it is performing well for smaller inputs [My PREFERENCE]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    //TimeComplexity: O(NK) N is the no of strings in array and K is the no of characters in each string
    public List<List<String>> groupAnagrams_1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            StringBuilder keyBuilder = new StringBuilder();
            char[] chars = str.toCharArray();
            int [] occurrences = new int[26];
            Arrays.fill(occurrences, 0);

            for(char c : chars) {
                ++occurrences[c - 'a'];
            }
            for(int o : occurrences) {
                keyBuilder.append("#").append(o);
            }
            String key = keyBuilder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}