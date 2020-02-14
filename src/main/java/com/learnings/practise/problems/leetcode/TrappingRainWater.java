package com.learnings.practise.problems.leetcode;

public class TrappingRainWater {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Approach: Two Pointer Technique
     */
    public int trap(int [] height) {
        if(height == null || height.length < 3) return 0;

        int start = 0, end = height.length - 1, water = 0;
        while(start < end) {
            if(height[start] <= height[end]) {
                int current = height[start];
                while(current > height[++start]) water += (current - height[start]);
            }
            else {
                int current = height[end];
                while(current > height[--end]) water += (current - height[end]);
            }
        }
        return water;
    }

    private int [] a;

    //Time Complexity: O(N^2) Space Complexity O(1)
    public int trap_slower(int[] height) {

        a = height;
        int result = 0;
        int [] lMax = new int[a.length];
        int [] rMax = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            lMax[i] = findMax(0, i);
            rMax[i] = findMax(i + 1, height.length);
        }

        for(int i = 0; i < height.length; i++) {
            int unitOfWaterAtIndex = Math.min(lMax[i], rMax[i]) - a[i];
            result = result + Math.max(unitOfWaterAtIndex, 0);
        }
        return result;
    }

    private int findMax(int start, int end) {
        int maximum = 0;
        for(int i = start; i < end; i++)
            maximum = Math.max(a[i], maximum);
        return maximum;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap_slower(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}