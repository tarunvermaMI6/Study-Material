package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminalOpsExample {

	public static void main(String[] args) {

		// 1) Collect
		// 2) for each

		// 3) reduce - combine element to produce a single result

		List<Integer> list = Arrays.asList(1, 6, 7, 9, 4);
		Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y); // will produces sum of result
		// or
		Optional<Integer> reduce1 = list.stream().reduce(Integer::sum); // will produces sum of result
		System.out.println(reduce);

		// 4) count

		// 5) anymatch, allmatch, nonematch findfirst, findany (these are short circuit
		// method they stop the operation once they find something)

		boolean any = list.stream().anyMatch(x -> x % 2 == 0);
		boolean all = list.stream().allMatch(x -> x > 0);
		boolean none = list.stream().noneMatch(x -> x < 0);
		int findFirst = list.stream().findFirst().get();
		int findAny = list.stream().findAny().get();
		
		// 6) toArray()
		Object[] array = Stream.of(1,2,5,7,9,5,6).toArray();
		
		// 7) min/max
		
		Stream.of(1,2,5,7,9,5,6).max(Comparator.naturalOrder()); // can give lamda exp too, sorting it and getting last example
		
		
		// Example: sort name by length greater than 3
		List<String> names = Arrays.asList("tarun","bob","kumar","shantnu");
		System.out.println(names.stream().filter(x->x.length()>3).toList());
	   
		// Example: sqaure the number and sort it
		List<Integer> listNumber = Arrays.asList(8,4,5,9,1,0);
		System.out.println(listNumber.stream().map(x->x*x).sorted((a,b)->b-a).toList());
        
		// Example: sum of numbers
		listNumber.stream().reduce((x,y)->x+y);
		
		// Example: Counting occurrences of characters
		String sentance = "Hello World";
		IntStream sentanceStream = sentance.chars();
		sentanceStream.filter(x -> x == 'l').count();
		
		// stateful and stateless operation
		
		
		
		
		
		
		
		
		
	}
}
