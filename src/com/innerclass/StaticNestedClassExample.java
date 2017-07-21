package com.innerclass;

/**
 * static block is execute when class is load on memory
 * instance block is called when object is created
 * 
 */
class TestOuter{  
	static{
		 System.out.println("static outer block");
	 }
	 {
		 System.out.println("outer block");
	 }
	  private static int data=30; 
	//  private int nonstaticId =10;
	  // can access only static field and method of outer class
	  static class Inner{  
		  static{
				 System.out.println("static inner block");
			 }
			 {
				 System.out.println("inner block");
			 }
	   void msg(){
		   System.out.println("data is "+data);
		  // System.out.println("non static id "+nonstaticId);
	   }  
	  }  	  
}
	  
public class StaticNestedClassExample {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("innerclass.TestOuter");
		//TestOuter outer = new TestOuter();
		
		//TestOuter.Inner obj=new TestOuter.Inner();  
		//obj.msg(); 

	}

}
