package com.learnings.algorithm.recursive;

public class BinarySearch {

	int resultIndex = -1;

	private int search(int [] inputArray, int value, int firstIndex, int lastIndex) {
		
		if(firstIndex <= lastIndex) {
			int midIndex = getMidIndex(firstIndex, lastIndex);
			System.out.println("First Index: " + firstIndex + " Mid Index: " + midIndex + " Last Index: " + lastIndex + " Value: " + inputArray[midIndex]);

			if(value == inputArray[midIndex]) {
				resultIndex = midIndex;
			}
			else if(value < inputArray[midIndex]) {
				lastIndex = midIndex - 1;
				search(inputArray, value, firstIndex, lastIndex);
			}
			else if(value > inputArray[midIndex]) {
				firstIndex = midIndex + 1;
				search(inputArray, value, firstIndex, lastIndex);
			}
		}
		return resultIndex;
	}
	
	public int searchUsingRecursion(int [] inputArray, int value) {
		
		int searchIndex = -1;
		
		if(null != inputArray)
			searchIndex = search(inputArray, value, 0, inputArray.length - 1);
		
		return searchIndex;
	}

	private int getMidIndex(int firstIndex, int lastIndex) {
		return (int) Math.floor((firstIndex + lastIndex) / 2);
	}
}