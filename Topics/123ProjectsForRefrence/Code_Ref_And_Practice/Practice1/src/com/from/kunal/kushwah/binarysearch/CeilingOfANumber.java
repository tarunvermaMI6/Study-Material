package com.from.kunal.kushwah.binarysearch;

public class CeilingOfANumber {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 5, 9, 14, 16, 18 };
		int target = 15;
		System.out.println(ceilingOfArray(arr, target));
	}

	public static int ceilingOfArray(int arr[],int target) {
        
		int start = 0, end = arr.length,mid = 0;
		
		while(start<=end) { // here we need to use (<=) cause we when s == e , we need s+1 or s-1 
			mid = start+(end-start)/2;
			
			if(arr[mid] == target) {
				return target;
			}else if(arr[mid]<target) {
				start = mid+1;
			}else {
				end = mid - 1;
			}
		}
		
		return arr[start];
	}
}
