package com.learnings.practise.problems.leetcode.general;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];

        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int wStart = 0, wEnd = 0; wEnd < nums.length; wEnd++) {
            if(nums[wEnd] > sum && (nums[wEnd] >= (sum + nums[wEnd])) ) {
                wStart = wEnd;
                sum = nums[wEnd];
            } else {
                sum += nums[wEnd];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
