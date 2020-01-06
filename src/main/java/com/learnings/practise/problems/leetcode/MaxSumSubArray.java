package com.learnings.practise.problems.leetcode;

public class MaxSumSubArray {

    private int findMaxSumSubArray(int [] subArray, int k) {
        int maximum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for(int windowEnd = 0; windowEnd < subArray.length; windowEnd++) {
            if(windowEnd < k) {
                currentRunningSum += subArray[windowEnd];
            } else {
                currentRunningSum = currentRunningSum - subArray[windowEnd - k] + subArray[windowEnd];
                maximum = Math.max(maximum, currentRunningSum);
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumSubArray().findMaxSumSubArray(
                new int[]{ 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3)
        );

        System.out.println(new MaxSumSubArray().findMaxSumSubArray(
                new int[]{ 4, 9, 5, 7, 8, 3, 7, 8, 9, 4 }, 4)
        );
    }
}