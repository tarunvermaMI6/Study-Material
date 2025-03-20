package com.kunal.kushwah.oops;

import java.util.ArrayList;
import java.util.List;

public class GenricCustomArraylist<T extends Number> { // extends Number is a wild card means i can add numbers only

	private Object[] arr;
	private static int DEFAULT_SIZE = 10;
	private int size;
    private ArrayList list;
	
	
    public void getList(List<? extends Number> list1) {
    	
    	// only allow numbers and not its subclass use ? extends Number to allow Numbers subclass int , float
    }
    
	public GenricCustomArraylist() {
		arr = new Object[DEFAULT_SIZE];
		size = 0;
	}

	public int getSize() {

		return size;
	}

	public T remove(int i) {
		
			T removed = (T)arr[i];
		    swap(i, size-1);    
			return removed;
	}

	public T getValue(int i) {
		return (T)arr[i];
	}

	public void add(int value) {

		if (isFull()) {
			arr[size++] = value;

		} else {
			resize();
			arr[size++] = value;
		}
	}

	public boolean isFull() {

		if (arr.length > size) {
			return true;
		}
		return false;
	}

	public void resize() {

		Object[] newArr = new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	public void swap(int firstIndex,int lastIndex) {
		
		int firstEl = 0;
		for(int i=1; i<lastIndex; i++) {
			
			// will do it later
		}
	}
}
