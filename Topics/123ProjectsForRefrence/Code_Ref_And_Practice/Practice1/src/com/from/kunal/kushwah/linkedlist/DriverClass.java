package com.from.kunal.kushwah.linkedlist;

public class DriverClass {

	public static void main(String[] args) {
		
		CustomLinkedlIst list = new CustomLinkedlIst();
	//	list.addAtBeginning(5);
//		list.addAtBeginning(10);
	//	list.addAtBeginning(3);
//		list.addAtBeginning(2);

		list.addAtEnd(1);
		list.addAtEnd(2);
		list.addAtEnd(3);
		list.addAtEnd(4);
		list.addAtEnd(5);
		list.addAtEnd(6);
	
		// what if we are not maintaining tail but we want to add the number at the end
	//	list.addAtEndIfNotMaintaingTail(15);
		
		//list.insertAtIndex(90, 3);
		list.printAll();
		list.delete(4);
		//	System.out.println(list.deleteLast());
		list.printAll();
		System.out.println(list.getSize());
	}
}
