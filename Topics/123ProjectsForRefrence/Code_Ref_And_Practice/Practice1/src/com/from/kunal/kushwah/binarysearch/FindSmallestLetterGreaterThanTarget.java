package com.from.kunal.kushwah.binarysearch;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {

		char arr[] = { 'c', 'f', 'j' };
		char target = 'f';
		// here we also wrap the text .... its a condition of leetcode
        System.out.println("my func === "+func(arr, target));
        System.out.println("kunal soln === "+func(arr, target));
	}

	public static char func(char arr[], char target) {

		int start = 0, end = arr.length - 1;
		if (target>arr[end]) {
			return arr[0];
		}
		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] < target || arr[mid] == target) {
				start = mid + 1;
			} else{
				end = mid - 1;
			}
		}

		return arr[start];
	}

	public static char kunalSolution(char arr[],char target) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] < target) {
				start = mid + 1;
			} else{
				end = mid - 1;
			}
		}
		return arr[start%(arr.length)]; // here when the loop get violated (start>end), start = end+1 == arr.length
	}
}
