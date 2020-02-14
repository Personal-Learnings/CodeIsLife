package com.learnings.practise.problems.leetcode.general;

public class ContainerWithMostWater {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Approach: Two Pointer Technique
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;

        int start = 0, end = (height.length - 1), maxCapacity = Integer.MIN_VALUE;
        while(start < end) {
            int minHeight = Math.min(height[start], height[end]);
            maxCapacity = Math.max(maxCapacity, (minHeight * (end - start)));

            if(height[start] < height[end]) start++;
            else end--;
        }
        return maxCapacity;
    }
}