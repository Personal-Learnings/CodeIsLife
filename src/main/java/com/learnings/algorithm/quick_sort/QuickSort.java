package com.learnings.algorithm.quick_sort;

public class QuickSort {
	
	public int [] sort(int [] data) {
		return quickSort(data, 0, (data.length - 1));
	}
	
	private int [] quickSort(int [] data, int firstIndex, int lastIndex) {
		
		if(firstIndex < lastIndex) {
			int partitionIndex = partitionWithPivotAsLastIndex(data, firstIndex, lastIndex);
			quickSort(data, firstIndex, partitionIndex - 1);
			quickSort(data, partitionIndex + 1, lastIndex);
		}
		return data;
	}
	
	private int partitionWithPivotAsLastIndex(int [] data, int firstIndex, int lastIndex) {
		
		int partitionIndex = 0;
		int pivot = data[lastIndex];
		
		for(int j = firstIndex, i = firstIndex - 1; j <= lastIndex; j++) {
			if(data[j] <= pivot) {
				++i;
				swapElements(data, i, j);
				partitionIndex = i;
			}
		}
		System.out.println("Partition Index: " + partitionIndex + " Parition Value = " + data[partitionIndex]);
		printArray(data);
		return partitionIndex;
	}

	@SuppressWarnings("unused")
	private int partitionWithPivotAsFirstIndex(int [] data, int firstIndex, int lastIndex) {
		
		int partitionIndex = 0;
		int pivot = data[firstIndex];
		
		for(int j = lastIndex, i = lastIndex + 1; j >= firstIndex; j--) {
			if(pivot <= data[j]) {
				--i;
				swapElements(data, i, j);
				partitionIndex = i;
			}
		}
		System.out.println("Partition Index: " + partitionIndex + " Parition Value = " + data[partitionIndex]);
		printArray(data);
		return partitionIndex;
	}

	private int[] swapElements(int[] data, int xIndex, int yIndex) {
		int temp = data[xIndex];
		data[xIndex] = data[yIndex];
		data[yIndex] = temp;
		return data;
	}
	
	private void printArray(int[] data) {
		System.out.print("Sorted Array: [");
		for(int i=0; i<data.length; i++)
			System.out.print(data[i] + " ");
		System.out.print("]\n");
		System.out.println();
	}
}