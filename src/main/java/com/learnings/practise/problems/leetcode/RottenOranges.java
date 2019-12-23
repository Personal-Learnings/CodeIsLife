package com.learnings.practise.problems.leetcode;

import java.util.*;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        Queue<Element> queue = new LinkedList<>();
        int iLength = grid.length;
        int timeUnit = 0;

        //Populate Queue with Rotten Oranges
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(hasRotten(grid[i][j])) {
                    queue.add(new Element(i, j));
                }
            }
        }
        //Add Delimiter to track the End
        queue.add(new Element(-1, -1));

        while(!queue.isEmpty()) {
            Element e = queue.remove();

            if(isDelimiter(e)) {
                if(!queue.isEmpty()) {
                    ++timeUnit;
                    //Add Delimiter to track the End
                    queue.add(new Element(-1, -1));
                } else {
                    //All Oranges Are Rotten
                    break;
                }
            } else {
                //Rot all Adjacent Fresh Oranges and Push.

                //Left Adjacent Orange
                if(isValidIndex(e.i, e.j - 1, iLength, grid[e.i].length)) {
                    rotIfFreshAndPushToQueue(e.i, e.j - 1, grid, queue);
                }
                //Top Adjacent Orange
                if(isValidIndex(e.i - 1, e.j, iLength, grid[e.i].length)) {
                    rotIfFreshAndPushToQueue(e.i - 1, e.j, grid, queue);
                }
                //Right Adjacent Orange
                if(isValidIndex(e.i, e.j + 1, iLength, grid[e.i].length)) {
                    rotIfFreshAndPushToQueue(e.i, e.j + 1, grid, queue);
                }
                //Bottom Adjacent Orange
                if(isValidIndex(e.i + 1, e.j, iLength, grid[e.i].length)) {
                    rotIfFreshAndPushToQueue(e.i + 1, e.j, grid, queue);
                }
            }
        }

        //Populate Queue with Rotten Oranges
        for (int[] i : grid) {
            for (int j : i) {
                if (isFresh(j)) {
                    timeUnit = -1;
                    return timeUnit;
                }
            }
        }
        return timeUnit;
    }

    private boolean isValidIndex(int i, int j, int length, int jLength) {
        return (i >=0 && i < length && j >= 0 && j < jLength);
    }

    private void rotIfFreshAndPushToQueue(int i, int j, int[][] grid, Queue<Element> queue) {
        if(isFresh(grid[i][j])) {
            grid[i][j] = 2;
            queue.add(new Element(i, j));
        }
    }

    private boolean isFresh(int orange) {
        return orange == 1;
    }

    private boolean hasRotten(int orange) {
        return orange == 2;
    }

    private boolean isDelimiter(Element e) {
        return e.i == -1 && e.j == -1;
    }

    static class Element {
        int i;
        int j;

        Element(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int [][] input = new int[3][3];
        input[0][0] = 2;
        input[0][1] = 1;
        input[0][2] = 1;

        input[1][0] = 1;
        input[1][1] = 1;
        input[1][2] = 0;

        input[2][0] = 0;
        input[2][1] = 1;
        input[2][2] = 1;
        System.out.println("Time Taken: " + new RottenOranges().orangesRotting(input));

        input = new int[3][3];
        input[0][0] = 2;
        input[0][1] = 1;
        input[0][2] = 1;

        input[1][0] = 0;
        input[1][1] = 1;
        input[1][2] = 1;

        input[2][0] = 1;
        input[2][1] = 0;
        input[2][2] = 1;
        System.out.println("Time Taken: " + new RottenOranges().orangesRotting(input));

        input = new int[2][1];
        input[0][0] = 1;
        input[1][0] = 2;
        System.out.println("Time Taken: " + new RottenOranges().orangesRotting(input));
    }
}