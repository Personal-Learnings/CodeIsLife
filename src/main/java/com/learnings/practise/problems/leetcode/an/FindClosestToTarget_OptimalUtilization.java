package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class FindClosestToTarget_OptimalUtilization {

    /** Time Complexity O(ab) where a and b are the two input arrays */
    private List<List<Integer>> findClosestToTarget(int [][] a, int [][] b, int target) {

        if(a == null || a.length == 0 || b == null || b.length == 0) return Collections.emptyList();

        int max = Integer.MIN_VALUE;
        List<Integer> maxIndex = new ArrayList<>(2);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                int sum = a[i][1] + b[j][1];
                if(sum == target) {
                    result.add(Arrays.asList(a[i][0], b[j][0]));
                } else if(sum < target && sum > max) {
                    max = sum;
                    maxIndex = Arrays.asList(a[i][0], b[j][0]);
                }
            }
        }
        return result.isEmpty() ? Collections.singletonList(maxIndex) : result;
    }

    /** Time Complexity O(A*B*logN)*/
    private static List<List<Integer>> findClosestToTarget_1(int[][] a, int[][] b, int target) {
        TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<>();

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {
                int sum = a[i][1] + b[j][1];
                if (sum <= target) {
                    List<List<Integer>> list = tree.computeIfAbsent(sum, (k) -> new ArrayList<>());
                    list.add(Arrays.asList(a[i][0], b[j][0]));
                }
            }
        }

        return tree.floorEntry(target).getValue();
    }

    public static void main(String[] args) {
        System.out.println(new FindClosestToTarget_OptimalUtilization().findClosestToTarget(
                new int[][]{{1, 2}, {2, 4}, {3, 6}},
                new int[][]{{1, 2}}, 7
        ));

        System.out.println(new FindClosestToTarget_OptimalUtilization().findClosestToTarget(
                new int[][]{{1, 3}, {2, 5}, {3, 7}, {4, 10}},
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 10
        ));

        System.out.println(new FindClosestToTarget_OptimalUtilization().findClosestToTarget(
                new int[][]{{1, 8}, {2, 7}, {3, 14}},
                new int[][]{{1, 5}, {2, 10}, {3, 14}}, 20
        ));

        System.out.println(new FindClosestToTarget_OptimalUtilization().findClosestToTarget(
                new int[][]{{1, 8}, {2, 15}, {3, 9}},
                new int[][]{{1, 8}, {2, 11}, {3, 12}}, 20
        ));
    }
}
