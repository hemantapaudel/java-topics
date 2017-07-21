package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Lion implements Serializable {
	  
	private static final long serialVersionUID = -7347297768429415071L;
	
	private String sound;
	private long weight;
	  public Lion(String sound,long weight) {
	    System.out.println("Lion's constructor invoked.");
	    this.sound=sound;
	    this.weight=weight;
	  }
	  public String getSound(){
	    return sound;
	  }
	  public void setSound(String sound){
	    this.sound = sound;
	  }

	  private void writeObject(ObjectOutputStream out) throws IOException {
		  System.out.println("private writeObject invoke");
           //default serializing protocal used
		  //out.defaultWriteObject();
		  
		  out.writeObject(sound);
		  out.writeLong(weight);
	  }

	  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		  System.out.println("private readObject invoke");
		  // invoking default protocal
		  //in.defaultReadObject();
		 sound = (String)in.readObject();
		 weight = in.readLong();
	  }
	  
	  private Object readResolve(){
		  System.out.println("private readResolve ===this==="+this);		  
		    return this;
	}
	  
	  @Override
	public String toString() {
		return "sound = "+sound +" weight = "+weight;
	}
	}
public class CustomSerializationExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lion.txt"))){
			out.writeObject(new Lion("roar",85));
		}
		System.out.println("doing deserialization process");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("lion.txt"))){
			
		 Lion lion = (Lion)in.readObject();
		 System.out.println(lion);
			
		}
	}

}
