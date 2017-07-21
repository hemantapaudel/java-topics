package com.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *The Externalizable interface provides the facility of writing the state of an
 * object into a byte stream in compress format.
 * It is not a marker interface. 
 *
 */

class ExternalizablePair implements Externalizable {
    private String key;
    private String value;
     
    public ExternalizablePair() {
    	System.out.println("public constructor called");
        this.key = null;
        this.value = null;
    }
     
    public ExternalizablePair(String key, String value) {
        this.key = key;
        this.value = value;
    }
     
    @Override
    public String toString() {
        return "key = "+key +" value = "+value;
    }
 
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(key);
        out.writeUTF(value);
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.key = in.readUTF();
        this.value = in.readUTF();
    }
     
}

public class ExternalizableExample1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		final String FILE_NAME = "externalizable1.txt";
		
		System.out.println("Method 1: directly calling  Externalizable override method");
		ExternalizablePair pair = new ExternalizablePair("Hello","world");
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
		    pair.writeExternal(out);
		}		
        ExternalizablePair copyOfPair = new ExternalizablePair();
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			copyOfPair.readExternal(in);
		}
		System.out.println(copyOfPair);
		
		System.out.println("Method 2: In-directly calling  Externalizable override method");
		ExternalizablePair pair1 = new ExternalizablePair("Hello1","world1");
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
		   out.writeObject(pair1);
		}		
         
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			ExternalizablePair copyOfPair1 =	(ExternalizablePair)in.readObject();
			System.out.println(copyOfPair1);
		}	
	}
}