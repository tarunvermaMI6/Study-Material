package com.from.kunal.kushwah.recursion;

public class FindFibonnaciNthNumber {

	public static void main(String[] args) {
		
		int n = fibo(7);
		System.out.println(n);
	}
	
	static int fibo(int n) {
		
		// base condition to stop calling function call
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		return fibo(n-1)+fibo(n-2);
	}
}
