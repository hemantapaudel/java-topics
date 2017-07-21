package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If a class implements serializable then all its sub classes will also be serializable.
 * 
 * if sub class only implements Serializable interface then only sub class attributes get serialized
 * 
 */
class Person  implements Serializable{

	private static final long serialVersionUID = -6013639794761370516L;

	private int id;
	private String name;
	public int myid=0;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Person(){
		
	}

	@Override
	public String toString() {
		return " Id = "+id +" name = "+name;
	}
}

class Student extends Person  {
	private static final long serialVersionUID = 8966025650788302807L;
	private String course;
	private int fee;
	public int myid=1;

	public Student(int id, String name, String course, int fee) {
		super(id, name);
		this.course = course;
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return super.toString() +" course == "+ course +"  fee = "+fee;
	}
	
}

public class SerializationIsARelationExample {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		Student student = new Student(10, "hemanta", "IT", 1000);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("student.txt"))) {
			out.writeObject(student);
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"student.txt"))) {
			System.out.println("reading");
			Student student2 = (Student) in.readObject();
			System.out.println(student2);

		}
	}
}
