package com.learnings.algorithm.quick_sort;

public class App {

	public static void main(String[] args) {

		int [] inputArray = new int[] {8, 6, 1, 5, 9, 2, 2, 7, 0, 9, 0, 5, 1, 7, 9, 11, 1024, 8};
		QuickSort quickSort = new QuickSort();

		System.out.print("Input Array: [");
		for(int i=0; i<inputArray.length; i++)
			System.out.print(inputArray[i] + " ");
		System.out.print("]\n\n");

		quickSort.sort(inputArray);
	}
}