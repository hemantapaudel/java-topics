package com.collectionexample.set;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

enum days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumSetExmple {
	public static void main(String[] args) {
		Set<days> set = EnumSet.of(days.TUESDAY, days.WEDNESDAY);
		// Traversing elements
		Iterator<days> iter = set.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
		System.out.println("example of allof");
		System.out.println(EnumSet.allOf(days.class));
		

		System.out.println("example of noneof");
		System.out.println(EnumSet.noneOf(days.class));
		
	}
}
