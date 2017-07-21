package com.collectionexample.map;

import java.util.EnumMap;
import java.util.Map;

enum Days {  
	   Monday, Tuesday, Wednesday, Thursday  
	   }
public class EnumMapExample {

	public static void main(String[] args) {
		EnumMap<Days, String> map = new EnumMap<Days, String>(Days.class);  
		   map.put(Days.Monday, "1");  
		   map.put(Days.Tuesday, "2");  
		   map.put(Days.Wednesday, "3");  
		   map.put(Days.Thursday, "4");  
		   // print the map  
		   for(Map.Entry <Days, String> m:map.entrySet()){    
		       System.out.println(m.getKey()+" "+m.getValue());    
		      }   

	}

}
