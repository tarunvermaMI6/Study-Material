package com.telusko.java8;

interface PhoneInterface {

	void phone();
	
	// by default every method is public in interface , if we want to upgrade the interface by having new methods we can't so so coz
	// every class that implemented that interface will have to implement new methods too which is not feasible
	// thats why we need to define methods using default keyword
	
	default void message() {
		System.out.println("in message ........");
	}
}

class AndroidPhone implements PhoneInterface {

	@Override
	public void phone() {
		
		System.out.println("In Android Phone ....");
		
	}
}

public class java8defaultmethodininterface{

	public static void main(String [] args) {
		
		AndroidPhone obj = new AndroidPhone();
		obj.phone();
		obj.message();
	}
}



