package com.learnings.practise.problems.leetcode.ms.explore;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[left]) {
                if(target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if(target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
