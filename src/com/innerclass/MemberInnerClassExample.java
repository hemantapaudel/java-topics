package com.innerclass;

/**
 * 
 */
class TestMemberOuter{  
	 private int data=30;  
	 class Inner{  
		 // the inner call have instance of outer class when byte code is generated
	  void msg(){
		  System.out.println("data is "+data);}  
	 }
}

public class MemberInnerClassExample {

	public static void main(String[] args) {
		TestMemberOuter obj = new TestMemberOuter();
		TestMemberOuter.Inner in = obj.new Inner();
		in.msg();
	}

}
