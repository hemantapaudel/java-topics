package com.collectionexample.model;

public class Employee {

	String firstName;
	String lastName;
	
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee)obj;
		
		if( this == obj){
			return true;
		}
		return firstName.equals(emp.firstName) && lastName.equals(emp.lastName);
	}
	
	@Override
	public int hashCode() {	
			return firstName.hashCode()+ lastName.hashCode();
	}
	
	
}
