package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIProgramsAdvancedLevel {

	public static void main(String[] args) {

		List<Employeee> listOfEmp = Arrays.asList(new Employeee("tarun", 50.0, "Engineering"),
				new Employeee("tarun", 80.0, "Engineering"), new Employeee("tarun", 50.0, "IT"),
				new Employeee("tarun", 30.0, "CIVIL"));

		List<Integer> listOfInteger = Arrays.asList(5, 8, 1, 8, 9, 1, 4, 6);

		// 1. How do you implement a custom collector?

		// 2. How do you sort a list of objects based on multiple fields using streams?

		listOfEmp.stream()
				.sorted(Comparator.comparing(Employeee::getMarks)
						.thenComparing(Comparator.comparing(Employeee::getDepartment).reversed()
								.thenComparing(Comparator.comparing(Employeee::getName))))
				.toList();

		// 3. How do you parallelize a stream for better performance?

		// 4. How do you handle exceptions inside stream operations?

		// Best Choice: Use try-catch inside lambda for quick handling,
		// Optional for ignoring failures, and Function<T, R> for checked exceptions.

		// 5. How do you compute the frequency of characters in a string using streams?
		String str = "freggeerrerere";
		Map<Character, Long> mapOfChar = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// 6. How do you implement a sliding window over a stream?

		// 7. How do you find the most frequently occurring element in a list using
		// streams?

		Map<Integer, Long> mapOfCount = listOfInteger.stream()
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		mapOfCount.entrySet().stream().max(Map.Entry.comparingByValue());

		// 8. How do you implement a custom comparator for sorting using streams?

		// 9. How do you perform batch processing on a stream?

		// 10.How do you collect results of a stream into an immutable collection?

		// 11.How do you implement pagination using streams?

//        12.How do you convert a nested object structure into a flat list using streams?
		// 13.How do you dynamically apply filters to a stream based on runtime
		// conditions?
		// 14.How do you convert an Iterator into a Stream?
		// 16.How do you create a summary report (e.g., count, sum, min, max, average)
		// for a dataset using streams?

		System.out.println(listOfEmp.stream().sorted(Comparator.comparing(Employeee::getMarks))
				.skip(1).findFirst().get().getMarks());

	}

}

class Employeee {

	private String name;
	private double marks;
	private String department;

	public Employeee() {

	}

	public Employeee(String name, double marks, String department) {

		this.name = name;
		this.marks = marks;
		this.department = department;
	}

	public double getMarks() {
		return this.marks;
	}

	public String getName() {
		return this.name;
	}

	public String getDepartment() {
		return this.department;
	}

}
