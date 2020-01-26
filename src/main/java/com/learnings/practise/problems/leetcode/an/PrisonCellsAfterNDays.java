package com.learnings.practise.problems.leetcode.an;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {

    /**
     * Time Complexity: O(1) Regardless or input N this almost runs in constant time. i could say amortized constant time.
     * Space Complexity: O(1)
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0 || cells == null || cells.length == 0) return cells;

        Map<String, Integer> cellState = new HashMap<>();

        while (N > 0) {
            //Recording the cells and its state
            cellState.put(Arrays.toString(cells), N);
            N--;

            //Performing Cell Update
            int leftCellBk = cells[0];
            for(int j = 0; j < cells.length; j++) {
                int left = j - 1, right = j + 1;

                if(left >= 0 && right < cells.length && leftCellBk == cells[right]) {
                    leftCellBk = cells[j];
                    cells[j] = 1;
                }
                else {
                    leftCellBk = cells[j];
                    cells[j] = 0;
                }
            }

            //Checking if the cell state already is present in the persisted map
            //If Found Reducing the Iteration to N % Pattern (Found Index - Current N Index)
            String newCells = Arrays.toString(cells);
            if (cellState.containsKey(newCells)) {
                N %= cellState.get(newCells) - N;
            }
        }
        return cells;
    }

    /**
     * Unnecessary Array Copy is done here, i have did something to avoid that
     */
    public int[] prisonAfterNDays_2(int[] cells, int N) {
        if(N == 0 || cells == null || cells.length == 0) return cells;

        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            //Recording the cells and its state
            seen.put(Arrays.toString(cells), N);
            N--;

            int[] tempCells = new int[cells.length];
            //Considering 1 to n - 1 because the first and last cells doesn't have adjacent and will eventually change to zero.
            for (int i = 1; i < (cells.length - 1); ++i) {
                int left = i - 1, right = i + 1;
                tempCells[i] = (cells[left] == cells[right]) ? 1 : 0;
            }
            cells = tempCells;

            String newCells = Arrays.toString(cells);
            if (seen.containsKey(newCells)) {
                N %= seen.get(newCells) - N;
            }
        }
        return cells;
    }

    public int[] prisonAfterNDays_1(int[] cells, int N) {
        if(N == 0 || cells == null || cells.length == 0) return cells;

        for(int i = (N - 1) % 14 + 1; i > 0; i--) {
            int leftCellBk = cells[0];

            for(int j = 0; j < cells.length; j++) {
                int left = j - 1, right = j + 1;

                if(left >= 0 && right < cells.length && leftCellBk == cells[right]) {
                    leftCellBk = cells[j];
                    cells[j] = 1;
                }
                else {
                    leftCellBk = cells[j];
                    cells[j] = 0;
                }
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int [] {0,1,0,1,1,0,0,1}, 209)));
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int [] {0,1,0,1,1,0,0,1,1}, 200)));
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int [] {0,1,0,1,1,0,0,1,1,1}, 200)));
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int [] {0,1,0,1,1,0,0,1,1}, 1000000000)));
    }
}
