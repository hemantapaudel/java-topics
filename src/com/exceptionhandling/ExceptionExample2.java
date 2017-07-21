package com.exceptionhandling;

/**
 * 1.  When (JVM terminate the application) System.exit() call, then finally will not execute 
 * 
 *
 */
public class ExceptionExample2 {
	
	public int check1(){
		try{
			System.exit(0);
			return 5;
			
		}catch(Exception exception){
			System.out.println("catch block");
			return 2;
		}
		finally{
			System.out.println("finally block");
			if(Boolean.TRUE){
			return 3;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main ");
		ExceptionExample2 test = new ExceptionExample2();
		System.out.println(test.check1());
	}
}
