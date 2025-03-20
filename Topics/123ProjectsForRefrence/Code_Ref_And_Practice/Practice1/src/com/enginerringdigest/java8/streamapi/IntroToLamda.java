package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IntroToLamda {

	public static void main(String[] args) {

	//	lamdaFunction();
	//	predicate();
	//	functionExample();
	//	consumerExample();
	//	supplierExample();
		allCompbinedExample();
		
		// we also have BiPredicate,BiConsumer,BiFunction which take two inputs
		// do read method and constructor reference	
	}
	
	public static void allCompbinedExample() {
		
		// let do odd even
		Predicate<Integer> predicate = x -> x%2==0;
		Function<Integer, Integer> function = x -> x*10;
		Supplier<Integer> supplier = ()->10;
		Consumer<Integer> consumer = x-> System.out.println(x);
		if(predicate.test(supplier.get())) {
			consumer.accept(function.apply(supplier.get()));
		}
	}
	
	public static void supplierExample() {
		// take no input , just do some operation
		
		Supplier<String> supply = () -> "I am a supplier";
		String str = supply.get();
		System.out.println(str);
	}

	public static void consumerExample() {

		// consumer , take input don't return anything , use to print things

		Consumer<Integer> consume = x -> System.out.println("x== " + x);
		consume.accept(7);

		List<Integer> list = Arrays.asList(4, 5, 7, 3, 7);
		Consumer<List<Integer>> listConsume = x -> {
			for (Integer value : list) {
				System.out.println(value);
			}
		};
		listConsume.accept(list);
	}

	public static void functionExample() {

		// input type, output type
		Function<Integer, Integer> doubleIt = x -> x * 2;
		Function<Integer, Integer> trippleIt = x -> x * 3;
		int result = doubleIt.andThen(trippleIt).apply(20); // same
		// or
		result = doubleIt.compose(trippleIt).apply(20); // same
		System.out.println("result === " + result);

	}

	public static void predicate() {

		Predicate<String> firstChar = str -> str.toLowerCase().startsWith("t");
		Predicate<String> lastChar = str -> str.toLowerCase().endsWith("n");
		Predicate<String> and = firstChar.and(lastChar);
		boolean result = and.test("tarun");
		System.out.println("result === " + result);

	}

	public static void lamdaFunction() {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("runnable");
			}
		};
		Thread thread = new Thread(runnable);

		// or

		Runnable runnable1 = () -> System.out.println("runnable1 using lamda .... ");
		Thread thread1 = new Thread(runnable1);

		// or
		Thread thread2 = new Thread(() -> System.out.println("my thread. ....."));
	}
}
