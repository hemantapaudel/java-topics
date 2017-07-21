package com.collectionexample.linkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();
		  list.add("Ravi"); 
		  list.add("Vijay");  
		  list.add("Ravi");  
		  list.add("Ajay");  
		  
		  Iterator<String> iterator=list.iterator();  
		  while(iterator.hasNext()){  
		   System.out.println(iterator.next());  
		  }  

		  // create two iterator 
		  Iterator<String> iterator1 =list.iterator();  
		  Iterator<String> iterator2 =list.iterator();  
		  // iterate first element from both iterator
		  System.out.println(iterator1.next());
		  System.out.println(iterator2.next());
		  //remove first element from first iterator
		  iterator1.remove();
		  System.out.println(iterator2.hasNext());
		  //iterate second element from second iterator, which cause the ConcurrentModificationException 
		  System.out.println(iterator2.next());
		  
		  //Note the Iterator maintain the  int expectedModCount = modCount, when we create the iterator.
		  // whenever we call remove() method it increase the modCount variable and
		  // when next() method call java check the modification count.
		  
		  /*
		   *final void checkForComodification() {
	       *     if (modCount != expectedModCount)
	       *        throw new ConcurrentModificationException();
	       * }
	       *
	       **/
		  
	}

}
