package com.multithreadexample;

public class InterruptExample22 {

	public static void main(String[] args) throws InterruptedException {

		/**
		 *  Case1
		 *  interrupting thread which is in sleep or wait state, then throws InterruptedException exception
		 *  
		 */
		Thread test1 = new Thread(()->{
				try {
					System.out.print("thread is going to sleep \n");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					throw new RuntimeException("Thread interrupted..."+e);  
				}
			});
		test1.start();
		test1.interrupt();
		test1.join();
		
		/**
		 *  Case2
		 *  interrupting thread which is in running state, then it will be number
		 *  
		 */
		Thread test2 = new Thread(()->{
					System.out.println(" case 2: Thread 2 is runnint");
					
					for(int i =0;i< 1000;i++){
						System.out.println(i);
					}
			});
		
		
		test2.start();
		test2.interrupt();
		System.out.println("  interrupted the thread::");
		test2.join();		
	}

}
 