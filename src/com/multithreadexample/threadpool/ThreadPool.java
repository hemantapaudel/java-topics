package com.multithreadexample.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	
	private LinkedBlockingQueue<Runnable> taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
   // private boolean isStopped = false;
    
    public ThreadPool(int noOfThreads, int maxNoOfTasks){
    	taskQueue = new LinkedBlockingQueue<Runnable>(maxNoOfTasks);
    	// create N number of thread
    	for(int i=0;i<noOfThreads ;i++){
    		 threads.add(new PoolThread(taskQueue));
    	}
    	// start all threads
    	threads.stream().forEach((t)->t.start());
    }
    
    public synchronized void  execute(Runnable task) throws Exception{
        
    	//if(this.isStopped) throw  new IllegalStateException("ThreadPool is stopped");
        
        this.taskQueue.put(task);
    }
    
    public synchronized void stop(){
    	while(!taskQueue.isEmpty()){
    		try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
       // this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }
    
    
    
}
