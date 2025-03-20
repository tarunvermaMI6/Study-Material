package com.engineeringdigest.multithreading.revison;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static void main(String[] args) {

		LockDriverClass lockClass = new LockDriverClass();

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				int i = 10000;
				while (i > 0) {
					lockClass.increment();
					i--;
				}
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		
		try {
			t1.join(); // main thread and t2 will wait to execute it first
			t2.join(); // main thread will wait to execute t2
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(lockClass.getCount());
	}
}

class LockDriverClass {

	private int count = 0;
	private final Lock lock = new ReentrantLock();

	public void increment() {
		
		try {
			if (lock.tryLock(3000,TimeUnit.MILLISECONDS)) {
				try {
					count++;
				//	Thread.sleep(5000);
				} finally {
					lock.unlock();
				}
			}else {
				System.out.println("lock is locked ...");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

	public int getCount() {
		return this.count;
	}
}
