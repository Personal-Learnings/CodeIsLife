package com.learnings.practise.problems.leetcode.general;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1) return map.get(s.charAt(0));

        int result = 0, current, prev = map.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            current = map.get(s.charAt(i));
            result = (prev < current) ? (result - prev) : (result + prev);
            prev = current;
        }
        result += prev;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("I"));
        System.out.println(new RomanToInteger().romanToInt("II"));
        System.out.println(new RomanToInteger().romanToInt("IV"));
        System.out.println(new RomanToInteger().romanToInt("V"));
        System.out.println(new RomanToInteger().romanToInt("VI"));
        System.out.println(new RomanToInteger().romanToInt("IX"));
        System.out.println(new RomanToInteger().romanToInt("X"));
        System.out.println(new RomanToInteger().romanToInt("XIV"));
        System.out.println(new RomanToInteger().romanToInt("XV"));
        System.out.println(new RomanToInteger().romanToInt("XVI"));
    }
}
