package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;


public class AtomicIntegerArrayExample1 {
	public static void main(String[] args) {

		AtomicIntegerArray array = new AtomicIntegerArray(10);
		array.set(5, 999);
		System.out.println(array.get(5));
		
		boolean swapped = array.compareAndSet(5, 999, 123);
		System.out.println(swapped);
		System.out.println(array.get(5));
		System.out.println(array.incrementAndGet(5));
	}

}
