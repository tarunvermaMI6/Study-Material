package com.from.kunal.kushwah.binarysearch;

public class SearchInRotatedArray {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 7,8,15,0, 1, 2 }; // both r asc series, getting peak element is different from this.
		int target = 5;

		// find the pivot
		int pivot = findPivot(arr);
		// search i both series
		System.out.println("pivot == "+pivot);
		int result = bs(arr, 0, pivot, target);
		
		if (result == -1) {
			result = bs(arr, pivot+1, arr.length - 1, target);
		}
        System.out.println("result === "+result);
	}

	public static int bs(int[] arr, int start, int end, int target) {

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int findPivot(int[] arr) {

		int start = 0, end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

					}
		return end;
	}
}