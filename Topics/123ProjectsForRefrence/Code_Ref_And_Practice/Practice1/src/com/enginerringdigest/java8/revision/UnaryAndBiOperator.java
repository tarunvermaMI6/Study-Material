package com.enginerringdigest.java8.revision;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryAndBiOperator {

	public static void main(String[] args) {
		
		// take same data type as input and output
		Function<Integer, Integer> function = x->x*x;
	
		// convert to
		
		UnaryOperator<Integer> unaryOp = x->x*x;
		unaryOp.apply(10);
		
	
		// take same data type as input and output for BiFunction
		BiFunction<String, String, String> biFunction = (x,y)-> x+y;
		
		// convert to
		
		// same data type as input and output
		BinaryOperator<String> binary = (x,y)-> x+y;
		
	}
}
