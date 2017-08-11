package com.cache;

public interface Cacheable<T,U> {

  public boolean isExpired();
  
  public U getIdentifier();
	
}
