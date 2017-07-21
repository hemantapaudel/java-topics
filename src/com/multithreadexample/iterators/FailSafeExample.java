package com.multithreadexample.iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the 
 * copied data structure.Any structural modification done to the iterator affects the copied data structure. 
 *  So , original data structure remains  structurally unchanged .Hence , 
 *  no ConcurrentModificationException throws by the fail safe iterator.
 *  
 *   Two  issues associated with Fail Safe Iterator are :
 *   
 *   1. Overhead of maintaining the copied data structure i.e memory.
 *   2.  Fail safe  does not guarantee that the data being read is the data currently in the 
 *   original data structure. 
 *
 */
public class FailSafeExample {
	public static void main(String[] args) {
		
		System.out.println("====Fail safe example 1===================");
		/*
		 * In the ConcurrentHashMap Api , you will find the following constants.
		static final int DEFAULT_INITIAL_CAPACITY = 16;
		static final int DEFAULT_CONCURRENCY_LEVEL = 16;*/
		Map<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        System.out.println("After modification "+premiumPhone);
        
        System.out.println("====Fail safe example 2===================");
        CopyOnWriteArrayList<String> friendList = new CopyOnWriteArrayList<String>();
        friendList.add("manoj");
        Iterator<String> it =    friendList.iterator();
        while(it.hasNext()){
        	friendList.add("Bharat");
        	System.out.println(it.next());
        	
        }
        System.out.println(" after modified friend list "+friendList);
    }
}
