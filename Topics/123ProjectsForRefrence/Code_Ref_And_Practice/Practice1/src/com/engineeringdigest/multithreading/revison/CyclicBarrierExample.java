package com.engineeringdigest.multithreading.revison;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		
		int numberOfService = 3;
		ExecutorService service = Executors.newFixedThreadPool(numberOfService);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfService);
		 service.submit(new CyclicExampleDriver(cyclicBarrier));
		 service.submit(new CyclicExampleDriver(cyclicBarrier));
		 service.submit(new CyclicExampleDriver(cyclicBarrier));
		 System.out.println("** "+Thread.currentThread().getName());
		 service.shutdown();
	}
}

class CyclicExampleDriver implements Callable<String> {
	
	private CyclicBarrier barrier;
	
	public CyclicExampleDriver(CyclicBarrier barrier) {
	
		this.barrier = barrier;
	}
	
	@Override
	public String call() throws Exception {

		try {
			System.out.println(Thread.currentThread().getName() + " service start...");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is waiting for the barrier...");
			barrier.wait();
		} catch (Exception e) {
			
		}
		
		return "ok";
	}

}