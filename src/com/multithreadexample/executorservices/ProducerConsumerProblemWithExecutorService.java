package com.multithreadexample.executorservices;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

import com.multithreadexample.thread.ThreadUtil;


class Producer implements Callable<Boolean> {

	private BlockingQueue<String> blockingQueue;

	public Producer(BlockingQueue<String> blockingQueue2) {
		this.blockingQueue = blockingQueue2;
	}

	@Override
	public Boolean call() throws Exception {
		IntStream.range(0, 10).forEach( e ->{
			ThreadUtil.sleep(1000);

			blockingQueue.add("product"+e);
		});
		return blockingQueue.add("FINSISH");
	}

}

class Consumer implements Callable<String> {

	private BlockingQueue<String>  blockingQueue;

	Consumer(BlockingQueue<String>  blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public String call() throws Exception {
		System.out.println("=====Consumed====");
		String product = blockingQueue.take();
		System.out.println("product "+ product);
		while(!product.equalsIgnoreCase("FINSISH")){
			System.out.println(product);
			product = blockingQueue.take();
			System.out.println("");
		}
		return "Completed";
	}
}

public class ProducerConsumerProblemWithExecutorService {
	public static void main(String[] args) {

		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		 
	    executorService.submit(new Producer(blockingQueue));
	    executorService.submit(new Consumer(blockingQueue));
	    
	    executorService.shutdown();
	    while(!executorService.isTerminated()){
	    	
	    }
	    
	    //calling other dao calls
	    System.out.println("Producer consumer completed");
	}
}
