package com.learnings.practise.problems.leetcode.an;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairWithGivenSum {

    /**
     * Time Complexity: O(N) where N is the number of elements in the Given List.
     * Space Complexity: O(N) where N is the number of elements in the Given List.
     * My Solution
     */
    private List<Integer> getIndices(List<Integer> nums, int target) {

        if(nums == null || nums.isEmpty()) return null;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = Arrays.asList(-1, -1);
        target -= 30;

        for(int i = 0; i < nums.size(); i++) {
            int diff = target - nums.get(i);

            if(map.containsKey(diff)) {
                if(result.get(0) == -1) {
                    result = Arrays.asList(map.get(diff), i);
                } else {
                    int existingMax = Math.max(nums.get(result.get(0)), nums.get(result.get(1)));
                    int newMax = Math.max(nums.get(i), nums.get(map.get(diff)));
                    if(newMax > existingMax) result = Arrays.asList(map.get(diff), i);
                }
            }
            map.put(nums.get(i), i);
        }
        return result;
    }

    /**
     * Time Complexity: O(N) where N is the number of elements in the Given List.
     * Space Complexity: O(N) where N is the number of elements in the Given List.
     * -----Sithis Solution.
     */
    public static List<Integer> getIndices_2(List<Integer> nums, int target) {
        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = Arrays.asList(-1, -1);
        int largest = 0;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if ((nums.get(i) > largest || complement > largest) && map.containsKey(complement)) {
                result.set(0, map.get(complement));
                result.set(1, i);
                largest = Math.max(nums.get(i), complement);
            }
            map.put(nums.get(i), i);
        }
        return result;
    }


    /**
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     * */
    private int [] getIndices_1(int [] input, int target) {

        if(input == null || input.length == 0) return null;

        int sum = 0;
        int [] index = new int[] {-1, -1};
        int newTarget = target - 30;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            int key = input[i];
            map.put(key, i);
        }

        Arrays.sort(input);

        int i = 0, j = input.length - 1;
        while(i < j) {
            int tempSum = input[i] + input[j];
            if(tempSum <= newTarget) {
                if(tempSum > sum) {
                    index = new int[] {map.get(input[i]), map.get(input[j])};
                    sum = tempSum;
                }
                i++;
            } else {
                j--;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(new FindPairWithGivenSum().getIndices(Arrays.asList(1, 10, 25, 35, 60), 90));
        System.out.println(new FindPairWithGivenSum().getIndices(Arrays.asList(20, 50, 40, 25, 30, 10), 90));
        System.out.println(new FindPairWithGivenSum().getIndices(Arrays.asList(5, 55, 40, 20, 30, 30), 90));
        System.out.println(new FindPairWithGivenSum().getIndices(Arrays.asList(3, 5, 7, 6, 4, 6), 40));
    }
}
