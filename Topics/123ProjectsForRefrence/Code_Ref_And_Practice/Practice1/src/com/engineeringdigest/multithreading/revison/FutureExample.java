package com.engineeringdigest.multithreading.revison;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(3);
		Future<?> future = service.submit(() -> {
			return 90;
		});

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.shutdown();
	}
}
