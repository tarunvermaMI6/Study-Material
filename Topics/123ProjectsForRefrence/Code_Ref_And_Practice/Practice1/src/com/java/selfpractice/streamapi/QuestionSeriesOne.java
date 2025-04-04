package com.java.selfpractice.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionSeriesOne {

	public static void main(String[] args) {

		// Convert a List of Strings to Uppercase

		List<String> names = Arrays.asList("java", "python", "c++");
		// names = names.stream().map(x->x.toUpperCase()).toList();

		// Find the Length of Each String in a List

		List<Integer> list = names.stream().map(x -> x.length()).collect(Collectors.toList());

		// System.out.println(list);

		// Find the First Element Matching a Condition

		// list.stream().filter(x-> x/2 == 0).findFirst();

		// Find the Sum of All Elements in a List

		int sum = list.stream().reduce(0, (x, y) -> x + y); // jo ye 0 hai na bc aage add hora hai

		// System.out.println("sum ===="+ sum);

		// String str = names.stream().reduce("a",(x,y)-> x+y);

		// System.out.println("str == "+str);

	//	Optional<Integer> op = list.stream().max((x, y) -> x - y);
	//	op.get();

		// or
//		op.ifPresent(x -> System.out.println(x));
		
	//	op = list.stream().min((x, y) -> x - y);
		
	//	op.ifPresent(x -> System.out.println(x)); 
		
		list.stream().count();
	
//		Sort by string length.
		
		names = names.stream().sorted((x,y)-> x.length() - y.length()).toList();
		
		System.out.println(names);
		
		
		
		
		
		

	}
}
