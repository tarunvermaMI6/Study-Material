package com.kunal.kushwah.oops;

public class CustomArraylistImpl {

	public static void main(String[] args) {
		
		GenricCustomArraylist<Integer> list = new GenricCustomArraylist<Integer>();

		for (int i = 1; i <= 16; i++) {

			list.add(i);
		}

		for (int i = 0; i < list.getSize(); i++) {

			System.out.println(list.getValue(i));
		}

	//	private ArrayList list = new ArrayList<>();
		System.out.println("remove elm === "+list.remove(0));
			System.out.println("size ===== " + list.getSize());
	}
}
