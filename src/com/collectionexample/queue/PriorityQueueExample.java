package com.collectionexample.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		
		return id + " " + name + " " +author + " "
				+ publisher + " " + quantity;
	}
}

public class PriorityQueueExample {

	public static void main(String[] args) {
		
		Comparator<Book> comparator = ( b1,  b2) ->{
				if (b1.getId() > b2.getId()) {
					return 1;
				} else {
					return -1;
				} 
			};
		Queue<Book> queue = new PriorityQueue<Book>(comparator);
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);
		// Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		System.out.println("Traversing the queue elements:");
		// Traversing queue elements
		for (Book b : queue) {
			System.out.println(b);
		}
		queue.remove(); // remove from queue base on priority
		System.out.println("After removing one book record:");
		for (Book b : queue) {
			System.out.println(b);
		}
		
		queue.remove();
		System.out.println("After removing one book record:");
		for (Book b : queue) {
			System.out.println(b);
		}
	}
}
