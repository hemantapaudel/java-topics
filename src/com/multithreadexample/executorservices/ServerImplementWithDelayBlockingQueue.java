package com.multithreadexample.executorservices;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class Request implements Delayed {

	private String data;
	private long startTime;

	public Request(String data, long delay) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delay;
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.startTime < ((Request) o).startTime) {
			return -1;
		}
		if (this.startTime > ((Request) o).startTime) {
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
		return "data " + data + "startTime = " + startTime;
	}

}

class Task implements Runnable {

	private BlockingQueue<Request> queue;

	Task(BlockingQueue<Request> queue) {
		this.queue = queue;
	}

	public void run() {
		while (queue.size()>0) {
			try {
				System.out.println(queue.take());
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ServerImplementWithDelayBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Request> blockingQueue = new DelayQueue<Request>();
		blockingQueue.add(new Request("first ", 2000));
		blockingQueue.add(new Request("second ", 2000));
		blockingQueue.add(new Request("third ", 2000));
		blockingQueue.add(new Request("first ", 2000));
		blockingQueue.add(new Request("second ", 2000));
		blockingQueue.add(new Request("third ", 2000));
		blockingQueue.add(new Request("first ", 2000));
		blockingQueue.add(new Request("second ", 2000));
		blockingQueue.add(new Request("third ", 2000));
		blockingQueue.add(new Request("first ", 2000));
		blockingQueue.add(new Request("second ", 2000));
		blockingQueue.add(new Request("third ", 2000));

		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		for(int i =0; i < 20;i++){
			executorService.submit(new Task(blockingQueue));
		}
		executorService.shutdown();
		
		
		
		
		
	}

}
