package com.multithreadexample.semaphore;
import java.util.concurrent.Semaphore;


/**
 * Counting Semaphore in Java maintains specified number of pass or permits,
 *  In order to access a shared resource
 * 
 * a Counting semaphore with one permit is known as binary semaphore because it has only two state permit 
 * available or permit unavailable 
 *
 *    =====Some Scenario where Semaphore can be used:
 * 1) To implement better Database connection pool which will block if no more connection is available
 *  instead of failing and hand over Connection as soon as its available.
 *
 * 2) To put a bound on collection classes. by using semaphore you can implement bounded collection 
 * whose bound is specified by counting semaphore.
 */
public class SimaphoreExample1 {
	
	Semaphore binary = new Semaphore(1);
	private void mutualExclusion() {
        try {
            binary.acquire();
            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    } 
  	
	
	public static void main(String[] args) {
		SimaphoreExample1 semaphoreExample = new SimaphoreExample1();  
		
		Runnable runnable = ()->semaphoreExample.mutualExclusion();
		
		Thread test1 = new Thread(runnable,"Thread A");
		Thread test2 = new Thread(runnable,"Thread B");
		Thread test3 = new Thread(runnable,"Thread C");
		
		test1.start();
		test2.start();
		test3.start();
	}
}
