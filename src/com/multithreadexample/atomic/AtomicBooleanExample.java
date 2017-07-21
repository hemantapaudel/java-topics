package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 
 * The AtomicX class provides you with a variable which can be read and written atomically
 *
 */
public class AtomicBooleanExample {

	public static void main(String[] args) {

		AtomicBoolean atomicBoolean = new AtomicBoolean();
		System.out.println("Default boolean value "+atomicBoolean.get());
		atomicBoolean.set(true);
		
		System.out.println(atomicBoolean.getAndSet(false));
		System.out.println(atomicBoolean.get());
		System.out.println("Compare and Set AtomicBoolean's Value");
	
		atomicBoolean.set(true);
		System.out.println("atomic value having "+atomicBoolean.get());
		/**
		 * The method compareAndSet() allows you to compare the current value of the AtomicBoolean to
		 *  an expected value, and if current value is equal to the expected value, a new value can be 
		 *  set on the AtomicBoolean. The compareAndSet() method is atomic, so only a single thread can 
		 *  execute it at the same time. Thus, the compareAndSet() method can be used to implemented 
		 *  simple synchronizers like locks.
		 *  
		 *  return value False  indicates that the actual value was not equal to the expected value.
		 */
		System.out.println(atomicBoolean.compareAndSet(true, false));
		System.out.println(atomicBoolean.get());
	}
	

}
