package com.genzpdf.javacoding.question;

public class RemoveWhiteSpace {

	// Write a Java Program to remove all white spaces from a string
	// without using replace().

	public static void main(String[] args) {

		String str = " rrr tt yyy tty ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (ch != ' ') {
				sb.append(ch);
			}
		}

		System.out.println(sb.toString());
	}
}
