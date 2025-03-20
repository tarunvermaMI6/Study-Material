package com.from.kunal.kushwah.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		
		int [] arr = {3,1,5,4,2};
		arr = bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}
	}
	
	public static int[] bubbleSort(int [] arr){
		
		// normal way
		/*  
		int n = arr.length;
		for(int i=0; i<arr.length; i++) {
			
			for(int j=1; j<n; j++) {
				if(arr[j-1]>arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			n--;
		} */
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j = 1; j<arr.length-i; j++) {   // array is getting sorted at the end every index, no need to check again
				if(arr[j-1]>arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
}
