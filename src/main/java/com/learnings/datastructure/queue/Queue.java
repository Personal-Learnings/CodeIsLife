package com.learnings.datastructure.queue;

/**
 * 
 * @author Madanraj Venkatesan
 */
public class Queue {
	
	private int maxSize;
	private Object [] data;
	private int frontIndex;
	private int rearIndex;
	public int size;

	public Queue(int size) {
		this.maxSize = size;
		this.data = new Object[size];
		this.frontIndex = 0;
		this.rearIndex = this.maxSize - 1;
		this.size = 0;
	}
	
	public void enqueue(Object element) {
		if(isFull()) {
			throw new QueueIndexOutOfBoundsException("The Queue is Full.");
		}
		else {
			rearIndex = (rearIndex + 1) % this.maxSize;
			data[rearIndex] = element;
			size++;
			System.out.println("Adding " + element + " to the Queue.");
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			throw new QueueIndexOutOfBoundsException("The Queue is Empty.");
		}
		else {
			Object temp = data[frontIndex];
			frontIndex = (frontIndex + 1) % this.maxSize;
			size--;
			System.out.println("Removing " + temp + " from the Queue.");
			return temp;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new QueueIndexOutOfBoundsException("The Queue is Empty.");
		}
		else {
			System.out.println("Front: " + data[frontIndex]);
			return data[frontIndex];
		}
	}
	
	public Object rear() {
		if(isEmpty()) {
			throw new QueueIndexOutOfBoundsException("The Queue is Empty.");
		}
		else {
			System.out.println("Rear: " + data[rearIndex]);
			return data[rearIndex];
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}
}