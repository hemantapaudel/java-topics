package com.collectionexample.customlist;

import java.util.Iterator;

public class CustomList<E> implements Iterable<E> {
	private int capacity;
	private int currentIndex;
	private Object[] elementData; 
	public CustomList(int size){
		elementData = new Object[size]; 
		capacity=size;
		currentIndex=0;
	}
	
	public boolean add(E e){
		if(currentIndex < capacity){
			elementData[currentIndex++]= e;
			return true;
		}
		return false;
	} 


	private class CustomIterator implements Iterator<E>{
		int cursor;
		private CustomIterator(){
			cursor=0;
		}
		
		@Override
		public boolean hasNext() {
			if(cursor <0){
				return false;
			}
			if(cursor < elementData.length){
				if(elementData[cursor] !=null){
					return true;
				}
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E)elementData[cursor++];
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new CustomIterator();
	}

}
