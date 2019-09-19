package com.learnings.algorithm.recursive;

public class LinearSearch {
	
	int index = -1;
	
	public int searchUsingRecursion(Object [] inputArray, Object value) {
		return search(inputArray, value, 0);
	}
	
	private int search(Object [] inputArray, Object value, int initCounter) {
		
		if(inputArray[initCounter].equals(value)) {
			index = initCounter;
		}
		else if (initCounter < (inputArray.length - 1)){
			search(inputArray, value, ++initCounter);
		}
		return index;
	}
}