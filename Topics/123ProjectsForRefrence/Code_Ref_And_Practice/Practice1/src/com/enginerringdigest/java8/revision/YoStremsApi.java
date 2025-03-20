package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YoStremsApi {

	// stream is sequence of elements
	// u need to use stream if u want to use declarative and functional approach

	public static void main(String[] args) {

		Stream<Integer> integerStream = Stream.of(1, 3, 4, 5, 6);
		List<Integer> list = Stream.iterate(0, n -> n + 1).limit(100).toList(); // generate infinite stream

		list = list.stream().filter(x -> x % 2 == 0).map(y -> y * y).distinct().sorted().collect(Collectors.toList());

		// get max

		list.stream().max((a, b) -> a - b).get();
		// or
		list.stream().max((a, b) -> {
			return a.compareTo(b);
		});
		// or
		System.out.println("max == " + list.stream().max(Comparator.comparing(Integer::intValue)).get());
		
		List<String> listOfString = Arrays.asList("sumaya","adesh","subh","tarun");
		
		System.out.println(listOfString.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList()));

	}

}
