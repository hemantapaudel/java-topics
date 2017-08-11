package com.multithreadexample.executorservices;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		//1. creating schedule executor service
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);

		Callable<String> callable = () -> {
			System.out.println("Executed!");
			return "Called!";
		};
		// deligate tast to executor service
		ScheduledFuture<String> scheduledFuture = scheduledExecutorService
				.schedule(callable, 5, TimeUnit.SECONDS);

		System.out.println(scheduledFuture.isDone());
		System.out.println(scheduledFuture.get());
		
		
		//scheduledExecutorService.shutdown();
		
		
		/**
		 * scheduleAtFixedRate (Runnable, long initialDelay, long period, TimeUnit timeunit)

		 *	This method schedules a task to be executed periodically. 
		 *  The task is executed the first time after the initialDelay, and then 
		 *  recurringly every time the period expires.
		 *  In the scheduleAtFixedRate() method the period is interpreted as a delay between 
		 *  the start of the previous execution, until the start of the next execution.
		 */
		

		
		scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("periodic- scheduleAtFixedRate"), 1, 5, TimeUnit.SECONDS);
		
		
		/**
		 * scheduleWithFixedDelay (Runnable, long initialDelay, long period, TimeUnit timeunit)
		 * 
		 * This method works very much like scheduleAtFixedRate() except that the period is interpreted differently.
		 * 
		 * In the scheduleAtFixedRate() method the period is interpreted as a delay between the start of the previous execution, 
		 * until the start of the next execution.
		 * 
		 * In this method, however, the period is interpreted as the delay between the end of the previous execution, 
		 * until the start of the next. The delay is thus between finished executions, not between the beginning of executions.
		 */
		
		
		scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("periodic- scheduleWithFixedDelay"), 1, 5, TimeUnit.SECONDS);
		
		
		
		
		
		

	}

}
