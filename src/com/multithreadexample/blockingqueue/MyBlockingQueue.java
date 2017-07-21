package com.multithreadexample.blockingqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * A blocking queue is a queue that blocks when you try to dequeue from it and
 * the queue is empty, or if you try to enqueue items to it and the queue is
 * already full.
 */
public class MyBlockingQueue<T> {
	private List<T> queue;
	private int limit;

	public MyBlockingQueue(int limit) {
		this.limit = limit;
		this.queue = new ArrayList<T>();
	}

	public synchronized void enQueue(T object) throws InterruptedException {
		if (this.queue.size() == this.limit) {
			wait();
		}
		if (queue.isEmpty()) {
			notifyAll();
		}
		System.out.println("Produced: " + object);
		queue.add(object);
	}

	public synchronized T deQueue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		return this.queue.remove(0);
	}
}
