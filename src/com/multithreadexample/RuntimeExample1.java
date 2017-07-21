package com.multithreadexample;
import java.io.IOException;


public class RuntimeExample1 {
	public static void main(String[] args) throws IOException {
		//Runtime.getRuntime().exec("notepad");//will open a new notepad  
		// restart the system
		 //Runtime.getRuntime().exec("shutdown -r -t 0");  
		 // shoutdown the system
		 //Runtime.getRuntime().exec("shutdown -s -t 0"); 
		 
		 System.out.println(Runtime.getRuntime().availableProcessors());  
		 
		 Runtime r=Runtime.getRuntime();  
		  System.out.println("Total Memory: "+r.totalMemory());  
		  System.out.println("Free Memory: "+r.freeMemory());  
		    
		  for(int i=0;i<10000;i++){  
		   new RuntimeExample1();  
		  }  
		  System.out.println("After creating 10000 instance, Free Memory: "+r.freeMemory());  
		  System.gc();  
		  System.out.println("After gc(), Free Memory: "+r.freeMemory());  
		 }  
		 
		 
		 
	
}
