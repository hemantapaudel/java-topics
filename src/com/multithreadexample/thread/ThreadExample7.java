package com.multithreadexample.thread;

/**
 * Java provides a convenient way to group multiple threads in a single object. 
 * In such way, we can suspend, resume or interrupt group of threads by a single method call.
 *
 */
public class ThreadExample7 {
	public static void main(String[] args) {

		Runnable runnable = ()-> System.out.println(Thread.currentThread().getName());  
		
		ThreadGroup threadGroup = new ThreadGroup("Group A");
		
		Thread t1 = new Thread(threadGroup, runnable,"one");  
        t1.start();  
        Thread t2 = new Thread(threadGroup, runnable,"two");  
        t2.start();  
		
        
        
        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.activeGroupCount());
	}

}
