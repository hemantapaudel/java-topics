package com.multithreadexample.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class PoolThread extends Thread{

	 private LinkedBlockingQueue<Runnable> taskQueue = null;
	 private boolean       isStopped = false;
	 public PoolThread(LinkedBlockingQueue<Runnable> queue){
		 this.taskQueue=queue;
	 }
	 
	 @Override
	public void run() {
		while(!isStopped){
			try {
				Runnable runnable = taskQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
			}
		}
	}
	 
	 public synchronized void doStop(){
	        isStopped = true;
	       // this.interrupt(); //break pool thread out of dequeue() call.
	    }

	    public synchronized boolean isStopped(){
	        return isStopped;
	    }
}
