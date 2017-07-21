# Generic in Java

Java Generic methods and generic classes enable programmers to specify, with a single method declaration, a set of related methods, or with a single class declaration, a set of related types, respectively.

Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time.

Using Java Generic concept, we might write a generic method for sorting an array of objects, then invoke the generic method with Integer arrays, Double arrays, String arrays and so on, to sort the array elements.

# Advantage of Java Generics

There are mainly 3 advantages of generics. They are as follows:
 * Type-safety : We can hold only a single type of objects in generics. It doesn’t allow to store other objects.

 * Type casting is not required: There is no need to typecast the object.Before Generics, we need to type cast.
 * Compile-Time Checking: It is checked at compile time so problem will not occur at runtime. The good programming strategy says it is far better to handle the problem at compile time than runtime.
    
# Type Parameters

The type parameters naming conventions are important to learn generics thoroughly. The commonly type parameters are as follows:

 * T - Type
 * E - Element
 * K - Key
 * N - Number

# Wildcard in Java Generics

The ? (question mark) symbol represents wildcard element. It means any type. If we write <? extends Number>, it means any child class of Number e.g. Integer, Float, double etc. Now we can call the method of Number class through any child class object.