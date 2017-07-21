package com.collectionexample.iterator;

import java.util.ArrayList;
import java.util.List;

public class ListIteratorExample {
	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		al.add("Amit");
		al.add("Vijay");
		al.add("Kumar");
		al.add("Sachin");
		System.out.println("element at 2nd position: " + al.get(2));
		java.util.ListIterator<String> itr = al.listIterator();
		System.out.println(itr.next());
		//Adding new element as second position using List Iterator
		itr.add("125421");
		System.out.println("traversing elements in forward direction...");
		java.util.ListIterator<String> itr1 = al.listIterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
		System.out.println("traversing elements in backward direction...");
		while (itr1.hasPrevious()) {
			System.out.println(itr1.previous());
		}
		
		
	}
}
