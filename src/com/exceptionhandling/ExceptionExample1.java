package com.exceptionhandling;

import java.io.IOException;

/**
 * 
 * 1. The finally block return always considerable e.g. check1(), and check2()
 * 2. if exception and return both execute, then last execute statement will consider e.g. check2() and check3()
 *
 */
public class ExceptionExample1 {
	
	@SuppressWarnings("finally")
	public int check(){
		try{
			System.out.println("try block");
			return 1;
		}catch(Exception exception){
			System.out.println("catch block");
			return 2;
		}
		finally{
			System.out.println("finally block");
			return 3;
		}
	}
	
	@SuppressWarnings("finally")
	public int check2() throws Exception{
		try{
			throw new IOException("try block exception");
		}catch(Exception exception){
			System.out.println("catch block");
			throw exception;
		}
		finally{
			System.out.println("finally block");
			return 3;
		
		}
	}
	
	@SuppressWarnings("finally")
	public int check3() throws Exception{
		try{
			System.out.println("try block ");
			return 1;
		}catch(Exception exception){
			System.out.println("catch block");
			throw exception;
		}
		finally{
			System.out.println("finally block");
			throw new Exception("exception from finally block");
		}
	}
	
	
	public void check4() throws Exception{
		try{
			throw new IOException("try block exception");
		}catch(Exception exception){
			System.out.println("catch block");
			throw exception;
		}
		finally{
			System.out.println("finally block");
			//return;
			}
	}
	public static void main(String[] args) throws Exception{
		ExceptionExample1 test = new ExceptionExample1();
		System.out.println("====check 1===========");
		System.out.println(test.check());
		System.out.println("====check 2===========");
		System.out.println(test.check2());
		try {
			System.out.println("====check 3===========");
			System.out.println(test.check3());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("====check 4===========");
			test.check4();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
