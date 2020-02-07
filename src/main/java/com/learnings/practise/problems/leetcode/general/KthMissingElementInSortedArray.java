package com.learnings.practise.problems.leetcode.general;

import java.util.ArrayList;
import java.util.List;

public class KthMissingElementInSortedArray {

    private int findKthMissingElement(int [] a, int k) {
        if(a == null || a.length == 0 || a.length == 1) return -1;

        List<Integer> missing = new ArrayList<>();
        for(int i = 1; i < a.length; i++) {
            int next = a[i - 1] + 1;
            while(a[i] != next) missing.add(next++);
        }
        return missing.size() >= k ? missing.get(k - 1) : -1;
    }

    public static void main(String[] args) {
        System.out.println(new KthMissingElementInSortedArray().findKthMissingElement(new int[] {2, 3, 5, 9, 10}, 1));
        System.out.println(new KthMissingElementInSortedArray().findKthMissingElement(new int[] {2, 3, 5, 9, 10, 11, 12}, 4));
    }
}