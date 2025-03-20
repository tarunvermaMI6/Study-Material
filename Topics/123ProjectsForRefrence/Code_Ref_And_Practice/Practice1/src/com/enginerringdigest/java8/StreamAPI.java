package com.enginerringdigest.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		//upperOrLowerCase();
		//removeDups();
	//	countTheNumberOfStringsInListthatstartwithaspecificletterusingStreams();
	//	sortalistofstringsinalphabeticalorderascendinganddescendingusingstreams();
	///	maxormin();
		
		findthesecondsmallestandlargestelementsinalistofintegersusingstreams();
	}

	public static void sumOfEven() {
		int arr[] = { 2, 3, 5, 9, 14, 16, 18 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println("sum == " + sum);
		//// using stream
		int sum1 = Arrays.stream(arr).filter(n -> n % 2 == 0).sum(); // passed predicate in filter
		System.out.println("sum1 == " + sum1);
	}

	public static void avgOfArray() {
		List<Integer> list = Arrays.asList(2, 3, 5, 9, 14, 16, 18);
		Stream<Integer> stream = list.stream(); // convert list to stream
		DoubleStream doubleStream = stream.mapToDouble(Integer::doubleValue);
		double avg = doubleStream.average().orElse(0.0);
		System.out.println("avg == " + avg);
		////// or ////////
		avg = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
	}

	public static void upperOrLowerCase() {
		List<String> words = Arrays.asList("hello", "world", "namaste", "rom", "rom", "ji");
		words = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(words);
	}

	public static void removeDups() {
		List<Integer> list = Arrays.asList(2, 3, 5, 9, 14,14,16, 16, 18);
		list = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list);
	}
	
	public static void countTheNumberOfStringsInListthatstartwithaspecificletterusingStreams() {
		String letter = "r";
		List<String> words = Arrays.asList("hello", "world", "namaste", "rom", "rom", "ji");
		long count = words.stream().filter(x -> x.startsWith(letter)).count();
		System.out.println("count === "+count);
	}
	
    public static void sortalistofstringsinalphabeticalorderascendinganddescendingusingstreams() {
    	List<String> words = Arrays.asList("hello", "world", "namaste", "rom", "rom", "ji");
    	// asc
    	words = words.stream().sorted().collect(Collectors.toList());
    	System.out.println(words);
    	// desc 
    	words = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(words);
    }
    
    public static void maxormin() {
    	List<Integer> list = Arrays.asList(2, 3, 5, 9, 14,14,16, 16, 18);
    	int max = list.stream().max(Integer :: compare).orElse(null);
    	int min = list.stream().min(Integer :: compare).orElse(null);
    	System.out.println(max);
    	System.out.println(min);
    }
    
    public static void findthesecondsmallestandlargestelementsinalistofintegersusingstreams() {
    	
    	List<Integer> list = Arrays.asList(2, 3, 5, 9, 14,14,16, 16, 18);
    	int secondSmallest = list.stream().distinct().sorted().skip(1).findFirst().orElse(0);
        int secondLargest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);	
         /////// or 
        secondLargest = list.stream().distinct().sorted((a,b) -> Integer.compare(b, a)).skip(1).findFirst().orElse(0);
        System.out.println(secondLargest);
    }
    
}
