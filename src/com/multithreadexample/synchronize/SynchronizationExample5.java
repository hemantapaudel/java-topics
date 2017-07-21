package com.multithreadexample.synchronize;


/**
 * 
 *  the situation where two threads compete for the same resource, where the sequence 
 *  in which the resource is accessed is significant, is called race conditions.
 *   A code section that leads to race conditions is called a critical section
 *
 */
public class SynchronizationExample5 {
	public static void main(String[] args) {

		TwoSums twoSums = new TwoSums();
		Runnable runnable =()->twoSums.add(10, 20);
		Runnable runnable1 =()->twoSums.add(15, 50);
		
		Thread test1 = new Thread(runnable);
		Thread test2 = new Thread(runnable1);
		
		test1.start();
		test2.start();
	}
}

class TwoSums {
    private int sum1 = 0;
    private int sum2 = 0;
    
    private Integer sum1Lock = new Integer(1);
    private Integer sum2Lock = new Integer(2);

    public void add(int val1, int val2){
    	// this two line of code is critical section, where both line of code are independent so we 
    	//can put multiple synchronized block
        synchronized(this.sum1Lock){
            this.sum1 += val1;   
        }
        synchronized(this.sum2Lock){
            this.sum2 += val2;
        }
        System.out.println(" sum 1: "+sum1 +" sum 2: "+sum2);
    }
}