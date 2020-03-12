package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void generateCombinations(List<List<Integer>> result, List<Integer> tempList, int [] candidates, int target, int start) {
        if(target < 0) return;
        else if(target == 0) result.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < candidates.length; i++) {
                int value = candidates[i];
                tempList.add(value);
                generateCombinations(result, tempList, candidates, target - value, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(output);
    }
}