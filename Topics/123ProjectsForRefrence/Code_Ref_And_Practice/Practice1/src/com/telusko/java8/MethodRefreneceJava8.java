package com.telusko.java8;

import java.util.Arrays;
import java.util.List;

public class MethodRefreneceJava8 {


	// call by value : where we pass values in methods
	// call by method : where we pass functions in function , in java 8
	// functional interface and lamda function are required for this
	// In Java 8 we can use the method as if they were objects or primitive values, and we can treat them as a variable
	
	public static void main(String [] args) {
		
		List<String> names = Arrays.asList("tarun","shubh","adesh","gaurav","balendra");
		
	//	names.forEach(s->System.out.println(s)); // example of lambda exp
		
		names.forEach(System.out :: println); // println is a function belongs to out object of system
		
		// another one
		
	//	Printp.printStr((Addition add) -> add.addValues(5, 6));
		
	}
}	
	class Printp{
		
		public static void printStr(Addition addition) {
			System.out.println("in printStr == ");
		}
	}
	
	
	interface Addition {
		
		public void addValues(int a , int b);
	}
	

