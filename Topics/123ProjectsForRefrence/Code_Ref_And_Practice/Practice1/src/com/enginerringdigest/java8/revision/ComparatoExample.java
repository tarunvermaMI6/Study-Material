package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ComparatoExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5, 6, 7, 8, 7, 9);
		list.sort((a, b) -> a - b);
		System.out.println(list);

		HashMap<Integer, Integer> hashmap = new HashMap<>();
		Set<Integer> set = new TreeSet<Integer>((a, b) -> a - b); // can pass the comprator
		Map<Integer, Integer> map = new TreeMap<>((a, b) -> a - b);

		
	}
}
