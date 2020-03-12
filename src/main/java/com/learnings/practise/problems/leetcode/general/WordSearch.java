package com.learnings.practise.problems.leetcode.general;

public class WordSearch {

    private int[][] SIDES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Time Complexity: O(N 4^L)
     * Space Complexity: O(L)
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && searchInMatrix(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean searchInMatrix(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || board[i][j] == '#')
            return false;

        char c = board[i][j];

        //marking the current space in the board as # because it shouldn't be visited again.
        board[i][j] = '#';

        //search all four valid directions of the matrix
        for (int[] side : SIDES) {
            int newRow = side[0] + i, newCol = side[1] + j;
            if (searchInMatrix(board, word, newRow, newCol, index + 1))
                return true;
        }

        //once done replace the char back to the original char
        board[i][j] = c;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
