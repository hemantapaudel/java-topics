package com.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class LRUCacheManager {
	
	private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private static Map<String,Object > cacheHashMap = new LinkedHashMap<String,Object>(){
		private static final long serialVersionUID = 1L;
		 
		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<String, Object> eldest) {
			//System.out.println(this.size());
			 return size()>50?true:false;
		}
	};
	
	
	public static  void put(String identifier , Object data){
		readWriteLock.writeLock().lock();
	    cacheHashMap.put(identifier, data);
		readWriteLock.writeLock().unlock();
	}
	

	public static  Object get(String identifier){
		readWriteLock.readLock().lock();
	    Object object =cacheHashMap.get(identifier);
		readWriteLock.readLock().unlock();
		return object;
	}
	
}
	

