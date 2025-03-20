package com.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpeakingReadingListeningWriting {

	public static void main(String[] args) {

		String[] arr = { "Listening","Reading"};
		Arrays.sort(arr);

		char[] chAr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			chAr[i] = arr[i].charAt(0);
		}

		List<String> combinationList = new ArrayList<>();
		combinationList.add("SRW");
		combinationList.add("SWL");
		combinationList.add("SLR");
		combinationList.add("RWL");
		combinationList.add("SR");
		combinationList.add("WL");
		combinationList.add("SW");
		combinationList.add("RL");
		combinationList.add("SRWL");
		//combinationList.add("LWRS");
		List<String> resultList = new ArrayList<>();

		for (int i = 0; i < combinationList.size(); i++) {
			char[] charArr = combinationList.get(i).toCharArray();
			Arrays.sort(charArr);

			if (Arrays.equals(chAr, charArr)) {
				resultList.add((combinationList.get(i)));
			}
		}

		System.out.println(resultList);
	}
	
}