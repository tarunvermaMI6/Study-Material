package com.engineeringdigest.multithreading.revison;

import com.java.programms.practice.CalculateFrequency;

public class WithoutExecuterFrameWork {

	// 1
	/* 
	public static void main(String[] args) {

		long starttime = System.currentTimeMillis();

		Thread t1 = new Thread(() -> {

			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName()+"= "+i);
			}
		});

		t1.start();
		
		// below executed by main thread , so it can execute anytime not in order
		// use join()
		System.out.println(
				"total time =" + Thread.currentThread().getName() + "= " + (System.currentTimeMillis() - starttime));
	}
	*/
	
	public static void main(String[] args) {
		
		long starttime = System.currentTimeMillis();
		
		for (int i = 1; i <= 10; i++) {
		
			int[] arr = new int[i];
			Thread t1 = new Thread(() -> {
				CalculateFrequency.usingMap(arr);
			});
			t1.start();
		}
		
	
		System.out.println(
				"total time =" + Thread.currentThread().getName() + "= " + (System.currentTimeMillis() - starttime));
	}
}
