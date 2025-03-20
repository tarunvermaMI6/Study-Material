package com.enginerringdigest.java8.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {

		// Function is also a functional interface
		// it is used to do some work

		// passing , return
		Function<Integer, String> function = (x) -> (x * x) + "";

		System.out.println(function.apply(5));

		// apply than
		
		List<String> listStr = Arrays.asList("tarun", "verma", "adesh", "subh");

		Function<List<String>, List<String>> listFunction = list -> {

			List<String> resultList = new ArrayList<>();
			for (String str : list) {
				if (str == "verma") {
					resultList.add(str);
				}

			}
			return resultList;
		};
		
		Function<List<String>, List<String>> listFunction1 = list -> {

			List<String> resultList = new ArrayList<>();
			for (String str : list) {
					resultList.add(str.toUpperCase());
			
			}
			return resultList;
		};
		
		//listStr = listFunction.apply(listStr);
		listFunction = listFunction.andThen(listFunction1); // storing it in a new function
		System.out.println(listFunction.apply(listStr));
		
		
		// compose , oppsite of andThen
		
		listFunction = listFunction.compose(listFunction1);
		System.out.println("compose == "+listFunction.apply(listStr));
		
		// identity, return the same input
		
		Function<String, String> functionStr = Function.identity(); 
		
	}
	
	
}
