package com.from.kunal.kushwah.binarysearch;

public class PositionoOfAnElementInInfiniteSortedArray {

	public static void main(String[] args) {

		int target = 27;
		int[] arr = { 2, 4, 5, 6, 7, 8, 18, 19, 21, 25, 27, 29, 34, 36, 41, 42, 45, 49, 55, 59, 60, 63, 65, 69, 72, 75,
				80 };
		int[] range = findRange(arr, target); 
		int ans = bs(arr, range[0], range[1], target);
		System.out.println("ans == "+ans);
	}

	public static int[] findRange(int arr[],int target) {
		
		int start =0,tempStart = 0;
		int end = 1 ;
		
		while(target>arr[end]) {
			tempStart = end+1;
			end = end + (end-start+1)*2;
			start = tempStart;
		}
		
		arr[0] = start;
		arr[1] = end;
		
		return arr;
	}
	
	public static int bs(int[] arr, int start, int end, int target) {

		while (start <=end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}
}
