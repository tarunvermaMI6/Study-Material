package com.kunal.kushwah.oops;

public class SingleInheritance2 extends SingleInheritance1{

	public SingleInheritance2() {
		// TODO Auto-generated constructor stub
	   super(); // will call it's parent class constructor to initialize the default values
	}
	

	public SingleInheritance2(String name,int age) {
	
		super(name ,age);
	}
	
	public static void main (String[] args) {
		
		SingleInheritance1 si1 = new SingleInheritance1("verma",90);
		SingleInheritance2 si2 = new SingleInheritance2("tarun",76);
		si1.call();
		si2.call();
	}
}
