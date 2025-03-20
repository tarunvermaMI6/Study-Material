package com.engineeringdigest.multithreading;

public class MyThreadUsingRunnableInterface implements Runnable{

	@Override
	public void run() {

		System.out.println("in my thread ....."+Thread.currentThread());
	}
}
