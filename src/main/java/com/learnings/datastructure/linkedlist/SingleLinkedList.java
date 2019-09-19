package com.learnings.datastructure.linkedlist;

public class SingleLinkedList {
	
	private Node primaryNode;
	private Node headNode;
	private Node tailNode;
	private int size;
	
	public SingleLinkedList() {
		this.headNode = new Node();
		this.tailNode = new Node();
		this.size = 0;
	}
	
	public void add(Object data) {
		
		Node newNode = new Node();
		
		if(this.primaryNode == null) {
			this.primaryNode = newNode;
			this.primaryNode.setData(data);
			updateHeadReference(this.primaryNode);
			updateTailReference(null);
			this.size = 1;
		}
		else {
			primaryNode.setReference(newNode);
			newNode.setData(data);
			newNode.setReference(null);
			updateTailReference(newNode);
			primaryNode = newNode;
			this.size++;
		}
	}

	private void updateHeadReference(Node node) {
		this.headNode = node;
	}
	
	private void updateTailReference(Node node) {
		this.tailNode = node;
	}
	
	public void remove(Object data) {
		
		Node iteratorNode = this.headNode;
		Node previousNode = new Node();
		
		for(int i=0; i<this.size; i++) {
			if(null != iteratorNode && iteratorNode.getData().equals(data)) {
				if(i==0) {
					this.headNode = iteratorNode.getReference();
					this.size--;
				}
				else if (i==(size-1)) {
					this.tailNode = previousNode;
					previousNode.setReference(null);
					this.size--;
				}
				else {
					previousNode.setReference(iteratorNode.getReference());
					this.size--;
				}
			}
			previousNode = iteratorNode;
			iteratorNode = iteratorNode.getReference();
		}
	}
	
	public Node get(Object data) {
		Node iteratorNode = this.headNode;
		for(int i=0; i<this.size; i++) {
			if(null != iteratorNode && iteratorNode.getData().equals(data)) {
				return iteratorNode;
			}
			iteratorNode = iteratorNode.getReference();
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[\n");
		Node iteratorNode = this.headNode;
		for(int i=0; i<size; i++) {
			if(null != iteratorNode) {
				builder.append("Data: " + iteratorNode.getData() + " :: ");
				builder.append("Reference: " + iteratorNode.getReference() + "\n");
				iteratorNode = iteratorNode.getReference();
			}
		}
		builder.append("]");
		builder.append("\n\n[\n");
		builder.append("Head Node: " + this.headNode.getData() + " :: " + this.headNode.getReference());
		builder.append("\nTail Node: " + this.tailNode.getData() + " :: " + this.tailNode.getReference());
		builder.append("\n]");
		return builder.toString();
	}
}