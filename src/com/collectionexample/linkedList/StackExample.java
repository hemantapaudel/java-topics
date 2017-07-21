package com.collectionexample.linkedList;

import java.util.Stack;
//FIFO
public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		
		System.out.println("searcing = "+stack.search("3"));
		//look at top object ("3"), without taking it off the stack.  
		System.out.println(stack.peek());
		System.out.println(stack.pop()); //the string "3" is at the top of the stack.
		System.out.println(stack.pop()); //the string "2" is at the top of the stack.
		System.out.println(stack.pop()); //the string "1" is at the top of the stack. 
		

	}

}
