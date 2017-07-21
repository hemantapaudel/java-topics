package com.multithreadexample;
import com.multithreadexample.thread.ThreadUtil;


/**
 * 
 * Deadlock can occur in a situation when a thread is waiting for an object lock,
 * that is acquired by another thread and second thread is waiting for an object lock that is acquired by 
 * first thread. Since, both threads are waiting for each other to release the lock,
 * the condition is called deadlock.
 *
 */
public class DeadLockExample1 {
	public static void main(String[] args) {

		String resource1 = "TEST A";
		String resource2 = "TEST B";
		
		Runnable runnable1 = ()->{
			 synchronized (resource1) {  
				 System.out.println("Thread A: locked resource 1");
				 ThreadUtil.sleep(5000);
			    synchronized (resource2) {  
			    	System.out.println("Thread A: locked resource 1 and 2");
			    } 
			 }
		};
		
		Runnable runnable2 = ()->{
			 synchronized (resource2) { 
				 System.out.println("Thread B: locked resource 2");
			    ThreadUtil.sleep(5000);
			    synchronized (resource1) {  
			    	System.out.println("Thread B: locked resource 1 and 2");
		           } 
			 }
		};
		
		Thread thread1 = new Thread(runnable1,"Thread A");
		Thread thread2 = new Thread(runnable2,"Thread B");
		
		thread1.start();
		thread2.start();
	}

}
