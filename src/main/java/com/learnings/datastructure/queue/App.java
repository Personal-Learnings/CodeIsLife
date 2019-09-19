package com.learnings.datastructure.queue;

public class App {
	
	public static void main(String[] args) {
		
		Queue queue = new Queue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.peek();queue.rear();
		queue.dequeue();
		queue.peek();queue.rear();
		queue.enqueue(40);
		queue.peek();queue.rear();
		queue.enqueue(50);
	}
}