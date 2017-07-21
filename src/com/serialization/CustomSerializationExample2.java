package com.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class Pojo implements Serializable, ObjectInputValidation {
	 
    private String msg;
 
    public Pojo(String msg) {
        this.msg = msg;
    }
 
    public String getMsg() {
        return msg;
    }
 
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
        out.defaultWriteObject();
    }
 
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace");
        return this;
    }
 
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
        in.registerValidation(this, 0);
        in.defaultReadObject();
    }
 
    @Override
    public void validateObject() throws InvalidObjectException {
        System.out.println("validateObject");
    }
 
    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve");
        return this;
    }
}

public class CustomSerializationExample2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		 Pojo pojo = new Pojo("Hello world");
	     byte[] bytes = serialize(pojo); // Serialization        
	     Pojo p = (Pojo) deserialize(bytes); // De-serialization
	     System.out.println(p.getMsg());
	    
	}
	
	private static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.flush();
        oos.close();
        return baos.toByteArray();
    }
 
    private static Object deserialize(byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        ois.close();
        return o;
    }

}
