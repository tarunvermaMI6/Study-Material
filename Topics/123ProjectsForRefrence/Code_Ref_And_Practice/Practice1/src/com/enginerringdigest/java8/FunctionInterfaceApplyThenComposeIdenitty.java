package com.enginerringdigest.java8;

import java.util.function.Function;

public class FunctionInterfaceApplyThenComposeIdenitty {

	public static void main(String[] args) {

		// string as input , integer as output
		Function<String, String> function = str -> str + " tarun";
		Function<String, String> function1 = str -> str + " verma";

		String x = function.andThen(function1).apply("hello"); // output of function is passing as 
		//input to function1
		System.out.println("x ==" + x);
	}
}
