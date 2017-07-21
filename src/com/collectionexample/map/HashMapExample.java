package com.collectionexample.map;

import java.util.HashMap;
import java.util.Map;

import com.collectionexample.model.Employee;


public class HashMapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		for (Map.Entry<Integer,String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		//Q1. what happen if we change the field on same reference 
		// unexpected result can happen
		Employee employee = new Employee("hemanta","paudel");
		Map<Employee, String> empMap = new HashMap<Employee, String>();
		empMap.put(employee, "data1");
		employee.setFirstName("basant");
		empMap.put(employee, "data2");
		System.out.println(empMap.size());
		System.out.println(empMap.get(new Employee("hemanta", "paudel")));
		System.out.println(empMap.get(new Employee("basant", "paudel")));
		
		
		// what happen if we change reference type but same object
		// it will override
		Map<Object, String> objectMap = new HashMap<Object, String>();
		
		Object obj1 = new Object();
		Object obj2 = obj1;
		
		objectMap.put(obj1, "First");
		objectMap.put(obj2, "Second");
		
		System.out.println("object refence change example");
		System.out.println(objectMap.get(obj1));
		System.out.println(objectMap.get(obj2));
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
