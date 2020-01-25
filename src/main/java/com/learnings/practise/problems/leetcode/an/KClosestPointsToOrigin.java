package com.learnings.practise.problems.leetcode.an;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    /**
     * Time Complexity: O(NLogK) where n is the number of elements in points
     * Space Complexity: O(k+1) as we are always having K + 1 items on the Queue.
     */
    private int[][] findKClosestPointToOrigin(int [][] points, int k) {

        if(points == null || points.length == 0 || k == 0) return null;

        //Add items to Min queue by applying Euclidean distance formula.
        Queue<int[]> queue = new PriorityQueue<>(k + 1, Comparator.comparingInt(a -> ((a[0] * a[0]) + (a[1] * a[1]))));
        for (int[] point : points) {
            queue.offer(point);
        }

        // Popping out the K closest points from the origin
        int [][] result = new int[k][2];
        for(int x = 0; !queue.isEmpty() && x < k; x++) {
            result[x] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().findKClosestPointToOrigin(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().findKClosestPointToOrigin(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}