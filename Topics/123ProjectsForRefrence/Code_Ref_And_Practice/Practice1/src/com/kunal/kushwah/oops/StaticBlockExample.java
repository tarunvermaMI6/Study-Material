package com.kunal.kushwah.oops;

public class StaticBlockExample { // outer class

	static int num = 5;
	static int temp = 10;
	
	static {
		System.out.println("static block .....");
		temp = num*temp;
		System.out.println(temp);
	}
	
	static class Test{
		
		String a = "ummm";
	}
	
	public static void main(String[] args) {
		
		Test test = new Test();
		
	}
}
