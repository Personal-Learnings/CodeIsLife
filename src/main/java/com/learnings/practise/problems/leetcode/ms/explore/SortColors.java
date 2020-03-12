package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortColors {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int [] counts = new int[3];

        for(int num : nums) counts[num]++;

        int i = 0;
        for(int j = 0; j < counts.length; j++) {
            for(int k = 0; k < counts[j]; k++, i++) {
                nums[i] = j;
            }
        }
    }

    public void sortColors_map(int[] nums) {
        if(nums == null || nums.length == 0) return;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for(int j = 0; map.get(0) != null && j < map.get(0); j++, i++)
            nums[i] = 0;

        for(int j = 0; map.get(1) != null && j < map.get(1); j++, i++)
            nums[i] = 1;

        for(int j = 0; map.get(2) != null && j < map.get(2); j++, i++)
            nums[i] = 2;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {2,0,2,1,1,0};
        new SortColors().sortColors_map(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
