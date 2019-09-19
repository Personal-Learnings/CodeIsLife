package com.learnings.algorithm.recursive;

public class App {
	
	public static void main(String[] args) {
		
		//Recursive Linear Search
		System.out.println("Index: " + new LinearSearch().searchUsingRecursion(new Object[]{"First", "Second", "Third"}, "First"));
		
		//Recursive Binary Search
		System.out.println("Index: " + new BinarySearch().searchUsingRecursion(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 11));
	}
}