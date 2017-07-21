package com.multithreadexample.thread;
import static java.lang.Thread.currentThread;
import java.util.concurrent.TimeUnit;

/**
 * How to stop thread on java ???
 * 
 * You can stop a thread by using a boolean volatile variable.
 *
 */
public class ThreadExample11 {
	public static void main(String[] args) throws InterruptedException {
		Server myServer = new Server(); 
		Thread t1 = new Thread(myServer, "T1"); 
		t1.start();
		//Now, let's stop our Server thread 
		System.out.println(currentThread().getName() + " is stopping Server thread"); 
		myServer.stop(); 
		TimeUnit.MILLISECONDS.sleep(200);
		System.out.println(currentThread().getName() + " is finished now");
		

	}

}

class Server implements Runnable {
	private volatile boolean exit = false;
	public void run() {
		while (!exit) {
			System.out.println("Server is running.....");
		}
		System.out.println("Server is stopped....");
	}

	public void stop() {
		exit = true;
	}
}
