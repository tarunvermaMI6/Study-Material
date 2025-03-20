package com.kunal.kushwah.oops;

public class SingleInheritance1 {

	String name;
	int age;
	
	public SingleInheritance1() {
	  // TODO Auto-generated constructor stub
	  this.name = "Tarun";
	  this.age = 30;
	}
	
	SingleInheritance1(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println(name);
	}
	
	public void call() {
		
		System.out.println("SingleInheritance1 == "+name+" "+age);
	}
	
	
}
