package com.garbagecollection;

class Student {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Student.finalize() called");
	}
	@Override
	public String toString() {
		return "name : "+name;
	}

}

public class GarbageCollectionExample {
	public static void main(String[] args) {
		// created object on YOUNG generation(Edrn) area of the heap
		Student student = new Student();
		student.setName("Hemanta");

		// enable student object for garbage collect
		System.out.println(student);
		student = null;
		// requesting to jvm for garbage collection
		System.gc();
    	Runtime.getRuntime().gc();

	}

}
