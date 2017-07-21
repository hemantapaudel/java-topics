package com.collectionexample.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapExample {

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<Integer,String>();  
		  
		linkedHashMap.put(100,"Amit");  
		linkedHashMap.put(101,"Vijay");  
		linkedHashMap.put(102,"Rahul");  
		
	
		//LinkedHashIterator is internally used for iterate the for loop
		for(Entry<Integer,String> m:linkedHashMap.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
		}
				  	  
	}

}
