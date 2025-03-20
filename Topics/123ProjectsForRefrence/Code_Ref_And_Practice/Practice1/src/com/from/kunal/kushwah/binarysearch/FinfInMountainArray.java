package com.from.kunal.kushwah.binarysearch;

public class FinfInMountainArray {

	public static void main(String[] args) {

		int arr[] = {7, 8, 10, 15, 5, 4, 3, 0};
		int peakElm = peakElement(arr);
		int target = 19,ans =0 ;
		if(arr[0]>target) {
		    // element will be on desc side ,, elem to end
			ans = bs(arr, target,peakElm+1, arr.length-1, false);
		 }else {
			// element will be on aesc side ,, start to elm
			 ans = bs(arr, target,0,peakElm, true); 
		 }
	System.out.println("ans==== "+ans);
	}
		
	

	public static int bs(int[] arr, int target,int start,int end,boolean isAsc) {

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if(isAsc) {
				if (arr[mid] == target) {
					return mid;
				} else if (arr[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}else {
				if (arr[mid] == target) {
					return mid;
				} else if (target>arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}

		return -1;
	}

	public static int peakElement(int[] arr) {

		int start = 0, end = arr.length, mid = 0;

		while (start < end) {

			mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) { // aesc series, ans will lie on left
				end = mid; // we dont know if mid is the answer
			} else { // desc series , ans will lie on right
				start = mid + 1;
			}
		}
		// start == end , coz they r both finding the max element according to condition
		return start;
	}
}
