package com.genzpdf.javacoding.question;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		
		String str = "abcabcbb";
		
		int maxLength = 0;
		int firstIndex = 0, secondIndex = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(secondIndex = 0; secondIndex<str.length(); secondIndex++) {
			
			char ch = str.charAt(secondIndex); 
			
			if(map.containsKey(ch)) {
			
				firstIndex = Math.max(firstIndex, map.get(ch)+1);
			}
			
			map.put(ch, secondIndex);
			maxLength = Math.max(maxLength,secondIndex-firstIndex+1);
			
			
		}
	}
}
