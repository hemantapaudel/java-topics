package com.collectionexample.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Amit");
		set.add("Vijay");
		set.add("Kumar");
		set.add("Sachin");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
	}

}
