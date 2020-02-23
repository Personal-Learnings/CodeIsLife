package com.learnings.practise.problems.leetcode.general;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public int firstUniqueChar(String s) {
        if(s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>(26);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1) return i;
        }
        return -1;
    }
}