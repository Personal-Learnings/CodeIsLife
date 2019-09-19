package com.learnings.datastructure.heap;

public class App {
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10);

		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(10);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(9);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(8);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(7);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(6);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(5);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(4);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(20);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(1);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(2);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");

		heap.delete();
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");

		heap.delete();
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");

		heap.delete();
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
		
		heap.insert(2);
		System.out.println("Heap: " + heap.viewHeap() + " Size: " + heap.getSize() + "\n");
	}
}
