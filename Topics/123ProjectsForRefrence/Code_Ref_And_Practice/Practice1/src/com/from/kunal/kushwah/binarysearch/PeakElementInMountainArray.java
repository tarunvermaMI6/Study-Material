package com.from.kunal.kushwah.binarysearch;

public class PeakElementInMountainArray {

	public static void main(String[] args) {

		int arr[] = {7,8,10,15,5,4,3,0};
		System.out.println(func(arr));
	}

	public static int func(int[] arr) {

		int start = 0, end = arr.length, mid = 0;

		while (start < end) {
		
			mid = start + (end - start) / 2;

			if(arr[mid]>arr[mid+1]) { // aesc series, ans will lie on left
				end = mid; // we dont know if mid is the answer
			}else { // desc series , ans will lie on right
				start = mid+1;
			}
		}
        // start == end , coz they r both finding the max element according to condition
		return start;
	}
}
