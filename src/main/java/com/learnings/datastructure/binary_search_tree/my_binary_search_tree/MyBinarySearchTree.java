package com.learnings.datastructure.binary_search_tree.my_binary_search_tree;

import com.learnings.datastructure.binary_search_tree.my_binary_search_tree.Node;

public class MyBinarySearchTree {
	
	private Node rootNode = null;
	
	/**
	 * 	Accepts Duplicates
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if(isBinaryTreeEmpty()) {
			rootNode = newNode;
		}
		else {
			insertUsingLoop(newNode);
		}
	}
	
	public void insertUsingLoop(Node newNode) {
		
		Node currentNode = rootNode;

		while(currentNode != null) {
			if(newNode.getKey() < currentNode.getKey()) {
				if(currentNode.getLeftNode() == null) {
					currentNode.setLeftNode(newNode);
					break;
				}
				else {
					currentNode = currentNode.getLeftNode();
				}
			}
			else if(newNode.getKey() > currentNode.getKey()) {
				if(currentNode.getRightNode() == null) {
					currentNode.setRightNode(newNode);
					break;
				}
				else {
					currentNode = currentNode.getRightNode();
				}
			}
			else {
				int count = currentNode.getCount();
				currentNode.setCount(++count);
				break;
			}
		}
	}
	
	public boolean isBinaryTreeEmpty() {
		return rootNode == null;
	}
	
	public Node getMaxNode() {

		Node currentNode = rootNode;

		while(currentNode != null) {
			if(currentNode.getRightNode() != null)
				currentNode = currentNode.getRightNode();
			else
				break;
		}
		return currentNode;
	}
	
	public Node getMaxNode(Node currentNode) {

		while(currentNode != null) {
			if(currentNode.getRightNode() != null)
				currentNode = currentNode.getRightNode();
			else
				break;
		}
		return currentNode;
	}

	public Node getMinNode() {

		Node currentNode = rootNode;

		while(currentNode != null) {
			if(currentNode.getLeftNode() != null)
				currentNode = currentNode.getLeftNode();
			else
				break;
		}
		return currentNode;
	}
	
	public Node getMinNode(Node currentNode) {

		while(currentNode != null) {
			if(currentNode.getLeftNode() != null)
				currentNode = currentNode.getLeftNode();
			else
				break;
		}
		return currentNode;
	}
	
	@SuppressWarnings("unused")
	private Node getInOrderSuccessorNode(Node currentNode) {
		Node inOrderSuccessorNode = currentNode.getRightNode();

		while(inOrderSuccessorNode != null) {
			if(inOrderSuccessorNode.getLeftNode() != null)
				inOrderSuccessorNode = inOrderSuccessorNode.getLeftNode();
			else
				break;
		}
		return inOrderSuccessorNode;
	}
	
	@SuppressWarnings("unused")
	private Node getInOrderPredecessorNode(Node currentNode) {
		Node inOrderPredecessorNode = currentNode.getLeftNode();

		while(inOrderPredecessorNode != null) {
			if(inOrderPredecessorNode.getRightNode() != null)
				inOrderPredecessorNode = inOrderPredecessorNode.getRightNode();
			else
				break;
		}
		return inOrderPredecessorNode;
	}
	
	public void deleteNode(int key) {
	
		// To Delete the Root Node
		if(null != rootNode && key == rootNode.getKey()) {
			rootNode = null;
		}
		
		Node currentNode, currentNodeParent;
		currentNode = currentNodeParent = rootNode;
		
		// To Find the Node and Its Parent
		while(currentNode != null) {
			if(key == currentNode.getKey()) {
				break;
			}
			else if(key < currentNode.getKey()) {
				currentNodeParent = currentNode;
				currentNode = currentNode.getLeftNode();
			}
			else {
				currentNodeParent = currentNode;
				currentNode = currentNode.getRightNode();
			}
		}
		
		//Node Does Not Exist
		if(currentNode == null) {
			System.out.println("Nothing to Delete.");
			return;
		}
		else if(isLeafNode(currentNode)) {
			if(currentNodeParent.getKey() > currentNode.getKey()) {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setLeftNode(null);
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
			else {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setRightNode(null);
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
		}
		else if(isNodeHasOnlyLeftChildren(currentNode)) {
			
			if(currentNodeParent.getKey() > currentNode.getKey()) {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setLeftNode(currentNode.getLeftNode());
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
			else {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setRightNode(currentNode.getLeftNode());
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
		}
		else if(isNodeHasOnlyRightChildren(currentNode)) {
			
			if(currentNodeParent.getKey() > currentNode.getKey()) {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setLeftNode(currentNode.getRightNode());
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
			else {
				if(currentNode.getCount() == 1) {
					currentNodeParent.setRightNode(currentNode.getRightNode());
				}
				else {
					int count = currentNode.getCount();
					currentNode.setCount(--count);
				}
			}
		}
		else if(isNodeHasBothChildren(currentNode)) {
			
			if(currentNode.getCount() == 1) {
				//In-Order Successor Technique
				Node inOrderSuccessorNode = currentNode.getRightNode();
				Node inOrderSuccessorParentNode = currentNode.getRightNode();

				while(inOrderSuccessorNode != null) {
					if(inOrderSuccessorNode.getLeftNode() != null) {
						inOrderSuccessorParentNode = inOrderSuccessorNode;
						inOrderSuccessorNode = inOrderSuccessorNode.getLeftNode();
					}
					else
						break;
				}
				
				//Taking a backup of Right Node of the Node to be Deleted
				Node rightNodeOfCurrentNode = currentNode.getRightNode();
				
				//Replacing the Current Node with In-Order Successor Node Details
				currentNode.setKey(inOrderSuccessorNode.getKey());
				currentNode.setCount(inOrderSuccessorNode.getCount());
				
				if(inOrderSuccessorNode.getRightNode() != null) {
					currentNode.setRightNode(inOrderSuccessorNode.getRightNode()); // Only right as there wont be any left node for sure
				}
				
				//Find the Max of the In-Order Successor Right Node
				Node inOrderSuccessorMaxNode = getMaxNode(inOrderSuccessorNode);
				
				//Assign the Right Node of your Current Node to the In-Order Successor Max Node
				if(inOrderSuccessorMaxNode.getKey() != rightNodeOfCurrentNode.getKey()) {
					inOrderSuccessorMaxNode.setRightNode(rightNodeOfCurrentNode);
				}
				
				//Delete the In-Order Successor Node
				if(inOrderSuccessorNode.getKey() == inOrderSuccessorParentNode.getKey()) {
					currentNode.setRightNode(null);
				}
				else if(null != inOrderSuccessorParentNode.getLeftNode()) {
					inOrderSuccessorParentNode.setLeftNode(null);
				}
				else {
					inOrderSuccessorParentNode.setRightNode(null);
				}
			}
			else {
				//If Current Node Count != 1
				int count = currentNode.getCount();
				currentNode.setCount(--count);
			}
		}
	}
	
	private boolean isNodeHasOnlyRightChildren(Node currentNode) {
		return (currentNode.getLeftNode() == null && currentNode.getRightNode() != null);
	}

	private boolean isNodeHasOnlyLeftChildren(Node currentNode) {
		return (currentNode.getLeftNode() != null && currentNode.getRightNode() == null);
	}

	private boolean isNodeHasBothChildren(Node currentNode) {
		return (currentNode.getLeftNode() != null && currentNode.getRightNode() != null);
	}

	private boolean isLeafNode(Node currentNode) {
		return (currentNode.getLeftNode() == null && currentNode.getRightNode() == null);
	}
	
	public Node findNode(int data) {
		
		Node currentNode = rootNode;
		while(currentNode != null) {
			if(data == currentNode.getKey()) {
				break;
			}
			else if(data < currentNode.getKey()) {
				currentNode = currentNode.getLeftNode();
			}
			else {
				currentNode = currentNode.getRightNode();
			}
		}
		return currentNode;
	}
}