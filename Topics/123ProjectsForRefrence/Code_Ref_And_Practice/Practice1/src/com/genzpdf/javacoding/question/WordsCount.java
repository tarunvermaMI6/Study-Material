package com.genzpdf.javacoding.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCount {

	// Write a Java Program to count the number of words in a string using
	// HashMap.

	public static void main(String[] args) {
		usingStream();
	}

	public static void usingStream() {

		String string = "ddgereerrttyytretretreytrw";
		char[] arr = string.toCharArray();
		List<String> list = new ArrayList<>();
		for (char ch : arr) {
			list.add(ch + "");
		}

		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(map);

		// now if we want to sort it

		map =  map.entrySet().stream().sorted(Map.Entry.comparingByValue());
				.collect(Collectors.toList());

		System.out.println(map);
	}

	public static void usingMap() {

		String string = "ddgereerrttyytretretreytrw";

		char[] arr = string.toCharArray();

		HashMap<String, Integer> map = new HashMap<>();

		for (char ch : arr) {

			if (map.containsKey(ch + "")) {
				map.put(ch + "", map.get(ch + "") + 1);
			} else {
				map.put(ch + "", 1);
			}
		}

		System.out.println(map);
	}
}
