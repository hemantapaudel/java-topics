package com.multithreadexample.executorservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//import thread.ThreadUtil;

class MyCallable implements Callable<String>{
	@Override
	public String call() throws Exception {
		//ThreadUtil.sleep(1);
		//return the thread name executing this callable task
		return Thread.currentThread().getName();
	}
}

public class ExecutorServiceExample2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<Future<String>>();
		for(int i=0;i<100;i++){
			MyCallable myCallable = new MyCallable();
			Future<String> future =  executor.submit(myCallable);
			list.add(future);  
		}
		for(int i=0;i<100;i++){
			Future<String> future =  list.get(i);
			System.out.println(new Date()+":"+future.get());
			list.add(future);
		}
		executor.shutdown();
	}
}
