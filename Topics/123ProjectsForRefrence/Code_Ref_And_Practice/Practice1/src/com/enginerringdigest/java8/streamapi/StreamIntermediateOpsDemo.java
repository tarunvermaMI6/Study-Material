package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOpsDemo {

	// Intermediate operations transforms a stream into another stream
	// They are lazy meaning they don't execute until a terminal operation is
	// invoked.

	// Intermediate operations : filter(),map(),sort(),distinct(), iterate(), skip()

	public static void main(String[] args) {

		List<String> list = Arrays.asList("tarun", "mohit", "shubham", "ronak", "rohit");
		Stream<String> listStream = list.stream(); // conversion

		// 1) filter
		Stream<String> filterStream = listStream.filter(str -> str.startsWith("t")); // Intermediate operation
		// it won't invoked until u call terminal operation
		long result = filterStream.count(); // terminal operation
		Consumer<Long> consumer = x -> System.out.println(x);
		consumer.accept(result);

		// 2) map
		Stream<String> mapStream = list.stream().map(x -> x.toUpperCase());
		// or
		mapStream = list.stream().map(String::toUpperCase);
		List<String> upperCaseStream = mapStream.collect(Collectors.toList());

		// 3) sort
		list.stream().sorted(); // sort in asc
		// or
		list.stream().sorted((a, b) -> b.length() - a.length()); // using comparator

		// 4) distinct
		list.stream().distinct().count();

		// 5) limit
		System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count()); // 1 to 100

		// 6) skip

		System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count()); // 11 to 120 , count = 100

		// 7) peek

		System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(x -> System.out.println(x)).count()); // 11
																														// to
		// 8) flatMap

		// The flatMap() method in Java flattens nested structures and transforms them
		// into a single stream. It is widely used in processing lists of lists,
		// splitting strings, and handling complex data structures.

		List<List<String>> fruitList = Arrays.asList(Arrays.asList("orange", "apple"), Arrays.asList("guava", "banana"),
				Arrays.asList("tomato", "peach"));

		System.out.println(fruitList.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

		// split and uppercase
		List<String> sequence = Arrays.asList("Hello World", "My name", "ya hoo");

		System.out.println(sequence.stream().flatMap(sentance -> Arrays.stream(sentance.split(" ")))
				.map(String::toUpperCase).toList());

		// and stream can not be reused and called after terminal operator
		
	}
}
