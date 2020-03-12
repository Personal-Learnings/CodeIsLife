package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int result = -1;
        for (Integer integer : set) {
            result = integer;
            break;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
