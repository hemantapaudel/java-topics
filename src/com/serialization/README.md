# Serialization:

# What is meant by serialization in Java?

Serialization in java is a mechanism of writing the state of an object into a byte stream.

  * Serializable is marker interface

  * Any class which implement Serializible  that class object can be serialization

  * If a class implements serializable interface then all its sub classes will also be serializable, in that case
    when we serialized subclass object ,its parents class  attributes also get serialized.
    
  * If only sub class is serializable and super class is not serializable, in this case when sub-class 
	object serialize, its parents class attributes are not get serialized.
 
  * If a class has a reference of another class, all the references must be Serializable 
	otherwise serialization process will not be performed. In such case, NotSerializableException 
	is thrown at runtime.

  * In case of array or collection, all the objects of array or collection must be serializable. If 
    any object is  not serialiizable, serialization will be failed.
    
#  In general there are three approaches to serialization in java:

	* Implement Serializable and use default protocol.
	* Implement Serializable and get a chance to modify the default protocol.
	* Implement Externalizable and write your own protocol to implement serailization.
	

# What is a serialVersionUID and why should I use it?
 
 The serialization runtime associates with each serializable class a version number, 
 called a serialVersionUID, which is used during deserialization to verify that the sender and receiver of a 
 serialized object have loaded classes for that object that are compatible with respect to serialization.
 If the receiver has loaded a class for the object that has a different serialVersionUID than that of 
 the corresponding sender's class, then deserialization will result in an  InvalidClassException. 
 A serializable class can declare its own serialVersionUID explicitly by declaring a field 
 named "serialVersionUID" that must be static, final, and of type long:
  
  ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
  
 If a serializable class does not explicitly declare a serialVersionUID, then the serialization runtime will
 calculate a default serialVersionUID value for that class based on various aspects of the class,
 as described in the Java(TM) Object Serialization Specification. However, it is strongly recommended that
 all serializable classes explicitly declare serialVersionUID values, since the default serialVersionUID 
 computation is highly sensitive to class details that may vary depending on compiler implementations, 
 and can thus result in unexpected InvalidClassExceptions during deserialization. Therefore,
 to guarantee a consistent serialVersionUID value across different java compiler implementations,
 a serializable class must declare an explicit serialVersionUID value. It is also strongly advised 
 that explicit serialVersionUID declarations use the private modifier where possible, since 
 such declarations apply only to the immediately declaring class--serialVersionUID fields are not useful 
 as inherited members.

# Object Construction in Serialization

* RULE1: When you serialize an object, the whole inheritance hierarchy is serialized till the first non-serializable class of that object.
* RULE2: The first non-serializable class must have an empty constructor.
*

# Customize Java Serialization

When a class implements Serializable interface it gives information to the JVM that the instances of these classes can be serialized. Along with that, there is a special note to the JVM.
"look for following two methods in the class that implements Serializable. If found invoke that and continue with serialization process else directly follow the standard serialization protocol".

So this gives us a chance to write these two methods in-sided the Class that implements Serializable and you get a hook to the serialization process. You can write your custom code inside these two methods and customize the standard behaviour of serialization.

* private void writeObject(ObjectOutputStream out) throws IOException;
* private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException; 

# Suppose super class of a new class implement Serializable interface, how can you avoid new class to being serialized?

If Super Class of a Class already implements Serializable interface in Java then its already Serializable in Java, since you can not unimplemented an interface its not really possible to make it Non Serializable class but yes there is a way to avoid serialization of new class. To avoid Java serialization you need to implement writeObject() and readObject() method in your Class and need to throw NotSerializableException from those method. This is another benefit of customizing java serialization process.

# Serialization and MAGIC METHODS
# During serialization
	*  private Object writeReplace() throws ObjectStreamException
This method allows the developer to provide a replacement object that will be serialized instead of the original one.

	*  private void writeObject (ObjectOutputStream out) throws IOException
	This method allows to take complete control over what will be sent over the wire.
In most cases, you will just call out.defaultWriteObject() to benefit from the default serialization process, then add some more data of your choice (for instance, data from the parent class) by calling  out.writeDouble, out.writeUTF, etc. (inherited by ObjectOutputStream from the DataOutput interface).


	

# During De-Serialization


	* private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
This method is the same as writeObject above, but for reading objects from the serialized stream.
You can call in.defaultReadObject() to automatically read most of the data, then manually read back the extra data you may have added. Be careful to read data in the same exact order they were written in the stream !

	* private Object readResolve() throws ObjectStreamException
This method mirrors writeReplace : it may be used to replace the de-serialized object by another one of your choice.
 

	* public void validateObject() throws InvalidObjectException
If the serialized object implements ObjectInputValidation, you may register it as a stream validator.
Useful to verify the stream has not been tampered with, or that the data makes sense before handing it back to your application.


 
# Externalizable :
 
 The default java serialization is not efficient. It you serialize a bloated objected having lots of attributes and properties, you do not wish to serialize for any reason (e.g. they always been assigned default values), you get heavy object to process and send more bytes over network which may be costly on some cases.

To solve this issue, you can write your own serialization logic by implementing Externalizable interface and overriding it’s methods writeExternal() and readExternal(). By implementing these methods, you are telling the JVM how to encode/decode your object.

the Externalizable interface extends the Serializable interface and provides two methods to serialize and de-serialize an object, writeExternal and readExternal.

By implementing both the writeExternal and readExternal methods, a class gains complete control over the format and the contents that will be serialized.
The procedure of serializing an object uses both the Externalizable and Serializable interface interfaces. If an object implements the Externalizable interface, then, its writeExternal method is called. Otherwise, the object is persisted using the ObjectOutputStream class.
Regarding the procedure of de-serialization, initially, an instance is created using the public constructor, which contains no arguments at all. Then, if the object implements the Externalizable interface, the readExternal method is called. Otherwise, the object is created by reading its content from an instance of the ObjectInputStream class.

However, the implemention of the Externalizable interface must take place with caution, since there are some fundamental characteristics:
First of all, if a class implements the Serializable interface, then the Java Virtual Machine (JVM) is responsible for its automatic serialization. Otherwise, if a class implements the Externalizable interface, the developer and maintainer of a class is responsible for its serialization.
Second, the Externalizable interface poses the challenge of how to serialize the super type state, default values in case of transient variables and finally, static variables.
Third, in case a class implements the Externalizable inteface and a single field is changed, both the writeExternal and readExternal methods must be upgraded.
 
 

