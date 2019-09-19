package com.learnings.algorithm.merge_sort;

public class MergeSort {
	
	public int [] sort (int [] data) {		
		int firstIndex = 0, lastIndex = data.length - 1;
		return mergeSort(data, firstIndex, lastIndex);
	}
	
	private int [] mergeSort(int [] data, int firstIndex, int lastIndex) {
		
		if(firstIndex < lastIndex) {
			int midIndex = getMidIndex(firstIndex, lastIndex);
			mergeSort(data, firstIndex, midIndex);
			mergeSort(data, midIndex + 1, lastIndex);
			merge(data, firstIndex, midIndex, lastIndex);
		}
		return data;
	}
	
	private int [] merge(int [] data, int firstIndex, int midIndex, int lastIndex) {
		
		int leftArraySize = (midIndex - firstIndex) + 1;
		int rightArraySize = (lastIndex - midIndex);

		int [] leftArray = new int[leftArraySize];
		int [] rightArray = new int[rightArraySize];
		
		addElementsToLeftArray(data, leftArray, firstIndex, midIndex);
		addElementsToRightArray(data, rightArray, midIndex + 1, lastIndex);
		
		System.out.print("Left Array: [ ");
		for(int i=0; i<leftArray.length; i++)
			System.out.print(leftArray[i] + " ");
		System.out.print("]   ");
		
		System.out.print("Right Array: [ ");
		for(int i=0; i<rightArray.length; i++)
			System.out.print(rightArray[i] + " ");
		System.out.print("]\n");
		
		int k = firstIndex, i = 0, j = 0;
		
		for(;(i < leftArraySize && j < rightArraySize); k++) {
			if(leftArray[i] <= rightArray[j]) {
				data[k] = leftArray[i];
				i++;
			}
			else {
				data[k] = rightArray[j];
				j++;
			}
		}
		
		//Copying the Remaining Elements in left Array if Any
		while(i < leftArraySize) {
			data[k] = leftArray[i];
			i++;
			k++;
		}
		
		//Copying the Remaining Elements in Right Array if Any
		while(j < rightArraySize) {
			data[k] = rightArray[j];
			j++;
			k++;
		}
		
		System.out.print("After Merging: [ ");
		for(int m=0; m<data.length; m++)
			System.out.print(data[m] + " ");
		System.out.print("]\n\n");
		
		return data;
	}
	
	private void addElementsToRightArray(int[] data, int[] rightArray, int fromIndex, int toIndex) {
		for(int k = 0, i = fromIndex; i<= toIndex; k++, i++)
			rightArray[k] = data[i];
			
		//rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
	}

	private void addElementsToLeftArray(int[] data, int[] leftArray, int fromIndex, int toIndex) {
		for(int k = 0, i = fromIndex; i<= toIndex; k++, i++)
			leftArray[k] = data[i];
			
		//leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
	}
	
	private int getMidIndex(int firstIndex, int lastIndex) {
		return (firstIndex + lastIndex) / 2;
	}
}