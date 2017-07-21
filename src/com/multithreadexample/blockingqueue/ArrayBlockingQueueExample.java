package com.multithreadexample.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array.
 *
 */
public class ArrayBlockingQueueExample {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		
		Thread consumerThread = new Thread(new Consumer(queue));
		Thread producerThread = new Thread(new Producer(queue));
		consumerThread.start();
		producerThread.start();
	}

}
