package com.pattern.programs;

public class SquarePattern {

/*	
	*****
	*   *
	*   *
	*****
	
*/
	
	public static void main(String[] args) {
		
		//twoMethod();
		firstMethod();
	}
	
	
	public static void firstMethod() {
		
	int n = 5;
		
		for(int i=0; i<n-1; i++) {
			
			for(int j=0;j<n; j++) {
				
				if(i==0 || i==n-2) {
					System.out.print("*");
				}else if(j==0 || j == n-1) {
					System.out.print("*");
				}else if(j!=0 && j!=n-1) {
					System.out.print(" ");
				}
      	}
			
			System.out.println("");
		}
			
	}
	
	public static void twoMethod() {

		int n = 4;
		int m = 5;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 1 || j == 1 || i == n || i == j) {
					System.out.print("*");
				} else {
					System.out.println(" ");
				}
			}
			System.out.println();
		}

	}
	}
