package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String> map;

    LetterCombinationsOfAPhoneNumber() {
        map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty() || digits.contains("1")) return Collections.emptyList();
        return getCombinations(digits, 0);
    }

    private List<String> getCombinations(String digits, int index) {
        char currentChar;
        List<String> combinations;
        List<String> result = new ArrayList<>();

        if(index < digits.length()) {
            currentChar = digits.charAt(index);
            combinations = getCombinations(digits, ++index);
        }
        else return Collections.emptyList();

        if(map.containsKey(currentChar)) {
            for(char c : map.get(currentChar).toCharArray()) {
                if(combinations.isEmpty()) {
                   result.add(String.valueOf(c));
                } else {
                    for(String s : combinations) {
                        result.add(c + s);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("2345"));
    }
}
