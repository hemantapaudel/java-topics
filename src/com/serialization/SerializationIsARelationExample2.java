package com.serialization;

import java.io.IOException;
import java.io.Serializable;

import com.serialization.utils.SerializationUtils;

/**
 * 
 * Base class is not serialized but it default constructor is call while de-serialized 
 */
class Base{
	int BASE_CLASS_ID =10;
}
class Derived extends Base implements Serializable{

	private static final long serialVersionUID = 4733367101415610085L;

	int DERIVED_CLASS_X = 20;
}


public class SerializationIsARelationExample2 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Derived derived = new Derived();
		Derived deSerializedObject = (Derived)SerializationUtils.serializedAndDeserialized(derived, "test123.txt");

		System.out.println(deSerializedObject.BASE_CLASS_ID);
		System.out.println(deSerializedObject.DERIVED_CLASS_X);
		
	}

}
