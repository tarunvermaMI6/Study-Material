package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.List;

public class MethodRefAndConstructorRef {

	public static void main(String[] args) {

		// refer to a method without invoking it, use in place of lamda where lamda only
		// calls an existing method
		
		// same is constructor
		// x-> new Student() or (Student::new)
		
		// example
		
		List<Integer> list = Arrays.asList(4,5,76,8,90,12,5);
		
		list.forEach(x->System.out.println(x));
		
		// or using method ref
		
		list.forEach(System.out::print);
		
	}
}
