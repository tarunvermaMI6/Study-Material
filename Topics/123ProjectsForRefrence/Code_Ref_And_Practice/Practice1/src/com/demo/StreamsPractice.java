package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice {

	public static void main(String[] args) {

		// 1. How do you create a stream from a list of integers?
		// 2. How do you convert a stream back to a list?

		List<Integer> list = Arrays.asList(1, 5, 7, 8, 9, 3, 7, 80);
		// System.out.println(list.stream().count());

		// System.out.println(list.stream().filter(x->x%2==0).collect(Collectors.toList()));

		// 5. How do you transform a list of strings to uppercase using streams?

		List<String> listOfString = Arrays.asList("hello", "world", "mine");

		System.out.println(listOfString.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));

		// 6. How do you sort a list of numbers using streams?

		list = list.stream().sorted((a, b) -> {
			return a - b;
		}).collect(Collectors.toList());

//		System.out.println(list);

		// 7. How do you limit a stream to the first 5 elements?

		list = Arrays.asList(1, 5, 7, 8, 9, 3, 7, 80, 5, 6, 2, 5, 8);
		// list = list.stream().limit(5).collect(Collectors.toList());
//	    System.out.println(list);

		// 8. How do you skip the first 3 elements in a stream?

		// list.stream().skip(3).toList();

//		9. How do you find the first element of a stream?

		// list.stream().findFirst();

		// 10.How do you check if all elements in a stream match a given condition?

		// list.stream().allMatch(x -> x > 0);

		// 12.How do you remove duplicate elements from a list using streams?

		list.stream().collect(Collectors.toSet());

		// or

		list.stream().distinct().toList();

		// 15.How do you create a stream from an array?

//		int arr[] = {64,4,67,6,7};
//		IntStream streamOfArray =  Arrays.stream(arr);

//		Stream.of(arr).collect(Collectors.toList());

		// 1. How do you find the sum of a list of integers using streams?
		list.stream().reduce((x, y) -> x + y);
		list.stream().max((x, y) -> x - y).get();
		list.stream().min((x, y) -> x - y).get();

		// 3. How do you find the average of numbers in a list using streams?

		list.stream().collect(Collectors.averagingInt(Integer::intValue));

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();

		Stream.concat(list1.stream(), list2.stream()).toList(); // only for two

		Stream.of(list1, list2, list3).flatMap(x -> x.stream()).toList();

		// 5. How do you group a list of numbers into even and odd using streams?

		// even and odd

		list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));

		// empoyeeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

		// 7. How do you find the second highest number in a list using streams?

		list.stream().sorted((a, b) -> {
			return b - a;
		}).skip(1).findFirst();

		// 9. How do you count occurrences of each word in a list using streams?

		System.out.println(listOfString.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

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