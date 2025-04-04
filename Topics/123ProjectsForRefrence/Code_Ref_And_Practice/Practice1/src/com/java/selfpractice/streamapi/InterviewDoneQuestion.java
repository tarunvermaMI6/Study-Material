package com.java.selfpractice.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class InterviewDoneQuestion {

	public static void main(String[] args) {
		
		List<Integer> listOne = Arrays.asList(10,20, 30 ,40);
		List<Integer> listTwo = Arrays.asList(90,80,10,20);	
		TreeMap<K, V>
		
	//	System.out.println(gettingCommonElements(listOne,listTwo));
		sortTheEmployee();
	}

	public static List<Integer> gettingCommonElements(List<Integer> listOne, List<Integer> listTwo) {

		// l1 = 10,20, 30 ,40
		// l2= 90,80,10,20

		List<Integer> outputList = new ArrayList<>();
		outputList = listOne.stream().filter(x->{
			return listTwo.contains(x);
		}).collect(Collectors.toList());
/*
		List<Integer> megeList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());

		Map<Integer, Long> countMap = megeList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		for (Map.Entry<Integer, Long> value : countMap.entrySet()) {

			if (value.getValue() > 1) {
				//outputList.add(value.getKey());
				System.out.println(value.getKey());
			}
		}
        */
		return outputList;
	}

	public static void sortTheEmployee() {

		List<Employee> employeeList = Arrays.asList(new Employee("tarun", 1200), new Employee("Arun", 130),new Employee("Aeun", 100));

	//	employeeList = employeeList.stream().sorted((x, y) -> x.getSalary() - y.getSalary())
		//		.collect(Collectors.toList());
		
		employeeList = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		employeeList.forEach(x->System.out.println(x.getName()));
	}
}


class Employee {

	private String name;
	private int salary;

	// getter and setter

	public Employee(String name, int salary) {

		this.name = name;
		this.salary = salary;
	}
	
	public int getSalary() {

		return salary;
	}
	
	public String getName() {
		
		return name;
	}

}
