package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * Here you can see that education’s value is saved. This value is part of an Interface. 
 * But as this is constant hence it is saved while serialization.
 *
 */
interface EducationConstant extends Serializable{
	public  final String education = "INFORMATION_TECHNOLOGY";
}


class superEmployee implements EducationConstant, Serializable{
	
	private static final long serialVersionUID = -47866602787756482L;
	//static variables are not serialized
	protected static String lastName;
	
	//Static variables  can be stored while serializing if value is provided while initialization.
	protected static  String companyName ="BARCLAYS DEVELOPMENT CENTER INDIA";
	
	//transient variable are never serialized
	protected transient  String address;
	//If variable is defined as Static and Transient both, than static modifier will govern the behavior of variable and not Transient.
	protected static transient String companyCEO;
	
	// FINAL VAIRABLE ARE ALWAYS SERIALIZED
	protected  final String GREETING_WORD ="HELLO";
	
	/**
	 *   final transient will not serialize
	 */
	protected transient final  String SUPER_CANDIDATE_NAME ="HEMANTA";
	
	}

class Workers extends superEmployee {
	 public String firstName;
	 private static final long serialVersionUID = 5462223600l;
	}

public class SerializableWithStaticAttributeExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serializedEmp();
		deserializedEmp();

	}

	private static void deserializedEmp() throws IOException,
			ClassNotFoundException, FileNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("static_test.txt"))) {
			Workers worker = (Workers) in.readObject();
			System.out.println("Deserializing Employee...");
			System.out.println("First Name of Employee: " +worker.firstName);
			System.out.println("Last Name of Employee: " + Workers.lastName);
			System.out.println("Company Name: " + Workers.companyName);
			System.out.println("Company CEO: " + Workers.companyCEO);
			System.out.println("Company Address: " + worker.address);
			System.out.println("Education: "+Workers.education);
			System.out.println("Education: "+worker.GREETING_WORD);
		}
	}

	private static void serializedEmp() throws IOException,
			FileNotFoundException {
		Workers worker = new Workers();
		worker.firstName = "Vivekanand";
		Workers.lastName = "Gautam";
		worker.address = "MUM";
		Workers.companyCEO = "ME CEO";

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("static_test.txt"))) {
			out.writeObject(worker);
		}
	}

}
