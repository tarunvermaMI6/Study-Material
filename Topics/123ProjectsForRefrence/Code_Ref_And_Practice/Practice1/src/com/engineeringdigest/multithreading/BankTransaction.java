package com.engineeringdigest.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransaction {

	int amount;
	int balance;
	private Lock lock = new ReentrantLock();

	public BankTransaction() {
		this.balance = 100;
	}

	// use of sync keyword

//	public synchronized void withdraw(int amount) { // access by one thread at a time
//		
//		if(amount<balance) {
//			balance -= amount;
//		}
//		System.out.println(Thread.currentThread()+"balance == "+balance);
//		try {
//			Thread.sleep(10000); // sleep thread for 10 sec
//			// but what if something happened and t1 failed to execute it's job 
//			// as sync use lock , it will always be locked and other thread will always wait for the t1 to complete
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	// use of locks

	public void withdraw(int amount) {
System.out.println(Thread.currentThread().getName()+"trying to withdraw .....");
		try {

			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

				try {
					if (amount <= balance) {
						Thread.sleep(3000);

						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " Transaction done, current  balance : "
								+ getBalance());

					} else {
						System.out.println("Insufficient Balance");

					}

				} catch (InterruptedException ex ) {
                       Thread.currentThread().interrupt(); // to preserve the state
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " Server is Busy.");

			}
		} catch (Exception e) {
			Thread.currentThread().interrupt(); // to preserve the state
		}

	}

	public int getBalance() {

		return balance;
	}

}
