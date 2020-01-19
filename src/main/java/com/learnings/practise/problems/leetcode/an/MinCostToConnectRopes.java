package com.learnings.practise.problems.leetcode.an;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectRopes {

    /** Time Complexity: O(nlogn)
     *  Space Complexity: O(n), where n = input.length. **/
    public int getMinCostToConnectRopes(int[] input) {
        if(input == null || input.length == 0 || input.length == 1) return 0;

        Queue<Integer> queue = new PriorityQueue<>(input.length);
        for(int i : input) queue.add(i);

        int totalCost = 0;
        while(queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            queue.offer(sum);
            totalCost += sum;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToConnectRopes().getMinCostToConnectRopes(new int[] {8, 4, 6, 12}));
        System.out.println(new MinCostToConnectRopes().getMinCostToConnectRopes(new int[] {3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}));
    }
}