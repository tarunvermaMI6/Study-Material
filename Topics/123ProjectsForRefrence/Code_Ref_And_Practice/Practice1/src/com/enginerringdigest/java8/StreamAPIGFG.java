package com.enginerringdigest.java8;

import java.util.Arrays;
import java.util.List;

public class StreamAPIGFG {

	public static void main(String [] args) {
		
		FindthefirstelementofaStream();
	}
	
	public static void FindthefirstelementofaStream() {
		
		List<String> words = Arrays.asList("hello", "world", "namaste", "rom", "rom", "ji");
		String first =  words.stream().findFirst().orElse(null);
		System.out.println(first);
	}
	
	public static void findDups() {
		
		List<Integer> list = Arrays.asList(2, 3, 5, 9, 14,14,16, 16, 18);
		
		
	}
}
