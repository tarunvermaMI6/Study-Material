package com.genzpdf.javacoding.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondMax {

	public static void main(String[] args) {

		// Write a Java Program to find the second-highest number in an array

		int[] arr = { 65, 4, 78, 450, 80, 90, 109 };

		int max = arr[0], secondMax = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
			}
		}

		System.out.println(secondMax);
		
		
		// using streams
		
		
		List<Integer> list =  Arrays.stream(arr).boxed().toList();
		
		Integer n = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(n);
	}
}
