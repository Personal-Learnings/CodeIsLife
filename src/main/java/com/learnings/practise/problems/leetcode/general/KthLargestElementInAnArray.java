package com.learnings.practise.problems.leetcode.general;

import java.util.*;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i : nums) queue.offer(i);

        if(k > queue.size()) return -1;
        int i = 1;

        while(!queue.isEmpty()) {
            Integer val = queue.poll();
            if(i == k) return val;
            ++i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int [] {3,2,1,5,6,4}, 2));
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
