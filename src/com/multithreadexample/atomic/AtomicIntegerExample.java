package com.multithreadexample.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
public static void main(String[] args) {
	AtomicInteger atomicInteger = new AtomicInteger(10);
	atomicInteger.set(20);
	System.out.println(atomicInteger.get());
	
	System.out.println(atomicInteger.compareAndSet(20, 30));
	System.out.println(atomicInteger.compareAndSet(20, 40));
	System.out.println(atomicInteger.get());
	
	System.out.println("===getAndAdd example ==="+atomicInteger.get());
	System.out.println(atomicInteger.getAndAdd(10));
	System.out.println(atomicInteger.get());
	System.out.println(atomicInteger.addAndGet(10));
	System.out.println(atomicInteger.getAndIncrement());
	System.out.println(atomicInteger.decrementAndGet());
}
}
