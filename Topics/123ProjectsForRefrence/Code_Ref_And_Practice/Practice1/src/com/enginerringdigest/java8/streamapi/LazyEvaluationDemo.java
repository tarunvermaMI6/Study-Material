package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class LazyEvaluationDemo {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("tarun","bob","kumar","shantnu");
	 
		names.stream().filter(name -> { //it wont run cause there is no terminal operation 
			System.out.println("name === "+name);
			return name.length()>3;
		});
		
		System.out.println("hello world"); // print first
	}
}
