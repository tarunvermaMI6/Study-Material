package com.engineeringdigest.multithreading.revison;

public class DeadLockExample {

	// Solution 1: Always Acquire Locks in a Fixed Order or use try lock , try lock with time out
	
	private static final Object object1 = new Object();
	private static final Object object2 = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {

			synchronized (object1) {
				System.out.println("Thread-1 locked lock1");
				try {
					Thread.sleep(100); // its
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (object2) {
					System.out.println("Thread-1 locked lock2");

				}
			}

		});

		Thread t2 = new Thread(() -> {

			synchronized (object2) {
				System.out.println("Thread-2 locked lock2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (object1) {
					System.out.println("Thread-2 locked lock1");

				}
			}

		});

		t1.start();
		t2.start();
	}

}
