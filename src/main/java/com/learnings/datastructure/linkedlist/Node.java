package com.learnings.datastructure.linkedlist;

public class Node {
	
	private Object data;
	
	private Node reference;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getReference() {
		return reference;
	}

	public void setReference(Node reference) {
		this.reference = reference;
	}
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append("Data: " + this.getData() + " :: ");
		builder.append("Reference: " + this.getReference());
		builder.append("]\t");
		return builder.toString();
	}*/
}