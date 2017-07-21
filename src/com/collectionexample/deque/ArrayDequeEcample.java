package com.collectionexample.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeEcample {

	public static void main(String[] args) {
		Deque<String> deque=new ArrayDeque<String>();  
	    deque.offer("arvind");  
	    deque.offer("vimal");  
	    deque.add("mukul");  
	    deque.offerFirst("jai");  
	    System.out.println("After offerFirst Traversal...");  
	    for(String s:deque){  
	        System.out.println(s);  
	    }  
	    //deque.poll();  
	    //deque.pollFirst();//it is same as poll()  
	    deque.pollLast();  
	    deque.forEach((s)->System.out.println(s));
	}

}
