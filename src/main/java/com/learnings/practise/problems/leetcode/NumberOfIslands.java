package com.learnings.practise.problems.leetcode;

public class NumberOfIslands {

    private char [][] g;
    private int rowLen;
    private int colLen;
    private static int [][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //Calling the recursive function in loop using DIRS array
    //Time Complexity: O(NM) where N is the number of row and M is the number of cols
    //Space Complexity: O(
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;

        g = grid;
        rowLen = g.length;
        colLen = g[0].length;
        int result = 0;

        for(int i=0; i < g.length; i++) {
            for(int j=0; j < g[i].length; j++) {
                if(g[i][j] == '1') {
                    markAdjacentAsWater(i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void markAdjacentAsWater(int row, int col) {
        if(row < 0 || row >= rowLen || col < 0 || col >= colLen || g[row][col] == '0') return;
        g[row][col] = '0';

        for(int [] dir : DIRS)
            markAdjacentAsWater(row + dir[0], col + dir[1]);
    }

    //Calling the recursive function separate call with values
    /*private char [][] g;
    private int rowLen;
    private int colLen;

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;

        g = grid;
        rowLen = g.length;
        colLen = g[0].length;
        int result = 0;

        for(int i=0; i < g.length; i++) {
            for(int j=0; j < g[i].length; j++) {
                if(g[i][j] == '1') {
                    markAdjacentAsWater(i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void markAdjacentAsWater(int row, int col) {
        if(row < 0 || row >= rowLen || col < 0 || col >= colLen || g[row][col] == '0') return;
        g[row][col] = '0';
        markAdjacentAsWater(row - 1, col);
        markAdjacentAsWater(row + 1, col);
        markAdjacentAsWater(row, col - 1);
        markAdjacentAsWater(row, col + 1);
    }*/

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}