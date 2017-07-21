# JAVA INNER CLASS
Java inner class or nested class is a class i.e. declared inside the class or interface.
Inner class can access all the members of outer class including private data members and methods.

#Advantage of java inner classes
1) Nested classes represent a special type of relationship that is it can access all the members (data members and methods) of outer class including private.

2) Nested classes are used to develop more readable and maintainable code because it logically group classes and interfaces in one place only.

3) Code Optimization: It requires less code to write.

*Inner class is a part of nested class. Non-static nested classes are known as inner classes.

#Types of Nested classes

There are two types of nested classes non-static and static nested classes.The non-static nested classes are also known as inner classes.
 * Non-static nested class(inner class)
		a)Member inner class
		b)Annomynous inner class
		c)Local inner class

 * Static nested class
 
 # Java Member inner class
 A non-static class that is created inside a class but outside a method is called member inner class.
 
 
 #Java Anonymous inner class
 A class that have no name is known as anonymous inner class in java.
 It should be used if you have to override method of class or interface.
 
 # Java Local inner class
 A class i.e. created inside a method is called local inner class in java. If you want to invoke the methods of local inner class, you must instantiate this class inside the method.
 	Rules for Java Local Inner class
 	1) Local inner class cannot be invoked from outside the method.
 	2) Local inner class cannot access non-final local variable till JDK 1.7. Since JDK 1.8, it is possible to access the non-final local variable in local inner class.
 	
 # Java static nested class
 A static class  created inside a class is called static nested class in java
 It can access static data members of outer class including private.
Static nested class cannot access non-static (instance) data member or method.