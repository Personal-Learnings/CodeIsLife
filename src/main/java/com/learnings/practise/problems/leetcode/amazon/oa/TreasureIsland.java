package com.learnings.practise.problems.leetcode.amazon.oa;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {

    // Sailing Directions
    private int [][] SIDES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Time Complexity: O(R * C) where R is number of rows and C is no of columns in matrix
     * Space Complexity: O(R * C) where R is number of rows and C is no of columns in matrix
     */
    private int getMinDistanceToTreasureIsland(char [][] map) {
        if(map == null || map.length == 0) return 0;
        int steps = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0 , 0});

        //To Track the end of Step
        queue.add(new int[] {-1, -1});

        //Marking as Visited
        map[0][0] = 'D';

        while(!queue.isEmpty()) {
            int [] e = queue.poll();
            int row = e[0], col = e[1];

            if(row == -1 && col == -1) {
                //End of Queue so Incrementing the step
                //If there are no more elements other than end of queue then break
                ++steps;
                if(!queue.isEmpty()) {
                    queue.offer(new int[] {-1, -1});
                }
                else break;
            } else if(map[row][col] == 'X') {
                //Return the Steps if the treasure is found
                return steps;
            } else {
                //Sail on all directions if it is safe
                for(int [] side : SIDES) {
                    int newRow = row + side[0], newCol = col + side[1];
                    if(isSafeToSail(newRow, newCol, map)) {
                        queue.add(new int[] {newRow, newCol});
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
        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'}, {'X', 'D', 'D', 'O'} })
        );

        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'X'}, {'O', 'O'}, {'O', 'O'} })
        );
        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'D'}, {'D', 'O'}, {'D', 'O'} })
        );
        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'O', 'D'}, {'O', 'D', 'O'}, {'D', 'D', 'X'} })
        );
        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'O', 'D'}, {'O', 'O', 'O'}, {'D', 'D', 'X'} })
        );
        System.out.println(new TreasureIsland().getMinDistanceToTreasureIsland(
                new char[][]{ {'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'} })
        );
    }
}