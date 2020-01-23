package com.learnings.practise.problems.leetcode.an;

import java.util.Arrays;

public class SpiralMatrixII {

    /**
     * Time Complexity: O(n) where n is the given input
     * Space Complexity: O(1)
     */
    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][0];

        int [][] matrix = new int[n][n];
        int count = 0, rMin = 0, rMax = n-1, cMin = 0, cMax = n-1;

        while(rMin <= rMax && cMin <= cMax) {
            //Left to Right
            for(int j = cMin; j <= cMax; j++) {
                matrix[rMin][j] = ++count;
            }
            rMin++;

            //Top to Bottom
            for(int i = rMin; i <= rMax; i++) {
                matrix[i][cMax] = ++count;
            }
            cMax--;

            //Right to Left
            for(int j = cMax; j >= cMin; j--) {
                matrix[rMax][j] = ++count;
            }
            rMax--;

            //Bottom to Top
            for(int i = rMax; i >= rMin; i--) {
                matrix[i][cMin] = ++count;
            }
            cMin++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(4)));
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(100)));
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(0)));
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(-1)));
    }
}