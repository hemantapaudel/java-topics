package com.multithreadexample.synchronize;
import com.multithreadexample.thread.ThreadUtil;


/**
 * Synchronization in java is the capability to control the access of multiple threads to any shared resource.
 * Java Synchronization is better option where we want to allow only one thread to access the shared resource.
 * The synchronization is mainly used to
 * 1. To prevent thread interference.
 * 2. To prevent consistency problem.
 *
 */
public class SynchronizationExample1 {
	
	
	public static void main(String[] args) {
	
		Table table = new Table();
		
		
		Thread t1 = new Thread(()->table.printTable(10));
		Thread t2 = new Thread(()->table.printTable(20));
		
		t1.start();
		t2.start();
	}
}


class Table{
	/**
	 * If you declare any method as synchronized, it is known as synchronized method.
	 * Synchronized method is used to lock an object for any shared resource.
	 * 
	 * When a thread invokes a synchronized method, it automatically acquires the lock for that 
	 * object and releases it when the thread completes its task.
	 * 
	 * Synchronization is built around an internal entity known as the lock or monitor.
	 *  Every object has an lock associated with it. By convention, a thread that needs consistent access to 
	 *  an object's fields has to acquire the object's lock before accessing them, 
	 *  and then release the lock when it's done with them.
	 */
	synchronized void printTable(int n){
		 for(int i=1;i<=5;i++){  
		     System.out.println(n*i);  
		     ThreadUtil.sleep(400);
		 }  
	}
	
}