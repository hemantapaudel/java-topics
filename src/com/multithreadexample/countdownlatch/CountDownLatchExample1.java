package com.multithreadexample.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch in Java is a kind of synchronizer which allows one Thread  to wait for one or more Threads 
 * before starts processing. CountDownLatch is useful if you want to start main processing thread once its 
 * dependency is completed.
 *
 *In following CountDownLatch example, Java program requires 3 services namely CacheService, AlertService 
 * and ValidationService  to be started and ready before application can handle any request and 
 * this is achieved by using CountDownLatch in Java.
 *
 *One of the disadvantage of CountDownLatch is that its not reusable once count reaches to zero 
 *you can not use CountDownLatch any more
 *
 */
public class CountDownLatchExample1 {
	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch latch = new CountDownLatch(3);
	
		Thread cacheService  = new Thread(new Service("Cache Service", 1000, latch));
		Thread alertService  = new Thread(new Service("Alert Service", 2000, latch));
		Thread validationService  = new Thread(new Service("Validation Service", 3000, latch));

		cacheService.start(); 
	    alertService.start(); 
	    validationService.start();
	    System.out.println("All three service are request to start");
	    latch.await();  //main thread is waiting on CountDownLatch to finish
        System.out.println("All services are up, Application is starting now");
	}
}


/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
  
    public Service(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }
    @Override
    public void run() {
            try {
				Thread.sleep(timeToStart);
			} catch (InterruptedException e) {
			}       
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }  
}

