package com.learnings.datastructure.heap;

public class MaxHeap {
	
	private int [] data;
	
	private int size;
	
	private int currentIndex;
	
	private int capacity;
	
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		this.data = new int[capacity];
		this.size = 0;
		this.currentIndex = -1;
	}
	
	public void insert(int value) {
		
		System.out.println("Adding " + value + " to the Heap.");
		if(!isHeapFull()) {
			data[++currentIndex] = value;
			size++;
			
			if(currentIndex > 0) {
				checkParentAndSwap(currentIndex);
			}
		}
		else {
			System.out.println("Heap is Full.");
		}
	}

	public void delete() {
		
		System.out.println("Deleting " + data[0] + " from the Heap.");
		if(!isHeapEmpty()) {

			//Replace the Root Element with the Last Inserted Element
			data[0] = data[currentIndex];
			currentIndex--;
			size--;
			
			if(currentIndex > 0) {
				checkChildrenAndSwap(0);
			}
		}
	}
	
	private void checkChildrenAndSwap(int index) {
		
		if(hasChildNodes(index)) {
			for(int parentIndex = index, childIndex = getMaxChildIndex(index); childIndex < size; ) {
				
				if(data[parentIndex] < data[childIndex]) {

					int temp = data[parentIndex];
					data[parentIndex] = data[childIndex];
					data[childIndex] = temp;

					parentIndex = childIndex;
					childIndex = getMaxChildIndex(childIndex);
				}
				else {
					break;
				}
			}
		}
	}

	private boolean hasChildNodes(int index) {
		return ((2 * index) + 1) <= size;
	}

	private void checkParentAndSwap(int index) {
		
		for(int parentIndex = getParentIndex(index), childIndex = index; parentIndex >= 0;) {
			
			if(data[parentIndex] < data[childIndex]) {

				int temp = data[parentIndex];
				data[parentIndex] = data[childIndex];
				data[childIndex] = temp;

				childIndex = parentIndex;
				parentIndex = getParentIndex(parentIndex);
			}
			else {
				break;
			}
		}
	}
	
	public boolean isHeapEmpty() {
		return size == 0;
	}
	
	public boolean isHeapFull() {
		return size == capacity;
	}
	
	public String viewHeap() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		
		for(int i = 0; i < this.size; i++) {
			builder.append(data[i] + " ");
		}
		builder.append("]");
		return builder.toString();
	}
	
	private int getParentIndex(int index) {
		return ((index - 1)/2);
	}
	
	private int getMaxChildIndex(int index) {
		
		//Check whether the current Index has left and right Child nodes
		int maxChildIndex;
		int leftChildIndex = (2 * index) + 1;
		int rightChildIndex = (2 * index) + 2;
		
		if(rightChildIndex < size) { //Assuming if it has right child it should also have left child
			maxChildIndex = (data[leftChildIndex] > data[rightChildIndex]) ? leftChildIndex : rightChildIndex;
		}
		else {
			maxChildIndex = leftChildIndex;
		}
		return maxChildIndex;
	}

	public int getSize() {
		return size;
	}
}