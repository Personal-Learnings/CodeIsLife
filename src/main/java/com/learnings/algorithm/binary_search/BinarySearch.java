package com.learnings.algorithm.binary_search;

public class BinarySearch {
	
	public int search(int [] inputArray, int value) {

		int resultIndex = -1;
		if(null != inputArray) {
			
			int firstIndex = 0;
			int lastIndex = inputArray.length - 1;
			
			while(firstIndex <= lastIndex) {
				
				
				int midIndex = getMidIndex(firstIndex, lastIndex);
				
				//System.out.println("First Index: " + firstIndex + " Mid Index: " + midIndex + " Last Index: " + lastIndex + " Value: " + inputArray[midIndex]);

				if(value < inputArray[midIndex]) lastIndex = midIndex - 1;
				else if(value > inputArray[midIndex]) firstIndex = midIndex + 1;
				else {
					resultIndex = midIndex; break;
				}
			}
		}
		return resultIndex;
	}
	
	private int getMidIndex(int firstIndex, int lastIndex) {
		return (firstIndex + lastIndex) / 2;
	}
}