# Java Annotation

Java Annotation is a tag that represents the metadata i.e. attached with class, interface, methods or fields to indicate some additional information which can be used by java compiler and JVM.

Annotation is special kind of Java construct used to decorate a class, method, field, parameter, variable, constructor, or package. It’s the vehicle chosen by JSR-175 to provide metadata.Annotation defines a standard 
way of defining metadata in code. Prior to annotations people also used their own ways to define metadata. Some examples are – using marker interfaces, comments, transient keywords etc. Each developer decided his own way to decide metadata, but annotation standardized things.

# Built-In Java Annotations
# Built-In Java Annotations used in java code
	@Override
	@SuppressWarnings
	@Deprecated

# Built-In Java Annotations used in other annotations
	@Target
	@Retention
	@Inherited
	@Documented
	
# @Override
@Override annotation assures that the subclass method is overriding the parent class method. If it is not so, compile time error occurs.
Sometimes, we does the silly mistake such as spelling mistakes etc. So, it is better to mark @Override annotation that provides assurity that method is overridden.


# Java Custom Annotation
Java Custom annotations or Java User-defined annotations are easy to create and use. The @interface element is used to declare an annotation. For example:
@interface MyAnnotation{}  
Points to remember for java custom annotation signature
 * Method should not have any throws clauses
 * Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
 * Method should not have any parameter.
 * We should attach @ just before interface keyword to define annotation.
 * It may assign a default value to the method.
	
# Types of Annotation
There are three types of annotations.
 * Marker Annotation
 * Single-Value Annotation
 * Multi-Value Annotation

# Marker Annotation
An annotation that has no method, is called marker annotation. For example:
	@interface MyAnnotation{}  
	The @Override and @Deprecated are marker annotations.

# Single-Value Annotation
An annotation that has one method, is called single-value annotation.

# Multi-Value Annotation
An annotation that has more than one method, is called Multi-Value annotation


# Built-in Annotations used in custom annotations in java
 * @Target :-  @Target tag is used to specify at which type, the annotation is used.
 * @Retention :- @Retention annotation is used to specify to what level annotation will be available.
 


# How built-in annotaions are used in real scenario?
 
 * @Inherited
		By default, annotations are not inherited to subclasses. The @Inherited annotation marks the 		annotation to be inherited to subclasses.

	  @Inherited  
		@interface ForEveryone { }//Now it will be available to subclass also
	
 * @Documented
    The @Documented Marks the annotation for inclusion in the documentation.

# Retention Policies 

 *  RetentionPolicy.SOURCE: Discard during the compile. These annotations don't make any sense after the compile has 	completed, so they aren't written to the bytecode. Example: @Override, @SuppressWarnings

 *  RetentionPolicy.CLASS: Discard during class load. Useful when doing bytecode-level post-processing. Somewhat 	surprisingly, this is the default.

 *  RetentionPolicy.RUNTIME: Do not discard. The annotation should be available for reflection at runtime. Example: 		@Deprecated