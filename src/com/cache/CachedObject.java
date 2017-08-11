package com.cache;

import java.time.LocalDateTime;

public class CachedObject<T,U> implements Cacheable<T, U> {

	private LocalDateTime dateofExpiration = null;
    private U identifier = null;
    public T dataObject = null;
    
    
    public T getDataObject() {
		return dataObject;
	}
    
    public CachedObject(T dataObject, U id, int minutesToLive){
    	 this.dataObject = dataObject;
         this.identifier = id;
         if (minutesToLive > 0){
        	 dateofExpiration = LocalDateTime.now();
        	 dateofExpiration = dateofExpiration.plusMinutes(minutesToLive);
         }   
    }
    
	@Override
	public boolean isExpired() {
	   	if(dateofExpiration == null){
	   		return false;
	   	}
	   	if(dateofExpiration.isBefore(LocalDateTime.now())){
	   		System.out.println("expired");
	   		return true;
	   	}
	   	return false;
	}

	@Override
	public U getIdentifier() {
		return identifier;
	}

}
