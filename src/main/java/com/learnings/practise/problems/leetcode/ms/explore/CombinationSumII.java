package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void generateCombinations(List<List<Integer>> result, List<Integer> tempList, int [] candidates, int target, int start) {
        if(target < 0) return;
        else if(target == 0) result.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                int value = candidates[i];
                tempList.add(value);
                generateCombinations(result, tempList, candidates, target - value, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5,1}, 8);
        System.out.println(output);
    }
}