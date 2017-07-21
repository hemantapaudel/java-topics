package com.collectionexample.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;



class Student {
	int roll;
	String name;
	Student(int roll, String name){
		this.roll=roll;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Roll = "+ roll +" name "+name;
	}
}

public class TreeMapExample {
	public static void main(String[] args) {
		System.out.println("the primitive or wrapper class are already");
		TreeMap<Integer, String> hm = new TreeMap<Integer, String>();
		hm.put(100, "Amit");
		hm.put(102, "Ravi");
		hm.put(101, "Vijay");
		hm.put(103, "Rahul");
		for (Map.Entry<Integer, String> m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println("sorting custom class using by creating treeMap with comparator");
		Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);
		TreeMap<Student, String> treeMap = new TreeMap<Student, String>(nameComparator);
		Student s1 = new Student(20, "ABC");
		Student s2 = new Student(10, "ADF");
		Student s3 = new Student(15, "AAA");
		Student s4 = new Student(16, "DFR");

		treeMap.put(s1, "Amit");
		treeMap.put(s2, "Ravi");
		treeMap.put(s3, "Vijay");
		treeMap.put(s4, "Rahul");
		for (Map.Entry<Student, String> m : treeMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}

}
