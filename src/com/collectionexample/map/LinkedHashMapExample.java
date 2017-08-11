package com.collectionexample.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class LRUCache<Integer, String> extends LinkedHashMap<Integer, String>{
	
	private static final long serialVersionUID = 1L;
	
	static int count =100;
	public LRUCache(){
		super(16,0.75f,true);
	}
	
	
	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Integer, String> eldest) {
		System.out.println("======count==="+count + "key = "+ eldest.getKey());
		 //return size()>10?true:false;
		 return true;
	}
	
}


public class LinkedHashMapExample {
	
	
	

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> linkedHashMap=new LRUCache<Integer,String>();
		  
		linkedHashMap.put(101,"Amit");  
		linkedHashMap.put(102,"Vijay");  
		linkedHashMap.put(103,"Rahul");  
		System.out.println(linkedHashMap.size());
		
	   /* int i=104;
	    for( ;i<200;i++){
	    	System.out.println("======i==="+i);
	    	linkedHashMap.put(i, "amit");
	    }*/
	    
	   
	    
		/*//LinkedHashIterator is internally used for iterate the for loop
		for(Entry<Integer,String> m:linkedHashMap.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue()); 
		}*/
				  	  
	}

}
