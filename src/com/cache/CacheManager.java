package com.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.stream.Collectors.toSet;

//this cache only store 50 items and delete all those object which has expried
public class CacheManager {
	
	private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private static Map<String,Cacheable<Object,String> > cacheHashMap = new LinkedHashMap<String,Cacheable<Object,String>>(){
		private static final long serialVersionUID = 1L;
		@Override
		protected boolean removeEldestEntry(
				java.util.Map.Entry<String, Cacheable<Object, String>> eldest) {
			System.out.println(" eldest element ::"+eldest.getKey());
			return this.size()>50;
		}
	};
	
	static{
		final int milliSecondSleepTime = 5000;
		Runnable runnable = ()->{
			try{
				while (true) {
					deleteExpiredObjects();
					Thread.sleep(milliSecondSleepTime);
				}
			}catch(Exception e){
				 e.printStackTrace();
			}
		};		
		Thread threadCleanerUpper = new Thread(runnable);
		threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
		threadCleanerUpper.start();
		
	}

	private static void deleteExpiredObjects() {
		System.out.println("Delete Expired Items");
		Set<Entry<String, Cacheable<Object, String>>> keySet = cacheHashMap.entrySet();
		
		Set <String > expiredKeys = keySet.stream()
					.filter(entry -> entry.getValue().isExpired())
					.map(entry -> entry.getKey())
					.collect(toSet());
		
		readWriteLock.writeLock().lock();
		for(String key : expiredKeys){
			cacheHashMap.remove(key);
		}
		readWriteLock.writeLock().unlock();
		
	}
	
	

	public static void put(String identifier, Object dataObject) {
		CachedObject<Object, String> cacheableObject = new CachedObject<Object, String>(
				dataObject, identifier, 1);

		readWriteLock.writeLock().lock();
		cacheHashMap.put(identifier, cacheableObject);
		readWriteLock.writeLock().unlock();

	}
	
	public static Object getCache(String identifier) {
		readWriteLock.readLock().lock();
		Cacheable<Object, String> object = cacheHashMap.get(identifier);
		readWriteLock.readLock().unlock();
		if (object == null) {
			return null;
		}
		if (object.isExpired()) {
			readWriteLock.writeLock().lock();
			cacheHashMap.remove(identifier);
			readWriteLock.writeLock().unlock();
			return null;
		}
		return ((CachedObject<Object, String>) object).getDataObject();
	}
	
	
} 
