package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes_constantSpace(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) isFirstRowZero = true;
                    if(j == 0) isFirstColZero = true;

                    if(i != 0 || j != 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstRowZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(isFirstColZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] input = new int[][] {{0,1,2,0}, {3,4,5,2},{ 1,3,1,5 }};
        new SetMatrixZeroes().setZeroes(input);
        System.out.println(Arrays.deepToString(input));

        input = new int[][] {{0,1,2,0}, {3,4,5,2},{ 1,3,1,5 }};
        new SetMatrixZeroes().setZeroes_constantSpace(input);
        System.out.println(Arrays.deepToString(input));
    }
}