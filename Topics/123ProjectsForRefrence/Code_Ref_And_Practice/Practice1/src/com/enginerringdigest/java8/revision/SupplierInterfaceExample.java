package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierInterfaceExample {

	public static void main(String[] args) {
		
		// supplier , it gonna return something but don't take any input
		
		Supplier<Integer> supplier = ()-> 100;
		System.out.println(supplier.get());
		
		
		// use all in one
		
		List<Integer> list = Arrays.asList(3,5,76,8,6,9,0);
		Predicate<Integer> predicate = x->x%2==0; // test condition
		Function<Integer,Integer> function = x->x*x;
		Consumer<Boolean> consumer = x->System.out.println(x);
		Supplier<Integer> supplier1 = ()-> 100;
		
		consumer.accept(predicate.test(function.apply(supplier1.get())));
		
		
	    
		
	
	}
}
