package com.learnings.practise.problems.leetcode;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

    //Time Complexity: O(N) where N is the number of cells in the prison
    //Space Complexity: O(1)
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells.length == 0 || N == 0) return cells;

        // N%14 works but fails for multiples of 14, when N is divisible by 14 we have to take the 14th type not 0th type so -1%14
        // will give 13+1 will give 14 so that it works for N value divisible by 14 too
        for(int i = (N - 1) % 14 + 1; i > 0; --i) {
            int leftBackup = cells[0];

            for(int j=0; j < cells.length; j++) {
                int left = j - 1, right = j + 1;

                if(left >= 0 && right < cells.length && leftBackup == cells[right]) {
                    leftBackup = cells[j];
                    cells[j] = 1;
                } else {
                    leftBackup = cells[j];
                    cells[j] = 0;
                }
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
        System.out.println("Output: " + Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 100)));
        System.out.println("Output: " + Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 0, 1}, 826)));
    }
}