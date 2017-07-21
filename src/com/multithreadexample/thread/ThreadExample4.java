package com.multithreadexample.thread;
/**
 * 
 * The join() method waits for a thread to die. In other words, 
 * it causes the currently running threads to stop executing until the thread it joins with completes its task.
 *
 */
public class ThreadExample4 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("started main thread");
		Runnable testJoinThread = ()->{
			
				ThreadUtil.sleep(4000);
				System.out.println("Thread name:"+ Thread.currentThread().getName() );  
			
		};
		
		Thread test1 = new Thread(testJoinThread);
		Thread test2 = new Thread(testJoinThread);
		Thread test3 = new Thread(testJoinThread);
		
		test1.start();
		test1.join();
		test2.start();
		test2.join();
		test3.start();
		
		
	}

}
