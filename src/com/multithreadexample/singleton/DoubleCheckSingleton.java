package com.multithreadexample.singleton;

public class DoubleCheckSingleton {

	private static DoubleCheckSingleton singleton;

	//1. double check singleton object creation
	public static DoubleCheckSingleton getInstanceDC() {
		if (singleton == null) {
			// Single Checked
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					// Double checked
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

	//2. Singleton pattern example with static factory method
	
	//initailzed during class loading
    private static final DoubleCheckSingleton INSTANCE = new DoubleCheckSingleton();
  
    //to prevent creating another instance of Singleton
    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getSingleton(){
        return INSTANCE;
    }

	//3 using enum
    enum SingletonEnum {
    	 INSTANCE;
    	 public void doStuff(){
    	     System.out.println("Singleton using Enum");
    	 }
    	}
	
	
	
	public static void main(String[] args) {

		SingletonEnum.INSTANCE.doStuff();
	}

}
