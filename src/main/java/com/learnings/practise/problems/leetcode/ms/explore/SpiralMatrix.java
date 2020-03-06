package com.learnings.practise.problems.leetcode.ms.explore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();

        int rMin = 0, rMax = matrix.length - 1, cMin = 0, cMax = matrix[0].length - 1, max = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();

        while(rMin <= rMax && cMin <= cMax) {
            //left to right
            for(int i = cMin; result.size() < max && i <= cMax; i++) {
                result.add(matrix[rMin][i]);
            }
            rMin++;

            //top to bottom
            for(int i = rMin; result.size() < max && i <= rMax; i++) {
                result.add(matrix[i][cMax]);
            }
            cMax--;

            //right to left
            for(int i = cMax; result.size() < max && i >= cMin; i--) {
                result.add(matrix[rMax][i]);
            }
            rMax--;

            //Bottom to Top
            for(int i = rMax; result.size() < max && i >= rMin; i--) {
                result.add(matrix[i][cMin]);
            }
            cMin++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
