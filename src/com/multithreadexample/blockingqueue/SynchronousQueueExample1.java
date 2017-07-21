package com.multithreadexample.blockingqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * The SynchronousQueue is a queue that can only contain a single element internally.
 *  A thread inserting an element into the queue is blocked until another thread takes that element from the queue. 
 *  Likewise, if a thread tries to take an element and no element is currently present, 
 *  that thread is blocked until a thread insert an element into the queue.
 *
 */
public class SynchronousQueueExample1 {

	public static void main(String[] args) {
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();

		Thread producer = new Thread("PRODUCER") { 
			public void run() {
				String event = "FOUR";
				try {
				System.out.println("putting score into the queue");	
				queue.put(event); // thread will block here 
				System.out.printf("[%s] published event : %s %n", Thread .currentThread().getName(), event); } 
				catch (InterruptedException e)
				{ 
					e.printStackTrace(); } 
				}
			};
			producer.start(); // starting publisher thread 
			Thread consumer = new Thread("CONSUMER") {
				public void run() {
					try {
						System.out.println("taking the object from the queue");
						String event = queue.take(); // thread will block here
						System.out.printf("[%s] consumed event : %s %n", Thread .currentThread().getName(), event); } 
					catch (InterruptedException e) { 
						e.printStackTrace();
						}
					}
				};

		consumer.start();
	}

}
