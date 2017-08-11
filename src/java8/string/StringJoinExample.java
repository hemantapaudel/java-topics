package java8.string;

import java.util.ArrayList;
import java.util.List;

public class StringJoinExample {

	public static void main(String[] args) {

		 String joinedString = String.join(" ", "Hemanta ", "Paudel");
	     System.out.println(joinedString);
	     
	     List<String> list = new ArrayList<String>();
	        list.add("Hello");
	        list.add("World");
	        //Using join() method added in JDK 8
	 
	        joinedString = String.join(" ", list);
	        System.out.println(joinedString);
	        
	}

}
