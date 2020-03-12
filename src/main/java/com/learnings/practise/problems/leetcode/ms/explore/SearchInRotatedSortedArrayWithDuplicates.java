package com.learnings.practise.problems.leetcode.ms.explore;

public class SearchInRotatedSortedArrayWithDuplicates {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            //if left part is sorted
            if (nums[left] < nums[mid]) {
                if (target < nums[left] || target > nums[mid]) {
                    //target is in rotated part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] > nums[mid]) {
                //right part is rotated

                //target is in rotated part
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //duplicates, we know nums[mid] != target, so nums[left] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                left++;
            }
        }
        return false;
    }
}