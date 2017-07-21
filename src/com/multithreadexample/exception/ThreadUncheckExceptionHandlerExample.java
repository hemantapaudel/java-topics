package com.multithreadexample.exception;

import java.lang.Thread.UncaughtExceptionHandler;

class ThreadUncaughtExceptionHandler implements UncaughtExceptionHandler{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exception occure in thread : "+t.getName());
		System.out.println("exception message is "+ e.getMessage());
		e.printStackTrace();
		
	}
}

public class ThreadUncheckExceptionHandlerExample {
	public static void main(String[] args) {
		Runnable run = ()->{
			Thread.currentThread().setUncaughtExceptionHandler(new ThreadUncaughtExceptionHandler());
			int i =0;
			int x =10;
			 System.out.println("result = "+ x/i);
		};
		new Thread(run,"thread-example1").start();

	}

}
