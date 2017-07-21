package com.multithreadexample.blockingqueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	protected BlockingQueue<String> queue = null;
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
	@Override
	public void run() {
		try {
            System.out.println("Consumer "+ queue.take());
            System.out.println("Consumer "+ queue.take());
            System.out.println("Consumer "+ queue.take());
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		
	}
}
