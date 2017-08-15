package com.collectionexample.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  LinkedHashMap maintain the insertion order and also
 *  maintained the size of map if required
 *  
 *  it will remove eldest entry first.
 *
 */
public class LinkedHashMapExample {
	

	public static void main(String[] args) {
		
		Map<Integer,String> linkedHashMap=new LinkedHashMap<Integer,String>(){
			private static final long serialVersionUID = -7822062564231729253L;
			
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer,String> eldest) {
				System.out.println(eldest.getValue());
				return this.size()>2;
			}
		};
		  
		linkedHashMap.put(101,"Amit");  
		linkedHashMap.put(102,"Vijay");  
		linkedHashMap.put(103,"Rahul");  
		linkedHashMap.put(104,"Rahul1");  
		System.out.println(linkedHashMap.size());
		
	  
				  	  
	}

}
