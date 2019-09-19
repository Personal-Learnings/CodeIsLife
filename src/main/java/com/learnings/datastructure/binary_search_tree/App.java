package com.learnings.datastructure.binary_search_tree;

public class App {
	
	public static void main(String[] args) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		binaryTree.insert(20);
		binaryTree.insert(10);
		binaryTree.insert(40);
		binaryTree.insert(30);
		binaryTree.insert(90);
		binaryTree.insert(70);
		binaryTree.insert(100);
		binaryTree.insert(1020);
		binaryTree.insert(12);
		binaryTree.insert(18);
		binaryTree.insert(8);
		binaryTree.insert(2020);
		binaryTree.insert(1500);
		binaryTree.insert(0);
		binaryTree.insert(0);
		binaryTree.insert(999);
		binaryTree.insert(9);
		binaryTree.insert(25);
		binaryTree.insert(26);
		binaryTree.insert(75);
		
		System.out.println("Min Node: " + binaryTree.getMinNode().getData());
		System.out.println("Max Node: " + binaryTree.getMaxNode().getData());
		System.out.println("Searched Node: " + binaryTree.findNode(100).getData());
		binaryTree.deleteNode(101);
		binaryTree.viewBinaryTree();	
	}
}