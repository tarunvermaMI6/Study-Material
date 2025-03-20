package com.from.kunal.kushwah.binarysearch;

public class FindPivotPoint {

	public static void main (String [] args) {
		
		int arr[] =  {7,8,9,0,1,2,3,4,5,6}; // pivot means max element from rotates or biotanic  array 
		System.out.println(getPivotPoint(arr));
	}
	
	public static int getPivotPoint(int arr[]) {
		
	    int start = 0, end = arr.length-1,mid= 0;
	    
	    while(start<=end) {
	    	
	    	 mid = start+(end-start)/2;
	    	
	    	// case 1 // case 2 
	    	if((mid <end && arr[mid]>arr[mid+1])) { // mid < end otherwise array index out of bound
	    		System.out.println("case 1 ="+mid);
	    		return mid;
	    	} 
	    	if((arr[mid]<arr[mid-1])){
	    		System.out.println("case 2 ="+(mid-1));
	    		return mid-1;
	    	} 
	    	
	    	if(mid>start && arr[start]>arr[mid]){ // case 3
	    		System.out.println("case 3 ="+mid);
	    		end = mid;
	    	}else  //arr[start]<arr[mid] case 4 
	    		{
	    		System.out.println("case 4 ="+mid);
	    		start = mid+1;
	    	}
	    	
	    }
		
		return -1;
	}
}
