package com.multithreadexample.thread;

/**
 * 
 * Sleep() : used to sleep a thread for the specified amount of time
 * Note: The thread does not lose ownership of any monitors i.e. the Resource will not be free or available even thread is sleeping
 */
public class ThreadUtil {
	
	public static void sleep(long miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep(long miliseconds,int nanos){
		try {
			System.out.println("Thread going to sleep name: "+ Thread.currentThread().getName());
			Thread.sleep(miliseconds,nanos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread is wakeup name :"+Thread.currentThread().getName());
	}
	
	public static void waiting(Object object){
		try {
			object.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
