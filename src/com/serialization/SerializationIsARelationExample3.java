package com.serialization;

import java.io.IOException;
import java.io.Serializable;

import com.serialization.utils.SerializationUtils;

/**
 * Base class is not serializable and don't have default constructor
 */
class A{
	private int id;
	public A(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}
}

class B extends A implements Serializable{
	private static final long serialVersionUID = -385697634604341696L;
	public B(int id) {
		super(id);
		System.out.println(" calling base class constructor");
	}	
}

public class SerializationIsARelationExample3 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		B b = new B(10);
		SerializationUtils.serializedAndDeserialized(b, "test123.txt");
	}
}
