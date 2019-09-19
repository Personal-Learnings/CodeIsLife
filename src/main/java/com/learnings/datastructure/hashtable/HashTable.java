package com.learnings.datastructure.hashtable;

public class HashTable {
	
	private Object [] data;
	
	private int capacity;
	
	private int size;
	
	public HashTable(int capacity) {
		
		if(!isPrimeNumber(capacity)) {
			this.capacity = getNextPrimeNumber(capacity);
			System.out.println("Since " + capacity + " is not a prime number, so the capacity is autoincremented to the next prime number " + this.capacity);
		}
		else {
			this.capacity = capacity;
		}
		this.data = new Object[this.capacity];
		this.size = 0;
	}
	
	public void insert(Object element) {
		if(!isHashTableFull()) {
			
			int index = hash(element);
			
			if(data[index] == null) {
				data[index] = element;
				size++;
				System.out.println("Inserting " + element + " at Position " + index);
			}
			else {
				while(true) {
					index = (index + doubleHash(element)) % capacity;
					if(data[index] == null) {
						data[index] = element;
						size++;
						System.out.println("Inserting " + element + " at Position " + index);
						return;
					}
				}
			}
		}
		else {
			System.out.println("Hash Table is Full !!!");
		}
	}
	
	public Object find(Object element) {
		
		Object newElement = null;
		if(!isHashTableEmpty()) {
			
			int index = hash(element);
			
			if(data[index] != null && data[index].equals(element)) {
				System.out.println("Found " + element + " at Index " + index);
				newElement = data[index];
			}
			else {
				int i = 1;
				while(true) {
					index = (index + doubleHash(element)) % capacity;
					
					if(data[index] != null && data[index].equals(element)) {
						newElement = data[index];
						System.out.println("Found " + element + " at Index " + index);
						break;
					}
					
					//To Break the Loop if the Element is not found in the Hash Table
					if(i ==  capacity) {
						System.out.println("Element " + element + " not Found in the Hash Table !!!");
						break;
					}
					++i;
				}
			}
		}
		else {
			System.out.println("HashTable is Empty !!!");
		}
		return newElement;
	}
	
	public void delete(Object element) {
		
		if(!isHashTableEmpty()) {
			
			int index = hash(element);
			
			if(data[index] != null && data[index].equals(element)) {
				data[index] = null;
				size--;
				System.out.println("Deleting " + element + " at Index " + index);
			}
			else {
				int i = 1;
				while(true) {
					index = (index + doubleHash(element)) % capacity;
					if(data[index] != null && data[index].equals(element)) {
						data[index] = null;
						size--;
						System.out.println("Deleting " + element + " at Index " + index);
						break;
					}
					
					//To Break the Loop if the Element is not found in the Hash Table
					if(i ==  capacity) {
						System.out.println("Element " + element + " not Found in the Hash Table !!!");
						break;
					}
					++i;
				}
			}
		}
		else {
			System.out.println("HashTable is Empty !!!");
		}
	}
	
	public int getSize() {
		System.out.println("Hash Table Size: " + size);
		return size;
	}
	
	public boolean isHashTableFull() {
		return size == capacity;
	}
	
	public boolean isHashTableEmpty() {
		return size == 0;
	}
	
	public void viewHashTable() {
		System.out.print("[ ");
		for(int i = 0; i < capacity; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println("]");
	}
	
	private int hash(Object element) {
		int hashCode = Math.abs(element.hashCode() % capacity);
		return hashCode;
	}
	
	private int doubleHash(Object element) {
		int hashCode = Math.abs(element.hashCode() % capacity);
		hashCode = 3 - (hashCode % 3);
		return (hashCode == 0) ? hashCode += capacity : Math.abs(hashCode);
	}
	
	private int getNextPrimeNumber(int number) {
		int i = number;
		while(true) {
			if(isPrimeNumber(i))
				return i;
			++i;
		}
	}

	private boolean isPrimeNumber(int number) {
		for(int i = 2; i * i <= number; i++) {
	        if(number % i == 0)
	            return false;
	    }
	    return true;
	}
}