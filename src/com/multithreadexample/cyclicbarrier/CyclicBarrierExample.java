package com.multithreadexample.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.multithreadexample.thread.ThreadUtil;

class Task implements Runnable{
	private int sleepTime;
	private CyclicBarrier barrier;
	public Task(CyclicBarrier barrier,int sleepTime) {
        this.barrier = barrier;
        this.sleepTime=sleepTime;
    }
	
	@Override
    public void run() {
        try {
        	ThreadUtil.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException | BrokenBarrierException ex) {
        } 
    }
}

/**
 * When to use CyclicBarrier in Java
 * 
 * 1) To implement multi player game which can not begin until all player has joined.
 * 2) Perform lengthy calculation by breaking it into smaller individual tasks,
 *  In general, to implement Map reduce technique.
 *
 */
public class CyclicBarrierExample {
	public static void main(String[] args) throws InterruptedException {
		
		//creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run(){
               //This task will be executed once all thread reaches barrier
               System.out.println("All parties are arrived at barrier, lets play");
            }
        });
		
		//starting each of thread
        Thread t1 = new Thread(new Task(cb,1000), "Thread 1");
        Thread t2 = new Thread(new Task(cb,1000), "Thread 2");
        Thread t3 = new Thread(new Task(cb,1000), "Thread 3");
        Thread t4 = new Thread(new Task(cb,1000), "Thread 4");
        Thread t5 = new Thread(new Task(cb,1000), "Thread 5");
        Thread t6 = new Thread(new Task(cb,1000), "Thread 6");

       
        t1.start();
        t2.start();
        t3.start();
       // t3.join();
        //System.out.println("==================");
        cb.reset();
       

        t4.start();
        t5.start();
        t6.start();
        
        
	 
	}
}
