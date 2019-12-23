package com.learnings.practise.problems.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSumIIinputArrayIsSorted {

    public int[] twoSum_BigO_nlogn(int[] numbers, int target) {
        Arrays.sort(numbers);

        int l = numbers.length;
        int lowerBound = 0, upperBound = l - 1;
        int[] result = new int[2];

        while (lowerBound < upperBound) {
            int sum = numbers[lowerBound] + numbers[upperBound];
            if (sum <= target) {
                if (sum == target) {
                    result[0] = lowerBound + 1;
                    result[1] = upperBound + 1;
                }
                ++lowerBound; //may be too lower increase the lower bound
            } else {
                --upperBound; //may be too higher decrease the upper bound
            }
        }
        return result;
    }
}
