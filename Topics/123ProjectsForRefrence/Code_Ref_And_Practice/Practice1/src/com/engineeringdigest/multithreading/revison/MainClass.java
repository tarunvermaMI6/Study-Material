package com.engineeringdigest.multithreading.revison;

public class MainClass {

	// computer has CPU -> core -> process/program -> thread

	// when this method is run by main thread...
/*	public static void main(String[] args) {

		// Thread class extend
	 /*	
		System.out.println("main method == "+Thread.currentThread().getName());
		CustomThreadByExtendingThreadClass thread = new CustomThreadByExtendingThreadClass();
		thread.start(); // it will be a new thread
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("after thread.start()");
		thread.run(0); // it will run by main thread
		
		*/
	/*	
		CustomThreadByImplRunnable customThread = new CustomThreadByImplRunnable();
		Thread t1 = new Thread(customThread);
		t1.start();
		customThread.run(0);
	} */
	
	public static void main (String[] args)
    {

        // creating two threads
		CustomThreadByExtendingThreadClass t1 = new CustomThreadByExtendingThreadClass();
		CustomThreadByExtendingThreadClass t2 = new CustomThreadByExtendingThreadClass();
		CustomThreadByExtendingThreadClass t3 = new CustomThreadByExtendingThreadClass();

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 has died.
        try
        {
            System.out.println("line 47 Current Thread: "
                  + Thread.currentThread().getName());
            t1.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                                "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died.
        try
        {
            System.out.println("line 64 Current Thread: "
                 + Thread.currentThread().getName());
            t2.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                                    " caught" + ex);
        }
        
        // t3 starts
        t3.start();
        
        // After t2 has dead, t3 starts
        try
        {
            System.out.println("line 81 Current Thread: "
                 + Thread.currentThread().getName());
            t3.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                                    " caught" + ex);
        }
    }
}
