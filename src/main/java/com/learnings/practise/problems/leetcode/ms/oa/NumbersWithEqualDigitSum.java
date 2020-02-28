package com.learnings.practise.problems.leetcode.ms.oa;

import java.util.*;
import java.util.stream.Collectors;

public class NumbersWithEqualDigitSum {

    /**
     * Time Complexity: O(n log(k)) - log k is time taken to calculate the digit sum for each value with base 10
     * Space Complexity: O(n)
     */
    public int getTwoSumMax(int [] input) {
        if(input == null || input.length == 0) return -1;
        int result = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int value : input) {
            int digitSum = getDigitSum(value);

            if(map.containsKey(digitSum)) {
                result = Math.max(result, map.get(digitSum) + value);
                map.put(digitSum, Math.max(value, map.get(digitSum)));
            }
            else map.put(digitSum, value);
        }
        return result;
    }

    public int getTwoSumMax_slower(int [] input) {
        if(input == null || input.length == 0) return -1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int value : input) {
            int digitSum = getDigitSum(value);
            List<Integer> list = map.getOrDefault(digitSum, new ArrayList<>());
            list.add(value);
            map.put(digitSum, list.stream().sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList()));
        }

        OptionalInt max = map.values().stream()
                .filter(e -> e.size() > 1)
                .map(integers -> integers.stream().mapToInt(Integer::intValue).summaryStatistics().getSum())
                .mapToInt(Long::intValue)
                .max();

        return max.orElse(-1);
    }

    private int getDigitSum(int num) {
        int result = 0;
        while(num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumbersWithEqualDigitSum().getTwoSumMax(new int[] { 51, 71, 17, 42 }));
        System.out.println(new NumbersWithEqualDigitSum().getTwoSumMax(new int[] { 42, 33, 60 }));
        System.out.println(new NumbersWithEqualDigitSum().getTwoSumMax(new int[] { 51, 32, 43 }));
    }
}