package com.serialization.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class SerializationUtils{

	public static  Object serializedAndDeserialized(Object object,String fileName) throws IOException, ClassNotFoundException{
		System.out.println("doing serialization process");
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(object);
		}
		System.out.println("doing de serialization process");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			System.out.println("reading");
		 return in.readObject();
		}
	}
		
	
	
}
