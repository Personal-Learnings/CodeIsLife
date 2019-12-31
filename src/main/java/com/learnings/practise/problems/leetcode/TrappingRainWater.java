package com.learnings.practise.problems.leetcode;

public class TrappingRainWater {

    private int [] a;

    //Time Complexity: O(N^2) Space Complexity O(1)
    public int trap(int[] height) {

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
        System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}