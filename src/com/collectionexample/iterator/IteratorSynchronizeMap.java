package com.collectionexample.iterator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IteratorSynchronizeMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(2, "Anil");
		hmap.put(44, "Ajit");
		hmap.put(1, "Brad");
		hmap.put(4, "Sachin");
		hmap.put(88, "XYZ");

		Map<Integer, String> map = Collections.synchronizedMap(hmap);
		Set<Entry<Integer, String>> set = map.entrySet();
		synchronized (map) {
			Iterator<Entry<Integer, String>> i = set.iterator();
			while (i.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>) i
						.next();
				System.out.print(me.getKey() + ": ");
				System.out.println(me.getValue());
			}
		}
		//for each loop using lambda
		map.forEach((K, V) -> System.out.println(" key " + K + " value " + V));

	}
        
	}


