package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {

		// here we are doing what holding a condition in a variable
		Predicate<Integer> pred = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return false;
			}
		};
		// or
		pred = x -> x > 0;
		pred.test(1000); // calling function
		// or
		Predicate<String> pred1 = x -> {
			// do operation here
			return x.startsWith("t");
		};
		
		Predicate<String> pred2 = x -> {
			// do operation here
			return x.endsWith("n");
		};
		
		
		// stream example
		
		List<Integer> list = Arrays.asList(4,5,6,7,8,9);
		list.stream().filter(x->x>4);
		
		// more precise way 
		
		Predicate<Integer> predInt = x->x>4;
		list.stream().filter(predInt).toList();
		
		// prdicate and , or 
		
		Predicate<String> pred1And2 = pred1.and(pred2);
		Predicate<String> pred1Or2 = pred1.and(pred2);
		pred1And2.test("tarun");
		pred1Or2.test("tarun");
		
		List<String> listStr = Arrays.asList("tarn","verma","name","meow","hello");
		listStr.stream().filter(pred1Or2);
		
	    pred1.equals(pred2);
	
		
	}
}
