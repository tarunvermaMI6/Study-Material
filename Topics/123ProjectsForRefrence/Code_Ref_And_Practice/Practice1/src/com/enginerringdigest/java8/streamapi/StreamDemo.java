package com.enginerringdigest.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(11,6,77,8,999,667);
		//check even count
		System.out.println(list.stream().filter(x->x%2==0).count());
	}
}
