package com.multithreadexample.immutable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 1. class should be final
 * 2. all field should be private and final
 *  1. Avoid setter method
 *  2. do not return actual ref type
 *  3. if there is any modifying method exist, it should not modify actual object, it should return new immutable 
 *  object with modified data 
 */
final class Person{
	private final String name;
	private final Date birthday; 
	private final List<String> hobbies; 
	public Person(String name, Date birthday, List<String> hobbies){
		this.name = name; 
		this.birthday = birthday;
		this.hobbies = hobbies;
		} 
	public String getName() { return name; }
	
	public Date getBirthday() {
		return (Date) birthday.clone(); } 
	public List<String> getHobbies() {
		return Collections.unmodifiableList(hobbies); } 
	@Override 
	public String toString() { 
		return "Person [name=" + name + ", birthday=" + birthday + ", hobbies=" + hobbies + "]"; 
		}
}


public class ImutableExample {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); 
		cal.set(1982, 4, 21); 
		Date birthDate = cal.getTime(); 
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Painting"); hobbies.add("Travelling"); 
		hobbies.add("Fitness"); 
		Person robin = new Person("Robin", birthDate, hobbies); 
		System.out.println("Before"); 
		System.out.println(robin); 
		// if it's immutable you can't change the object 
		Date birthday = robin.getBirthday(); 
		birthday.setTime(System.currentTimeMillis()); 
		List<String> originalHobbies = robin.getHobbies(); 
		originalHobbies.remove(0);
		originalHobbies.remove(0); 
		System.out.println("After");
		System.out.println(robin); 
	}

}
