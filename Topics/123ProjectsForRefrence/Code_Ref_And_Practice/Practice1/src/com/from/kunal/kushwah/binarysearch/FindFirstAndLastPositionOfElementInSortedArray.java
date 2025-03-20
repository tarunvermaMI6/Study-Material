package com.from.kunal.kushwah.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {

		int[] arr = {5,7,7,7,7,8,8,10};
		int[] resp = new int[2];
		
		resp[0] = func(arr, 7, true);
		resp[1] = func(arr, 7, false);
		System.out.println("["+resp[0]+","+resp[1]+"]");
		
	}

	public static int func(int[] arr,int target,boolean isFirstIndex) {

		int start = 0, end = arr.length - 1,mid = 0, ans = 0;

		while (start <= end) {

			 mid = start + (end - start) / 2;

			if(arr[mid] == target) {
				ans = mid;
				if(isFirstIndex) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return ans;
	}

}
