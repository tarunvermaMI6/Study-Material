package com.genzpdf.javacoding.question;

public class StringReverse {

	// Write a Java Program to reverse a string without using String inbuilt
	// function
	public static void main(String[] args) {
		betterSolution();
	}

	public static void betterSolution() {

		String str = "tarunn";

		// simple do the swapping from left to right

		char[] arr = str.toCharArray();

		int left = 0, right = arr.length - 1;

		while (left < right) {

			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}

		System.out.println(new String(arr));

	}

	public static void behudaSolution() {

		String str = "abcdheki";

		// can't use string.length

		char[] charArr = str.toCharArray();
		char[] charArr1 = new char[charArr.length];
		int index = 0;
		for (int i = charArr.length - 1; i >= 0; i--) {
			charArr1[index] = charArr[i];
			index++;
		}

		System.out.println(new String(charArr1));
	}
}
