package com.multithreadexample.thread;


/**
 * 
 * 
 * Shutdown hooks are initialized but not-started threads. They start when JVM shutdown triggers.
 *
 */

public class ThreadExample8 {
	public static void main(String[] args) {
		Runnable runnable = ()-> System.out.println("shut down hook task completed.");
		Runtime.getRuntime().addShutdownHook(new Thread(runnable));
		System.out.println("Now main sleeping... press ctrl+c to exit");  
		ThreadUtil.sleep(30000);
		
	}

}
