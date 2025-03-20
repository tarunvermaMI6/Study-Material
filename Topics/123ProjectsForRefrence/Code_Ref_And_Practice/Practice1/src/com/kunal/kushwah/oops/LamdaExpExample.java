package com.kunal.kushwah.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LamdaExpExample {

	public static void main(String[] args) {

		//lamdaExpBasicExample();
		//lamdaExpSortListExample();
		//lamdaExpWithStreamExample();
		lamdaExpIterateListExample();
	}

	public static void lamdaExpIterateListExample() {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.forEach((item)->System.out.println("item = "+item));
	}
	
	public static void lamdaExpWithStreamExample() {
		
		// without lamda
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> evenNumbers = new ArrayList<>();
		for (Integer num : numbers) {
		    if (num % 2 == 0) {
		        evenNumbers.add(num);
		    }
		}
	//	System.out.println(evenNumbers); // Output: [2, 4]
		
		// with stream
		evenNumbers = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
		
		
		
	}
	
	public static void lamdaExpSortListExample() {
		
		// without lamda
		List<String> names = Arrays.asList("John", "Alice", "Bob");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.compareTo(s2);
		    }
		});
		System.out.println(names); 
	
		// with lamda 
		
		Comparator<String> comp = (a,b) -> a.compareTo(b);
		Collections.sort(names , comp);
		
		// or 
		
		Collections.sort(names , (a,b) -> a.compareTo(b));
		
		// or
	
		names.sort((a,b) -> a.compareTo(b));
	}
	
	
	public static void lamdaExpBasicExample() {

		Operation sum = new Operation() { // using Anonymous class
			@Override
			public int sum(int a, int b) {
				return a + b;
			}
		};
		System.out.println("sum === " + sum.sum(5, 6));
		// shorter and cleaner
		// (parameter) -> {function body}
		Operation sum1 = (a, b) -> {
			return a + b;
		};
		System.out.println(sum1.sum(9, 9));
		// more shorter
		Operation sum2 = (a, b) -> a + b;
		System.out.println(sum2.sum(9, 8));
	}
}

@FunctionalInterface
interface Operation {

	int sum(int a, int b);
	
}