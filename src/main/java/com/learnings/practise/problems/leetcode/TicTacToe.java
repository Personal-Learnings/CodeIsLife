package com.learnings.practise.problems.leetcode;

public class TicTacToe {

    private int [] rowData;
    private int [] colData;
    private int diagonal;
    private int aDiagonal;
    private int n;
    private boolean gameOver;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.diagonal = 0;
        this.aDiagonal = 0;
        this.gameOver = false;
        this.rowData = new int[n];
        this.colData = new int[n];
    }

    public int move(int row, int col, int player) {
        if(!gameOver) {
            int value = (player == 1) ? 1 : -1;
            int target = (player == 1) ? n : -n;
            if(row == col) diagonal+=value;
            if(row + col == n - 1) aDiagonal+=value;
            rowData[row]+=value;
            colData[col]+=value;

            if(diagonal == target || aDiagonal == target || rowData[row] == target || colData[col] == target) {
                gameOver = true;
                return player;
            }
        }
        return 0;
    }

    /*
    /** Player {player} makes a move() at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    //Time Complexity = O(N^2)
    /*
    public int move()(int row, int col, int player) {
        if(!gameOver) {
            grid[row][col] = player;
            return getWinnerIfWon_BigO_N2(row, col);
        }
        return 0;
    }

    private int getWinnerIfWon_BigO_N2(int row, int col) {
        //Check Rows are Equal
        for(int i = 0; i < grid.length; i++) {
            List<Boolean> rowsEqual = new ArrayList<>();
            int cellValue = 0;

            for (int j = 0; j < grid.length; j++) {
                cellValue = grid[i][j];
                rowsEqual.add(cellValue != 0 && cellValue == grid[i][0]);
            }
            if(!rowsEqual.isEmpty() && rowsEqual.stream().allMatch(a -> a)) {
                return cellValue;
            }
        }
        //Check Columns are Equal
        for(int i = 0; i < grid.length; i++) {
            int colValue = 0;
            List<Boolean> columnsEqual = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                colValue = grid[j][i];
                columnsEqual.add(colValue != 0 && colValue == grid[0][i]);
            }
            if(!columnsEqual.isEmpty() && columnsEqual.stream().allMatch(a -> a)) {
                return colValue;
            }
        }

        //Right Diagonals are Equal
        if ((row == col)) {
            List<Boolean> rightDiagonalEqual = new ArrayList<>();
            int rightDiagonalValue = 0;
            for (int i = 0; i < grid.length; i++) {
                rightDiagonalValue = grid[i][i];
                rightDiagonalEqual.add(rightDiagonalValue != 0 && rightDiagonalValue == grid[0][0]);
            }
            if (!rightDiagonalEqual.isEmpty() && rightDiagonalEqual.stream().allMatch(a -> a)) {
                return rightDiagonalValue;
            }
        }

        //Left Diagonals are Equal
        if(row + col == grid.length - 1) {
            List<Boolean> leftDiagonalEqual = new ArrayList<>();
            int cellValue = 0;
            int topRight = grid[0][grid.length - 1];
            for (int i = 0, j = grid.length - 1; j >= 0; i++, j--) {
                cellValue = grid[i][j];
                leftDiagonalEqual.add(cellValue != 0 && cellValue == topRight);
            }
            if (!leftDiagonalEqual.isEmpty() && leftDiagonalEqual.stream().allMatch(a -> a)) {
                return cellValue;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                stringBuilder.append(ints[j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }*/

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.print(ticTacToe.move(0, 0, 1) + " ");
        System.out.print(ticTacToe.move(0, 2, 2) + " ");
        System.out.print(ticTacToe.move(2, 2, 1) + " ");
        System.out.print(ticTacToe.move(1, 1, 2) + " ");
        System.out.print(ticTacToe.move(2, 0, 1) + " ");
        System.out.print(ticTacToe.move(1, 0, 2) + " ");
        System.out.print(ticTacToe.move(2, 1, 1) + " ");
        //System.out.print(ticTacToe);
        System.out.println();

        ticTacToe = new TicTacToe(2);
        System.out.print(ticTacToe.move(0, 1, 1) + " ");
        System.out.print(ticTacToe.move(1, 1, 2) + " ");
        System.out.print(ticTacToe.move(1, 0, 1) + " ");
        //System.out.print(ticTacToe);
        System.out.println();

        ticTacToe = new TicTacToe(2);
        System.out.print(ticTacToe.move(0, 1, 2) + " ");
        System.out.print(ticTacToe.move(1, 0, 1) + " ");
        System.out.print(ticTacToe.move(1, 1, 2) + " ");
        //System.out.print(ticTacToe);
        System.out.println();

        ticTacToe = new TicTacToe(3);
        System.out.print(ticTacToe.move(1, 2, 2) + " ");
        System.out.print(ticTacToe.move(0, 2, 1) + " ");
        System.out.print(ticTacToe.move(0, 0, 2) + " ");
        System.out.print(ticTacToe.move(2, 0, 1) + " ");
        System.out.print(ticTacToe.move(0, 1, 2) + " ");
        System.out.print(ticTacToe.move(1, 1, 1) + " ");
        //System.out.print(ticTacToe);
    }
}