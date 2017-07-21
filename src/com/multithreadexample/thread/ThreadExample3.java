package com.multithreadexample.thread;

/**
 * What if we call run() method directly instead start() method?
 * 
 *
 *Each thread starts in a separate call stack. Invoking the run() method from main thread, 
 *the run() method goes onto the current call stack rather than at the beginning of a new call stack.
 */
public class ThreadExample3 {
	public static void main(String[] args) {
		System.out.println("=======directly run method call=================");
		Runnable runnable = ()-> System.out.println("Thread is running, name :"+ Thread.currentThread().getName());
		Thread test = new Thread(runnable);
		test.run();
		System.out.println("===========start thread using start method=================");
		Thread test2Thread = new Thread(runnable);
		test2Thread.start();
	}

}
