package com.multithreadexample.thread;

/**
 * Can we start a thread twice
 * 
 *
 */
public class ThreadExample2 {
	public static void main(String[] args) {

		Runnable runnable = ()-> System.out.println("Thread is running, name :"+ Thread.currentThread().getName());
		Thread test = new Thread(runnable);
		test.start();
		ThreadUtil.sleep(1000);
		// same thread start again
		test.start();
	}

}
