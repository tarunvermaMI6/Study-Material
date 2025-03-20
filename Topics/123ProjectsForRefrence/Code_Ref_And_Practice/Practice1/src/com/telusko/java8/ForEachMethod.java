package com.telusko.java8;

import java.util.Arrays;
import java.util.List;

public class ForEachMethod {

	public static void main(String [] args) {
		
		List <Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.forEach(i->System.out.println(i)); // i->System.out.println(i) this is a impl of consumer interface 
	}
}
