package com.learnings.algorithm.selection_sort;

public class App {

	public static void main(String[] args) {
		
		//Selection Sort
		SelectionSort selectionSort = new SelectionSort();
		int[] sortedArray = selectionSort.sort(new int[] {5, 1028, 2, 90, 64, 783, 99, 1, 444, 3});
		
		System.out.print("Sorted List: [ ");
		for(int i=0; i<sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		System.out.print("}");

	}
}