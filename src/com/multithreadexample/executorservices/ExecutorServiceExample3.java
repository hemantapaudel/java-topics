package com.multithreadexample.executorservices;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MyCallableExample implements Callable<String> {
	private long waitTime;
	public MyCallableExample(int timeInMillis){
		this.waitTime=timeInMillis;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}
}

public class ExecutorServiceExample3 {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		MyCallableExample callable1 = new MyCallableExample(10000);
		MyCallableExample callable2 = new MyCallableExample(20000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		
			System.out.println("futureTask1.isDone():"+futureTask1.isDone());
			System.out.println("futureTask2.isDone():"+futureTask2.isDone());
			Thread.sleep(1000);
			System.out.println("futureTask1.isDone():"+futureTask1.isDone());
			System.out.println("futureTask2.isDone():"+futureTask2.isDone());
			
			// waiting for task1 to complete and get response
			System.out.println("FutureTask1 output="+futureTask1.get());	
			
			
			System.out.println("futureTask2.isDone():"+futureTask2.isDone());
			System.out.println( futureTask2.get(1000L, TimeUnit.MILLISECONDS));// waiting for task only for 1000ms complete and get response
			
		
		executor.shutdown();
	}
}
