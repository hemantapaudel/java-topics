package com.multithreadexample.locking;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class FairLockExample {

	public static void main(String[] args) {
		FairCounter counter = new FairCounter();
		Runnable runnable = () -> {
			IntStream.rangeClosed(1, 100).forEach((i) -> {
					counter.inc();
			});
		};
		
		
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

class FairCounter {
	private java.util.concurrent.locks.Lock lock = new ReentrantLock(Boolean.TRUE);
	private int count = 0;

	public int inc() {
		int newCount = count;
		lock.lock();
		newCount = ++count;
		System.out.println("Thread "+Thread.currentThread().getName()+"  " +newCount);
		lock.unlock();
		return newCount;
	}
}

