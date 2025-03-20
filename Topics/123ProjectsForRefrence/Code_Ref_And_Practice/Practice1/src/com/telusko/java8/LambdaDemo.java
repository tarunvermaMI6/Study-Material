package com.telusko.java8;

interface App{
	
	void show(int i);
}

//class ToCall implements App {  // 1) here we need to make a class and declare a method to use it , which is not feasible
//
//	@Override
//	public void show() {
//		
//		System.out.println("in method show .....");
//	}
//}

public class LambdaDemo {

	public static void main(String[] args) {
		
//		ToCall obj = new ToCall();
//		obj.show(); 
	
	// 2) we can do this ...
		
		App obj = new App(){ // Anonymous Inner class

			@Override
			public void show(int i) {
					System.out.println("in message....");
			}
			
		};
		
		obj.show(1);
	
		App obj1 = (i)-> {    // this code is same as above but using lamda expression
			System.out.println("Hello");
		};
		
		// or if we have only single line of code
		
		// the idea is when we have already deine lots of things in interface by should we need to define again and again
		
		App obj2 = (i)-> System.out.println("Hello "+i);
		obj2.show(0);
		
		// if we have only one param then 
		App obj3 = i-> System.out.println("Hello "+i); // i-> System.out.println("Hello "+i) this is an implementation of a interface
		obj3.show(3);
		
	}

}
