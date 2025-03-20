package com.genzpdf.javacoding.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateMapUsingWhileAndAdvanceForLoop {

	// Write a Java Program to iterate HashMap using While and advance for loop.

	public static void main(String[] args) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			System.out.println(entry.getValue());
		}

		Iterator<Map.Entry<Integer, Integer>> iterate = map.entrySet().iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next().getValue());
		}

	}

}
