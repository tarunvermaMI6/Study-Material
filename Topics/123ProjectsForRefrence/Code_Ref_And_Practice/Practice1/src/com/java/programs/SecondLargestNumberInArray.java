package com.java.programs;

public class SecondLargestNumberInArray {

	public static void main(String[] args) {

		int arr[] = {2,3,10,4,5,9,6,7};
		//int arr[] = { 1, 2, 7, 3, 19, 111, 10 };
		// System.out.println("output === "+findSecondMax(arr, findMax(arr))); // lame
		// approach
		inSingleLoop(arr);
	}

	public static void inSingleLoop(int[] arr) {

		
		int max = arr[0], secondMax = 0;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
			}

		}

		System.out.println("max: " + max + " secondmax: " + secondMax);
	}

	public static int findMax(int arr[]) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}

		}
		return max;
	}

	public static int findSecondMax(int arr[], int max) {

		int secodmax = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > secodmax && arr[i] != max) {
				secodmax = arr[i];
			}

		}
		return secodmax;
	}

}