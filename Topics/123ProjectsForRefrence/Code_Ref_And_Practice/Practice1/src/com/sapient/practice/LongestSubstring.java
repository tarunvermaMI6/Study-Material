package com.sapient.practice;

import java.util.HashSet;

public class LongestSubstring {

	//ip = abcabcbb
	public static void main(String[] args) {
		
		String str = "abcabcbb";
	
		HashSet<Character> set = new HashSet<>();
		if(str.length()>1) {
			
			int i=0,j=0,m=0;
			
			while(j<str.length()) {
			
				if(set.contains(str.charAt(j))) {
					set.remove(str.charAt(i));
					i++;
				}else {
					set.add(str.charAt(j));
					m = Math.max(m, (j-i)+1);
					j++;
				}
			}
			
			System.out.println(m);
		}
		
	}
	
	public static void bruteforce() {
		
		String str = "abcabcbb";
		String pstr = "";
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0; i<str.length(); i++) {
			
			String oStr = "";
			for(int j=i; j<str.length(); j++) {
				
				if(set.add(str.charAt(j))) {
					oStr = oStr+str.charAt(j);
				}else {
					set = new HashSet<>();
					break;
				}
			}
			
			if(oStr.length()>pstr.length()) {
				pstr = oStr;
			}
		}
		
		System.out.println(pstr);
		
	}
}
