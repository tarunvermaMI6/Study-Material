package com.enginerringdigest.java8;

import java.util.function.Predicate;

public class PredicateANDORISEqual {

	public static void main(String[] args) {
		
		predicateFunc();
	}
	
	public static void predicateFunc() {
	
		// predicate is a functional interface
		Predicate<Integer> predicate = x -> x > 5; // x is an input argument , here predicate holding the condition 
		boolean flag = predicate.test(1);
		System.out.println(flag);
		
		Predicate<String> predicate2 = str -> str.charAt(0) == 'T';
		Predicate<String> predicate3 = str -> str.charAt(str.length()-1) == 'N';
		Predicate<String> predicate4 = predicate2.and(predicate3);
		Predicate<String> predicate5 = predicate2.or(predicate3);
		
		flag = predicate4.test("TARUN");
		flag = predicate4.test("ARUN")	;
		System.out.println(flag);
		
		
	}
}
