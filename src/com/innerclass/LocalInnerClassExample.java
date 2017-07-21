package com.innerclass;

class LocalInner {
	private int data = 30;// instance variable

	void display() {
		class Local {
			private int value = 50;// local variable must be final till jdk 1.7
									// only
			void msg() {
				System.out.println("value " + value);
				System.out.println("data " + data);
			}
		}
		Local l = new Local();
		l.msg();
	}
}

public class LocalInnerClassExample {

	public static void main(String[] args) {
		LocalInner obj = new LocalInner();
		obj.display();
	}

}
