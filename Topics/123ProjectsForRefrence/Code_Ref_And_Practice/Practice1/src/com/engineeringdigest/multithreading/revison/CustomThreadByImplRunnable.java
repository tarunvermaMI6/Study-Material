package com.engineeringdigest.multithreading.revison;

import com.java.programms.practice.CalculateFrequency;

public class CustomThreadByImplRunnable implements Runnable{

	@Override
	public void run() {
		
		System.out.println("thread name in run = "+Thread.currentThread().getName());
		int[] arr = { 5, 6, 7, 9, 1 };
		CalculateFrequency.usingMap(arr);
		
	}

	public void run(int m) { // we can overload the run method
		
		System.out.println("thread name is run overloading = "+Thread.currentThread().getName());
		System.out.println("this is run method overloading = "+m+" "+Thread.currentThread().getName());
	}
	
}
