package com.multithreadexample.blockingqueue;


import com.multithreadexample.thread.ThreadUtil;

public class BlockingQueueExample1 {
	public static void main(String[] args) {

		MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<Integer>(5);
		Runnable producerRunnable = ()->{
			for(int i=0; i<10; i++){
	            try {
	                
	                ThreadUtil.sleep(1000);
	                blockingQueue.enQueue(i);
	            } catch (InterruptedException ex) {
	            }
				}
				};
				
		Runnable consumerRunnable = ()->{
					for(int i=0; i<10; i++){
			            try {
			            	ThreadUtil.sleep(5000);
			                System.out.println(" consumer are cosumming: " + blockingQueue.deQueue());
			            } catch (InterruptedException ex) {
			            }
						}
						};
		
		
	   Thread consumer1 = new Thread(consumerRunnable);
	   Thread produce1 = new Thread(producerRunnable);
	   
	   consumer1.start();
	   produce1.start();
	}
}
