package com.java.programms.practice;

public class w4a3d1e1x6 {

	public static void main(String[] args) {

		String str = "w4a3d1e1x6";

		// print w 4 times
		// print a 3 times
		// print d 1 times
		// print e 1 times
		// print x 6 times
		bruteForce(str);

	}

	// brute force

	public static void bruteForce(String str) {

		for (int i = 0; i < str.length(); i++) {
			print(str.charAt(i) + "", Integer.parseInt(str.charAt(i + 1) + ""));
			i++;
		}
	}

	public static void print(String str, int n) {

		while (n != 0) {
			System.out.println(str);
			n--;
		}
	}
}
