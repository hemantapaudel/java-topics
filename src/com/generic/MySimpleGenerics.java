package com.generic;

/**
 * 
 * 1) Type-safety 
 * 2) Type casting is not required:
 * 3) Compile-Time Checking:
 *
 */

public class MySimpleGenerics {
	public static void main(String[] args) {
		SimpleGeneric<String> simpleGeneric = new SimpleGeneric<String>("This is string");
		simpleGeneric.printType();
		
		SimpleGeneric<Boolean> simpleGeneric1 = new SimpleGeneric<Boolean>(Boolean.TRUE);
		simpleGeneric1.printType();
		
	}
}

class SimpleGeneric <T>{
	//declaration of object type T
    private T objReff = null;
    
    SimpleGeneric(T ref){
    	this.objReff =ref;
    }
	public T getObjReff() {
		return objReff;
	}
	public void setObjReff(T objReff) {
		this.objReff = objReff;
	}
    public void printType(){
        System.out.println("Type: "+objReff.getClass().getName());
    }
    
}
