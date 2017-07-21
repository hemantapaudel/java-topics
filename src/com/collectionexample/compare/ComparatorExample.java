package com.collectionexample.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	private int id;
	private String name;
	private int age;

	Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return id + " " + name + " " + age;
	}
}

/**
 * Note : Arrays.sort  is using quick sort
 *
 */
public class ComparatorExample {
	public static void main(String[] args) {

		Comparator<Employee> ageComparator = (e1, e2) -> {
			if (e1.getAge() == e2.getAge())
				return 0;
			else if (e1.getAge() > e2.getAge())
				return 1;
			else
				return -1;
		};
		        
		Comparator<Employee> nameComparator = (e1, e2) -> {
			return e1.getName().compareTo(e2.getName());
		};
		
		
		List<Employee> al=new ArrayList<>();  
		al.add(new Employee(101,"Vijay",23));  
		al.add(new Employee(106,"Ajay",27));  
		al.add(new Employee(105,"Jai",21));  
		  
		System.out.println("Sorting by Name...");  		  
		Collections.sort(al,nameComparator); 
		al.forEach(System.out::println);
		
		System.out.println("Sorting by age...");  		  
		Collections.sort(al,ageComparator); 
		al.forEach(System.out::println);
		
		
		
		
		
		
	}

}
