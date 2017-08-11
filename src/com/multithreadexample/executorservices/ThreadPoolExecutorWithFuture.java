package com.multithreadexample.executorservices;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The ExecutorService has the following implementation in the
 * java.util.concurrent package:
 *
 * 1. ThreadPoolExecutor 2. ScheduledThreadPoolExecutor
 *
 */
public class ThreadPoolExecutorWithFuture {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		// 1. creation
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// 2. Submitting task -> delegate task to executor service
		Future<String> firstOutPut = executorService
				.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						Thread.sleep(2000);
						return "First Thread completed";
					}
				});

		System.out.println(firstOutPut.isDone());
		System.out.println(firstOutPut.get());

		// 3. shout down the executor service
		executorService.shutdown();

		// creating thredpool executor using constructor

		int corePoolSize = 5;
		int maxPoolSize = 10;
		long keepAliveTime = 5000;

		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize,
				maxPoolSize,
				keepAliveTime,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		// 2. Submitting task -> delegate task to executor service
		Future<String> secondResult = threadPoolExecutor
				.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						Thread.sleep(2000);
						return "Second Thread completed";
					}
				});

		System.out.println(secondResult.isDone());
		System.out.println(secondResult.get());

		// 3. shout down the executor service
		threadPoolExecutor.shutdown();

	}

}
