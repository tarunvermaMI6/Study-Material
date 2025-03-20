package com.enginerringdigest.java8.revision;

public class ThreadUsingLamda {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{
			
			System.out.println("kya dekh raha hai");
		});
		
		t1.start();
	}
}
