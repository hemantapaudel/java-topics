package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If a class has a reference of another class, all the references must be
 * Serializable otherwise serialization process will not be performed. In such
 * case, NotSerializableException is thrown at runtime.
 *
 */
class Address implements Serializable{
	
	private static final long serialVersionUID = 7190807191034712110L;
	
	private String addressLine, city, state;

	public Address(String addressLine, String city, String state) {
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return ", addressLine = " + addressLine + ", city = " + city + ", state "
				+ state;
	}
}

class Worker implements Serializable {
	
	private static final long serialVersionUID = 2363324695532070480L;
	
	private int id;
	private String name;
	private Address address;// HAS-A

	public Worker(int id, String name,Address address) {
		this.id = id;
		this.name = name;
		this.address=address;
	}

	@Override
	public String toString() {
		return " id = " + id + ", name = " + name + ", address " + address;
	}
}

public class SerializationWithAggregation {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Address address = new Address("yerwada-jail road", "pune", "UP");
		Worker worker = new Worker(10, "hemanta",address);
		
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("worker.txt"))) {
			out.writeObject(worker);
		}
		System.out.println("=========reading==========");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("worker.txt"))) {
			Worker worker2 = (Worker) in.readObject();
			System.out.println(worker2);
		}
	}
}
