package com.kunal.kushwah.oops;

public class Parent {

	int a;
	int b;
	static String abc ="tarun";
	
	public Parent() {
	
		System.out.println("in parent const....");
	}

	public Parent(Parent parent) {
		
		System.out.println("in parent const...."+parent.abc);
	}
	
	public void parentMethod() {
		System.out.println("parent method .....");
	}
	
	 public void call() {
		System.out.println("parent func .....");
	}
}
