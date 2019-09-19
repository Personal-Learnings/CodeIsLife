package com.learnings.algorithm.insertion_sort;

public class InsertionSort {
	
	public int [] sort(int [] inputArray) {
		
		for(int k = 0; k < inputArray.length; k++) {
			for(int i = k, j = i + 1; i >= 0 && j<inputArray.length; i--) {
				if(inputArray[i] > inputArray[j]) {
					swapElements(inputArray, i, j);
					j--;
				}
			}
		}
		return inputArray;
	}

	private int[] swapElements(int[] unsortedArray, int xIndex, int yIndex) {
		int temp = unsortedArray[xIndex];
		unsortedArray[xIndex] = unsortedArray[yIndex];
		unsortedArray[yIndex] = temp;
		return unsortedArray;
	}
}