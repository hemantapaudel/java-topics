package com.multithreadexample.threadpool;

import java.util.stream.IntStream;

import com.multithreadexample.thread.ThreadUtil;

public class ThreadPoolExample1 {
	public static void main(String[] args) {
		
		Runnable runnable = ()->{
			System.out.println(Thread.currentThread().getName() +" is started");
			ThreadUtil.sleep(2000);
			System.out.println(Thread.currentThread().getName() +" is completed");
		};
		
		
		ThreadPool threadPool = new ThreadPool(5, 10);
		
		IntStream.rangeClosed(1, 10)
		.forEach((i)->{
			try {
				threadPool.execute(runnable);
			} catch (Exception e) {
			}
		});
			
		threadPool.stop();
	}
}
