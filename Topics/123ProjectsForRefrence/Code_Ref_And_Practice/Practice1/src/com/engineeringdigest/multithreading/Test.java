package com.engineeringdigest.multithreading;

public class Test {

	public static void main(String[] args) {
//		
//		MyThreadUsingThreadClass threadClass = new MyThreadUsingThreadClass();
//		System.out.println(threadClass.getName());
//		threadClass.start();
//		System.out.println(threadClass.getName()+" :start");
//		
        MyThreadUsingRunnableInterface thread = new MyThreadUsingRunnableInterface();
        Thread th = new Thread(thread);
        System.out.println(th.getName());
        th.start();
//		System.out.println(th.getName()+" :start");
//
	}
	
	// static variable
    static int a = m1();
    // static block
    static {
        System.out.println("Inside static block");
    }
    // static method
    static int m1() {
        System.out.println("from m1");
        return 20;
    }
    // static method(main !!)
   /* public static void main(String[] args)
    {
       System.out.println("Value of a : "+a);
       System.out.println("from main");
    } */
}
