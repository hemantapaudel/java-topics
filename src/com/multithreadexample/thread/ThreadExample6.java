package com.multithreadexample.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class WorkerThread implements Runnable {
	private String message;

	public WorkerThread(String s) {
		this.message = s;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " (Start) message = " + message);
		processmessage();
		System.out.println(Thread.currentThread().getName() + " (End)");
	}

	private void processmessage() {
		ThreadUtil.sleep(2000);
	}
}

public class ThreadExample6 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		IntStream.rangeClosed(1, 10).forEach((i) -> {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		});
		executor.shutdown();
		Runnable worker = new WorkerThread("" + 11);
		executor.execute(worker);
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
