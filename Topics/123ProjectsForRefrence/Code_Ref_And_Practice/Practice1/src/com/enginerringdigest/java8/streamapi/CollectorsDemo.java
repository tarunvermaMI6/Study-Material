package com.enginerringdigest.java8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {

		// 1) collecting to a list
		// 2) collecting to a set (no dups)
		// 3) collecting to a collection

		List<String> list = new ArrayList<>();
		list.stream().map(String::toUpperCase).collect(Collectors.toCollection(() -> new ArrayList<>()));

		// 4) Joining Strings
	 
		list.stream().map(String::toUpperCase).collect(Collectors.joining("hello"));
		
		// 5) summarizing data, count, sum, min,average,max
		
		// 6) Collectors.averagingInt(), Collectors.counting(), 
		
		// grouping elements  
		
		List<String> words = Arrays.asList("hello world","meow meow","woof woof","scandal");
		System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));
		
		
		
	}
}
