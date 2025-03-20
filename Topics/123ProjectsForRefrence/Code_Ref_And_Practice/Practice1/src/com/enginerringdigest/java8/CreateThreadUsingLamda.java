package com.enginerringdigest.java8;

public class CreateThreadUsingLamda {

	public static void main(String [] args) {
		
		Runnable runnable = ()-> { // providing impl to run method , runnable is a functional interface
			for (int i = 0; i < 5; i++) {
				System.out.println("In thread one.......");
			}
		};
		Thread thread = new Thread(runnable);
		thread.run();
	}
	
}


