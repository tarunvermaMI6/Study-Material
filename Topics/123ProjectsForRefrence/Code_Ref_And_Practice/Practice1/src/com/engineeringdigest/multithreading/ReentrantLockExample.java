package com.engineeringdigest.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	private ReentrantLock lock = new ReentrantLock();

	public void outerMethod() {

		lock.lock();
		try {
			System.out.println("in outer method");
			innerMethod();
		} finally {
			lock.unlock();
		}
	}

	public void innerMethod() {

		lock.lock();
		try {
			System.out.println("in inner method");
			
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		ReentrantLockExample rle = new ReentrantLockExample();
		rle.outerMethod();
		
		
	}
}
