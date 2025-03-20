package com.java.programs;

public class MoveZeroInArray {

	public static void main(String[] args) {

		// input
		int[] arr = { 3, 0, 0, 4, 6, 2, 7, 9, 5, 0 };
		// output
		// {3,4,6,2,7,9,0,0,0,0}

		// arr = notAGoodMethod(arr);
		// arr = betterMethod(arr);
		arr = expectedMethod(arr);
		for (int n : arr) {
			System.out.print(n + " ");
		}
	}

	private static int[] expectedMethod(int arr[]) {

		int count = 0, temp = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0) {
				// swap
				temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}

		return arr;
	}

	private static int[] betterMethod(int[] arr) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		while (count < arr.length) {

			arr[count++] = 0;
		}

		return arr;

	}

	private static int[] notAGoodMethod(int[] arr) {

		int temp = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				if (arr[j] == 0 && arr[i] != 0) {
					// swap
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					break;
				}
			}
		}
		return arr;
	}
}
