package com.multithreadexample.blockingqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 
 * The DelayQueue blocks the elements internally until a certain delay has
 * expired. The elements must implement the interface
 * java.util.concurrent.Delayed.
 * 
 */

class DelayObject implements Delayed {
	private String data;
	private long startTime;

	public DelayObject(String data, long delay) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delay;
	}
	@Override
	public int compareTo(Delayed o) {
		if (this.startTime < ((DelayObject) o).startTime) {
			return -1;
		}
		if (this.startTime > ((DelayObject) o).startTime) {
			return 1;
		}
		return 0;

	}
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	@Override
	public String toString() {
		return "{ data='" + data + '\'' + ", startTime=" + startTime +'}';
	}
}

public class DelayQueueExample1 {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Delayed> queue = new DelayQueue<Delayed>();

		// create delayed object and put into the deleyed queue
		final Random random = new Random();
		int delay = random.nextInt(10000);
		DelayObject object = new DelayObject(UUID.randomUUID().toString(), delay);
		queue.put(object);

		 DelayObject object2 = (DelayObject) queue.take();
		 System.out.println(object2);
		 System.out.println(System.currentTimeMillis());
	}
}
