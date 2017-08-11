package com.cache;

import com.multithreadexample.thread.ThreadUtil;

public class LRUCacheManagerTest {

	public static void main(String[] args) {
			
		Runnable produce = ()->{
			String str ="Hemanta";
			String key ="name";
			
			for(int i =0; i<100; i++){
				ThreadUtil.sleep(500);
			    LRUCacheManager.put(key+i, str+i);
			}
			
		};
		
		Runnable consume = ()->{
			
			String key ="name";
			for(int i =0; i<100; i++){
				ThreadUtil.sleep(1000);
			  System.out.println(LRUCacheManager.get(key+i));
			}
			
		};
		
		
		Thread thread1 = new Thread(produce);
		Thread thread2 = new Thread(consume);
		
		thread1.start();
		thread2.start();
		
		
		
		
		
		
	}

}
