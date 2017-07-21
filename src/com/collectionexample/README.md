# Collections-framework

Collections in java is a framework that provides an architecture to store and manipulate the group of objects.
Collection represents a single unit of objects i.e. a group.

# ArrayList:
Java ArrayList class uses a dynamic array for storing the elements.
ArrayList class can contain duplicate elements/maintains insertion order/non synchronized/allows random access, but
manipulation is slow because a lot of shifting needs to be occurred if any element is removed from the array list

# ListIterator
ListIterator Interface is used to traverse the element in backward and forward direction

# LinkedList 
Java LinkedList class uses doubly linked list to store the elements. It provides a linked-list data structure. It inherits the AbstractList class and implements List and Deque interfaces.

In Java LinkedList class, manipulation is fast because no shifting needs to be occurred.

# Difference between ArrayList and LinkedList

 * ArrayList internally uses dynamic array to store the elements.
   LinkedList internally uses doubly linked list to store the elements.

 * Manipulation with ArrayList is slow because it internally uses array. If any element is removed from the array,           	all the bits are shifted in memory.	Manipulation with LinkedList is faster than ArrayList because it uses 
   doubly linked list so no bit shifting is required in memory.
 
 * ArrayList class can act as a list only because it implements List only.	LinkedList class can act as a list and    	queue both because it implements List and Deque interfaces.
 
 * ArrayList is better for storing and accessing data.	LinkedList is better for manipulating data.
 
 
# HashSet :-->Set(I)->Collection(I)->Iterable 
HashSet  is used to create a collection that uses a hash table for storage. It inherits the AbstractSet class and implements Set interface.
* HashSet stores the elements by using a mechanism called hashing.
* HashSet contains unique elements only.
* HashSet used HashMap Internally

Object  will mask as duplicate on map if below (1 & 2) or (1 & 3) condition pass.
 *	1. hashcode is already filled  on hash table (collision)
 *	2. the new object ref and hashtable containing object refer are same
 *	3. if  2nd condition is false, it will call key object equal method, if equal method return true then object is  as duplicate 	


# LinkedHashSet :-> HashSet(C)->Set(I)->Collection(I)->Iterable
 LinkedHashSet  is a Hash table and Linked list implementation of the set interface. It inherits HashSet class and implements Set interface.

The important points about Java LinkedHashSet class are:

Contains unique elements only like HashSet.
Provides all optional set operations, and permits null elements.
Maintains insertion order.

# EnumSet 

 


# TreeSet :-> NavigableSet(I)->SortedSet(I)->Set(I)->Collection(I)->Iterable
TreeSet class implements the Set interface that uses a tree for storage. It inherits AbstractSet class and implements NavigableSet interface. The objects of TreeSet class are stored in ascending order.
The important points about Java TreeSet class are:
* Contains unique elements only like HashSet.
* Access and retrieval times are quiet fast.
* Maintains ascending order (Sorted)

# Queue : 
Queue data structure orders the element in FIFO(First In First Out) manner.

# PriorityQueue:
The PriorityQueue class is an unbounded priority queue based on a priority heap.Following are the important points about PriorityQueue:

 * The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided 	at queue construction time, depending on which constructor is used.
 * A priority queue does not permit null elements.
 * A priority queue relying on natural ordering also does not permit insertion of non-comparable objects.


# Map
A map contains values on the basis of key i.e. key and value pair. Each key and value pair is known as an entry. Map contains only unique keys.
 
# Java LinkedHashMap class

Java LinkedHashMap class hierarchy
Java LinkedHashMap class is Hash table and Linked list implementation of the Map interface, with predictable iteration order. It inherits HashMap class and implements the Map interface.
* A LinkedHashMap contains values based on the key.
* It contains only unique elements.
* It may have one null key and multiple null values.
* It is same as HashMap instead maintains insertion order.  

# TreeMap
 TreeMap class implements the Map interface by using a tree. It provides an efficient means of storing key/value pairs in sorted order.
 * A TreeMap contains values based on the key.It implements the NavigableMap interface and extends AbstractMap.
 * It contains only unique elements.
 * It cannot have null key but can have multiple null values.
 * It is same as HashMap instead maintains ascending order.

# Hashtable 
Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary class and implements the Map interface.

* Hashtable is an array of list. Each list is known as a bucket. The position of bucket is identified by calling the    	hashcode() method. A Hashtable contains values based on the key.
* It contains only unique elements.
* It may have not have any null key or value.
* It is synchronized.

# EnumMap 
 EnumMap class is the specialized Map implementation for enum keys. It inherits Enum and AbstractMap classes.
 
# Comparable :
 	Comparable interface is used to order the objects of user-defined class. It provide single sorting sequence only  	i.e. you can sort the elements on based on single data member only. For example it may be rollno, name, age or 	anything else.
 
# Comparator :
 Java Comparator interface is used to order the objects of user-defined class.

This interface  contains 2 methods compare(Object obj1,Object obj2) and equals(Object element).
It provides multiple sorting sequence i.e. you can sort the elements on the basis of any data member, for example rollno, name, age or anything else.
 
 
# Java Collection Interview Question
	* How does HashMap work in Java? -> explain about hash code and equal method
	* What is the difference between poll() and remove() method of Queue interface?
	   BOTH return head element but if queue is empty remove method throw exception
	* What is the difference between fail-fast and fail-safe Iterators?
    * What is the difference between Iterator and Enumeration?
		-->Iterator provide duplicate functionality of Enumeration with one addition of remove().
		--> Iterator is more safe than Enumeration and doesn't allow another thread to modify collection 		object during iteration except remove() method and throws ConcurrentModificaitonException. 
	* How does HashSet is implemented in Java, How does it use Hashing?
	   ==>> HashSet internally used HashMap
	*  What do you need to do to use a custom object as a key in Collection classes like Map or Set?
	   ==>> you have to implement hash code and equals method.
	* The difference between HashMap and Hashtable?
	  1. Hash table does not allow null but hash map allow
	  2. Hash table is synchronized but hash map is not synchronized
	  3. Hash  table use  Enumerator (only access) but hash map use  Iterator(access and modify)
	  4. Hash table is slower than HashMap 
	* When do you use ConcurrentHashMap in Java?
	  => ConcurrentHashMap is better suited for situation where you have multiple readers and one
	  Writer or fewer writers since Map gets locked only during the write operation. If you have
	  an equal number of reader and writer than ConcurrentHashMap will perform in the line of 
	  hash table or synchronized HashMap.
	* What is the difference between Set and List in Java?
	
	* Hence, Hashtable uses method level synchronization but Collections.synchronizedMap(Map) provides a flexibility to developer lock on provided mutex with Synchronized block.
	  


