package com.multithreadexample.iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap is specially designed for concurrent use i.e.more than one thread. By default it 
 * simultaneously allows 16 threads to read and write from Map without any external synchronization.
 * 
 * Since ConcurrentHashMap introduced the concept of segmentation, how large it becomes only certain part of it
 *  get locked to provide thread safety so many other readers can still access map without waiting for iteration
 *   to complete.
 *   
 *   In Summary, ConcurrentHashMap only locked certain portion of Map while Hashtable locks full
 *    map while doing iteration.
 *    
 *    ConcurrentHashMap is designed for concurrency and improve performance while HashMap which
 *     is non-synchronized by nature can be synchronized by applying a wrapper using synchronized Map. 
 *     Here are some of the common differences between ConcurrentHashMap and synchronized map in Java
 *     ConcurrentHashMap does not allow null keys or null values while synchronized HashMap allows one null key.
 *
 */
public class ConcurrentHashMapExample {
	public static void main(String[] args) {

		/**
		 * ConcurrentHashMap iterator behaves like fail safe iterator.
		 *  It will not throw ConcurrentModificationException 
		 *  Fail Safe Iterator makes copy of the internal data structure (object array) 
		 *  and iterates over the copied data structure
		 */
		ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        Iterator<String> iterator =  premiumPhone.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        System.out.println("After modification premiumPhone == "+premiumPhone);
        
        /**
         * Actually Iterator on Collection objects are fail-fast i.e any modification in the structure or the 
         * number of entry in the collection object will trigger this exception thrown by iterator.
         */
		Map<String,String> phoneMap = new HashMap<String,String>();
		phoneMap.put("Apple", "iPhone6");
		phoneMap.put("HTC", "HTC one");
		phoneMap.put("Samsung","S6");
        
        Iterator<String> it =  phoneMap.keySet().iterator();
        while (it.hasNext())
        {
            System.out.println(phoneMap.get(it.next()));
            phoneMap.put("Sony", "Xperia Z");
        }
        System.out.println("After modification phoneMap == "+phoneMap);
    }

}
