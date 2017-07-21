package com.garbagecollection;

import java.lang.ref.WeakReference;

/**
 * Now as soon as you make strong reference student = null, 
 * student object created on line 1 becomes eligible for garbage collection; because it doesn't have any more Strong reference
 * and Weak reference by reference variable weakStudent can not prevent Counter object from being 
 * garbage collected.
 *   
 * WeakReference are more suitable for storing meta data.
 */
public class WeakReferenceType {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("rahul");
		
		// strong reference - line 1
		WeakReference<Object> weakStudent= new WeakReference<Object>(student);
		//weak reference 
		student = null; // now Counter object is eligible for garbage collection
		System.out.println(weakStudent.get());
	}

}
