package com.learnings.practise.problems.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumValue {

    private static final int [][] CARDINALS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    //Time Complexity: O(max Log(max)) where max = Math.max(a.length, a[0].length) Space: O(max) every time the queue doesn't take more than max number of elements in it
    public int maximumMinimumPath(int[][] A) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        queue.offer(new int[]{A[0][0], 0, 0});
        int minimum = A[0][0];
        A[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] max = queue.poll();
            int value = max[0], row = max[1], col = max[2];
            minimum = Math.min(value, minimum);

            if(row == (A.length - 1) && col == (A[0].length - 1)) {
                return minimum;
            }

            for(int [] cardinal : CARDINALS) {
                int newRow = row + cardinal[0], newCol = col + cardinal[1];
                if(newRow >= 0 && newRow < A.length && newCol >= 0 && newCol < A[newRow].length && A[newRow][newCol] >=  0) {
                    queue.offer(new int[] {A[newRow][newCol], newRow, newCol});
                    A[newRow][newCol] = -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PathWithMaximumMinimumValue().maximumMinimumPath(new int[][] {{5, 4, 5}, {1, 2, 6}, {7,4,6}}));
        System.out.println(new PathWithMaximumMinimumValue().maximumMinimumPath(new int[][] {{2, 2, 1, 2, 2, 2}, {1, 2, 2, 2, 1, 2}}));
    }
}