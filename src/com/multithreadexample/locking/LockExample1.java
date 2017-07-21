package com.multithreadexample.locking;
import java.util.stream.IntStream;

/**
 * 
 * writing critical section code using lock mechanism
 */
class Counter {
	private Lock lock = new Lock();
	private int count = 0;

	public int inc()  {
		int newCount =count;
		try {
			lock.lock();
			newCount  = ++count;
			System.out.println(newCount);
		} catch (InterruptedException e) {
		}finally{
			lock.unlock();
		}
		return newCount;
	}
}

/**
 * simple lock implementation
 */
class Lock {
	private boolean isLocked = false;
	private Thread lockedBy =null;
	private int lockedCount =0;
	public synchronized void lock() throws InterruptedException {
		Thread  callingThread = Thread.currentThread();
		while (isLocked   && callingThread != lockedBy) {
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
	}

	public synchronized void unlock() {
		if(Thread.currentThread() == lockedBy){
			lockedCount--;
			if(lockedCount==0){
				isLocked = false;
				notify();
			}
		}
		
	}
}

public class LockExample1 {
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
