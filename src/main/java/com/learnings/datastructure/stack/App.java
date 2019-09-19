package com.learnings.datastructure.stack;

/**
 * 
 * @author Madanraj Venkatesan
 *
 */
public class App {
	
	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.pop();
		stack.peek();
		stack.push("4");
		stack.pop();
		stack.pop();
		stack.peek();
		stack.push("5");
		stack.peek();
		
		System.out.println();
		System.out.println(reverseString("nasetakneV jarnadaM"));
		System.out.println(">>>>" + reverseStringWithoutStack("nasetakneV jarnadaM"));
	}
	
	private static String reverseString(String inputString) {
		char [] sequence = inputString.toCharArray();
		Stack stack = new Stack(sequence.length);
		String outputString = "";
		
		for(int i=0; !stack.isFull(); i++)
			stack.push(sequence[i]);
		
		while(!stack.isEmpty())
			outputString = outputString + stack.pop().toString();
			
		return outputString;
	}
	
	private static String reverseStringWithoutStack(String inputString) {
		String outputString = "";
		char [] charSequence = inputString.toCharArray();
		
		for(int i = 0, j = (charSequence.length - 1); i < j; i++, j--) {
			char temp = charSequence[i];
			charSequence[i] = charSequence[j];
			charSequence[j] = temp;
		}
		
		for(int i = 0; i < charSequence.length; i++) {
			outputString = outputString + charSequence[i];
		}
		
		return outputString;
	}
}