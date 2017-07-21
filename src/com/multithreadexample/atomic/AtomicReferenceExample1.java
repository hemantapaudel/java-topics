package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * The AtomicReference class provides an object reference variable which can be read and written atomically. 
 * @author Hemanta
 *
 */
public class AtomicReferenceExample1 {

	public static void main(String[] args) {
		String initialReference = "the initially referenced string";
		AtomicReference<String> atomicStringReference =   new AtomicReference<String>(initialReference);
		System.out.println(atomicStringReference.get());
		
		String newReference = "new value referenced";
		boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);
		
		exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);
	}

}
