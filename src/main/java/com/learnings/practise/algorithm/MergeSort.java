package com.learnings.practise.algorithm;

import java.util.Arrays;

public class MergeSort {

    private int [] sort(int [] array) {
        if(array == null || array.length == 0 || array.length == 1) return array;
        return splitAndMerge(array);
    }

    private int [] splitAndMerge(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        int endIndex = array.length;
        int midIndex = (endIndex / 2);
        int[] leftArray = Arrays.copyOfRange(array, 0, midIndex);
        int[] rightArray = Arrays.copyOfRange(array, midIndex, endIndex);

        splitAndMerge(leftArray);
        splitAndMerge(rightArray);
        merge(array, leftArray, rightArray);
        return array;
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray) {
        for(int i = 0, j = 0, k = 0; i < leftArray.length || j < rightArray.length; k++) {
            if(i < leftArray.length && j < rightArray.length) {
                if(leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            } else if(i < leftArray.length) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sort(new int[] { 5, 3, 7, 2, 8, 1, 9, 6 })));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[] { 5, 3, 7, 2, 8, 1, 9, 6, 4 })));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[] { 5, 3, 7, 2, 8, 2, 1, 9, 6, 9, 4 })));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[] { 0, 5, 3, -7, 2, 8, -1, 9, 6, 4 })));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[] { 0 })));
        System.out.println(Arrays.toString(new MergeSort().sort(null)));
    }
}