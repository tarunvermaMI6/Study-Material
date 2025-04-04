package com.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortByFrequency {

	public static void main(String[] args) {

		String str = "helloworld";
	    
		// str -> int stream 
		
		Map<Character, Long> map = str.chars().mapToObj(c-> (char)c)
				.collect(Collectors.groupingBy(x->x,Collectors.counting()));
		
		List<Entry<Character, Long>> entry = map.entrySet().stream().sorted((x,y)-> (int)(x.getValue()-y.getValue())).toList();
		
		entry.forEach(x->System.out.println(x.getKey()+" :: "+x.getValue()));
		
		System.out.println();
	}

	void simpleMethod() {

		String str = "helloworld";

		char[] arr = str.toCharArray();

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

	}
}
