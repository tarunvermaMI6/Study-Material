package com.sapient.practice;

public class LongestSubarrayWithSumSmallerThanEqualToK {

	public static void main(String[] args) {
		
		    //  Input: nums = [3, 1, 2, 5, 1, 1, 2, 3], K = 5
	//			Output: 4  
		//		Explanation: The longest subarray satisfying the condition is [1, 2, 1, 1] with sum = 5.
		
		int arr[] = {3, 1, 2, 5, 1, 1, 2, 3};
		int k = 5;
		int i=0,j=0, m=0;
		int sum = 0;
		
		while(j<arr.length) {
			
			sum = sum+arr[j];
			if(sum<k) {
				m = Math.max(m, (j-i)+1);
				
			}else {
				sum=sum-arr[i];
				i++;
			}
			
			j++;
		}
		System.out.println(m);
		
	}
}
