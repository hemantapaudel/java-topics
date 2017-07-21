package com.multithreadexample.synchronize;
import com.multithreadexample.thread.ThreadUtil;


/**
 * If you make any static method as synchronized, the lock will be on the class not on object.
 * 
 *
 */
public class SynchronizationExample3 {

	public static void main(String[] args) {

		PrintTable table1 = new PrintTable();
		PrintTable table2 = new PrintTable();
		
		
		Thread t1 = new Thread(()->table1.printTable(10));
		Thread t2 = new Thread(()->table1.printTable(100));
		
		Thread t3 = new Thread(()->table2.printTable(700));
		Thread t4 = new Thread(()->table2.printTable(1000));
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}

class PrintTable{
	
	/**
	 * 
	 *  To block all other thread even they used separate object, we need to used static level  synchronized
	 * we can do static level synchronized by below methods,
	 * 
	 * 1. make the synchronized method as static method
	 * 2. add Synchronized block on a class lock
	 **/
	
	 void printTable(int n){  
		 synchronized(PrintTable.class){
		     for(int i=1;i<=5;i++){  
		      System.out.println(n*i);  
		      ThreadUtil.sleep(400);  
		     }  
		   }    
	 }
}