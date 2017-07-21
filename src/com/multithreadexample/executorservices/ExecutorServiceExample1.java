package com.multithreadexample.executorservices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.multithreadexample.thread.ThreadUtil;

/**
 * example:using Executors class to create ExecutorService instance.
 * Executors class provide simple implementation of ExecutorService using ThreadPoolExecutor 
 * 
 * execute(Runnable) :- add task to the thread pool for future execution
 * submit(Runnable ) : - Submits a Runnable task for execution and returns a Future representing that task. 
 * 				         The Future's get method will return null upon successful completion
 * submit(Callable) :-   Submits a Runnable task for execution and returns a Future representing that task.
 * 						The Future's get method will return Result of task completion
 *
 *InvokeAll(List <Callable>):- Executes the given tasks, returning a list of Futures holding their status and results when all complete
 *InvokeAny(List <Callable>):- Executes the given tasks, returning the result of one that has completed successfully 
 *
 *shotdown() : No new task will accepted.
 *shotdownNow():- kill all task and terminate 
 */


class WorkerThread  implements Runnable{
	
	private String command;
	
	 public WorkerThread(String command) {
		this.command=command;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        ThreadUtil.sleep(15);
        System.out.println(Thread.currentThread().getName()+" End.");
	}

	@Override
    public String toString(){
        return this.command;
    }

}


class WorkerCallable  implements Callable<String>{
	private String command;
	 public WorkerCallable(String command) {
		this.command=command;
	}
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        ThreadUtil.sleep(5);
        System.out.println(Thread.currentThread().getName()+" End.");
		return command;
	}
}

public class ExecutorServiceExample1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {		
		ExecutorService executor  =  Executors.newFixedThreadPool(20);
        
		System.out.println("== adding tasks into the pool ===");
		for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("Runnable" + i);
            //add task for execution 
            executor.execute(worker);
          }
		System.out.println("added 10 worker thread on executor service ");
        
        
        System.out.println("=========adding tasks into the pool and get future object for the result ");
        List <Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
        	Callable <String>caller = new WorkerCallable("Callable" + i);
        	 Future <String>future = executor.submit(caller);
        	 results.add(future);
          }
        
        
        // do not allow any task in the future , only execute tasks which already added on pool
        executor.shutdown();
        
        // waiting to complete the pool execution
        while (!executor.isTerminated()) {
        	System.out.println("===executor service is running=====");
        }
        
        for(Future<String> future : results){
        	System.out.println("Result of task:: "+future.get());
        }
        
        System.out.println("Finished all threads");
	}
	
	

}
