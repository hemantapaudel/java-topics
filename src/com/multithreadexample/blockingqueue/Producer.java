package com.multithreadexample.blockingqueue;

import java.util.concurrent.BlockingQueue;

import com.multithreadexample.thread.ThreadUtil;

public class Producer implements Runnable {
	protected BlockingQueue<String> queue = null;
    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
            try {
				queue.put("1");
				ThreadUtil.sleep(1000);
	            queue.put("2");
	            ThreadUtil.sleep(1000);
	            queue.put("3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        
    }

}
