package com.learnings.datastructure.hashtable;

public class App {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable(11);
		hashTable.insert("India");
		hashTable.insert("UK");
		hashTable.insert("Dubai");
		hashTable.insert("USA");
		hashTable.insert("Australia");
		hashTable.insert("Dubai");
		
		System.out.println();
		hashTable.getSize();
		hashTable.viewHashTable();

		System.out.println();
		hashTable.find("Dubai");
		
		System.out.println();
		hashTable.delete("Dubai");
		hashTable.getSize();
		hashTable.viewHashTable();
		
		System.out.println();
		hashTable.find("Dubai");
	}
}