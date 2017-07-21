package com.multithreadexample.thread;

/**
 * The ThreadLocal class in Java enables you to create variables that can only be read and written by 
 * the same thread. Thus, even if two threads are executing the same code, and the code has a reference to
 *  a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables.
 *  
 *  myThreadLocal is common for not sharing message between threads
 *
 */
public class ThreadExample10 {  
	public static void main(String[] args) {

		ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();
		
		Runnable runnable = ()->{
			myThreadLocal.set("Hello ThreadLocal 1");
			System.out.println(" thread from A :: "+myThreadLocal.get());
			ThreadUtil.sleep(1000);
			System.out.println("Thread a completed");
			System.out.println(" thread from A :: "+myThreadLocal.get());
		};

		Runnable runnable2 = ()->{
			ThreadUtil.sleep(50);
			System.out.println(" thread from B :: "+myThreadLocal.get());
			myThreadLocal.set("setting from B");
			System.out.println(" thread from B :: "+myThreadLocal.get());
		};

		
		Thread test1 = new Thread(runnable);
		test1.setPriority(10);
		test1.start();
		
		Thread test2 = new Thread(runnable2);
		test2.start();
	}

}


