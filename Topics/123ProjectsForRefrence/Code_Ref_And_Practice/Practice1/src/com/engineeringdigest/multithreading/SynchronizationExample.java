package com.engineeringdigest.multithreading;

public class SynchronizationExample{

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		MyThread t1 = new MyThread(counter); // pointing to same object, sharing resource
		MyThread t2 = new MyThread(counter); // pointing to same object , sharing resource
		
		t1.start();
		t2.start();
		
		// two of these threads increasing the count simultaneously , sometimes both threads increase same count
		// so no synchronisation , use synchronized keyword on method or can use synchronized block
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			
		}
		
		System.out.println(counter.getCount());
	}
}

class MyThread extends Thread {

	private Counter counter;

	public MyThread() {

	}

	public MyThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() { 

		for (int i = 0; i < 1000; i++) { // job to run
			counter.increment();
		}

	}
}
