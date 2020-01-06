package com.learnings.practise.problems.leetcode;

public class SmallestSubArrayGivenSum {

    private int findSmallestSubArraySize(int [] inputArray, int sum) {
        if(inputArray == null || inputArray.length == 0) return -1;

        int minWindowSize = Integer.MAX_VALUE;
        int currentRunningSum = 0;
        for(int windowEnd = 0, windowStart = 0; windowEnd < inputArray.length; windowEnd++) {
            currentRunningSum += inputArray[windowEnd];

            while(currentRunningSum >= sum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentRunningSum -= inputArray[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestSubArrayGivenSum().findSmallestSubArraySize(
                new int[]{ 4, 2, 2, 7, 8, 1, 2, 8, 1, 0 }, 8)
        );

        System.out.println(new SmallestSubArrayGivenSum().findSmallestSubArraySize(
                new int[]{ 4, 2, 2, 7, 1, 2, 1, 0 }, 13)
        );
    }
}
