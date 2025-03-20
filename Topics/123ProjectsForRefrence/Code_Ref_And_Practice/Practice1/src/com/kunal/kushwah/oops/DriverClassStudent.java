package com.kunal.kushwah.oops;

class Student {

	int marks;
	String name;
	int rollno;
	Integer fees = 1000;
	Integer a;
	Integer b;
	final int sno; // final must be initalized either here or in constructor

	public Student() {
		this.sno = 0;

	}
	
	public Student(String name) {
		this.sno = 0;
		this.name = name;

	}

	public Student(int marks, String name, int rollno) {
		this(5, "me"); // calling a constructor, should be first statement
		this.marks = marks;
		this.name = name;
		this.rollno = rollno;

	}

	public Student(int marks, String name) {
		this.sno = 0;
		this.marks = marks;
		this.name = name;
	}
	
	public void swap(Integer a,Integer b) { // passing refrences 
		
		Integer temp = 0;
		temp = a;
		a = b;
		b = temp;
		System.out.println("inner = "+a +" ::: "+b); // it will swap in local method only out of this method it will be null
		// as we know object point to same memory location so it should change the instance var too
		// but that class uses final keyword
	}

	public void greetings() {

		System.out.println("hello " + name);
	}

}

public class DriverClassStudent {

	final Student stFinal = new Student();

	public static void main(String[] args) {

		Student st = new Student(20, "adesh", 1234);
		st.greetings();
		st.swap(2, 3);
		System.out.println("out = "+st.a +" ::: "+st.b);
		
	}
	
	public void callFinalExample() {
		
	//	stFinal = new Student(); // can not assign new object but we can change the value
		stFinal.fees = 500;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		// we can't destroy the objects manually but we can tell gc what to do after it destroy it
		System.out.println("object is destroyed ......");
	}
}
