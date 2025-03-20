package com.enginerringdigest.java8;

public class CreatingThread {

	public static void main(String [] args) {
		
		MyClass myClass = new MyClass();
		Thread thread = new Thread(myClass);
		thread.run();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("In thread two.......");
		}
	}

}

class MyClass implements Runnable{
	
	@Override
	public void run() { // creating job

		for (int i = 0; i < 5; i++) { 
			System.out.println("In thread one.......");
		}
	}
	
}