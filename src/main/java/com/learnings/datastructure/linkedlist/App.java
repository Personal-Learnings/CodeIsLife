package com.learnings.datastructure.linkedlist;

public class App {

	public static void main(String[] args) {

		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.add("First");
		linkedList.add("Second");
		linkedList.add("Third");
		
		System.out.println(linkedList.toString());
		System.out.println("\nRemoving.. Second Node______________________\n");
		linkedList.remove("Second");
		System.out.println(linkedList.toString());
		
		//System.out.println(linkedList.get("Second").getData() + " ::: " + linkedList.get("Second").getReference());
		
		/**
		 * Node Length Assignment
		 */
		
		Node nodeA = new Node();
		Node nodeB = new Node();
		Node nodeC = new Node();
		
		nodeA.setData("10");
		nodeA.setReference(nodeB);
		
		nodeB.setData("20");
		nodeB.setReference(nodeC);
		
		nodeC.setData("30");
		
		System.out.println(getNodeLength(nodeB));
	}
	
	/**
	 * Node Assignment
	 */
	private static int getNodeLength(Node node) {
		
		int nodeLength = 1;
		Node currentNode = node;
		while(hasNextNode(currentNode)) {
			nodeLength++;
			currentNode = currentNode.getReference();
		}
		return nodeLength;
	}

	private static boolean hasNextNode(Node currentNode) {
		return currentNode.getReference() != null;
	}
}