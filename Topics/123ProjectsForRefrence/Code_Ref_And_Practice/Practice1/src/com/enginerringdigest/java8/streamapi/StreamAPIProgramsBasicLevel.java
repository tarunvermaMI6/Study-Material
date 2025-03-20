package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIProgramsBasicLevel {

	public static void main(String[] args) {

		List<Integer> listOfInteger = Arrays.asList(5, 8, 1, 8, 9, 1, 4, 6);

		// 1. How do you create a stream from a list of integers?
		Stream<Integer> streamOfInteger = listOfInteger.stream();

		// 2. How do you convert a stream back to a list?
		listOfInteger = streamOfInteger.collect(Collectors.toList()); // or toList() java 16+ only

		// 3. How do you find the count of elements in a stream?
		System.out.println(listOfInteger.stream().count());

		// 4. How do you filter even numbers from a list using streams?
		listOfInteger.stream().filter(x -> x % 2 == 0).peek(x -> System.out.println("even= " + x))
				.collect(Collectors.toList());

		// 5. How do you transform a list of strings to uppercase using streams?
		// 6. How do you sort a list of numbers using streams?
		// 7. How do you limit a stream to the first 5 elements?
		System.out.println(listOfInteger.stream().limit(5).toList());

		// 8. How do you skip the first 3 elements in a stream?
		System.out.println(listOfInteger.stream().skip(3).toList());

		// 9. How do you find the first element of a stream?
		Optional<Integer> num = listOfInteger.stream().findFirst();
		System.out.println(num.get());

		// 10. How do you check if all elements in a stream match a given condition?
		boolean isAllMatch = listOfInteger.stream().allMatch(x -> x > 0);

		// 11.How do you check if any element in a stream matches a given condition?
		boolean anyMatch = listOfInteger.stream().anyMatch(x -> x == 9);

		// 12.How do you remove duplicate elements from a list using streams?
		System.out.println(listOfInteger.stream().collect(Collectors.toSet()));
		// or
		System.out.println(listOfInteger.stream().distinct().toList());

		// 13.How do you collect elements from a stream into a Set?

		// 14.How do you generate an infinite stream of random numbers?

		List<Integer> infiniteStream = Stream.iterate(1, x -> x + 1).limit(10).toList(); // produce infinite number of list but
																				// use limit for demo
		
		// 15.How do you create a stream from an array?
		
		int [] arr = {4,5,6,7,8,9,9,9};
		IntStream streamOfArray =  Arrays.stream(arr);
		

	}
}
