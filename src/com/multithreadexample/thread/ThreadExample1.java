package com.multithreadexample.thread;


/*
 * How to create thread  on java ???
 * 
 *There are two ways to create a thread:
 *By extending Thread class
 *By implementing Runnable interface.
 *
 **/

public class ThreadExample1 {
	public static void main(String[] args) {
		
		// creating thread by extending Thread class
		ThreadTest test= new ThreadTest();
		test.start();
		
		// creating thread by implementing Runnable interface
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(" Creating thread by implement Runnable Interface");
			}
		};
			
		Thread test2 = new Thread(runnable);
		test2.start();
		
		// Runnable is a Functional Interface which having only one abstract method
		Runnable functionalInterface = ()-> System.out.println(" creating thread using lembda expression");
		Thread test3 = new Thread(functionalInterface);
		test3.start();
		


		
	}
}

class ThreadTest extends Thread{
	@Override
	public void run() {
		System.out.println(" Creating thread by extending Thread class");
	}
}