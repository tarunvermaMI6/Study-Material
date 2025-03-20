package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoClass {

	//

	public static void main(String[] args) {
		int[] arr = { 5, 7, 5, 7, 5, 4 };
		int result = solution(arr);
		System.out.println(result);
	}

	private static int solutionStream(int[] arr) {

		Stream<int[]> arrStream = Stream.of(arr);
		Arrays.stream(arr).max().getAsInt(); // give max
		Arrays.stream(arr).max();

		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		Optional<Entry<Integer, Long>> maxMap = map.entrySet().stream().max(Map.Entry.comparingByValue());
		maxMap.ifPresent(x -> x.getValue());
		return maxMap.get().getKey().intValue();
	}

	private static int solution(int[] arr) {
		// TODO: write your logic here to return the number which is occurring max
		// number of times in array

		List<Integer> list = new ArrayList<>();

		for (int value : arr) {
			list.add(value);
		}

		// anoher approah

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		// no need of comparator we are not sorting we need to find max
		/*
		 * Collections.sort(list, new CCustomComparator(map)); System.out.println(list);
		 * return list.get(list.size() - 1);
		 */

		int max = 0, key = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}

		}

		System.out.println("key = " + key);
		return key;
	}
}

// for sorting
class CCustomComparator implements Comparator<Integer> {

	HashMap<Integer, Integer> map;

	public CCustomComparator(HashMap<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Integer o1, Integer o2) {

		int value = map.get(o1) - map.get(o2);

		return value;
	}

}
