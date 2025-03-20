package com.genzpdf.javacoding.question;

public class CountCharUsingCharArray {

	public static void main(String[] args) {
		
		String str = "Hello@@123";
		int [] arr = new int [256];
		
		for(Character ch :str.toCharArray()) {
			arr[ch]++;   // increment the count of the ch in the array
		}
		
		
		for(int value:arr) {
			if(value>0) {
				char ch = (char)value;
       		System.out.println(String.valueOf(ch)+" count is "+value);
			}
		}
	}
	
}
