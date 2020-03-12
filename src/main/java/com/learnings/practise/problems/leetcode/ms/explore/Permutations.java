package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    //Distinct Integers
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(result, new ArrayList<>(), nums);
        return result;
    }

    private void generatePermutations(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) result.add(new ArrayList<>(tempList));

        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(!tempList.contains(value)) {
                tempList.add(value);
                generatePermutations(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //String Permutations where String contains duplicates
    public List<String> permuteString(String val) {
        if(val == null || val.length() == 0) return Collections.emptyList();

        List<String> result = new ArrayList<>();
        char[] chars = val.toCharArray();
        Arrays.sort(chars);
        generateStringPermutations(result, new StringBuilder(), chars, new boolean[chars.length]);
        return result;
    }

    private void generateStringPermutations(List<String> result, StringBuilder sb, char [] chars, boolean [] used) {
        if(sb.length() == chars.length){
            result.add(sb.toString());
        } else{
            for(int i = 0; i < chars.length; i++){
                if(used[i] || i > 0 && chars[i] == chars[i-1] && !used[i - 1]) continue;
                used[i] = true;
                sb.append(chars[i]);
                generateStringPermutations(result, sb, chars, used);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[] {1, 2, 3}));
        System.out.println(new Permutations().permuteString("cat"));
        System.out.println(new Permutations().permuteString("madan"));
    }
}