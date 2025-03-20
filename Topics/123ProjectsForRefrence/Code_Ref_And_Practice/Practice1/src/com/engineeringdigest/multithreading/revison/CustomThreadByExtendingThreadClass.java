package com.engineeringdigest.multithreading.revison;

import com.java.programms.practice.CalculateFrequency;

public class CustomThreadByExtendingThreadClass extends Thread {

	@Override
	public void run() { // what thread need to do
		
	//	System.out.println("thread name in run = "+Thread.currentThread().getName());
//		int[] arr = { 5, 6, 7, 9, 1 };
//		CalculateFrequency.usingMap(arr);
		
		  try
          {
              Thread.sleep(500);
              System.out.println("run method Current Thread: "
                      + Thread.currentThread().getName());
          }

          catch(Exception ex)
          {
              System.out.println("Exception has" +
                              " been caught" + ex);
          }
	}
	
	public void run(int m) { // we can overload the run method
	
		System.out.println("thread name is run overloading = "+Thread.currentThread().getName());
		System.out.println("this is run method overloading = "+m+" "+Thread.currentThread().getName());
	}

}
