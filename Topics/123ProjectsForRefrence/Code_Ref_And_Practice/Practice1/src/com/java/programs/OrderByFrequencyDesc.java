package com.java.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.programms.practice.CalculateFrequency;

public class OrderByFrequencyDesc {

	// Given an integer array, sort the array according to the frequency of elements
	// in decreasing order,
//	if the frequency of two elements are same then sort in increasing order 

	public static void main(String[] args) {

		int[] arr = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
		usingComparator(arr);
//		usingStream(arr);

	}

	public static void usingComparator(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int value : arr) {

			if (map.get(value) == null) {
				map.put(value, 1);
				
			} else {
				map.put(value, map.get(value) + 1);
			}
			
			list.add(value);
		}
	//	System.out.println(map);
		CustomComparator comparator = new CustomComparator(map);
	//	System.out.println(list);
		Collections.sort(list, comparator);

		System.out.println(list);
	}

	public static void usingStream(int[] arr) {

		Map<Integer, Long> map = CalculateFrequency.usingMap(arr);
		List<Map.Entry<Integer, Long>> map2 = map.entrySet().stream()
				.sorted((a, b) -> a.getValue().compareTo(b.getValue())).collect(Collectors.toList());

		map2.forEach(entry -> System.out.println(entry.getKey() + " === " + entry.getValue()));
	}

}

class CustomComparator implements Comparator<Integer> {

	private final Map<Integer, Integer> map;

	public CustomComparator(Map<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Integer k1, Integer k2) {

		// if the frequency of two elements are same then sort in increasing order

	//	System.out.println("k1= " + k1 + " k2= " + k2);
		long freqCompare = map.get(k2).compareTo(map.get(k1)); // here freq means value of map
		long valueCompare = k1.compareTo(k2); // here value means key of map

		if (freqCompare == 0) {
			return (int) valueCompare;
		}

		return (int) freqCompare;
	}

}
