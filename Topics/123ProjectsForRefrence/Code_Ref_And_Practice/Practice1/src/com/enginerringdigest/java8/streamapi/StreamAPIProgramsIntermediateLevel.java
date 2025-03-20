package com.enginerringdigest.java8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIProgramsIntermediateLevel {

	public static void main(String[] args) {

		List<Integer> listOfInteger = Arrays.asList(5, 8, 1, 8, 9, 1, 4, 6);

		// 1. How do you find the sum of a list of integers using streams?
		System.out.println(listOfInteger.stream().reduce((x, y) -> x + y));
		// or
		System.out.println(listOfInteger.stream().mapToInt(x -> x.intValue()).sum());
		// or
		System.out.println(listOfInteger.stream().collect(Collectors.summingInt(Integer::intValue)));

		// 2. How do you find the maximum and minimum values in a stream?
		System.out.println(listOfInteger.stream().max((a, b) -> a - b).get());
		System.out.println(listOfInteger.stream().min((a, b) -> a - b).get());

		// 3. How do you find the average of numbers in a list using streams?
		System.out.println(listOfInteger.stream().collect(Collectors.averagingInt(Integer::intValue)));

		// 4. How do you concatenate multiple lists into a single stream?

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();

		// we can do Stream.concat(a,b) , but it's good for two only

		List<Integer> finalList = Stream.of(list1, list2, list3).flatMap(x -> x.stream()).toList(); // or
																									// flatMap(list::stream)

		// 5. How do you group a list of numbers into even and odd using streams?

		Map<String, List<Integer>> map = listOfInteger.stream()
				.collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));

		// or best approach

		Map<Boolean, List<Integer>> map1 = listOfInteger.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
		System.out.println(map1.get(true) + " " + map1.get(false));

		// 6. How do you group a list of employees by department using streams?

		List<Employee> listOfEmp = Arrays.asList(new Employee("tarun", 50.0, "Engineering"),
				new Employee("tarun", 50.0, "Engineering"), new Employee("tarun", 50.0, "IT"),
				new Employee("tarun", 50.0, "CIVIL"));

		Map<String, List<Employee>> groupEmployee = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		groupEmployee.entrySet().stream().forEach(
				entry -> System.out.println(entry.getKey() + " :: " + entry.getValue().get(0).getDepartment()));

		// 7. How do you find the second highest number in a list using streams?
		System.out.println(listOfInteger.stream().distinct().sorted((a, b) -> b - a).skip(1).findFirst());
		// or using reduce

		listOfInteger.stream().sorted((a, b) -> b - a).reduce((first, second) -> second);

		// 8. How do you partition a list of numbers into two groups: greater than 10
		// and less than 10?
		System.out.println(listOfInteger.stream().collect(Collectors.partitioningBy(x -> x > 10)));

		// 9. How do you count occurrences of each word in a list using streams?

		List<String> words = Arrays.asList("abc", "def", "abc", "czh");
		System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

		// 10.How do you remove null values from a list using streams?

		words = Arrays.asList("abc", "def", "abc", "czh", null, null);
		System.out.println(words.stream().filter(x -> x != null).collect(Collectors.toList())); // filter(Object::notNull)

		// 12.How do you flatten a list of lists into a single list using streams?

		// 13.How do you find duplicate elements in a list using streams?

		List<Integer> dups = listOfInteger.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("dups === " + dups);

		// using sets

		Set<Integer> calDups = new HashSet<>();
		System.out.println(
				"dups === " + listOfInteger.stream().filter(x -> !calDups.add(x)).collect(Collectors.toList()));

		// using frequency

		System.out.println(dups.stream().filter(n -> Collections.frequency(listOfInteger, n) > 1));

		// 14.How do you get the top 3 highest numbers from a list using streams?
		System.out.println(listOfInteger.stream().sorted((a, b) -> a - b).skip(listOfInteger.size() - 3).toList());
		// or best approach
		System.out.println(listOfInteger.stream().distinct().sorted((a, b) -> b - a).limit(3).toList());

		// and

		System.out.println(
				listOfEmp.stream().sorted(Comparator.comparingDouble(Employee::getMarks).reversed()).limit(3).toList());

		// 15.How do you convert a list of strings into a map of string-length pairs?
		List<String> words1 = Arrays.asList("hello world", "meow meow", "woof woof", "scandal");
		System.out.println(words1.stream().collect(Collectors.toMap(word -> word, String::length)));

		// 16.How do you find the longest word in a list using streams?
		System.out.println(words1.stream().sorted((x, y) -> y.length() - x.length()).limit(1).toList());

		// 17.How do you get distinct characters from a list of strings?
		System.out.println(words1.stream().flatMap(word -> Arrays.stream(word.split(""))).collect(Collectors.toSet()));

		// 18.How do you merge two maps using streams?
		Map<String, Integer> map2 = new HashMap<>();
		Map<String, Integer> map3 = new HashMap<>();
		System.out.println(Stream.concat(map2.entrySet().stream(), map3.entrySet().stream())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum)));

		// 19.How do you extract a sublist based on a condition using streams?
		System.out.println(listOfInteger.stream().filter(x->x>5).toList());
		
		// 20.How do you shuffle elements in a list using streams?
		Collections.shuffle(listOfInteger);
		
		
	}
}

class Employee {

	private String name;
	private double marks;
	private String department;

	public Employee() {

	}

	public Employee(String name, double marks, String department) {

		this.name = name;
		this.marks = marks;
		this.department = department;
	}

	public double getMarks() {
		return this.marks;
	}

	public String getDepartment() {
		return this.department;
	}

}
