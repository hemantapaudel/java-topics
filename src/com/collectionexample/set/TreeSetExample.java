package com.collectionexample.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
public class TreeSetExample {
	public static void main(String[] args) {
		Comparator<Student> rollComparator = (s1,s2)-> s1.roll-s2.roll;
		Comparator<Student> nameComparator = (s1,s2)-> s1.name.compareTo(s2.name);
		Student s1 = new Student(20, "ABC");
		Student s2 = new Student(10, "ADF");
		Student s3 = new Student(15, "AAA");
		Student s4 = new Student(16, "DFR");
	
		
		System.out.println("Tree set with roll comparator ");
		Set<Student> set = new TreeSet<Student>(rollComparator);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("Tree set with name comparator");
		Set<Student> set2 = new TreeSet<Student>(nameComparator);
		set2.add(s1);
		set2.add(s2);
		set2.add(s3);
		set2.add(s4);
		
		Iterator<Student> iterator2 = set2.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}

	}

}
