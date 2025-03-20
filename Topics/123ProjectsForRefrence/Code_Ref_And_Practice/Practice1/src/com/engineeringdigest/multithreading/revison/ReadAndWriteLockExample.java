package com.engineeringdigest.multithreading.revison;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockExample {

	public static void main(String[] args) {

		ReadAndWriteLockDriverClass object = new ReadAndWriteLockDriverClass();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("in run ...");
				object.increment();
				System.out.println(object.getCount());
			}
		};

		Thread t1 = new Thread(runnable);
		t1.start();
	}
}

class ReadAndWriteLockDriverClass {

	int count = 0;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public void increment() {

		lock.writeLock().lock();
		count++;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int getCount() {

		try {
			lock.readLock().lock();
		} catch (Exception e) {

		}finally {
			lock.readLock().unlock();
		}
		return count;
	}
}
