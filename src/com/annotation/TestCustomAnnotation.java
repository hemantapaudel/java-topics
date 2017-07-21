package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;



//Creating annotation  
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyCustomAnnotation{
	int value() default 20;
    String   name();
    int      age();
    String[] newNames();
	
}


//Applying annotation
class Hello {
	@MyCustomAnnotation(
		    value= 123,
		    name="Jakob",
		    age=37,
		    newNames={"Jenkov", "Peterson"}
		)
	public void sayHello() {
		System.out.println("hello annotation");
	}
	
	@Deprecated
	public void printMessage(String message){
		System.out.println(message);
	}
}

// Accessing annotation
public class TestCustomAnnotation {
	public static void main(String args[]) throws Exception {

		Hello h = new Hello();
		
		Method m = h.getClass().getMethod("sayHello");

		MyCustomAnnotation manno=m.getAnnotation(MyCustomAnnotation.class);  
		System.out.println("value is: "+manno.value());  
		System.out.println("name is: "+manno.name());  
		System.out.println("age is: "+manno.age());  
		System.out.println("newName is: "+manno.newNames());  
		
		
	}
}