package com.genzpdf.javacoding.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DupsChar {

	public static void main(String[] args) {

		String str = "iojdoiejiewjk";
		List<Character> list = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		char[] arr = str.toCharArray();
		boolean[] isVisted = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {

			if (!isVisted[i]) {
				int count = 0;
				for (int j = i; j < arr.length; j++) {
					if (arr[i] == arr[j]) {
						count++;
						isVisted[j] = true;
					}
				}

				map.put(arr[i], count);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}

		}
	}
}
