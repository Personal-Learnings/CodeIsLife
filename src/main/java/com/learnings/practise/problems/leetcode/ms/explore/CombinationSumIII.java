package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int [] nums = new int[9];
        for(int i = 0; i < 9; i++) nums[i] = i + 1;
        generateCombinations(result, new ArrayList<>(), nums, target, 0, k);
        return result;
    }

    private void generateCombinations(List<List<Integer>> result, List<Integer> tempList, int [] candidates, int target, int start, int k) {
        if(target < 0) return;
        else if(target == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                int value = candidates[i];
                tempList.add(value);
                generateCombinations(result, tempList, candidates, target - value, i + 1, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new CombinationSumIII().combinationSum3(3, 7);
        System.out.println(output);
    }
}