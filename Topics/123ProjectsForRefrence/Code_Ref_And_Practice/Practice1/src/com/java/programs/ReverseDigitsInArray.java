package com.java.programs;

public class ReverseDigitsInArray {

	public static void main(String[] args) {
		
//		int inArr[] = {1,4,2,5,0,8,6,7,9};
		int inArr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int opArr[] = call(inArr, 5);
		
		for(int i = 0; i < opArr.length; i++) {
			//System.out.print(opArr[i]+" ");
		}
	}
	
	public static int[] call(int arr[], int num) {

	
		int count = 1;
		for (int i = 0; i < arr.length; i++) {

			if (count % num == 0) {
				arr = reverse(arr, (i - (num-1)), i);
			}else if((arr.length-count)<num) {
				//reverse(arr, i, arr.length-1);
			System.out.println(arr[i]);
			}
			count++;
		}
		return arr;
	}
	
	public static int[] reverse(int arr[], int firstIndex, int lastIndex) {

		int temp = 0;
		while (firstIndex < lastIndex) {
			temp = arr[lastIndex];
			arr[lastIndex] = arr[firstIndex];
			arr[firstIndex] = temp;

			firstIndex++;
			lastIndex--;
		}
		return arr;
	}
	

}
