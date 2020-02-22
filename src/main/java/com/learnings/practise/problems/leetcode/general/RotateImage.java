package com.learnings.practise.problems.leetcode.general;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

       int n = matrix.length;
        //Transpose
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //Reverse
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
