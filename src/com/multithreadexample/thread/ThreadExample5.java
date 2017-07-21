package com.multithreadexample.thread;


/**
 * 
 * Each thread have a priority. Priorities are represented by a number between 1 and 10.
 *  In most cases, thread scheduler schedules the threads according to their priority 
 *  (known as preemptive scheduling). But it is not guaranteed because it depends on JVM 
 *  specification that which scheduling it chooses.
 */

public class ThreadExample5 {
	public static void main(String[] args) {
		
		Runnable testPriority = ()->{
			System.out.println("Thread name:"+ Thread.currentThread().getName() );  
		};
		
		Thread test1 = new Thread(testPriority);
		Thread test2 = new Thread(testPriority);
		Thread test3 = new Thread(testPriority);
		
		test1.setPriority(Thread.MIN_PRIORITY);
		test2.setPriority(Thread.NORM_PRIORITY);
		test3.setPriority(Thread.MAX_PRIORITY);
		
		test1.start();
		test2.start();
		test3.start();
		
	}
}
