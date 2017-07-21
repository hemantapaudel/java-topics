package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * if any object is instance of Serializable then it can be serialize or de serialize  
 *
 */
class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String department;
	private int employeeId;
	
	public Employee(){
		System.out.println("constructor called");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Name = "+name +" department=:"+department +" employeeId = "+employeeId;
	}
}



public class SerializableExample1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		System.out.println("creating object");
		Employee employee = new Employee();
		employee.setName("employee_name");
		employee.setEmployeeId(10);
		employee.setDepartment("it");
		
		System.out.println("doing serialization process");
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"))){
			out.writeObject(employee);
		}
		System.out.println("doing de serialization process");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"))){
			System.out.println("reading");
		 Employee employee2 = (Employee)in.readObject();
		 System.out.println(employee2);
			
		}
		
	}

}
