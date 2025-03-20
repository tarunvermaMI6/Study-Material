package com.engineeringdigest.multithreading.revison;

public class ThreadCommunication {

	public static void main(String[] args) {

		SharedResource SharedResource = new SharedResource();
		Thread t1 = new Thread(new Producer(SharedResource));
		Thread t2 = new Thread(new Consumer(SharedResource));
		t1.start();
		t2.start();
	}
}

class SharedResource {

	boolean isObjectAvl = false;
	int data = 0;

	public synchronized void produceTheObject(int value) { // produce

		while (isObjectAvl) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}		
		data = value;
		System.out.println("Produced: " + data);
		isObjectAvl = true;
		notify(); // notify the consumer
	}

	public synchronized void consumeTheObject() { // consume

		while (!isObjectAvl) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		System.out.println("Consumed: " + data);
		isObjectAvl = false;
		notify(); // notify the producer
	}
}

class Producer implements Runnable {

	SharedResource sharedResource;

	public Producer(SharedResource sharedResource) {

		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				sharedResource.produceTheObject(i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Consumer implements Runnable {

	SharedResource sharedResource;

	public Consumer(SharedResource sharedResource) {

		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				sharedResource.consumeTheObject();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}