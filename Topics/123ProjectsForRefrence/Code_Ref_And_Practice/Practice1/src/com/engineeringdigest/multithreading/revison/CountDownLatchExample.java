package com.engineeringdigest.multithreading.revison;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

	public static void main(String[] args) {

	//	ExecutorService service = Executors.newFixedThreadPool(3);
	/*  Future<String> future1 = service.submit(new CountDownLatchExampleDriver());
		Future<String> future2 = service.submit(new CountDownLatchExampleDriver());
		Future<String> future3 = service.submit(new CountDownLatchExampleDriver());
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
  */
	// or 
	/*	List<Callable<String>> list =  new ArrayList<Callable<String>>();
		list.add(new CountDownLatchExampleDriver());
		list.add(new CountDownLatchExampleDriver());
		list.add(new CountDownLatchExampleDriver());
		try {
			List<Future<String>> futureList = service.invokeAll(list);
			System.out.println(futureList.get(0).get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.shutdown(); */
		
		// now we want main thread to wait to finish the above task , thats where the countdownlatch 
		// comes into  picture
		// we also use latch with threads
		int numberOfService = 3;
		ExecutorService service = Executors.newFixedThreadPool(numberOfService);
		CountDownLatch latch = new CountDownLatch(numberOfService);
		 service.submit(new CountDownLatchExampleDriver(latch));
		 service.submit(new CountDownLatchExampleDriver(latch));
		 service.submit(new CountDownLatchExampleDriver(latch));
			try {
				latch.await(5,TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("** "+Thread.currentThread().getName());
		service.shutdown();
		
		
	}

}

class CountDownLatchExampleDriver implements Callable<String> {
	
	private CountDownLatch count;
	
	public CountDownLatchExampleDriver(CountDownLatch latch) {
	
		this.count = latch;
	}
	
	@Override
	public String call() throws Exception {

		try {
			Thread.sleep(6000);
			System.out.println(Thread.currentThread().getName() + " running...");
		} catch (Exception e) {
			
		}finally {
			count.countDown();
		}
		
		return "ok";
	}

}
