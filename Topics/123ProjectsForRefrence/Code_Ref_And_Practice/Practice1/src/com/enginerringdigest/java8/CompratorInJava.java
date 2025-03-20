package com.enginerringdigest.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CompratorInJava {

	public static void main(String [] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

	// 1	MyClassCompre mcc = new MyClassCompre();
	// 1.1	Collections.sort(list,mcc); // this will sort it in asc order but if we need to do something else we gonna need comprator
		
		///by using lamda exp
	// 2 Collections.sort(list,(a,b) -> b-a);
		
		Set<Integer> set = new TreeSet<>((a,b)->b-a);
	    set.add(5);
	    set.add(3);
	    set.add(19);
	    set.add(21);
		
	    System.out.println(set);
	}
}

class MyClassCompre implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		
//		return a-b; // for asc
		return b-a; // for desc
	}
	
	
}
