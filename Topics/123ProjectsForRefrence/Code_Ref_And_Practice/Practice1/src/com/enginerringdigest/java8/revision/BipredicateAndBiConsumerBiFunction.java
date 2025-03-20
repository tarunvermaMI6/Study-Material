package com.enginerringdigest.java8.revision;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BipredicateAndBiConsumerBiFunction {

	public static void main(String[] args) {
		
		// BiPredicate , take two arguments
		
		BiPredicate<Integer, Integer> bipredc = (x,y)-> x>y;
		bipredc.test(10, 100);
		
		// BiConsumer , take two argumnents
		
		BiConsumer<Integer, Integer> biConsumer = (x,y)->System.out.println(x+y);
		biConsumer.accept(10, 100);
		
		// BiFunction
		
		BiFunction<Integer, Integer, String> biFunct = (x,y)-> x+y+" hello";
		System.out.println(biFunct.apply(10, 100));
	}
}
