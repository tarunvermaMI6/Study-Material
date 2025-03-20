package com.genzpdf.javacoding.question;

public class FibonacciSeriesRecusrsion {
//Write a Java Program for the Fibonacci series in recursion
	
	public static void main(String[] args) {
		
		// 0, 1,1, 2,3,5,8,13 ........ n
		
		// n =2 , kese aaya == n = (n-1) + (n-2)
		
		// simple
		
/*		
		
	   int n = 5 , a = 0, b=1,c=0;
	   
	   System.out.print(a+","+b);
	   while(n!=0) {
		   
		   c = a+b;
		   System.out.print(","+c);
		   a = b;
		   b = c;
		   
		   n--;
	   }  */
	 System.out.print("0,1");	
	 System.out.print(getFibbb(5));
	   
	}
	
    
	public static int getFibbb(int n) {
		
		if(n<=1) {
			return n;
		}
		
		return getFibbb(n-1)+getFibbb(n-2);
	}
}
