package com.engineeringdigest.multithreading.revison;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterFrameworkExample {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		long starttime = System.currentTimeMillis();

		for (int i = 1; i <= 1000; i++) {

			int final_i = i;
			executorService.submit(() -> {
				System.out.println(final_i);
			});
		}
		executorService.shutdown();
		
        try {
			executorService.awaitTermination(100, TimeUnit.MICROSECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(
				"total time =" + Thread.currentThread().getName() + "= " + (System.currentTimeMillis() - starttime));

	}
}
