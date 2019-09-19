package com.learnings.algorithm.selection_sort;

public class SelectionSort {
	
	public int [] sort(int [] unsortedArray) {
		
		if(null != unsortedArray) {
			for(int i=0; i< unsortedArray.length; i++) {
				
				int minIndex = i;
				
				for(int j=i+1; j<unsortedArray.length; j++) {
					
					if(unsortedArray[minIndex] > unsortedArray[j]) {
						minIndex = j;
					}
				}
				
				if(minIndex != unsortedArray[i]) {
					swapElements(unsortedArray, i, minIndex);
				}
			}
		}
		return unsortedArray;
	}

	private void swapElements(int[] unsortedArray, int xIndex, int yIndex) {
		int temp = unsortedArray[xIndex];
		
		unsortedArray[xIndex] = unsortedArray[yIndex];
		unsortedArray[yIndex] = temp;
	}
}