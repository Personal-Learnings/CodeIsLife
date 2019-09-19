package com.learnings.algorithm.insertion_sort;

public class App {
	
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int [] sortedArray = insertionSort.sort(new int[] {5, 1028, 2, 5, 90, 64, 783, 5, 99, 1, 2, 444, 3, 2, 10000});
		
		System.out.print("Sorted List: [ ");
		for(int i=0; i<sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}