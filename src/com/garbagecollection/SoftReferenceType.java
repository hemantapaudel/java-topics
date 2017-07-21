package com.garbagecollection;

import java.lang.ref.SoftReference;
/**
 * Now as soon as you make strong reference student = null, 
 * student object created on line 1 becomes eligible for garbage collection; 
 * because it doesn't have any more Strong reference and Soft reference by reference variable soft, 
 * student object is not garbage collected until JVM absolutely needs memory because it is hold by SoftReference
 *      
 * SoftReference are more suitable for storing cache data.
 *
 */
public class SoftReferenceType {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("rahul");
		// prime holds a strong reference - line 2
		SoftReference<Object> soft = new SoftReference<Object>(student);
		// soft reference variable has SoftReference to Counter Object created
		// at line 2
		student = null; // now Counter object is eligible for garbage collection
						// but only be collected when JVM absolutely needs
						// memory

		System.out.println(soft.get());
	}
}
