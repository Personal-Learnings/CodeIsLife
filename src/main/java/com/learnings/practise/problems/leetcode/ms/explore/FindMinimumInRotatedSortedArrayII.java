package com.learnings.practise.problems.leetcode.ms.explore;

public class FindMinimumInRotatedSortedArrayII {

    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while(right > left) {
            int mid = left + (right - left) / 2;

            //In this scenario search right
            if(nums[mid] > nums[right]) left = mid + 1;

            //In this scenario search left
            else if(nums[mid] < nums[left]) {
                right = mid;
                left++;
            }
            else right--;
        }
        return nums[left];
    }

    public static void main(String[] args) {

    }
}
