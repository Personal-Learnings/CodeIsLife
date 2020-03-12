package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates_littleComplicated(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[j] > nums[i]) {
                i++; j++;
            } else {
                while(j < nums.length && nums[j] <= nums[i]) j++;
                if(j < nums.length) {
                    ++i;
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int [] array1 = new int[] { 1, 1, 2 };
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(array1));
        System.out.println(Arrays.toString(array1));

        int [] array2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(array2));
        System.out.println(Arrays.toString(array2));
    }
}