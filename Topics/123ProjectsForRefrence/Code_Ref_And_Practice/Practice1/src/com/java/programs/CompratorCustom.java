package com.java.programs;

import java.util.Comparator;

public class CompratorCustom implements Comparator<Integer>{

	@Override
	public int compare(Integer a, Integer b) {
		
		return b-a; // for desc
	}

	
	
}

