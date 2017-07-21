package com.multithreadexample.iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * Iterator read internal data structure (object array) directly . 
 * The internal data structure(i.e object array) should not be modified while iterating through the collection.
 *  To ensure this it maintains an internal  flag "mods" .Iterator checks the "mods" flag whenever 
 *  it gets the next value (using hasNext() method and next() method). Value of mods flag changes 
 *  whenever there is an structural modification. Thus indicating iterator to throw 
 *  ConcurrentModificationException.
 *
 */
public class FailFastExample {

	public static void main(String[] args) {
		Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }

	}

}
