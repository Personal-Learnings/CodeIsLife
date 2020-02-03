package com.learnings.practise.algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private void sort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) return;
        partitionAndSort(array, 0, array.length - 1);
    }

    private void partitionAndSort(int[] array, int startIndex, int endIndex) {
        if(startIndex >= endIndex) return;

        int partitionIndex = getPartitionIndex(array, endIndex);
        partitionAndSort(array, startIndex, partitionIndex - 2);
        partitionAndSort(array, partitionIndex, endIndex);
    }

    private int getPartitionIndex(int[] array, int endIndex) {
        int pivot = getPivot(array, endIndex);
        int partitionIndex = 0;

        for(int i = 0; i <= endIndex; i++) {
            if(array[i] <= pivot) {
                int temp = array[partitionIndex];
                array[partitionIndex] = array[i];
                array[i] = temp;
                partitionIndex++;
            }
        }
        return partitionIndex;
    }

    private int getPivot(int[] array, int endIndex) {
        return array[endIndex];
    }

    private int getRandomPivot(int[] array, int endIndex) {
        //Instead of picking the last index always for quick sort we can pick a pick using random to avoid O(n^2) when the array is already sorted.
        //Randomizing the pivot will make the performance to O(n log n) in average and worst case too.
        return 0;
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
