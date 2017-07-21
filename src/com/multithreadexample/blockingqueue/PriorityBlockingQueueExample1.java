package com.multithreadexample.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules as the 
 * java.util.PriorityQueue class. You cannot insert null into this queue.
 * 
 * All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. 
 * The elements thus order themselves according to whatever priority you decide in your Comparable implementation.
 * 
 * 
 *  Notice that the PriorityBlockingQueue does not enforce any specific behaviour for elements that have 
 *  equal priority (compare() == 0).
 *  
 *  Also notice, that in case you obtain an Iterator from a PriorityBlockingQueue, the Iterator does not 
 *  guarantee to iterate the elements in priority order.
 */
public class PriorityBlockingQueueExample1 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Student> queue   = new PriorityBlockingQueue<Student>();

	    
	    queue.put(new Student(1,"first"));
	    queue.put(new Student(2,"second"));
	    queue.put(new Student(3,"third"));

	    System.out.println(queue.take());
	    System.out.println(queue.take());
	    System.out.println(queue.take());
	    
	}

}
@SuppressWarnings("rawtypes")
class Student implements Comparable{
	private int id;
	private String name;
	
	public Student(int id , String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Object o) {
		// who have lower id it has more priority
		   return (this.id - ((Student)o).id);
	}
	
	@Override
	public String toString() {
		 return "{ name = "+name + " Id = "+ id +" }"; 
	}
}