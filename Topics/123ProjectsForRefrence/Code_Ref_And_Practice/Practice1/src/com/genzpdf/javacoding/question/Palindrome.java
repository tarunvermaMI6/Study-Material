package com.genzpdf.javacoding.question;

public class Palindrome {

	// Write a Java Program to find whether a string or number is 
 	// palindrome or not
	
	public static void main(String[] args) {
		
		String str = "tarun";
		
		// no need to reverse
		
		char[] arr =  str.toCharArray();
		int left = 0, right = arr.length-1;
		boolean isPalindrome = true;
		while(left<right) {
			
			if(arr[left] != arr[right]) {
				isPalindrome = false;
			}
			
			left++;
			right--;
		}
		
		System.out.println(isPalindrome);
		
	}
}
