package com.genzpdf.javacoding.question;

public class SwapWithoutThird {

	// Write a Java Program to swap two numbers without using the third 
	 // variable.
	public static void main(String[] args) {
		
		int a = 10, b=15;
		
		// output = b = 10,a = 15
		
		a = a+b;
		
		b = a-b;
		
		a = a-b;
		
		System.out.println(a+","+b);
	}
}
