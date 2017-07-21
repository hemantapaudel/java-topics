package com.multithreadexample.locking;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Java Lock example
 * 
 * A java.util.concurrent.locks.Lock is a thread synchronization mechanism just like synchronized blocks. A Lock is, 
 * however, more flexible and more sophisticated than a synchronized block.
 * 
 * Main Differences Between Locks and Synchronized Blocks
 * 
 * 1. A synchronized block makes no guarantees about the sequence in which threads waiting to entering it 
 * are granted access.
 * 
 * 2. You cannot pass any parameters to the entry of a synchronized block. 
 * Thus, having a timeout trying to get access to a synchronized block is not possible.
 * 
 * 3. The synchronized block must be fully contained within a single method. A Lock can have it's calls to lock() 
 * and unlock() in separate methods.
 * 
 */
public class ReentrantLockExample1 {

	public static void main(String[] args) {
		Counter counter = new Counter();
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

/**
 * 
 * writing critical section code using lock mechanism
 */
class Counters {
	private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	private int count = 0;

	public int inc()  {
		int newCount =count;
			lock.lock();
			newCount  = ++count;
			System.out.println(newCount);
			lock.unlock();
		return newCount;
	}
	
	
	
}
