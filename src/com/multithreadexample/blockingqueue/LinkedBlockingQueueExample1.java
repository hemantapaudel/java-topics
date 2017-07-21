package com.multithreadexample.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes). 
 * This linked structure can optionally have an upper bound if desired. 
 * If no upper bound is specified, Integer.MAX_VALUE is used as the upper bound.
 */
public class LinkedBlockingQueueExample1 {

	public static void main(String[] args) throws InterruptedException {
		//BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
		BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);

		bounded.put("Value");
		String value = bounded.take();
		System.out.println(value);
	}
}
