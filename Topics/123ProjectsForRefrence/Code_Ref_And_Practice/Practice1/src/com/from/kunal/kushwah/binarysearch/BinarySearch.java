package com.from.kunal.kushwah.binarysearch;

public class BinarySearch {

	public static void main(String [] args) {
		
		int arr[] = {7,8,10,15,16,19,23,40};
		
		int ans =  bs(arr,16);
		System.out.println("ans == "+ans);
	}
	
	public static int bs(int [] arr,int target) {
		
		int start =0,end  = arr.length-1;
		
		while(start<=end) {
			
			int mid = start +(end-start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid]>target){
			  end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return -1;
	}
}
