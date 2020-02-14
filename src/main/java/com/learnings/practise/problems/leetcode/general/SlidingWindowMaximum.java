package com.learnings.practise.problems.leetcode.general;

import java.util.Arrays;

public class SlidingWindowMaximum {

    /**
     * Time Complexity: O(N * K)
     * Space Complexity: O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0) return new int[0];

        int [] result = new int[nums.length - k + 1];
        for(int wStart = 0, wEnd = 1; wEnd <= nums.length; wEnd++) {
            if((wEnd - wStart) == k) {
                result[wStart] = getMax(wStart, wEnd, nums);
                wStart++;
            }
        }
        return result;
    }

    private int getMax(int start, int end, int [] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{ 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{}, 0)));
    }
}