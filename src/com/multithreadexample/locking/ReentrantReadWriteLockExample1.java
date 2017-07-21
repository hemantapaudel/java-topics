package com.multithreadexample.locking;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.multithreadexample.thread.ThreadUtil;



/**
 * A java.util.concurrent.locks.ReadWriteLock is an advanced thread lock mechanism.
 * It allows multiple threads to read a certain resource, but only one to write it, at a time.
 * 
 *
 */
public class ReentrantReadWriteLockExample1 {
	public static void main(String[] args) {

		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Runnable runnable = ()->{
			// all thread will enter at a time
			readWriteLock.readLock().lock();
			System.out.println("Thread readLock ="+Thread.currentThread().getName());
			readWriteLock.readLock().unlock();
			
			System.out.println("waiting for  writelock ="+Thread.currentThread().getName());
			// only one thread will enter
			readWriteLock.writeLock().lock();
			System.out.println("Thread writelock ="+Thread.currentThread().getName());
			ThreadUtil.sleep(1000);
			readWriteLock.writeLock().unlock();
			
			// thread only enter if there is not thread locked or waiting for write lock
			readWriteLock.readLock().lock();
			System.out.println("====re-entered Thread readLock ="+Thread.currentThread().getName());
			readWriteLock.readLock().unlock();
			
		};
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
