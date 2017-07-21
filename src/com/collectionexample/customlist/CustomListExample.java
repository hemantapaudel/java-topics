package com.collectionexample.customlist;

import java.util.Iterator;


public class CustomListExample {
	public static void main(String[] args) {
		
		CustomList<String> customList = new CustomList<String>(10);
		customList.add("hemanta");
		customList.add("paudel");
		customList.add("bharat");
		customList.add("paudel");
		customList.add("manoj");
		customList.add("belbase");
		customList.add("basant");
		customList.add("manish");
		//custom iterator return
		Iterator<String> iterator = customList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
	}

}
