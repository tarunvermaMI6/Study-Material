package com.from.kunal.kushwah.doublylinkedlist;

public class DriverClass {

	public static void main(String[] args) {
		CustomDoublyLinkedList list = new CustomDoublyLinkedList();
		
		list.insertAtLast(1); // 0
		list.insertAtLast(2); // 1
		list.insertAtLast(3); // 2
		list.insertAtLast(4); // 3
		list.insertAtLast(5); // 4
		list.insertAtLast(6); // 5
		
		//list.insert(3, 9);
	    list.insertAfterGivenNode(list.getNode(3), 100);
	    
	//	list.insert(3, 100);
		list.displayList();
		//list.insertAtLast(4);
	//	list.displayListInRverse();
	}
}
