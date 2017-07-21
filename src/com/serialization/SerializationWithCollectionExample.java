package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * In case of array or collection, all the objects of array or collection must be serializable.
 * If any object is not serialiizable, serialization will be failed.
 *
 */
public class SerializationWithCollectionExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// Address should be serializable
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address("yerwada", "pune", "MR"));
		addresses.add(new Address("viman nagar", "pune", "MR"));
		addresses.add(new Address("kharadi", "pune", "MR"));
		addresses.add(new Address("hinjawadi", "pune", "MR"));
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("addresses.txt"))){
			out.writeObject(addresses);
		}
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("addresses.txt"))){		 
		 @SuppressWarnings("unchecked")
		 List<Address> addresses2 = (List<Address>)in.readObject();
		 addresses2.forEach(address->System.out.println(address));			
		}
		
	}

}
