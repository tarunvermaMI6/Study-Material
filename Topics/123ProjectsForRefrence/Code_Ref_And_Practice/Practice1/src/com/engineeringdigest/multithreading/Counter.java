package com.engineeringdigest.multithreading;

public class Counter {

	int count;
	
//	public synchronized void increment() {
//		count++;
//	}
	
	// or
	
	public void increment() {
		synchronized (this) { // this equal current instance
			count++;
		}
	}
	
	public int getCount() {
		return count;
	}
}
