package com.learnings.practise.problems.leetcode.an;

public class MaxOfMinAltitudes {

    /**
     * Time Complexity: O(m * n) where m and n are the length of rows and columns in given matrix.
     * Space Complexity: O(1) No extra data structure used
     */
    public int getMaxOfMinAltitudes(int [][] input) {
        if(input == null || input.length == 0) return 0;
        if(input.length == 1) return input[0][0];

        int max = Integer.MIN_VALUE;
        int rowMin = 0, rowMax = input.length - 1, colMin = 0, colMax = input[0].length - 1;

        for(int m = 0; m < input[0].length; m++) {
            int min = Integer.MAX_VALUE;

            //Top Left to Right
            for(int j = colMin; j <= colMax; j++) {
                //Skip 0, 0
                if(j > 0) min = Math.min(min, input[0][j]);
            }
            rowMin++;

            //Top to Bottom
            for(int i = rowMin; i < input.length; i++) {
                //Skip n, n
                if(colMax != input[0].length - 1 || i < input.length - 1) min = Math.min(min, input[i][colMax]);
            }

            //Bottom Left to Right
            for(int j = colMax + 1; j < input[0].length; j++) {
                //Skip n, n
                if(j < input[0].length - 1) min = Math.min(min, input[rowMax][j]);
            }

            //After every iteration reduce the number of columns and reset rowMin to always start from 0, 0
            colMax--;
            rowMin = 0;

            //Finding the max of each row.
            max = Math.max(max, min);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {5, 1}, {4, 5} }));
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {1, 2, 3}, {4, 5, 1} }));
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {9, 8, 7, 6}, {5, 4, 3, 2}, {1, 2, 3, 4}, {5, 6, 7, 8} }));
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {1} }));
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {1, 2, 3, 5} }));
        System.out.println("Maximum: " + new MaxOfMinAltitudes().getMaxOfMinAltitudes(new int[][] { {1}, {2}, {3}, {4} }));
    }
}