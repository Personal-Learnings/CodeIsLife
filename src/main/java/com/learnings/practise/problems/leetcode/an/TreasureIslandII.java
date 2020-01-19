package com.learnings.practise.problems.leetcode.an;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIslandII {

    /**
     * Time Complexity: O(R * C) where R is number of rows and C is no of columns in map
     * Space Complexity: O(R * C) where R is number of rows and C is no of columns in map
     */
    private int getMinDistanceToTreasureIsland(char [][] map) {

        if(map == null || map.length == 0) return 0;

        int [][] SIDES = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        Queue<int[]> queue = new ArrayDeque<>();
        int steps = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'S') {
                    queue.offer(new int[] {i, j});
                    map[i][j] = 'D';
                }
            }
        }
        queue.offer(new int[] {-1, -1});

        while(!queue.isEmpty()) {
            int [] e = queue.poll();
            int row = e[0], col = e[1];

            if(row == -1 && col == -1) {
                ++steps;
                if(!queue.isEmpty()) queue.offer(new int[] {-1, -1});
                else break;
            }
            else if(map[row][col] == 'X') return steps;
            else {
                for(int [] side : SIDES) {
                    int newRow = row + side[0], newCol = col + side[1];
                    if(isSafeToSail(newRow, newCol, map)) {
                        queue.offer(new int[] {newRow, newCol});
                        map[row][col] = 'D';
                    }
                }
            }
        }
        return -1;
    }

    private boolean isSafeToSail(int row, int col, char [][] map) {
        return (row >= 0 && row < map.length && col >= 0 && col < map[row].length && map[row][col] != 'D');
    }

    public static void main(String[] args) {
        System.out.println(new TreasureIslandII().getMinDistanceToTreasureIsland(
                new char[][]{ {'S', 'O', 'O', 'S', 'S'}, {'D', 'O', 'D', 'O', 'D'}, {'O', 'O', 'O', 'O', 'X'}, {'X', 'D', 'D', 'O', 'O'}, {'X', 'D', 'D', 'D', 'O'} })
        );
    }
}
