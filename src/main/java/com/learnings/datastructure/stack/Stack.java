package com.learnings.datastructure.stack;

/**
 * 
 * @author Madanraj Venkatesan
 */
public class Stack {
	
	private int maxSize;
	public int size;
	private Object [] data;
	private int currentIndex;
	
	public Stack(int capacity) {
		this.maxSize = capacity;
		this.data = new Object[capacity];
		this.size = 0;
		this.currentIndex = -1;
	}
	
	public void push(Object element) {

		if(isFull()) {
			throw new StackIndexOutOfBoundsException("The Stack is Full.");
		}
		else {
			currentIndex++;
			size++;
			System.out.println("Pushing " + element + " to Stack.");
			data[currentIndex] = element;
		}
	}
	
	public Object pop() {
		
		Object elementValue;
		
		if(isEmpty()) {
			throw new StackIndexOutOfBoundsException("The Stack is Empty.");
		}
		else {
			elementValue = this.data[this.currentIndex];
			System.out.println("Popping " + elementValue + " from the Stack.");
			currentIndex--;
			size--;
		}
		return elementValue;
	}
	
	public Object peek() {
		
		Object elementValue;
		
		if(isEmpty()) {
			throw new StackIndexOutOfBoundsException("The Stack is Empty.");
		}
		else {
			elementValue = this.data[this.currentIndex];
			System.out.println("Stack Peek  " + elementValue);
		}
		return elementValue;
	}
	
	public boolean isFull() {
		return size == maxSize;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}