package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayExample {

	public static void main(String[] args) {
		String[] source = new String[10];
		source[5] = "Some string";
		AtomicReferenceArray<String> array =   new AtomicReferenceArray<String>(source);
		System.out.println(array.get(5));
		array.set(6, "another object");
		System.out.println(array.get(6));
		
		array.compareAndSet(5, "Some string", "updated string object");
		System.out.println(array.get(5));
		
	}

}
