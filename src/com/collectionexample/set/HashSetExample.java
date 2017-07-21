package com.collectionexample.set;

import java.util.*;  

class Book {
	private int id;
	private String name, author, publisher;
	private int quantity;

	public Book(int id, String name, String author, String publisher,
			int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return id+" "+name+" "+author+" "+publisher+" "+quantity;
	}
	
	
}  
public class HashSetExample {  
public static void main(String[] args) {  
	
    HashSet<Book> set=new HashSet<Book>();  
    //Creating Books  
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);     
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6); 
    Book b4=new Book(103,"Operating System","Galvin","Wiley",6); 
    
    //Adding Books to HashSet  
    set.add(b1);  
    set.add(b2);  
    set.add(b3);
    set.add(b4);
    set.add(b1);
    
    
    for(Book book:set){  
    System.out.println(book);  
    } 
}  
}  
