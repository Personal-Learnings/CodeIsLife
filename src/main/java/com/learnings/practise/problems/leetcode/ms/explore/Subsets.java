package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void generateSubsets(List<List<Integer>> result, List<Integer> tempList, int [] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            int value = nums[i];
            tempList.add(value);
            generateSubsets(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new Subsets().getSubsets(new int[]{1,2,3});
        System.out.println(output);
    }
}
