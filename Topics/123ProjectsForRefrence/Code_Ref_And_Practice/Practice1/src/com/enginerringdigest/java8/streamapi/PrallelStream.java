package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PrallelStream {

	public static void main(String[] args) {

		// A type of stream that enables parallel processing of elements
		// allowing multiple thread to process parts of stream simultaneously
		// This can significantly improve performance for large data set
		// workloads get distributed among multiple threads

		// calculate the factorial of all numbers
		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

		long startMs = System.currentTimeMillis();

		// List<Long> factorialList = list.stream().map(x -> factorial(x)).toList();

		// or
		List<Long> factorialList = list.stream().map(PrallelStream::factorial).toList(); // PrallelStream is my class

		long endMs = System.currentTimeMillis();

		System.out.println("total time ms without parrallel stream = " + (endMs - startMs));

		long startMs1 = System.currentTimeMillis();

		// List<Long> factorialList = list.stream().map(x -> factorial(x)).toList();

		// or
		List<Long> factorialList1 = list.parallelStream().map(PrallelStream::factorial).sequential().toList(); // PrallelStream is my
																									// class
		long endMs1 = System.currentTimeMillis();
		System.out.println("total time ms with parrallel stream = " + (endMs1 - startMs1));

		// Parallel streams are most effective for CPU-intensive or large data sets
		// where task are independent
		// they may add overhead for simple tasks or small data sets

		// local var in lamda exp is always final or effective final cause the process
		// runs on multicore

		// Cumulative sum
		List<Integer> getSum = Arrays.asList(4, 5, 6, 2, 5); // here sum of one depends on other, not an independent
																// task
		// use atomic integer
		AtomicInteger sum = new AtomicInteger();
		getSum.parallelStream().map(x -> sum.addAndGet(x)).toList(); // it wont give correct result cause parallel
																		// stream won't consider ordering

		// sequential() // to make the data in sequence
		// use foreachOrdered() to print order in parallel stream
		
	}

	public static long factorial(int number) {

		int n = number;
		while (number > 1) {
			n = n * (number - 1);
			number--;
		}
		return n;
	}
}
