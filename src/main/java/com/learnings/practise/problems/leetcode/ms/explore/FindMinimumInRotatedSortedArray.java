package com.learnings.practise.problems.leetcode.ms.explore;

public class FindMinimumInRotatedSortedArray {

    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        //Array is already in sequence
        if(nums[right] > nums[left]) return nums[left];

        while(right >= left) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] < nums[mid - 1]) return nums[mid];

            //In this scenario search right
            if(nums[mid] > nums[left]) left = mid + 1;

            //In this scenario search left
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMin_slower(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        for(int i = 1; i < nums.length; i++)
            if(nums[i] < nums[i - 1]) return nums[i];

        return nums[0];
    }

    public static void main(String[] args) {

    }
}
