package com.multithreadexample.synchronize;
import com.multithreadexample.thread.ThreadUtil;


/**
 * Inter-thread communication of thread
 *
 */

class Account{
	int currentBalance=1000;
	
	public synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");  
		if(currentBalance<amount){
			System.out.println("Less balance; waiting for deposit...");  
			ThreadUtil.waiting(this);
		}
		currentBalance -= amount;
		System.out.println("withdraw completed..."); 
	}
	
	public synchronized void deposite(int amount) {
		System.out.println("going to deposite...");  
		currentBalance += amount;
		System.out.println("deposite completed..."); 
		notify();
	}
	
}

public class SynchronizationExample4 {
	public static void main(String[] args) throws InterruptedException {
		// create account with 1000 balance
		Account account = new Account();
		
		Runnable runnable = ()->account.withdraw(1200);
		Runnable runnable1 = ()->account.deposite(300);
		

		Thread t1 = new Thread(runnable);
		t1.start();
		
		
		Thread t2 = new Thread(runnable1);
		t2.start();
		

	}
}
