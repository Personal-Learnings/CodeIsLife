package com.learnings.practise.problems.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SearchA2DMatrixII {

    //Time Complexity: O(M+N) where M is the no of rows and N is the number of columns
    //Space Complexity: O(1)
    public boolean searchMatrix_Faster(int [][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length - 1, col = 0;
        while(row >= 0 && col < matrix[0].length) {
            int value = matrix[row][col];
            if(value > target) row--;
            else if(value < target) col++;
            else return true;
        }
        return false;
    }

    //Time Complexity: O(MLogN) where M is the no of rows and N is the number of columns
    //Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        Set<Boolean> result = new HashSet<>();

        for (int[] row : matrix) {
            result.add(Arrays.binarySearch(row, target) >= 0);
        }
        return result.contains(true);
    }

    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrixII().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(new SearchA2DMatrixII().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));

        System.out.println(new SearchA2DMatrixII().searchMatrix_Faster(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(new SearchA2DMatrixII().searchMatrix_Faster(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
    }
}
