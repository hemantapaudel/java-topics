package com.multithreadexample.thread;
/**
 * he Garbage collector of JVM collects only those objects that are created by
 * new keyword. So if you have created any object without new, you can use
 * finalize method to perform cleanup processing (destroying remaining objects
 * 
 * Garbage collection is performed by a daemon thread called Garbage
 * Collector(GC). This thread calls the finalize() method before object is
 * garbage collected.
 *
 */
public class ThreadExample9 {
	private String message;
	public ThreadExample9(String msg) {
		this.message=msg;
	}
	public void finalize() {
		System.out.println("object is garbage collected where message = "+message);
		this.message =null;
		this.message=null;
	}
	public void test(){
		
	}

	public static void main(String args[]) {
		ThreadExample9 s1 = new ThreadExample9("test1");
		ThreadExample9 s2 = new ThreadExample9("test2");
		s1.test();
		s2.test();
		s1 = null;
		s2 = null;
		System.gc();
	}
}
