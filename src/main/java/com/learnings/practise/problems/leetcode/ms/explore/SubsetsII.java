package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void generateSubsets(List<List<Integer>> result, List<Integer> tempList, int [] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            int value = nums[i];
            tempList.add(value);
            generateSubsets(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new SubsetsII().getSubsets(new int[]{1,2,3,1});
        System.out.println(output);
    }
}
