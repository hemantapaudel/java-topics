package com.multithreadexample.synchronize;
import com.multithreadexample.thread.ThreadUtil;



/**
 * 
 * Synchronized block can be used to perform synchronization on any specific resource of the method.
 * Suppose you have 50 lines of code in your method, but you want to synchronize only 5 lines, 
 * you can use synchronized block.
 * If you put all the codes of the method in the synchronized block, it will work same as the synchronized method.
 * 
 * Points to remember for Synchronized block
 * Synchronized block is used to lock an object for any shared resource.
 * Scope of synchronized block is smaller than the method.
 * 
 **/
public class SynchronizationExample2 {
	public static void main(String[] args) {
		TablePrint table = new TablePrint();
		
		Thread t1 = new Thread(()->table.printTable(10));
		Thread t2 = new Thread(()->table.printTable(20));
		
		
		t1.start();
		t2.start();
	}

}

class TablePrint{  
	  
	 void printTable(int n){  
	   synchronized(this){// acquired the lock for the share object, and will montitor till this block of code executed
	     for(int i=1;i<=5;i++){  
	      System.out.println(n*i);  
	      ThreadUtil.sleep(400);  
	     }  
	   }  
	 }//end of the method  
	}  
