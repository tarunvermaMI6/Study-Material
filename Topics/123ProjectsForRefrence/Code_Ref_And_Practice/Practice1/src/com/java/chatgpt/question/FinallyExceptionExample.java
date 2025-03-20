package com.java.chatgpt.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FinallyExceptionExample {
	
	public static void main(String[] args) {
	
		/*try {
			System.out.println("Inside try");
			throw new RuntimeException("Exception from try");
		} catch (Exception e) {
			System.out.println("Inside catch: " + e.getMessage());
		} finally {
			System.out.println("Inside finally");
			throw new RuntimeException("Exception from finally"); // Overwrites previous exception
		}  */
		
		List<Integer> list = Arrays.asList();
		
		Collections.sort(list, (a,b)->{
			
			return a-b;
			
		});
	}
}
