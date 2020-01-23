package com.learnings.practise.problems.leetcode.an;

import java.util.HashSet;
import java.util.Set;

public class TwoSumUniquePairs {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Sol Jetemple
     */
    public int getTwoSumUniquePairs(int [] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        int count = 0;

        for(int num : nums) {
            int diff = target - num;
            if(set.contains(diff) && !result.contains(num)) {
                count++;
                result.add(num);
                result.add(diff);
            } else if(!set.contains(diff)) {
                set.add(num);
            }
        }
        return count;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * // My Solution
     */
    public int getTwoSumUniquePairs_1(int [] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int num : nums) {
            int diff = target - num;
            if (set.contains(diff)) {
                result.add(Math.max(num, diff) + "-" + Math.min(num, diff));
            }
            set.add(num);
        }
        return result.isEmpty() ? -1 : result.size();
    }

    public static void main(String[] args) {
        System.out.println(new TwoSumUniquePairs().getTwoSumUniquePairs(new int[] {1, 1, 2, 45, 46, 46}, 47));
        System.out.println(new TwoSumUniquePairs().getTwoSumUniquePairs(new int[] {1, 1}, 2));
        System.out.println(new TwoSumUniquePairs().getTwoSumUniquePairs(new int[] {1, 5, 1, 5}, 6));
        System.out.println(new TwoSumUniquePairs().getTwoSumUniquePairs(new int[] {1, 5, 1, 5}, 7));
        System.out.println(new TwoSumUniquePairs().getTwoSumUniquePairs(new int[] {1, 1, 1, 1}, 2));
    }
}