package com.engineeringdigest.multithreading;

public class LockExample {

	public static void main(String[] args) {
		
		BankTransaction transaction = new BankTransaction();
		
		Runnable task = new Runnable() { // it's a interface other way to make another class and impl runnable
			
			@Override
			public void run() {
			    transaction.withdraw(40); // my job
			}
		};
		
		Thread t1 = new Thread(task,"thread 1");
		Thread t2 = new Thread(task,"thread 2");
		
		t1.start();
		t2.start();
	}
}
