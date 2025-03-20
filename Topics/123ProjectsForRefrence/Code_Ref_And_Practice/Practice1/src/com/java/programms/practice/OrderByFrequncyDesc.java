package com.java.programms.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderByFrequncyDesc {

	// Print the elements of an array in the decreasing frequency, if 2 numbers have
	// the same
	// frequency then print the one which came first

	public static void main(String[] args) {

		int[] arr = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(list);
		// calculate frequency
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int value : list) {

			if (freqMap.containsKey(value)) {
				freqMap.put(value, freqMap.get(value) + 1);
			} else {
				freqMap.put(value, 1);
			}
		}

		CustomComparatorV1 compre = new CustomComparatorV1(freqMap);
		Collections.sort(list, compre);
		System.out.println(list);
	}

}

class CustomComparatorV1 implements Comparator<Integer> {

	HashMap<Integer, Integer> freqMap;

	public CustomComparatorV1(HashMap<Integer, Integer> freqMap) {

		this.freqMap = freqMap;
	}

	@Override
	public int compare(Integer o1, Integer o2) {

		// same frequency then print the one which came first
		// return freqMap.get(o2).compareTo(freqMap.get(o1));

		// suppose same frequency then print the one which is greater

		int freqDiff = freqMap.get(o2).compareTo(freqMap.get(o1));
		int valueDiff = o1.compareTo(o2);

		if (freqDiff == 0) {
			return freqDiff;
		}

		return valueDiff;
	}

}