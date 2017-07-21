# GARBAGE COLLECTION IN JAVA
Garbage collection works by employing several GC algorithm e.g. Mark and Sweep. There are different kinds of garbage collector available in Java to collect different area of heap memory e.g. you have serial, parallel and concurrent garbage collector in Java

1) Objects are created on the heap in Java irrespective of their scope e.g. local or member variable. while it's worth noting that class variables or static members are created in method area of Java memory space and both heap and method area is shared between different thread.

2) Garbage collection is a mechanism provided by Java Virtual Machine to reclaim heap space from objects which are eligible for Garbage collection.

3) Garbage Collection in Java is carried by a daemon thread called Garbage Collector.

5) Before removing an object from memory garbage collection thread invokes finalize() method of that object and gives an opportunity to perform any sort of cleanup required.

6) There are methods like System.gc() and Runtime.gc() which is used to send request of Garbage collection to JVM but it’s not guaranteed that garbage collection will happen.

8) If there is no memory space for creating a new object in Heap Java Virtual Machine throws OutOfMemoryError or java.lang.OutOfMemoryError heap space

9) J2SE 5(Java 2 Standard Edition) adds a new feature called Ergonomics goal of ergonomics is to provide good performance from the JVM with a minimum of command line tuning. See Java Performance The Definitive Guide for more details on garbage collection tuning.

# When an Object becomes Eligible for Garbage Collection

1) All references to that object explicitly set to null e.g. object = null

2) The object is created inside a block and reference goes out scope once control exit that block.

3) Parent object set to null if an object holds the reference to another object and when you set container object's reference null, child or contained object automatically becomes eligible for garbage collection.

4) If an object has only lived weak references via WeakHashMap it will be eligible for garbage collection.


#Marking and Sweeping ALGORITHMS
To determine which objects are no longer in use, the JVM intermittently runs what is very aptly called a mark-and-sweep algorithm. As you might intuit, it’s a straightforward, two-step process:

The algorithm traverses all object references, starting with the GC roots, and marks every object found as alive.
All of the heap memory that is not occupied by marked objects is reclaimed. It is simply marked as free, essentially swept free of unused objects.


# Heap Generations for Garbage Collection in Java

Heap is divided into three parts for the sake of garbage collection in Java, these are called as YOUNG generation, TENURED or Old Generation and PERM Area of the heap.  YOUNG Generation is further divided into three parts known as EDEN space, SURVIVOR 1 and SURVIVOR 2 space. 

When an object first created in heap its gets created in YOUNG generation inside EDEN space and after subsequent minor garbage collection, if an object survives its gets moved to SURVIVOR 1 and then SURVIVOR 2 before major garbage collection moved that object to old or TENURED generation

#Types of Garbage Collector in Java

1) Throughput Garbage Collector: This garbage collector in Java uses a parallel version of the young generation collector. It is used if the -XX:+UseParallelGC option is passed to the runtime via JVM command line options . The tenured generation collector is same as the serial collector.

2) Concurrent low pause Collector: This Collector is used if the -Xingc or -XX:+UseConcMarkSweepGC is passed on the command line. This is also referred as Concurrent Mark Sweep Garbage collector. The concurrent collector is used to collect the tenured generation and does most of the collection concurrently with the execution of the application. The application is paused for short periods during the collection. A parallel version of the young generation copying collector is used with the concurrent collector. Concurrent Mark Sweep Garbage collector is most widely used garbage collector in java and it uses an algorithm to first mark object which needs to collect when garbage collection triggers.

# Summary on Garbage collection in Java

1) Java Heap is divided into three generation for the sake of garbage collection. These are a young generation, tenured or old generation, and Perm area.

2) New objects are created by young generation and subsequently moved to the old generation.

3) String pool is created in PermGen area of Heap, garbage collection can occur in perm space but depends upon JVM to JVM. By the way from JDK 1.7 update, String pool is moved to heap area where objects are created.

4) Minor garbage collection is used to move an object from Eden space to survivor 1 and survivor 2 space and major collection is used to move an object from young to tenured generation.

5) Whenever Major garbage collection occurs application threads stop during that period which will reduce application’s performance and throughput.

6) There are few performance improvements has been applied in garbage collection in java 6 and we usually use JRE 1.6.20 for running our application.

7) JVM command line options –Xmx and -Xms is used to setup starting and max size for Java Heap. The ideal ratio of this parameter is either 1:1 or 1:1.5 based on my experience, for example, you can have either both –Xmx and –Xms as 1GB or –Xms 1.2 GB and 1.8 GB.

8) There is no manual way of doing garbage collection in Java, but you can use various reference classes e.g. WeakReference or SoftReference to assist garbage collector. 





