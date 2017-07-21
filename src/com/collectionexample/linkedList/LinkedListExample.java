package com.collectionexample.linkedList;

import java.util.LinkedList;
import java.util.List;

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
		return id + " " + name + " " + author + " " + publisher + " "
				+ quantity;
	}
}

public class LinkedListExample {
	public static void main(String[] args) {
		// Creating list of Books
		List<Book> list = new LinkedList<Book>();
		// Creating Books
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan","Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Books to list
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.forEach((s)->System.out.println(s));
		
		
		
	}

}
