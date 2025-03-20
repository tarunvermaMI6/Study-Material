package com.kunal.kushwah.oops;

// if I want to restrict my class to make one object Only
public class SingletonClass {

	
    // Object obj = new Object(); // Object() is constructor call  
	// can not be accessed outside of the class
	private SingletonClass() {
		
	}
	
	static SingletonClass object = getInstance();
	
	public static SingletonClass getInstance() {
		
		if(object == null) {
			object = new SingletonClass();
		}
		return object; 
	}
}
