package com.enginerringdigest.java8.revision;


public class DefautMethodExample {

	public static void main(String[] args) {
		
		DriverClass d = new DriverClass();
		d.noDefault();
		d.sayHello();
		
		DefaultMethodInterface.thisMethodIsStatic();
		
	}
	
}

class DriverClass implements DefaultMethodInterface{
	
	@Override
	public void noDefault() {
		
		System.out.println("no default");
	}
	
	 // we can also override default method
	@Override
	public void sayHello() {
		System.out.println("oye hello ....... ");
	}
}


@FunctionalInterface
interface DefaultMethodInterface{
	
	
	void noDefault();
	
	static void thisMethodIsStatic() {
		
		System.out.println("static method .........");
	}
	
	default void sayHello() {
		System.out.println("oye hello ....... ");
	}
}
