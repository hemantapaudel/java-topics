package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceExample1 {
	public static void main(String[] args) {
		
		String initialRef   = "initial value referenced";
		int    initialStamp = 0;

		AtomicStampedReference<String> atomicStringReference =
		    new AtomicStampedReference<String>(initialRef, initialStamp);

		String newRef   = "new value referenced";

		boolean exchanged = atomicStringReference.compareAndSet(initialRef, newRef, 0, 1);
		System.out.println("exchanged: " + exchanged);  //true
		System.out.println(atomicStringReference.getReference());
		System.out.println(atomicStringReference.getStamp());
		
		
		exchanged = atomicStringReference.compareAndSet(initialRef, "new string", 1, 2);
		System.out.println("exchanged: " + exchanged);  //false
		
		exchanged = atomicStringReference.compareAndSet(newRef, "new string", 0, 1);
		System.out.println("exchanged: " + exchanged);  //false
		
		exchanged = atomicStringReference.compareAndSet(newRef, "new string", 1, 2);
		System.out.println("exchanged: " + exchanged);  //true
		System.out.println(atomicStringReference.getReference());
		
		/**
		 * AtomicStampedReference and the A-B-A Problem
		 */
		
		
	}
}
