package com.learnings.practise.algorithm;

import java.util.Arrays;

public class QuickSort {

    private void sort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) return;
        partitionAndSort(array, 0, array.length - 1);
    }

    private void partitionAndSort(int[] array, int startIndex, int endIndex) {
        if(startIndex >= endIndex) return;
        int pivot = array[endIndex];
        int newPivotIndex = 0;

        for(int i = 0; i <= endIndex; i++) {
            if(array[i] <= pivot) {
                int temp = array[newPivotIndex];
                array[newPivotIndex] = array[i];
                array[i] = temp;
                newPivotIndex++;
            }
        }

        partitionAndSort(array, startIndex, newPivotIndex - 2);
        partitionAndSort(array, newPivotIndex, endIndex);
    }

    public static void main(String[] args) {
        int[] array = new int[] { 5, 3, 7, 2, 8, 1, 9, 6 };
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 5, 3, 7, 2, 8, 1, 9, 6, 4 };
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 5, 3, 7, 2, 8, 7, 1, 9, 6, 4, 5 };
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 0, 5, 3, -7, 2, 8, -1, 9, 6, 4 };
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 0 };
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));

        new QuickSort().sort(null);
    }
}
