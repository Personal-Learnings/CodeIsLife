package com.learnings.practise.problems.leetcode.an;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {

    /**
     * Time Complexity: O(r * c) where r => number of rows and c => number of columns
     * Space Complexity: O(r * c) where r => number of rows and c => number of columns
     * Also Known as Min hours to send file to all available servers
     */
    private int getHoursTakenToInfect(int [][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        //Right, Bottom, Left and Top
        final int [][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int timeTaken = 0;

        Queue<int[]> affected = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    affected.offer(new int[]{i, j});
                }
            }
        }
        affected.offer(new int[] {-1, -1});

        while(!affected.isEmpty()) {
            int[] item = affected.poll();
            int i = item[0], j = item[1];

            if(i == -1 && j== -1) {
                if(affected.isEmpty()) {
                    break;
                } else {
                    ++timeTaken;
                    affected.offer(new int[]{-1, -1});
                }
            } else {
                for(int [] c : DIRECTIONS) {
                    int newI = i + c[0], newJ = j + c[1];
                    if(newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[newI].length && matrix[newI][newJ] == 0) {
                        affected.offer(new int[] { newI, newJ });
                        matrix[newI][newJ] = 1;
                    }
                }
            }
        }

        //There are few humans who cannot be affected :)
        for (int[] rows : matrix) {
            for (int cell : rows) {
                if (cell == 0) return -1;
            }
        }
        return timeTaken;
    }

    public static void main(String[] args) {
        System.out.println(new ZombieInMatrix().getHoursTakenToInfect(new int[][]{{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}}));
        System.out.println(new ZombieInMatrix().getHoursTakenToInfect(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(new ZombieInMatrix().getHoursTakenToInfect(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}));
    }
}