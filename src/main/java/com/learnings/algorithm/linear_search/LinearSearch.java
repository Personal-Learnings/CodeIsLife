package com.learnings.algorithm.linear_search;

public class LinearSearch {
	
	public int linearSearch(Object [] inputArray, Object value) {
		
		int index = -1;
		
		if(null != inputArray) {
			for(int n=0; n<inputArray.length; n++) {
				if(null != inputArray[n] && inputArray[n].equals(value)) {
					index = n;
					break;
				}
			}
		}
		return index;
	}
}