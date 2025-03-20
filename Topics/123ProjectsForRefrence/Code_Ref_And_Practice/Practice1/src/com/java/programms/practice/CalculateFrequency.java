package com.java.programms.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateFrequency {

	public static void main(String[] args) {

		int[] arr = { 5, 6, 2, 8, 9, 1, 0, 1, 2, 5, 3, 9, 8 };
		// bruteForceApproach(arr);
		// takeBooleanArray(arr);
		// usingStream(arr);
		usingMap(arr);
	}

	public static void bruteForceApproach(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int count = 0;
			for (int j = i; j < arr.length; j++) {

				if (arr[i] == arr[j]) {

					count++;
				}
			}

			System.out.println(arr[i] + " === " + count);
		}
	}

	public static void takeBooleanArray(int[] arr) {

		boolean[] visited = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {

			if (!visited[i]) {
				int count = 0;
				for (int j = i; j < arr.length; j++) {

					if (arr[i] == arr[j]) {
						count++;
						visited[j] = true;
					}
				}
				System.out.println(arr[i] + " == " + count);
			}
		}
	}

	public static Map<Integer, Long> usingMap(int[] arr) {

	//	System.out.println("thread name in usingMap function = "+Thread.currentThread().getName());
		
		Map<Integer, Long> map = new HashMap<>();

		for (int value : arr) {

			if (!map.containsKey(value)) {
				map.put(value, (long) 1);
			} else {
				map.put(value, map.get(value) + 1);
			}
		}
		// map.forEach((x, y) -> System.out.println(x + " == " + y));
	//	System.out.println(map);
		return map;
	}

	public static void usingStream(int[] arr) {

		Map<Integer, Long> map = Arrays.stream(arr).boxed() // this is needed to convert int to Integer
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		map.forEach((key, value) -> System.out.println(key + " == " + value));

	}
}
