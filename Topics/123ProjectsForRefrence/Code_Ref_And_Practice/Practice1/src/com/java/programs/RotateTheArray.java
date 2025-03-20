package com.java.programs;

public class RotateTheArray {

//	  Input: arr[] = [1, 2, 3, 4, 5], d = 2 Output: [3, 4, 5, 1, 2]
	// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.

	// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3 Output: [8, 10,
	// 12, 14, 16, 18, 20, 2, 4, 6]
	// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4
	// 6.

	// Input: arr[] = [7, 3, 9, 1], d = 9 Output: [3, 9, 1, 7]
	// Explanation: when we rotate 9 times, we'

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 }, num = 2;
	//	arr = rightRotate(arr, num);
		arr = leftRotate(arr, num);

		for (int n : arr) {
			System.out.print(n + ",");
		}
	}

	public static int[] rightRotate(int arr[], int num) {

		while (num > 0) {

			int firstValue = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = firstValue;
			for (int n : arr) {
				// System.out.print(n+",");
			}
			// System.out.println("");
			num--;
		}

		return arr;
	}

	public static int[] leftRotate(int arr[], int num) {

		while (num > 0) {

			int lastValue = arr[arr.length - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = lastValue;
			// for(int n : arr) {
			// System.out.print(n+",");
			// }
			// System.out.println("");
			num--;
		}

		return arr;
	}
}
