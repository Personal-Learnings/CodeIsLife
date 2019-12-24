package com.learnings.practise.problems.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // Time Complexity is O(NLogK) where
    public int[][] kClosest_usingMinHeap(int[][] points, int K) {

        //Making the size of the queue always to K+1 because when this is not set and when a insert occurs then the queue size will be doubled.
        PriorityQueue<int[]> queue = new PriorityQueue<>(K + 1, Comparator.comparingInt(this::applyEuclidean));
        queue.addAll(Arrays.asList(points));

        int [][] result = new int[K][];
        for(int i = 0; i < K; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    // Time Complexity is O(NLogK) where
    // Max Heap Solution - Bit faster because we would always have only K items in the Queue so it makes it easy to sift in priority queue
    public int[][] kClosest(int[][] points, int K) {

        //Making the size of the queue always to K+1 because when this is not set and when a insert occurs then the queue size will be doubled.
        PriorityQueue<int[]> queue = new PriorityQueue<>(K + 1, (a, b) -> applyEuclidean(b) - applyEuclidean(a));
        for(int [] point : points) {
            queue.add(point);
            if(queue.size() > K) {
                queue.poll();
            }
        }

        int [][] result = new int[K][];
        for(int i = 0; i < K; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private int applyEuclidean(int [] x) {
        return (x[0] * x[0]) + (x[1] * x[1]);
    }

    public int[][] kClosest_BigO_NLogN(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(this::applyEuclidean));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String[] args) {
        int [][] input = new int[2][2];
        input[0] = new int[]{ 1, 3 };
        input[1] = new int[]{ -2, 2 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(input, 1)));

        input = new int[3][3];
        input[0] = new int[]{ 3, 3 };
        input[1] = new int[]{ 5, -1 };
        input[2] = new int[]{ -2, 4 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(input, 2)));

        input = new int[2][2];
        input[0] = new int[]{ 1, 3 };
        input[1] = new int[]{ -2, 2 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest_BigO_NLogN(input, 1)));

        input = new int[3][3];
        input[0] = new int[]{ 3, 3 };
        input[1] = new int[]{ 5, -1 };
        input[2] = new int[]{ -2, 4 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest_BigO_NLogN(input, 2)));

        input = new int[2][2];
        input[0] = new int[]{ 1, 3 };
        input[1] = new int[]{ -2, 2 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest_usingMinHeap(input, 1)));

        input = new int[3][3];
        input[0] = new int[]{ 3, 3 };
        input[1] = new int[]{ 5, -1 };
        input[2] = new int[]{ -2, 4 };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest_usingMinHeap(input, 2)));
    }
}