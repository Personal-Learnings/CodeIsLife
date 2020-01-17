package com.learnings.practise.problems.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.offer(stick);
        }

        int result = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            queue.offer(sum);
            result += sum;
        }
        return result;
    }

    public int connectSticks_slower_Stack(int[] sticks) {
        Arrays.sort(sticks);
        int sum = 0;
        int result = 0;
        Stack<Integer> spent = new Stack<>();

        for(int i = 1; i < sticks.length; i++) {
            if(spent.isEmpty()) {
                sum = sticks[0] + sticks[i];
            }
            else {
                sum = sum + sticks[i];
            }
            spent.push(sum);
        }

        while(!spent.isEmpty()) {
            result += spent.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{2, 4, 3}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{1, 3, 8, 5}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{222, 29, 19, 988, 2999, 1717, 9898,34, 656, 3}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}));

        System.out.println(new MinimumCostToConnectSticks().connectSticks_slower_Stack(new int[]{2, 4, 3}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks_slower_Stack(new int[]{1, 3, 8, 5}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks_slower_Stack(new int[]{222, 29, 19, 988, 2999, 1717, 9898, 34, 656, 3}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks_slower_Stack(new int[]{3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}));
    }
}