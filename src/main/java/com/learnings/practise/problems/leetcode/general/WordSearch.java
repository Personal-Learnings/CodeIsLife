package com.learnings.practise.problems.leetcode.general;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

    private int [][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //IN COMPLETE
    public boolean exist(char[][] board, String word) {
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < word.length(); i++) {
            list.addLast(word.charAt(i));
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == list.peekFirst()) {
                    int x = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});

                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        for(int [] dir : DIRS) {
                            int newRow = dir[0] + poll[0], newCol = dir[1] + poll[1];
                            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length) {
                                if(x < list.size() && board[newRow][newCol] == list.get(x)) {
                                    queue.offer(new int[] {newRow, newCol});
                                    ++x;
                                }
                            }
                        }
                    }
                    return x == list.size();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][] { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} }, "DEE"));
    }
}
